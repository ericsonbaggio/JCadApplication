package br.cad.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import ognl.NoSuchPropertyException;

public class ObjectBinderImpl {
	
	public Object getValue(String property, Object root) throws Exception {
		return getValue(property, root, false);
	}
	
	public Object getValue(String property, Object root, boolean createIfIsNull) throws Exception {
		if(property==null || root==null || property.length()<=0)
			return null;

//		StringTokenizer st = new StringTokenizer(property, "\\.");
//		while(st.hasMoreTokens()) {
//			String attribute = st.nextToken();
//			root = getValueFromAttribute(attribute, root, createIfIsNull);
//			if(root==null)
//				return null;
//		}
		String st[] = property.split("\\.");
		for(String attribute: st) {
			root = getValueFromAttribute(attribute, root, createIfIsNull);
			if(root==null)
				return null;
		}
		
		return root;
	}
	
	protected Object invokeMethod(Method method, Object root,  Object...args) throws InvocationTargetException, IllegalAccessException {
		return method.invoke(root, args);
	}	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Object getValueFromAttribute(String attribute, Object root, boolean createIfIsNull) throws Exception {
		int index = -1;
		String key = null;
		if(attribute.endsWith("]")) { //Array
			int i = attribute.indexOf('[');
			if(attribute.charAt(i+1)=='\'') {
				key = attribute.substring(i+2, attribute.lastIndexOf("'"));
			}else{
				index = Integer.parseInt(attribute.substring(i+1, attribute.length()-1));
			}
			attribute = attribute.substring(0, i);
		}
		
		Method method = null;
		try{
			try{
				method = root.getClass().getMethod(Utils.getGetterMethodName(attribute), new Class[0]);
			}catch(NoSuchMethodException ex) {
			}
			if(method==null)
				method = root.getClass().getMethod(Utils.getGetterIsMethodName(attribute), new Class[0]);
			
		}catch(NoSuchMethodException e) {
			throw new NoSuchPropertyException(attribute, root);
		}
		
		if(method!=null) {
			//Object obj = method.invoke(root, new Object[0]);
			Object obj = invokeMethod(method, root, new Object[0]);
			if(obj==null && createIfIsNull) {
				obj = getNewInstance(method.getReturnType());
				performSetValue(attribute, root, obj);
			}
			if(index>=0) {
				int size = getArraySize(obj);
				if(createIfIsNull && size <= index) {
					if(obj instanceof List) {
						for(int i=size;i<=index;i++) {
							((List)obj).add(getNewInstance(ReflectUtil.getGenericClassFromMethodReturn(method)));
						}
					}//else FIXME: falta implementar para array
				}
				return getArrayValue(index, obj);
			}else if(!Utils.emptyString(key) && obj instanceof Map<?, ?>){
				Object value = ((Map<?, ?>) obj).get(key);
				if(value==null && createIfIsNull) {
					//FIXME: Implementar para inserir no Map um objeto novo quando for nulo.
				}
				return value;
			}else{
				return obj;
			}
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	private Object getNewInstance(Class type) throws Exception {
        if (Collection.class.isAssignableFrom(type)) {
            return new ArrayList();
        } else if (type == Map.class) {
            return new HashMap();
        } else if (type == Integer.class) {
        	return new Integer(0);
        }
        return type.newInstance();
	}
	
	@SuppressWarnings("rawtypes")
	private Object getArrayValue(int index, Object obj) {
		if(obj instanceof Object[]) {
			return ((Object[]) obj)[index];
		}
		if(obj instanceof List) {
			return ((List) obj).get(index);
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	private int getArraySize(Object obj) {
		if(obj instanceof Object[]) {
			return ((Object[]) obj).length;
		}
		if(obj instanceof List) {
			return ((List) obj).size();
		}
		return -1;
	}	

	
	public boolean setValue(String property, Object root, Object value) throws Exception {
		if(property==null || root==null || property.length()<=0)
			return false;

//		StringTokenizer st = new StringTokenizer(property, "\\.");
//		int count = st.countTokens();
//		int i=0;
//		Object current = root;
//		while(st.hasMoreTokens()) {
//			String attribute = st.nextToken();
//			if(i==count-1) {
//				return performSetValue(attribute, current, value);
//			}
//			current = getValueFromAttribute(attribute, current, true);
//			i++;
//		}
		String st[] = property.split("\\.");
		int count = st.length;
		int i=0;
		Object current = root;
		for(String attribute: st) {
			if(i==count-1) {
				return performSetValue(attribute, current, value);
			}
			current = getValueFromAttribute(attribute, current, true);
			i++;
		}		
		return false;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private boolean performSetValue(String property, Object root, Object value) throws Exception  {
		Method method = null;
		if(property!=null && property.endsWith("]")) { //Executa o set em Lista
			int i0 = property.lastIndexOf('[');
			String propList = property.substring(0, i0);
			
			Object v = getValue(propList, root);
			if(v instanceof Map<?, ?>) {
				Map<Object, Object> map = (Map<Object, Object>) v;
				if(property.charAt(i0+1)=='\'') {
					String key = property.substring(i0+2, property.lastIndexOf("'"));
					map.put(key, value);
				}
			}else{
				List list = (List) v;
				if(list==null) 
					setValue(property, root, new ArrayList());
				int index = Integer.parseInt(property.substring(i0+1, property.length()-1));
				if(list.size()>index) {
					list.set(index, value);
				}else{
					for(int i=list.size();i<index;i++) {
						list.add(null);
					}
					list.add(value);
				}
			}
		}else{ //Executa o set em propriedade normal
			String setterProperty = Utils.getSetterMethodName(property);
			if(value!=null) {
				try{
					method = root.getClass().getMethod(setterProperty, new Class[]{value.getClass()});
				}catch(Exception e){}
				if(method==null) {
					for(Method m: root.getClass().getMethods()) {
						if(m.getName().equals(setterProperty)) {
							if(m.getParameterTypes().length>0) {
								if((m.getParameterTypes()[0]).isInstance(value)) {
									method = m;
									break;
								}
							}
						}
					}
				}
			}
			
			if(method==null)//Busca somente pelo nome, pega o primeiro que encontrar
			for(Method m: root.getClass().getMethods()) {
				if(m.getName().equals(setterProperty)) {
					method = m;
					break;
				}
			}
			
			if(method!=null) {
				try{
					Object valueToSet = value;
					if(method.getParameterTypes().length>0) {
						Class type = method.getParameterTypes()[0];
						if(!type.isInstance(valueToSet)) {
							valueToSet = convertTo(valueToSet, type);
						}
					}
					//method.invoke(root, new Object[]{valueToSet});
					invokeMethod(method, root, new Object[]{valueToSet});
				}catch(Exception e){
					throw e;
				}
				return true;
			}
		}
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	private Object convertTo(Object object, Class type) throws Exception {
		if(type == Integer.class || type == int.class) {
			return new Integer(object.toString());
		}
		if(type == Double.class || type == double.class) {
			return new Double(object.toString());
		}
		if(type == Float.class || type == float.class) {
			return new Float(object.toString());
		}
		if(type == Long.class || type == long.class) {
			return new Long(object.toString());
		}
		if(type == Date.class || type == java.sql.Date.class) {
			if(object!=null)
				return DataSistema.getDate(object.toString());
		}
		return object;
	}
}

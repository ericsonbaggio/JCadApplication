package br.cad.util;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


@SuppressWarnings({"unchecked", "rawtypes"})
public class ReflectUtil {
	public static Object getPropertyValue(Object obj, String prop) throws Exception {
		Method method = obj.getClass().getMethod(Utils.getGetterMethodName(prop), new Class[0]);
		return method.invoke(obj, new Object[0]);
	}
	
	
	public static Class getGenericClassFromList(Object bean, String listName) throws Exception {
//		Method m = getMethod(bean, listName);
//		Type type = m.getGenericReturnType();
//
//		if(type instanceof ParameterizedType){
//			ParameterizedType pt = (ParameterizedType) type;
//			return (Class) pt.getActualTypeArguments()[0];
//		}
		return getGenericClassFromMethodReturn(getMethod(bean, listName));
	}
	
	
	public static Class getClassFromMethodReturn(Method m) throws Exception {
		if(m.getReturnType()!=null && m.getReturnType()==List.class) {
			return getGenericClassFromMethodReturn(m);
		}
		return m.getReturnType();
	}
	
	public static Class getGenericClassFromMethodReturn(Method m) throws Exception {
		Type type = m.getGenericReturnType();

		if(type instanceof ParameterizedType){
			ParameterizedType pt = (ParameterizedType) type;
			return (Class) pt.getActualTypeArguments()[0];
		}
		return null;		
	}
	
	public static Class getClassFromClassProperty(Class cl, String property) throws Exception {
		String chain[] = property.split("\\.");

		Method root = null;
		
		for(String prop: chain) {
			
			//ajuste para ignorar os caracteres [xxx] nas propriedades
			if(prop.endsWith("]")) {
				int index = prop.lastIndexOf('[');
				if(index!=-1) {
					prop = prop.substring(0, index);
				}
			}
			
			root = cl.getMethod(Utils.getGetterMethodName(prop), new Class[0]);
			if(root.getReturnType() ==List.class) {
				cl = getGenericClassFromMethodReturn(root);
			}else{
				if(root.getGenericReturnType() instanceof TypeVariable) {
					//Quando for generics, e necessario invocar o metodo para saber
					//Qual e a classe que esta valendo para aquele metodos generico
					//Somente ira funcionar se o metodo get retornar o objeto
					Object obj = root.invoke(cl.newInstance(), new Object[0]);
					if(obj==null) {
						return null;
					}
					cl = obj.getClass();
				}else{
					cl = root.getReturnType();
				}
			}
			
		}

		return cl;
	}
	
	public static Class getClassFromProperty(Object bean, String property) throws Exception {
//		if(bean instanceof List){
//			System.out.println(bean);
//			
//			Type type = bean.getClass().getGenericInterfaces()[0];
//			ParameterizedType pt = (ParameterizedType) type;
//			System.out.println( pt.getActualTypeArguments()[0]);
//		}
		Method m = getMethod(bean, property);
		if(m.getReturnType() ==List.class) {
			return getGenericClassFromMethodReturn(m);
		}
		return m.getReturnType();
	}
	
	public static Method getMethod(Object bean, String property) throws Exception {
		StringTokenizer st = new StringTokenizer(property,".");
		Object current = bean;
		Method method = null;
		int tokens = st.countTokens();
		int count = 0;
		while(st.hasMoreTokens()) {
			count++;
			String m = st.nextToken();

			//ajuste para ignorar os caracteres [xxx] nas propriedades
			if(m.endsWith("]")) {
				int index = m.lastIndexOf('[');
				if(index!=-1) {
					m = m.substring(0, index);
				}
			}
			if(current instanceof List && method!=null) {
				//Quando for lista busca o generics da lista para continuar
				method = getGenericClassFromMethodReturn(method).getMethod(Utils.getGetterMethodName(m), new Class[]{});
			}else{
				method = current.getClass().getMethod(Utils.getGetterMethodName(m), new Class[]{});
			}
			if(count < tokens) {
				current = method.invoke(current, new Object[0]);
				if(current==null) {
					current = getNewInstance(getClassFromMethodReturn(method));
				}
			}
			
			
		}
		
		//////////////////////////////////////////////////////////////////////
		//// Busca a classe real, caso seja uma classe Proxy do Hibernate ////
		//////////////////////////////////////////////////////////////////////
		String name = current.getClass().getCanonicalName();

		//Primeiro procura _$
		int index = name.indexOf("_$");
		
		//Caso nao encontre _$ procura por $
		if(index==-1)
			index = name.indexOf('$');
		
		if(index>0) {
			name = name.substring(0, index);
			Class realClass =  Class.forName(name);
			method = realClass.getMethod(method.getName(), new Class[0]);
		}
		//////////////////////////////////////////////////////////////////////
		
		
		return method;
	}
	
	/**
	 * Retorna o nome completo da classe, filtrando as classes de proxy do hibernate e javassit
	 * @param cls
	 * @return
	 */
	public static String getRealClassName(Class cls) {
		String name = cls.getCanonicalName();
		
		int index = name.indexOf("_$");
		if(index>0) {
			name = name.substring(0, index);
		}else{
			index = name.indexOf('$');
			if(index>0) {
				name = name.substring(0, index);
			}
		}
		return name;
	}
	
	private static Object getNewInstance(Class type) throws Exception {
        if (Collection.class.isAssignableFrom(type)) {
            return new ArrayList();
        } else if (type == Map.class) {
            return new HashMap();
        } else if (type == Integer.class) {
        	return new Integer(0);
        }
        return type.newInstance();
	}	
	
	public static void main(String args[]) throws Exception {
//		List<Site> sites = new ArrayList<Site>();
//		sites.add(new Site());
//		System.out.println(getClassFromProperty(sites, "classesConteudo"));
	}
}

package br.cad.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;



/**
 * Orderna uma lista de Objetos de acordo com as propriedades passadas em 'order'
 * 
 * Realizar a ordenacao de acordo com a order da lista de 'order'
 *  
 * @author Robson J. P.
 *
 */
public class ObjectSort {
	
	public static<MODEL> List<MODEL> sort(List<MODEL> list, String...order) {
		return sort(list, false, order);
	}
	
	public static<MODEL> List<MODEL> sort(List<MODEL> list, boolean inverse, String...order) {
		ModelComparator mc = null;
		if(!inverse)
			mc = new ModelComparator(order);
		else
			mc = new ModelComparatorInverse(order);
		Collections.sort(list, mc);
		return list;
	}
	
	private static class ModelComparator implements Comparator<Object> {
		private String[] orderList;
		
		public ModelComparator(String[] orderList) {
			this.orderList = orderList;
		}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public int compare(Object model1, Object model2) {
			try {
				if(model1==null && model2==null)
					return 0;
				if(model1==null)
					return -1;
				if(model2==null)
					return 1;
				for(String order: orderList) {
					Object obj1 = getProperty(order, model1);
					Object obj2 = getProperty(order, model2);
					if(obj1==null && obj2 ==null)
						return 0;
					if(obj1==null)
						return -1;
					if(obj2==null)
						return -2;
					if(obj1 instanceof Comparable) {
						int dif = ((Comparable) obj1).compareTo(obj2);
						if(dif!=0)
							return dif;
					}else{
						throw new RuntimeException("A classe "+obj1.getClass()+", passada em order '"+order+"', deve ser Comparable");
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			return 0;
		}
		
		private Object getProperty(String prop, Object model) throws Exception {
			return ObjectBinder.getValueObject(prop, model);
		}
		
	}
	
	private static class ModelComparatorInverse extends ModelComparator {
		public ModelComparatorInverse(String[] orderList) {
			super(orderList);
		}

		@Override
		public int compare(Object model1, Object model2) {
			return -(super.compare(model1, model2));
		}
		
		
	}	
}

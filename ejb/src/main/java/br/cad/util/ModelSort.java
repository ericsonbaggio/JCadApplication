package br.cad.util;

import java.util.List;


import br.cad.model.Model;

/**
 * Orderna uma lista de Models de acordo com as propriedades passadas em 'order'
 * Realizar a ordenacao de acordo com a order da lista de 'order' 
 * @author Robson J. P.
 *
 */
public class ModelSort {
	
	public static<MODEL extends Model> List<MODEL> sort(List<MODEL> list, String...order) {
		return ObjectSort.sort(list, order);
	}
	
	public static<MODEL extends Model> List<MODEL> sort(List<MODEL> list, boolean inverse, String...order) {
		return ObjectSort.sort(list, inverse, order);
	}

}

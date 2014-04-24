package br.cad.util;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import br.cad.model.Model;

/**
 * 
 * @author Will
 *
 * @param <MODEL>
 */
public class GenericDataModel<MODEL extends Model> extends ListDataModel<MODEL> implements SelectableDataModel<MODEL> {

	public GenericDataModel(List<MODEL> list) {
		super(list);
	}
	
	@SuppressWarnings("unchecked")
	public MODEL getRowData(String rowKey) {
		if(rowKey==null)
			return null;
		for(MODEL model: (List<MODEL>) getWrappedData()) {
			String key = (String) getRowKey(model);
			if(rowKey.equals(key)) {
				return model;
			}
		}
		return null;
	}

	public Object getRowKey(MODEL model) {
		if(model!=null) {
			return model.getClass().getName() + "@" + Integer.toHexString(hashCode());
		}
		return null;
	}
	
}

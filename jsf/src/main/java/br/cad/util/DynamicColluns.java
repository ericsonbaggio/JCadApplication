package br.cad.util;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import br.cad.model.Model;

public class DynamicColluns<MODEL extends Model> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MODEL model;
	private String columnTemplate;
	private List<ColumnModel> columns = new ArrayList<ColumnModel>();

	public DynamicColluns(MODEL model, String columnTemplate){
		this.model = model;
		this.columnTemplate = columnTemplate;
	}
	
	public MODEL getModel() {
		return model;
	}

	public void setModel(MODEL model) {
		this.model = model;
	}

	public String getColumnTemplate() {
		return columnTemplate;
	}

	public void setColumnTemplate(String columnTemplate) {
		this.columnTemplate = columnTemplate;
	}

	public void setColumns(List<ColumnModel> columns) {
		this.columns = columns;
	}

	public List<ColumnModel> getColumns() {
		return columns;
	}

	public void createDynamicColumns() {
		String[] columnKeys = columnTemplate.split(", ");
		columns.clear();
		
		Field[] fielders = (Field[]) ArrayUtils.addAll(getModel().getClass().getDeclaredFields(), getModel().getClass().getSuperclass().getDeclaredFields()); 
		
		for (String columnKey : columnKeys) {			
			
			String property = columnKey.substring(columnKey.indexOf("{") + 1, columnKey.indexOf(" "));
			String header = columnKey.substring(columnKey.indexOf(" ") + 1, columnKey.lastIndexOf("}"));
			
			for(Field field : fielders){
				if (field.getName().equals(property)) {
					columns.add(new ColumnModel(header, property));
					break;
				}
			}
			
		}
	}

	static public class ColumnModel implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private String header;
		private String property;

		public ColumnModel(String header, String property) {
			this.header = header;
			this.property = property;
		}

		public String getHeader() {
			return header;
		}

		public String getProperty() {
			return property;
		}
	}
	
	
	public static void main(String[] args){
//		DynamicColluns<Usuario> colluns = new DynamicColluns<Usuario>();
//		colluns.model = new Usuario();
//		
//		colluns.setColumnTemplate("{nmUsuario Nome}, {userName Login}");
//		colluns.createDynamicColumns();
	}
}

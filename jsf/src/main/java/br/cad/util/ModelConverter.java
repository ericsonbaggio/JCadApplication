package br.cad.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.codec.binary.Base64;

import br.cad.model.Model;

/**
 * 
 * @author Will
 *
 */

@FacesConverter(forClass=Model.class)
public class ModelConverter implements Converter {
	
	public ModelConverter() {
	}
	
	/*public Object getAsObject(FacesContext ctx, UIComponent component, String pojo) {
		if(pojo!=null) {
			int index = pojo.indexOf(':');
			if(index!=-1) {
				String classeName = pojo.substring(0, index);
				String id = pojo.substring(index+1, pojo.length());
				try {
					Object obj = HibernateUtil.getSession().load(Class.forName(classeName), new Long(id));
					Hibernate.initialize(obj);
					return obj;
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public String getAsString(FacesContext ctx, UIComponent component, Object pojo) {
		if(pojo!=null && pojo instanceof Model) {
			return HibernateProxyHelper.getClassWithoutInitializingProxy(pojo).getName()+":"+((Model)pojo).getId();
		}
		return null;
	}*/
	
	private static final Logger log = Logger.getLogger(ModelConverter.class.getName());

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		try {
			byte[] data = Base64.decodeBase64(value);
			ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
			Object o = ois.readObject();
			ois.close();
			return o;
		} catch (Exception e) {
			log.log(Level.SEVERE, "Unable to decode PositionMetric!", e);
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(value);
			oos.close();

			return Base64.encodeBase64String(baos.toByteArray());
		} catch (IOException e) {
			log.log(Level.SEVERE, "Unable to encode PositionMetric!", e);
			return "";
		}
	}

}
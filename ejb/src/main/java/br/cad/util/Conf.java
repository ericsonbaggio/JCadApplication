/*
 * Created on 11/12/2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package br.cad.util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;
/**
 */
public class Conf{

	private static Conf manager = null;
	private static Object managerLock = new Object();
	private static String propsName = "/br/cad/cfg/msg.properties";
	
	public Conf()
	{
	}

	public static String getProperty(String name) {
		if (manager == null) {
			synchronized(managerLock) {
				if (manager == null) {
					manager = new Conf(propsName);
				}
			}
		}
		return manager.getProp(name);
	}
	
	public static Long getLongProperty(String name) {
		try{
			return new Long(getProperty(name));
		}catch(Exception e) {
			throw new RuntimeException("Erro ao ler a ropriedade '"+name+"' para uma variável tipo Long");
		}
	}	
    
	public static void setPropsName(String name)
	{
		propsName = name;
	}
    
	public static String getPropsName()
	{
		return propsName;
	}

	/**
	 * Sets a Jive property. If the property doesn't already exists, a new
	 * one will be created.
	 *
	 * @param name the name of the property being set.
	 * @param value the value of the property being set.
	 */
	public static void setProperty(String name, String value) {
		if (manager == null) {
			synchronized(managerLock) {
				if (manager == null) {
					manager = new Conf(propsName);
				}
			}
		}
		manager.setProp(name, value);
	}

	/**
	 * Deletes a Jive property. If the property doesn't exist, the method
	 * does nothing.
	 *
	 * @param name the name of the property to delete.
	 */
	public static void deleteProperty(String name) {
		if (manager == null) {
			synchronized(managerLock) {
				if (manager == null) {
					manager = new Conf(propsName);
				}
			}
		}
		manager.deleteProp(name);
	}

	/**
	 * Compara o valor informado com o valor da propriedade.
	 * 
	 * @param property Propriedade a ser comparada.
	 * @param value Valor a ser comparado.
	 * @return true se o valor informado for igual ao valor da propriedade
	 * e false caso conario.
	 */
	public static boolean equalsProperty(String property, String value) {
		String prop = getProperty(property);
		if(prop!=null)
			return prop.equals(value);
		return false;
	}
	
	/**
	 * Returns the names of the Jive properties.
	 *
	 * @return an Enumeration of the Jive property names.
	 */
	@SuppressWarnings("rawtypes")
	public static Enumeration propertyNames() {
		if (manager == null) {
			synchronized(managerLock) {
				if (manager == null) {
					manager = new Conf(propsName);
				}
			}
		}
		return manager.propNames();
	}

	/**
	 * Returns true if the properties are readable. This method is mainly
	 * valuable at setup time to ensure that the properties file is setup
	 * correctly.
	 */
	public static boolean propertyFileIsReadable() {
		if (manager == null) {
			synchronized(managerLock) {
				if (manager == null) {
					manager = new Conf(propsName);
				}
			}
		}
		return manager.propFileIsReadable();
	}

	/**
	 * Returns true if the properties are writable. This method is mainly
	 * valuable at setup time to ensure that the properties file is setup
	 * correctly.
	 */
	public static boolean propertyFileIsWritable() {
		if (manager == null) {
			synchronized(managerLock) {
				if (manager == null) {
					manager = new Conf(propsName);
				}
			}
		}
		return manager.propFileIsWritable();
	}

	/**
	 * Returns true if the jive.properties file exists where the path property
	 * purports that it does.
	 */
	public static boolean propertyFileExists() {
		if (manager == null) {
			synchronized(managerLock) {
				if (manager == null) {
					manager = new Conf(propsName);
				}
			}
		}
		return manager.propFileExists();
	}


	private Properties properties = null;
	private Object propertiesLock = new Object();
	private String resourceURI;

	/**
	 * Creates a new Conf. Singleton access only.
	 */
	private Conf(String resourceURI) {
		this.resourceURI = resourceURI;
	}

	/**
	 * Gets a Jive property. Jive properties are stored in jive.properties.
	 * The properties file should be accesible from the classpath. Additionally,
	 * it should have a path field that gives the full path to where the
	 * file is located. Getting properties is a fast operation.
	 *
	 * @param name the name of the property to get.
	 * @return the property specified by name.
	 */
	protected String getProp(String name) {
		//If properties aren't loaded yet. We also need to make this thread
		//safe, so synchronize...
		if (properties == null) {
			synchronized(propertiesLock) {
				//Need an additional check
				if (properties == null) {
					loadProps();
				}
			}
		}
		String property = properties.getProperty(name);
		if (property == null) {
			return null;
		}
		else {
			return property.trim();
		}
	}

	/**
	 * Sets a Jive property. Because the properties must be saved to disk
	 * every time a property is set, property setting is relatively slow.
	 */
	protected void setProp(String name, String value) {
		//Only one thread should be writing to the file system at once.
		synchronized (propertiesLock) {
			//Create the properties object if necessary.
			if (properties == null) {
				loadProps();
			}
			properties.setProperty(name, value);
			saveProps();
		}
	}

	protected void deleteProp(String name) {
		//Only one thread should be writing to the file system at once.
		synchronized (propertiesLock) {
			//Create the properties object if necessary.
			if (properties == null) {
				loadProps();
			}
			properties.remove(name);
			saveProps();
		}
	}

	@SuppressWarnings("rawtypes")
	protected Enumeration propNames() {
		//If properties aren't loaded yet. We also need to make this thread
		//safe, so synchronize...
		if (properties == null) {
			synchronized(propertiesLock) {
				//Need an additional check
				if (properties == null) {
					loadProps();
				}
			}
		}
		return properties.propertyNames();
	}

	/**
	 * Loads Jive  from the disk.
	 */
	private void loadProps() {
		properties = new Properties();
		InputStream in = null;
		try {
			in = getClass().getResourceAsStream(resourceURI);
			properties.load(in);
		}
		catch (Exception e) {
			System.err.println("Error reading Jive properties in Conf.loadProps() " + e);
			e.printStackTrace();
		}
		finally {
			try {
				in.close();
			} catch (Exception e) { }
		}
	}

	/**
	 * Saves Jive properties to disk.
	 */
	private void saveProps() {
		//Now, save the properties to disk. In order for this to work, the user
		//needs to have set the path field in the properties file. Trim
		//the String to make sure there are no extra spaces.
		String path = properties.getProperty("path").trim();
		OutputStream out = null;
		try {
			out = new FileOutputStream(path);
			properties.store(out, "msg.properties -- " + (new java.util.Date()));
		}
		catch (Exception ioe) {
			System.err.println("There was an error writing jive.properties to " + path + ". " +
				"Ensure that the path exists and that the Jive process has permission " +
				"to write to it -- " + ioe);
			ioe.printStackTrace();
		}
		finally {
			try {
			   out.close();
			} catch (Exception e) { }
		}
	}

	/**
	 * Returns true if the properties are readable. This method is mainly
	 * valuable at setup time to ensure that the properties file is setup
	 * correctly.
	 */
	public boolean propFileIsReadable() {
		try {
			getClass().getResourceAsStream(resourceURI);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}

	/**
	 * Returns true if the jive.properties file exists where the path property
	 * purports that it does.
	 */
	public boolean propFileExists() {
		String path = getProp("path");
		if( path == null ) {
			return false;
		}
		File file = new File(path);
		if (file.isFile()) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Returns true if the properties are writable. This method is mainly
	 * valuable at setup time to ensure that the properties file is setup
	 * correctly.
	 */
	public boolean propFileIsWritable() {
		String path = getProp("path");
		File file = new File(path);
		if (file.isFile()) {
			//See if we can write to the file
			if (file.canWrite()) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}

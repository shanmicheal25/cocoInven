package com.inven.coco.common.config;

import java.io.*;
import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.inven.coco.common.validation.ValidatorUtil;




/*
 * * @author Gopal
 * @version 1.0
 * @since 21 May 2012
 * 
 */

public class Configuration implements IConfiguration, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8965223977346002947L;

	/**
	 * 
	 */
	private static final long serialVersionUID1 = 8965223977346002947L;

	private static Log log = LogFactory.getLog(Configuration.class);

	private static final String APP_CONFIG_DEFAULT_FILENAME = "META-INF/app-config.properties";

	private static final String TOKEN_SEPARATOR = ",";

	private static String fileNameProperties = "";

	private static Properties table = null;

	private static long readingFileTime = 0;

	private static Configuration thisIstance = null;

	private java.net.URL url = null;
	
	InputStream inputStream;

	/**
	 * ctor -- creates new configuration object and performs initial update.
	 * This method is private because the actual configuration object is
	 * retrieved by a call to a static method getConfiguration...ru
	 */
	public Configuration() {
		System.out.println("Configuration Load");
		url = this.getClass().getClassLoader().getResource(APP_CONFIG_DEFAULT_FILENAME);
		Configuration.fileNameProperties = url.getFile();
		update();
	}

	public Configuration(java.net.URL url) {
		Configuration.fileNameProperties = url.getFile();
		update();
	}	
	/**
	 * ctor -- creates new configuration object and performs initial update.
	 * This method is private because the actual configuration object is
	 * retrieved by a call to a static method getConfiguration...
	 * 
	 * @param fileName
	 *            takes a string representing the name of the file to use as the
	 *            configuration file
	 */
	public Configuration(String fileName) {
		java.net.URL url = this.getClass().getClassLoader().getResource(
				fileName);
		Configuration.fileNameProperties = url.getFile();
		update();		
	}

	public Configuration(String filePath, int intValue) {
		Configuration.fileNameProperties = filePath;
		update();		
	}	
	/**
	 * static method returns the singleton instance of the cnfiguration class
	 * with default filename of "app.properties". Note that the configuration
	 * file will look along the class path to locate this file and use the first
	 * instance of the file encountered along that path.
	 * 
	 * @return Configuration returns the unique istance of this class
	 */
	public static Configuration getConfiguration() {
		if (ValidatorUtil.isNull(thisIstance)) {
			thisIstance = new Configuration();
		}

		return thisIstance;
	}

	public static Configuration getConfiguration(java.net.URL url) {
		if (ValidatorUtil.isNull(thisIstance)) {
			thisIstance = new Configuration(url);
		}

		return thisIstance;
	}	
	/**
	 * static method returns the singleton instance of the configuration class
	 * with a specified filename. Note that the configuration file will look
	 * along the class path to locate this file and use the first instance of
	 * the file encountered along that path.
	 * 
	 * @param fileName
	 *            takes a string representing the name of file to open
	 * @return Configuration returns the unique istance of this class
	 */
	public static Configuration getConfiguration(String fileName) {
		if (thisIstance == null) {
			thisIstance = new Configuration(fileName);
		}

		return thisIstance;
	}

	public static Configuration getConfiguration(String filePath, int value) {
		if (thisIstance == null) {
			thisIstance = new Configuration(filePath,0);
		}

		return thisIstance;
	}	
	/**
	 * sets the version to compare the configuration file agsinst. This
	 * information is passed in when the program starts and is used to maintain
	 * sychronizatoin between builds and configuration files. The stamp in the
	 * configuration file AND in the build are generated when the build is run.
	 * 
	 * @param versionToCompare
	 *            takes a string representing the version info
	 */
	public void setVersionToCompare(String versionToCompare) {
		log.info(" versionToCompare  : "+versionToCompare);
	}

	/**
	 * Returns a property value for a given property name. If there is no value
	 * for the property name, returns empty string "".
	 * 
	 * @param key
	 *            takes a string representing the property name
	 * @return String returns a property value
	 */
	public synchronized String getValue(String key) {
		if ((table == null) || table.isEmpty()) {
			return "";
		}

		return (String) table.get(key);
	}

	/**
	 * Sets a property value for a given property name.
	 * 
	 * @param key
	 *            takes a string representing the property name
	 * @param value
	 *            takes a string representing the property value
	 */
	public synchronized void setValue(String key, String value) {
		if (table != null) {
			table.put(key, value);
		}
	}
	
	/**
	 * Get a list of available keys
	 * @return String[] an array of string
	 */
        public synchronized String[] getKeys() {
            String keys[] = null;
            if (table != null && !table.isEmpty()) {
            	keys = table.keySet().toArray(new String[0]);
            }
            return keys;
        }
	    
	/**
	 * Returns an array of values as strings for properties that contain a comma
	 * separated list of values. If there is no value for the key, returns a
	 * null array.
	 * 
	 * @param key
	 *            takes a string representing the property name
	 * @return String Array returns a string array with all property values
	 */
	public synchronized String[] getValues(String key) {
		String[] values = null;

		if ((table != null) && (!table.isEmpty())) {
			String line = (String) table.get(key);

			if (line != null) {
				StringTokenizer st = new StringTokenizer(line, TOKEN_SEPARATOR);
				values = new String[st.countTokens()];

				for (int i = 0; st.hasMoreElements(); i++) {
					values[i] = (String) st.nextElement();
				}
			}
		}

		return values;
	}

	/**
	 * Retrieves a configuration value returning a default value if no value
	 * exists.
	 * 
	 * @param key
	 *            takes a string representing the property name
	 * @param defaultValue
	 *            takes a string representing the property default value
	 * @return String returns a string as property value
	 */
	public synchronized String getValue(String key, String defaultValue) {
		if ((table == null) || table.isEmpty()) {
			return defaultValue;
		}

		return (table.get(key) != null) ? (String) table.get(key)
				: defaultValue;
	}

	/**
	 * Returns an int value for the specified key. If the key doesn't exist, or
	 * can't be converted to an int, then it returns the default value.
	 * 
	 * @param key
	 *            takes a string representing the name of the value to be
	 *            returned.
	 * @param ciDefaultValue
	 *            takes a string representing the default value to be returned.
	 * @return int returns an interger as value from configuration file or
	 *         default value.
	 */
	public synchronized int getIntValue(String key, int ciDefaultValue) {
		String t_string = getValue(key);
		int t_iReturnValue = ciDefaultValue;

		try {
			t_iReturnValue = Integer.parseInt(t_string);
		} catch (NumberFormatException e) {
			// -- log error and return default --
			if (log.isDebugEnabled()) {
				log
						.debug("Confguration.getValue(return int) retrieved invalid integer for value,"
								+ " substituting default value of "
								+ ciDefaultValue);
			}
		} catch (Exception e) {
			// -- log error and return default --
			if (log.isDebugEnabled()) {
				log.debug("Confguration.getValue(return int) retrieval failed,"
						+ " substituting default value of " + ciDefaultValue);
			}
		}

		return (t_iReturnValue);
	}

	/**
	 * Returns an int value for the specified key. If the key doesn't exist, or
	 * can't be converted to an int, then it returns zero.
	 * 
	 * @param key
	 *            takes a string representing name of the value to be returned.
	 * @return int returns an interger value from configuration file or default
	 *         value.
	 */
	public synchronized int getIntValue(String key) {
		return getIntValue(key, 0);
	}
	
	/**
	 * Returns an int value for the specified key. If the key doesn't exist, or
	 * can't be converted to an int, then it returns the default value.
	 * 
	 * @param key
	 *            takes a string representing the name of the value to be
	 *            returned.
	 * @param ciDefaultValue
	 *            takes a string representing the default value to be returned.
	 * @return int returns an interger as value from configuration file or
	 *         default value.
	 */
	public synchronized float getFloatValue(String key, float ciDefaultValue) {
		String t_string = getValue(key);
		float t_iReturnValue = ciDefaultValue;

		try {
			t_iReturnValue = Float.parseFloat(t_string);
		} catch (NumberFormatException e) {
			// -- log error and return default --
			if (log.isDebugEnabled()) {
				log
						.debug("Confguration.getValue(return float) retrieved invalid float for value,"
								+ " substituting default value of "
								+ ciDefaultValue);
			}
		} catch (Exception e) {
			// -- log error and return default --
			if (log.isDebugEnabled()) {
				log.debug("Confguration.getValue(return int) retrieval failed,"
						+ " substituting default value of " + ciDefaultValue);
			}
		}

		return (t_iReturnValue);
	}

	/**
	 * Returns an int value for the specified key. If the key doesn't exist, or
	 * can't be converted to an int, then it returns zero.
	 * 
	 * @param key
	 *            takes a string representing name of the value to be returned.
	 * @return int returns an interger value from configuration file or default
	 *         value.
	 */
	public synchronized float getFloatValue(String key) {
		return getFloatValue(key, 0);
	}
	
	/**
	 * Returns a boolean value for the specified key. If the key doesn't exist, or
	 * can't be converted to a boolean, then it returns false.
	 * 
	 * @param key takes a string representing name of the value to be returned.
	 * @return boolean returns a boolean value from configuration file or default
	 *         value.
	 */
	public synchronized boolean getBooleanValue(String key) {
	    String t_string = getValue(key);
	    return (t_string!=null && t_string.trim().equalsIgnoreCase("true"));
	}

	/**
	 * Reloads the properties if the property file has changed since the last
	 * time it was loaded
	 */
	private void loadProperties() {
		try {
			File fproperties = new File(fileNameProperties);

			if ((table == null) || table.isEmpty()
					|| (readingFileTime < fproperties.lastModified())) {
				/*log.info("** Updating Application Properties Configuration **");*/

				readingFileTime = System.currentTimeMillis();
				table = new Properties();
				
				table.load(url.openStream());

				String fileName =getValue("kgen.properties");
				FileInputStream fis = new FileInputStream(new File(fileName));
				table.load(fis);
				fis.close();
			}
		} catch (FileNotFoundException fnfe) {
			if (log.isErrorEnabled()) {
				log
						.error("Configuration - file not found:"
								+ fnfe.getMessage());
			}
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			if (log.isErrorEnabled()) {
				log.error("Configuration - ioe exception:" + ioe.getMessage());
			}
			ioe.printStackTrace();
		}
	}

	/**
	 * returns the filename for the configuration file
	 * 
	 * @return String returns a filename
	 */
	public static String getFileName() {
		return Configuration.fileNameProperties;
	}

	/**
	 * returns true if the configuration file version matches the version in the
	 * configuraiton file
	 * 
	 * @return boolean returns boolean true if versions match, false otherwise.
	 */
/*	public boolean isRightVersion() {
		String appPropertiesVersion = getValue(IConfigConstants.APP_PROPERTIES_VERSION);

		if (versionToCompare.equalsIgnoreCase(appPropertiesVersion)) {
			return true;
		} else {
			if (log.isErrorEnabled()) {
				log
						.error("***** APPLICAITON PROPERTY FILE VERSION MISMATCH ******");
			}
		}

		return false;
	}*/

	/**
	 * Configuration monitor calls this to update the properties if the
	 * properties file has changed
	 */
	public synchronized void update() {
		loadProperties();
	}
	
	


}

package com.founder.common;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConfigParameter {
	private static PropertiesConfiguration config;
	private static Log logger = LogFactory.getLog(ConfigParameter.class);

	static {
		try {
			config = new PropertiesConfiguration("systemConfig.properties");
		} catch (Exception e) {
			logger.error(e);
		}
	}
	public static String getLoaclDbPath() {
		return config.getString("LoaclDbPath");
	}
	public static boolean getIsValid(){
		return Boolean.valueOf(config.getString("Valid")).booleanValue();
	} 
	public static boolean setProperties(String key, String value) {
		boolean result = true;
		config.setProperty(key, value);
		try {
			config.save();
		} catch (ConfigurationException e) {
			logger.error(e);
			result = false;
		}
		return result;
	}
}

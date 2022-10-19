package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {


	public static Properties prop;

	public static String url;
	public static String browserName;

	/**
	 * Method used to load properties from config.properties
	 * @return Properties prop
	 */
	public Properties initProperties() {
		
		prop = new Properties();
		
		try {
			FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\config.properties");
			prop.load(fis);
	//		browserName = prop.getProperty("browser");
		//	url = prop.getProperty("url");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prop;
	}

}

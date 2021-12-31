package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// Under Construction
// This class will be implemented in a later update
public class ReadPropertiesFile {

	public static void main(String[] args) {

		Properties prop = new Properties();

		String fileName = "config.properties";
		InputStream is = null;

		try {
			//is = new FileInputStream("config.properties");
		//	is = getClass().getClassLoader().getResourceAsStream(fileName);
			prop.load(is);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		//try {
		//	prop.load(is);
		//} catch (IOException e2) {
		//	e2.printStackTrace();
		//}

		System.out.println(prop.getProperty("fullName"));
	}

	
	
	
	
}

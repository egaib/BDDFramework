package test;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesFile {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		
		String fileName = "config.properties";
		InputStream is = null;
		
		try {
			is = new FileInputStream(fileName);
		} catch (Exception e1){
			e1.printStackTrace();
		}

		try {
			prop.load(is);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		

		System.out.println(prop.getProperty("fullName"));
		
	
		
	}
	
}

//}

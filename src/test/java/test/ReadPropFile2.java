package test;

import java.io.*;
import java.util.*;

public class ReadPropFile2 {



	public static void main(String args[]) throws IOException {
		Properties prop = readPropertiesFile("config.properties");
		System.out.println("fullName: "+ prop.getProperty("fullName"));
		//System.out.println("password: "+ prop.getProperty("password"));
	}
	public static Properties readPropertiesFile(String fileName) throws IOException {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fis.close();
		}
		return prop;
	}

}


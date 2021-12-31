package test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Test_Utilities {

	//Test_Utilities.saveScreenshot("FileName tag desired, eg. Login");
	
	static String ssFilePath = "C:/EG/ssFiles/";

	static WebDriver driver = null;
	
	//constructor
	//public Test_Utilities (WebDriver driver) {
	//	this.driver = driver;
	//}
	
	public static void saveScreenshot(WebDriver driver, String ssFileTag){
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("-yyyy_MM_dd--hh_mm_ss").format(new Date());
		File destFile = new File (ssFilePath + ssFileTag + timeStamp + ".jpg");
		
		try {
			FileUtils.copyFile(scrFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

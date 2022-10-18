package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Test_Utilities {

	//Implementation: Test_Utilities.saveScreenshot("FileName tag desired");

	static String ssFilePath = "C:/EG/ssFiles/";
	static WebDriver driver = null;


	//explicit waits
	// sendkeys & clickOn https://www.youtube.com/watch?v=hRjVVnmmcCc


	public static void saveScreenshot(WebDriver driver, String ssFileTag){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		String timeStamp = new SimpleDateFormat("-yyyy_MM_dd--hh_mm_ss").format(new Date());
		File destFile = new File (ssFilePath + ssFileTag + timeStamp + ".jpg");

		try {
			FileUtils.copyFile(scrFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

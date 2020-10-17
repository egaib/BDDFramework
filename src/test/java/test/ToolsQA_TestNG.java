package test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//load in page object classes
import pages.ToolsQA_AlertsPageObjects;
import pages.ToolsQA_ElementPageObjects;



//not actually being used; confusing how to fully implement
//without using the static main args function
import test.ReadPropertiesFile;


public class ToolsQA_TestNG {

	//	TestNG class does not need main method
	WebDriver driver = null;
	//trying to make these values to read from a Config file...
	String fullName = "Evan";
	String email = "zut@sink.com";


	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		//link chrome webdriver path
		System.setProperty("webdriver.chrome.driver", projectPath + "\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void textBoxForm() {
		
		//Load browser and main website
		driver.get("https://demoqa.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//define page object to call methods from
		ToolsQA_ElementPageObjects toolsQAElementObj = new ToolsQA_ElementPageObjects(driver);
		
		//call methods as described
		toolsQAElementObj.clickMainElementsAppButton();
		toolsQAElementObj.clickElementsButton();
		toolsQAElementObj.clickTextBoxFormButton();
		toolsQAElementObj.setTextInFullNameTextBox(fullName);
		toolsQAElementObj.setTextInEmailTextBox(email);
		toolsQAElementObj.clickSubmitButtonTextBoxForm();
		assertTrue(toolsQAElementObj.fullNameConfirmationText().contains(fullName));
		
	}
	
	
	@Test
	public void checkBoxForm() {
		
		//unfinished
		driver.get("https://demoqa.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		//define page object to call methods from
		ToolsQA_ElementPageObjects toolsQAElementObj = new ToolsQA_ElementPageObjects(driver);
		
		toolsQAElementObj.clickMainElementsAppButton();
		//toolsQAElementObj.clickCheckBoxButton();
		//toolsQAElementObj.clickHomeFolderCheckBox();
		
		
		
	}
	
	
	@Test
	public void alertsForm() {
		
		//unfinished
		driver.get("https://demoqa.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		ToolsQA_AlertsPageObjects toolsQAAlertsObj = new ToolsQA_AlertsPageObjects(driver);
		
		
		
		//unfinished
		System.out.println("alertsForm test complete.");
		
		
	}
	
	
	
	
	
	
	
	
	
	
	@AfterTest
	public void tearDownTest() {
//		driver.close();
//		driver.quit();
		System.out.println("Test Completed Successfully");
	}
	

}

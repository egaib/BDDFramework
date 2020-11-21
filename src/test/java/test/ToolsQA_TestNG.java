package test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//Import page object classes
import pages.ToolsQA_AlertsPageObjects;
import pages.ToolsQA_ElementPageObjects;



//not actually being used; confusing how to fully implement
//without using the static main args function
import test.ReadPropertiesFile;


public class ToolsQA_TestNG {


	//Declare Selenium WebDriver
	WebDriver driver = null;
	
	//Test Data (consider pulling this from a config file instead)
	String fullName = "Evan";
	String email = "testuser@domain.com";

	
	//Set project path and chromedriver path before all tests
	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		
		//Set chrome webdriver path
		System.setProperty("webdriver.chrome.driver", projectPath + "\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	//Get the landing page and wait for the page to load before all tests
	@BeforeMethod
	public void getLandingPage() {
		
		//Consider using a dynamic wait here
		driver.get("https://demoqa.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	//Tests Text Box form
	@Test
	public void textBoxForm() {
		
		//Initialize element page object
		ToolsQA_ElementPageObjects toolsQAElementObj = new ToolsQA_ElementPageObjects(driver);
		
		//Consider combining these steps to one method in the Page Object class
		toolsQAElementObj.clickMainElementsAppButton();
		//toolsQAElementObj.clickElementsButton();
		toolsQAElementObj.clickTextBoxFormButton();
		toolsQAElementObj.setTextInFullNameTextBox(fullName);
		toolsQAElementObj.setTextInEmailTextBox(email);
		toolsQAElementObj.clickSubmitButtonTextBoxForm();
		assertTrue(toolsQAElementObj.fullNameConfirmationText().contains(fullName));
		
	}
	
	//Runs same test as class textBoxForm() above, via new added page object method
	@Test
	public void textBoxForm2() {
		ToolsQA_ElementPageObjects toolsQAElementObj = new ToolsQA_ElementPageObjects(driver);
		
		toolsQAElementObj.fillAndSubmitTextBoxForm(fullName, email);
		assertTrue(toolsQAElementObj.fullNameConfirmationText().contains(fullName));
		assertTrue(toolsQAElementObj.emailConfirmationText().contains(email));
		
	}
	
	//Tests Check Box Form
	@Test
	public void checkBoxForm() {
					
		//Initialize ElementPage object
		ToolsQA_ElementPageObjects toolsQAElementObj = new ToolsQA_ElementPageObjects(driver);
		
		toolsQAElementObj.clickMainElementsAppButton();
		//toolsQAElementObj.clickCheckBoxButton();
		//toolsQAElementObj.clickHomeFolderCheckBox();
				
	}
	
	//Test Radio Button Form
	@Test
	public void radioButton() {
		
		//Initialize ElementPage object
		ToolsQA_ElementPageObjects toolsQAElementObj = new ToolsQA_ElementPageObjects(driver);
		
		
		
		toolsQAElementObj.clickMainElementsAppButton();
		//toolsQAElementObj.clickElementsButton();
		toolsQAElementObj.clickRadioButtonButton();
		
		new WebDriverWait(driver, 5);
		toolsQAElementObj.clickYesRadioButton();
		//assertTrue(toolsQAElementObj.radioButtonIsSelected());
	}
	
	//Tests Alerts Form
	@Test
	public void alertsForm() {
			
		//Initialize new AlertPage object
		ToolsQA_AlertsPageObjects toolsQAAlertsObj = new ToolsQA_AlertsPageObjects(driver);
		
		toolsQAAlertsObj.clickMainAlertsAppButton();
		//toolsQAAlertsObj.clickAlertsDropdownButton();
		toolsQAAlertsObj.clickAlertsFormButton();
		toolsQAAlertsObj.clickTopAlertButton();
		
		//String response = toolsQAAlertsObj.clickTopAlertButton();
		
		
		
		
		//System.out.println(response);
		
		
	}
	
	
	
	//Teardown once tests are complete
	//@AfterSuite
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
	}
	

}

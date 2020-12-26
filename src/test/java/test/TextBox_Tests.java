package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//Import page object classes
import pages.AlertsPageObjects;
import pages.TextBoxPageObjects;
import pages.ButtonsPageObjects;


//not actually being used; confusing how to fully implement
//without using the static main args function
import test.ReadPropertiesFile;


public class TextBox_Tests extends BaseSetupClass {

	//Test Data (consider reading from properties / config file
	String fullName = "Evan";
	String email = "testuser@domain.com";

	//Tests Text Box form
	@Test
	public void TB1() {
		TextBoxPageObjects textBoxPageObj = new TextBoxPageObjects(driver);
		
		//Navigate to TextBox form, enter fullName in text box, and submit form
		textBoxPageObj.clickMainElementsAppButton();
		textBoxPageObj.clickTextBoxFormButton();
		textBoxPageObj.setTextInFullNameTextBox(fullName);
		textBoxPageObj.clickSubmitButtonTextBoxForm();
		
		//Assert that output contains fullName as entered
		assertTrue(textBoxPageObj.fullNameConfirmationText().contains(fullName));
				
	}
	
	//Runs same test as class textBoxForm() above, via new added page object method
	@Test
	public void TB2() {
		TextBoxPageObjects textBoxPageObj = new TextBoxPageObjects(driver);
	
		//Navigate to TextBox form, enter email in text box, and submit form
		textBoxPageObj.clickMainElementsAppButton();
		textBoxPageObj.clickTextBoxFormButton();
		textBoxPageObj.setTextInEmailTextBox(email);
		textBoxPageObj.clickSubmitButtonTextBoxForm();
		
		//This is a combination of all steps; not used, possibly delete
		//textBoxPageObj.fillAndSubmitTextBoxForm(fullName, email);
		
		//Assert that output box contains email as entered
		assertTrue(textBoxPageObj.emailConfirmationText().contains(email));
		
	}
	
	
	
	
	/*
	 * 
	 * 
	//Tests Check Box Form
	//@Test
	public void checkBoxForm() {
					
		//Initialize ElementPage object
		TextBoxPageObjects toolsQAElementObj = new TextBoxPageObjects(driver);
		
		toolsQAElementObj.clickMainElementsAppButton();
		//toolsQAElementObj.clickCheckBoxButton();
		//toolsQAElementObj.clickHomeFolderCheckBox();
		
		
				
	}
	
	//Test Radio Button Form
	//@Test
	public void radioButton() {
		
		//Initialize ElementPage object
		TextBoxPageObjects toolsQAElementObj = new TextBoxPageObjects(driver);
		
		
		toolsQAElementObj.clickMainElementsAppButton();
		//toolsQAElementObj.clickElementsButton();
		toolsQAElementObj.clickRadioButtonButton();
		
		new WebDriverWait(driver, 5);
		toolsQAElementObj.clickYesRadioButton();
		//assertTrue(toolsQAElementObj.radioButtonIsSelected());
	}
	*
	*
	*/
	


}

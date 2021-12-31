package test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.TextBoxPageObjects;

public class TextBox_Tests extends TestBaseSetup {

	// Test data 
	String fullName = "Evan G";
	String email = "testuser@domain.com";

	// Declare page object
	TextBoxPageObjects textBoxPageObj = null;

	// Initialize page object and navigate to page
	// Note: Methods cannot be run in parallel with this instantiation in @BeforeMethod
	@BeforeMethod
	public void TextBoxTestSetup() {
		textBoxPageObj = new TextBoxPageObjects(driver);
		textBoxPageObj.clickMainElementsAppButton();
		textBoxPageObj.clickTextBoxFormButton();
	}

	@Test
	public void TB1() {
		textBoxPageObj.setTextInFullNameTextBox(fullName);
		Test_Utilities.saveScreenshot(driver, "TB1-SetNameInNameTextbox");
		textBoxPageObj.clickSubmitButtonTextBoxForm();
		assertTrue(textBoxPageObj.fullNameConfirmationText().contains(fullName));
	}

	@Test
	public void TB2() {
		textBoxPageObj.setTextInEmailTextBox(email);
		Test_Utilities.saveScreenshot(driver, "TB2-SetEmailInEmailTextbox");
		textBoxPageObj.clickSubmitButtonTextBoxForm();
		assertTrue(textBoxPageObj.emailConfirmationText().contains(email));
	}

}

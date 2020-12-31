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
		// From TextBoxPage, enter fullName in text box, and submit form
		textBoxPageObj.setTextInFullNameTextBox(fullName);
		textBoxPageObj.clickSubmitButtonTextBoxForm();

		// Assert that output contains fullName as entered
		assertTrue(textBoxPageObj.fullNameConfirmationText().contains(fullName));
	}

	@Test
	public void TB2() {
		// From TextBoxPage, enter email in text box, and submit form
		textBoxPageObj.setTextInEmailTextBox(email);
		textBoxPageObj.clickSubmitButtonTextBoxForm();

		// Assert that output box contains email as entered
		assertTrue(textBoxPageObj.emailConfirmationText().contains(email));
	}

}

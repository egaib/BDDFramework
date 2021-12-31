package test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ButtonsPageObjects;

public class Buttons_Tests extends TestBaseSetup {

	// Declare page object
	ButtonsPageObjects buttonsPageObj = null;

	// Initialize page object and navigate to page
	@BeforeMethod
	public void AlertsTestSetup() {
		buttonsPageObj = new ButtonsPageObjects(driver);
		buttonsPageObj.clickMainElementsAppButton();
		buttonsPageObj.clickButtonsFormButton();
	}

	@Test
	public void BT1() {
		buttonsPageObj.doubleClickDoubleClickButton();
		Test_Utilities.saveScreenshot(driver, "BT1-DoubleClickButton");
		assertEquals(buttonsPageObj.getDoubleClickMessage(), "You have done a double click");

	}

	@Test
	public void BT2() {
		buttonsPageObj.rightClickRightClickButton();
		Test_Utilities.saveScreenshot(driver, "BT2-RightClickButton");
		assertEquals(buttonsPageObj.getRightClickMessage(), "You have done a right click");
	}

}

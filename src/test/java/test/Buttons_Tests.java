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
		// Double click then assert against response message for confirmation
		buttonsPageObj.doubleClickDoubleClickButton();
		assertEquals(buttonsPageObj.getDoubleClickMessage(), "You have done a double click");

	}

	@Test
	public void BT2() {
		// Right click then assert against response message for confirmation
		buttonsPageObj.rightClickRightClickButton();
		assertEquals(buttonsPageObj.getRightClickMessage(), "You have done a right click");
	}

}

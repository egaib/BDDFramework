package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AlertsPageObjects;

public class Alerts_Tests extends TestBaseSetup {

	// Test data
	String name = "Evan";

	// Declare page object
	AlertsPageObjects alertsPageObj = null;

	// Initialize page object and navigate to page
	// Note: Methods cannot be run in parallel with this initialization in @BeforeMethod
	@BeforeMethod
	public void AlertsTestSetup() {
		alertsPageObj = new AlertsPageObjects(driver);
		alertsPageObj.clickMainAlertsAppButton();
		alertsPageObj.clickAlertsFormButton();
	}

	@Test
	public void AL1() {

		Test_Utilities.saveScreenshot(driver, "AL1-ClickTopAlertButton");
		alertsPageObj.clickTopAlertButton();

		//Note an error occurs when attempting to screenshot when alert is present

		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Test_Utilities.saveScreenshot(driver, "AL1-AcceptAlert");

		assertEquals(alertMessage, "You clicked a button");
	}

	@Test
	public void AL2() {

		Test_Utilities.saveScreenshot(driver, "AL2-ClickTimerAlertButton");
		alertsPageObj.clickTimerAlertButton();

		// Wait for >5 seconds for alert to show (explicit wait used to match button functionality)
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Test_Utilities.saveScreenshot(driver, "AL2-AcceptAlert");

		assertEquals(alertMessage, "This alert appeared after 5 seconds");

	}

	@Test
	public void AL3() {

		Test_Utilities.saveScreenshot(driver, "AL3-ClickConfirmAlertButton");
		alertsPageObj.clickConfirmAlertButton();

		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		Test_Utilities.saveScreenshot(driver, "AL3-AcceptAlert");
		
		assertEquals(alertMessage, "Do you confirm action?");
		assertTrue(alertsPageObj.getConfirmResultText().contains("Cancel"));

	}

	@Test
	public void AL4() {

		Test_Utilities.saveScreenshot(driver, "AL4-ClickPromptAlertButton");
		alertsPageObj.clickPromptAlertButton();

		driver.switchTo().alert().sendKeys(name);
		driver.switchTo().alert().accept();
		Test_Utilities.saveScreenshot(driver, "AL4-AcceptAlert");		
		
		assertTrue(alertsPageObj.getPromptResultText().contains(name));

	}

}

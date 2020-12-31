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

		// From AlertsPage, click the 1st alert button
		alertsPageObj.clickTopAlertButton();

		// Verify alert opened with specified message
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();

		// Compare alert message to expected message
		assertEquals(alertMessage, "You clicked a button");
	}

	@Test
	public void AL2() {

		// From AlertsPage, click the 2nd alert button
		alertsPageObj.clickTimerAlertButton();

		// Wait for >5 seconds for alert to show
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			System.out.println(e);
		}

		// Get alert message and accept alert
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();

		// Compare alert message to expected message
		assertEquals(alertMessage, "This alert appeared after 5 seconds");

	}

	@Test
	public void AL3() {

		// From AlertsPage, click the 3rd alert button
		alertsPageObj.clickConfirmAlertButton();

		// Get alert message and dismiss alert
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();

		// AssertEquals that the alert message equals the expected message
		assertEquals(alertMessage, "Do you confirm action?");

		// AssertTrue that the alert was dismissed
		assertTrue(alertsPageObj.getConfirmResultText().contains("Cancel"));

	}

	@Test
	public void AL4() {

		// From AlertsPage, click the 4th alert button
		alertsPageObj.clickPromptAlertButton();

		// Enter name into alert text box and accept
		driver.switchTo().alert().sendKeys(name);
		driver.switchTo().alert().accept();

		// AssertEquals that the entered name is shown
		assertTrue(alertsPageObj.getPromptResultText().contains(name));

	}

}

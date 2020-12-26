package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AlertsPageObjects;

public class Alerts_Tests extends BaseSetupClass {

	@Test
	public void AL1() {

		//Initialize AlertsPage object
		AlertsPageObjects alertsPageObj = new AlertsPageObjects(driver);

		alertsPageObj.clickMainAlertsAppButton();
		alertsPageObj.clickAlertsFormButton();
		alertsPageObj.clickTopAlertButton();

		//Verify alert opened with specified message
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		//Compare alert message to expected message
		assertEquals(alertMessage, "You clicked a button");
	}

	
	@Test
	public void AL2() {
		
		//Initialize AlertsPage object
		AlertsPageObjects alertsPageObj = new AlertsPageObjects(driver);
		
		alertsPageObj.clickMainAlertsAppButton();
		alertsPageObj.clickAlertsFormButton();
		alertsPageObj.clickTimerAlertButton();
		
		//Wait for >5 seconds for alert to show
		try {
			Thread.sleep(6000);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		//Get alert message and accept alert
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		//Compare alert message to expected message
		assertEquals(alertMessage, "This alert appeared after 5 seconds");
		
	}
	
	

}

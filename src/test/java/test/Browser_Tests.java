package test;

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
import pages.BrowserPageObjects;

public class Browser_Tests extends BaseSetupClass {


	@Test
	public void BW1(){

		//Initialize AlertsPage object
		BrowserPageObjects browserPageObj = new BrowserPageObjects(driver);

		browserPageObj.clickMainAlertsAppButton();
		browserPageObj.clickBrowserFormButton();
		browserPageObj.clickNewTabButton();
			
		
	}	




}

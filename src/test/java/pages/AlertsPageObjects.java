package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPageObjects {

	//Declare Webdriver
	WebDriver driver = null;

	//Locator declarations
	//Alerts, Frame & Windows drop-down list
	By mainAlertsAppButton = By.xpath("//h5[contains(text(),'Frame')]");
	By alertsFormButton = By.xpath("//span[contains(text(),'Alerts')]"); 
	
	
	//Alerts form
	By topAlertButton = By.id("alertButton");
	By timerAlertButton = By.id("timerAlertButton");
	By confirmAlertButton = By.id("confirmButton");
	By promptAlertButton = By.id("promtButton");


	//Constructor
	public AlertsPageObjects (WebDriver driver) {
		this.driver = driver;
	}


	//Alerts form methods
	public void clickMainAlertsAppButton() {
		driver.findElement(mainAlertsAppButton).click();
	}

	public void clickAlertsFormButton() {
		driver.findElement(alertsFormButton).click();
	}

	public void clickTopAlertButton() {
		driver.findElement(topAlertButton).sendKeys(Keys.ENTER);
	}

	public void clickTimerAlertButton() {
		driver.findElement(timerAlertButton).sendKeys(Keys.ENTER);
	}


}

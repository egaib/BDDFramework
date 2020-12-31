package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AlertsPageObjects {

	// Declare Webdriver
	WebDriver driver = null;

	// Locators
	By mainAlertsAppButton = By.xpath("//h5[contains(text(),'Frame')]");
	By alertsFormButton = By.xpath("//span[contains(text(),'Alerts')]");
	By topAlertButton = By.id("alertButton");
	By timerAlertButton = By.id("timerAlertButton");
	By confirmAlertButton = By.id("confirmButton");
	By confirmResultText = By.id("confirmResult");
	By promptAlertButton = By.id("promtButton");
	By promptResultText = By.id("promptResult");

	// Initialize webdriver
	public AlertsPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	// Alerts page methods
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

	public void clickConfirmAlertButton() {
		driver.findElement(confirmAlertButton).sendKeys(Keys.ENTER);
	}

	public String getConfirmResultText() {
		return driver.findElement(confirmResultText).getText();
	}

	public void clickPromptAlertButton() {
		driver.findElement(promptAlertButton).sendKeys(Keys.ENTER);
	}

	public String getPromptResultText() {
		return driver.findElement(promptResultText).getText();
	}

}

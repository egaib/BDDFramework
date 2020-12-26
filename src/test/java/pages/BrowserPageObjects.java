package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserPageObjects {


	//Declare Webdriver
	WebDriver driver = null;

	//Locator declarations
	//Alerts, Frame & Windows drop-down list
	By mainAlertsAppButton = By.xpath("//h5[contains(text(),'Frame')]");
	By browserFormButton = By.xpath("//span[contains(text(),'Browser Windows')]"); 

	//Browser Window form
	By browserWindowsButton = By.id("item-0");
	By newTabButton = By.id("tabButton");
	By newWindowButton = By.id("windowButton");
	By newWindowMessageButton = By.id("messageWindowButton");


	public BrowserPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	//Browser form methods
	public void clickMainAlertsAppButton() {
		driver.findElement(mainAlertsAppButton).click();
	}

	public void clickBrowserFormButton() {
		driver.findElement(browserFormButton).click();
	}


	//Browser Windows form
	public void clickNewTabButton() {
		driver.findElement(newTabButton).click();
	}

	public void clickNewWindowButton() {
		driver.findElement(newWindowButton).click();
	}

	public void clickNewWindowMessageButton() {
		driver.findElement(newWindowMessageButton);
	}













}

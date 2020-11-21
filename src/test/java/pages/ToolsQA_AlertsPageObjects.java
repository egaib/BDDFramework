package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolsQA_AlertsPageObjects {

	//Declare Webdriver
	WebDriver driver = null;
	
	//Locator declarations
	//Alerts, Frame & Windows drop-down list
	By mainAlertsAppButton = By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]");
	By alertsDropdownButton = By.xpath("//div[contains(text(),'Alerts, Frame & Windows')]");
	
	
		//Browser Window form
		By browserWindowsButton = By.id("item-0");
		By newTabButton = By.id("tabButton");
		By newWindowButton = By.id("windowButton");
		By newWindowMessageButton = By.id("messageWindowButton");
			
		//Alerts form
		//Add specifics to this; it is deferring to the first "item-1" on the page in the elements dropdown
		By alertsFormButton = By.xpath("item-1"); 
		By topAlertButton = By.id("alertButton");
		By timerAlertButton = By.id("timerAlertButton");
		By confirmAlertButton = By.id("confirmButton");
		By promptAlertButton = By.id("promtButton");
		
	
	//Constructor
	public ToolsQA_AlertsPageObjects (WebDriver driver) {
		this.driver = driver;
		new WebDriverWait(driver, 5)
			.until(ExpectedConditions.textToBe(By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]"), "Alerts, Frame & Windows"));
	}
	
	
	//Browser Windows form
	public void clickNewTabButton() {
		driver.findElement(newTabButton).click();
	}
	
	
	
	//Alerts form
	public void clickMainAlertsAppButton() {
		driver.findElement(mainAlertsAppButton).click();
	}
	
	public void clickAlertsDropdownButton() {
			driver.findElement(alertsDropdownButton).click();
	}
	
	public void clickAlertsFormButton() {
		driver.findElement(alertsFormButton).click();
	}
	
	public void clickTopAlertButton() {
		driver.findElement(topAlertButton).sendKeys(Keys.ENTER);
		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		//String alertText= driver.switchTo().alert().getText();
		//return alertText;
		
	}
	
	
	
	
	
	
}

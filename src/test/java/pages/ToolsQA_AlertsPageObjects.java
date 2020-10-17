package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToolsQA_AlertsPageObjects {

	WebDriver driver = null;
	//Alerts, Frame & Windows dropdown list
	By alertsButton = By.xpath("//span[contains(text(),'Alerts')]");
		//Browser Window form
		By browserWindowsButton = By.id("item-0");
		By newTabButton = By.id("tabButton");
		By newWindowButton = By.id("windowButton");
		By newWindowMessageButton = By.id("messageWindowButton");
			
		
	
	//Constructor
	public ToolsQA_AlertsPageObjects (WebDriver driver) {
		this.driver = driver;
	}
	
	//Alerts Tab
	public void clickAlertsButton() {
		driver.findElement(alertsButton).click();
	}
	
	//Browser Windows
	public void clickNewTabButton() {
		driver.findElement(newTabButton).click();
	}
	
	
	
}

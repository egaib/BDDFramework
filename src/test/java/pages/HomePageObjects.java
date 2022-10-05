package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.HomePageTests;
import test.TestBaseSetup;

public class HomePageObjects extends TestBaseSetup {

	WebDriver driver;

	By homeStoreTab = By.xpath("//li/*[contains(text(),'Store')]");
	By anchorBraceletTextLink = By.xpath("//div/a/*[contains(text(),'Anchor')]");
	By productName = By.xpath("//h1[contains(@class,\"product_title\")]");

	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void clickStoreTab() {
		driver.findElement(homeStoreTab).click();
	}

	public void clickAnchorBracelet() {
		driver.findElement(anchorBraceletTextLink).click();
	}

	public String productName() {
		return driver.findElement(productName).getText();
	}


	//example JS 
	//	public void clickSubmitButtonTextBoxForm() {
	//		WebElement submitButton = driver.findElement(submitButtonTextBoxForm);
	//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
	//		
	//		driver.findElement(submitButtonTextBoxForm).click();
	//	}

}

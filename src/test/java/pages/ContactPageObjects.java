package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.HomePageTests;
import test.TestBaseSetup;

public class ContactPageObjects extends TestBaseSetup {

	WebDriver driver;

	private By homeContactTab = By.xpath("//li/*[contains(text(),'Contact Us')]");
	private By emailText = By.xpath("//p[contains(text(),'Email')]/strong");

	public ContactPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void clickContactTab() {
		driver.findElement(homeContactTab).click();
	}

	public String emailText() {
		return driver.findElement(emailText).getText();
	}

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPageObjects {

	//extends TestBaseSetup
	
	private WebDriver driver;

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

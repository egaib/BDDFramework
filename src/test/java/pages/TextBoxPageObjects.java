package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPageObjects {

	// Declare WebDriver
	WebDriver driver = null;

	// Locators
	By mainElementsAppButton = By.xpath("//h5[contains(text(),'Elements')]");
	By textBoxFormButton = By.id("item-0");
	By fullNameTextBox = By.id("userName");
	By emailTextBox = By.id("userEmail");
	By submitButtonTextBoxForm = By.id("submit");
	By fullNameConfirmationText = By.id("name");
	By emailConfirmationText = By.id("email");

	// Initialize webdriver
	public TextBoxPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	// Text Box Page methods
	public void clickMainElementsAppButton() {
		driver.findElement(mainElementsAppButton).click();
	}

	public void clickTextBoxFormButton() {
		driver.findElement(textBoxFormButton).click();
	}

	public void setTextInFullNameTextBox(String text) {
		driver.findElement(fullNameTextBox).sendKeys(text);
	}

	public void setTextInEmailTextBox(String text) {
		driver.findElement(emailTextBox).sendKeys(text);
	}

	public void clickSubmitButtonTextBoxForm() {
		driver.findElement(submitButtonTextBoxForm).click();
	}

	public String fullNameConfirmationText() {
		return driver.findElement(fullNameConfirmationText).getText();
	}

	public String emailConfirmationText() {
		return driver.findElement(emailConfirmationText).getText();
	}

}

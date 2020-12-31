package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ButtonsPageObjects {

	// Declare webdriver
	WebDriver driver = null;

	// Locators
	By mainElementsAppButton = By.xpath("//h5[contains(text(),'Elements')]");
	By buttonsFormButton = By.xpath("//span[contains(text(),'Buttons')]");
	By doubleClickButton = By.id("doubleClickBtn");
	By doubleClickMessage = By.id("doubleClickMessage");
	By rightClickButton = By.id("rightClickBtn");
	By rightClickMessage = By.id("rightClickMessage");

	// Initialize webdriver
	public ButtonsPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	// Buttons page methods
	public void clickMainElementsAppButton() {
		driver.findElement(mainElementsAppButton).click();
	}

	public void clickButtonsFormButton() {
		driver.findElement(buttonsFormButton).click();
	}

	public void doubleClickDoubleClickButton() {
		// Use Selenium Actions class to perform a double click
		Actions actions = new Actions(driver);
		actions.doubleClick(driver.findElement(doubleClickButton)).perform();

	}

	public String getDoubleClickMessage() {
		return driver.findElement(doubleClickMessage).getText();
	}

	public void rightClickRightClickButton() {
		// use Selenium Actions class to perform a right click
		Actions actions = new Actions(driver);
		actions.contextClick(driver.findElement(rightClickButton)).perform();

	}

	public String getRightClickMessage() {
		return driver.findElement(rightClickMessage).getText();
	}

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ToolsQA_ElementPageObjects {

	WebDriver driver = null;
	
	//Locator assignments in one place for findElement methods in this class
	//(pulled from inspecting web site)
	By mainElementsAppButton = By.id("app");
	By elementsButton = By.xpath("//div[contains(text(),'Elements')]");	
	
		//Text Box form 
		By textBoxFormButton = By.id("item-0");	
		By fullNameTextBox = By.id("userName");	
		By emailTextBox = By.id("userEmail");	
		By submitButtonTextBoxForm = By.id("submit");	
		By fullNameConfirmationText = By.id("name");
	
		//Check Box form
		By checkBoxFormButton = By.id("item-1");	
		
	

		By homeFolderCheckBox = By.xpath("//*[@id='tree-node-home']"); 
		By homeFolderExpand = By.xpath("//*[@aria-label='Toggle']");

	
		//Radio Button form
	
	
		//Web Tables form
	
		//Buttons form
	
		//Links form
	
		//Broken Links - Images form
	
		//Upload and Download form
	
		//Dynamic Properties form
			
				
		
	
	
	//Constructor
	public ToolsQA_ElementPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	//Main Screen
	public void clickMainElementsAppButton() {
		driver.findElement(mainElementsAppButton).click();
	}
	
	//Elements Tab
	public void clickElementsButton() {
		driver.findElement(elementsButton).click();
	}
	
	//Text Box form actions
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
	

	//Check Box form actions 
	public void clickCheckBoxButton() {
		Select homeDir = new Select(driver.findElement(checkBoxFormButton));
		homeDir.selectByVisibleText("Home");
	}

	public void clickHomeFolderCheckBox() {
		driver.findElement(homeFolderCheckBox).click(); 
	}


	
}

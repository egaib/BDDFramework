package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolsQA_ElementPageObjects {

	//Declare Selenium WebDriver
	WebDriver driver = null;
	
	//Locator declarations
	By mainElementsAppButton = By.xpath("//h5[contains(text(),'Elements')]");
	By elementsButton = By.xpath("//div[contains(text(),'Elements')]");	
	
		//Text Box form 
		By textBoxFormButton = By.id("item-0");	
		By fullNameTextBox = By.id("userName");	
		By emailTextBox = By.id("userEmail");	
		By submitButtonTextBoxForm = By.id("submit");	
		By fullNameConfirmationText = By.id("name");
		By emailConfirmationText = By.id("email");
	
		//Check Box form
		By checkBoxFormButton = By.id("item-1");	
		
		//Review these xpaths for stability
		By homeFolderCheckBox = By.xpath("//*[@id='tree-node-home']"); 
		By homeFolderExpand = By.xpath("//*[@aria-label='Toggle']");

	
		//Radio Button form
		By radioButtonFormButton = By.id("item-2");
		//First radio button not working; review this locator
		By radioButtonYes = By.id("yesRadio");
		
	
		//Web Tables form
	
		//Buttons form
	
		//Links form
	
		//Broken Links - Images form
	
		//Upload and Download form
	
		//Dynamic Properties form
	
	//Constructor
	public ToolsQA_ElementPageObjects(WebDriver driver) {
		this.driver = driver;
		
		//Dynamic wait, until Elements is available 
		// (see if this can be moved to @BeforeMethod of base test class)
		new WebDriverWait(driver, 5)
			.until(ExpectedConditions.textToBe(By.xpath("//h5[contains(text(),'Elements')]"), "Elements"));
	}
	
	//Main Screen
	public void clickMainElementsAppButton() {
		driver.findElement(mainElementsAppButton).click();
	}
	
	//Elements Tab
	public void clickElementsButton() {
		driver.findElement(elementsButton).click();
	}
	
	//Text Box Page methods 
	//Consider combining some of these where applicable to perform a more complex action
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
		
	public void fillAndSubmitTextBoxForm(String fullName, String email) {
		this.clickMainElementsAppButton();
		this.clickElementsButton();
		this.clickTextBoxFormButton();
		this.setTextInFullNameTextBox(fullName);
		this.setTextInEmailTextBox(email);
		this.clickSubmitButtonTextBoxForm();
	}
	
	//Text Box confirmation actions
	public String fullNameConfirmationText() {
		return driver.findElement(fullNameConfirmationText).getText();
	}
	
	public String emailConfirmationText() {
		return driver.findElement(emailConfirmationText).getText();
	}
	
	

	//Check Box form actions 
	public void clickCheckBoxButton() {
		Select homeDir = new Select(driver.findElement(checkBoxFormButton));
		homeDir.selectByVisibleText("Home");
	}

	public void clickHomeFolderCheckBox() {
		driver.findElement(homeFolderCheckBox).click(); 
	}


	//Radio Button form actions
	
	public void clickRadioButtonButton() {
		driver.findElement(radioButtonFormButton).click();
	}
	
	public void clickYesRadioButton() {
		driver.findElement(radioButtonYes).click();
	}
	
	public boolean radioButtonIsSelected() {
		return driver.findElement(radioButtonYes).isSelected();
	}
	
	
}

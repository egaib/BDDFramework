package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObjects {

	private WebDriver driver;

	private By homeStoreTab = By.xpath("//li/*[contains(text(),'Store')]");
	private By anchorBraceletTextLink = By.xpath("//div/a/*[contains(text(),'Anchor')]");
	private By productName = By.xpath("//h1[contains(@class,\"product_title\")]");
	private By addToCart = By.xpath("//button[contains(text(),'Add to cart')]");
	private By cartLinkWithCount = By.xpath("//*[@class='cart-container']");
	private By anchorBraceletInCart = By.xpath("//td[contains(@class,'product-name')]/a[contains(text(),'Anchor Bracelet')]");
	private By addToCartNotice = By.xpath("//div[@class='woocommerce-message']");

	public HomePageObjects(WebDriver driver) {
		//120 replace with getdriver()..
		this.driver = driver;
	}

	public boolean validateAnchorBraceletInCart() {
		return driver.findElement(anchorBraceletInCart).isDisplayed();
	}

	public void clickCartLinkWithCount() {
		driver.findElement(cartLinkWithCount).click();
	}

	public void clickAddToCart() {
		driver.findElement(addToCart).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartNotice));
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


}

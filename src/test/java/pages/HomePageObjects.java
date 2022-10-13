package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import test.HomePageTests;
import test.TestBaseSetup;

public class HomePageObjects {

	//may need to pass threadlocal driver here
	WebDriver driver;

	By homeStoreTab = By.xpath("//li/*[contains(text(),'Store')]");
	By anchorBraceletTextLink = By.xpath("//div/a/*[contains(text(),'Anchor')]");
	By productName = By.xpath("//h1[contains(@class,\"product_title\")]");
	By addToCart = By.xpath("//button[contains(text(),'Add to cart')]");
	By cartLinkWithCount = By.xpath("//*[@class='cart-container']");
	By anchorBraceletInCart = By.xpath("//td[contains(@class,'product-name')]/a[contains(text(),'Anchor Bracelet')]");
	By addToCartNotice = By.xpath("//div[@class='woocommerce-message']");

	public HomePageObjects(WebDriver driver) {
		//120 replace with getdriver()..
		this.driver = driver;
	}

	public boolean validateAnchorBraceletInCart() {
		if (driver.findElement(anchorBraceletInCart).isDisplayed()) {
			return true;
		} else {
			return false;
		}
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

package stepDefs;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import appLib.MainLib;
import components.GlobalVariables;
import components.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import pages.ContactPageObjects;
import pages.HomePageObjects;

public class StepDefs extends DriverFactory {

	//	public static WebDriver driver;
//	public ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();	

//35:30
	
	//setDriver(new DriverFactory.createDriver();
	//120, 4:00, 
		
	// <Hooks>
	@Before (value="@Regression", order=1)
	public void browserSetup() {
		DriverFactory.createDriver();
		//setDriver(new DriverFactory.createDriver();
		System.out.println("Setup:");
		System.out.println("Thread Name: " + Thread.currentThread().getName());
		System.out.println("Thread ID: " + Thread.currentThread().getId());
	}

	@After
	public void tearDown() {
		System.out.println("Teardown: ");
		System.out.println("Thread Name: " + Thread.currentThread().getName());
		System.out.println("Thread ID: " + Thread.currentThread().getId());
		driver.get().quit();
	//	Don't set driver = null unless using parallel execution
		//driver = null; 
	} 	
	// </Hooks>
	
	
	@Given("The website is loaded")
	public void the_website_is_loaded() {
		driver.get().get(url);
	}

	@Given("The user adds an Item to the cart")
	public void the_user_adds_an_item_to_the_cart() {	
		homePageObj.clickStoreTab();
		homePageObj.clickAnchorBracelet();
		Assert.assertEquals(homePageObj.productName(), "Anchor Bracelet");
		homePageObj.clickAddToCart();
	}

	@When("The user navigates to the cart")
	public void the_user_navigates_to_the_cart() {
		homePageObj.clickCartLinkWithCount();

	}

	@Then("The item is displayed in the cart")
	public void the_item_is_displayed_in_the_cart() {
		Assert.assertTrue(homePageObj.validateAnchorBraceletInCart());

	}

	@When("The user navigates to the Contact page")
	public void the_user_navigates_to_the_contact_page() {
		contactPageOjb.clickContactTab();

	}

	@Then("The required information is displayed on the Contact page")
	public void the_required_information_is_displayed_on_the_contact_page() {
		Assert.assertEquals(contactPageOjb.emailText(), "askomdch@gmail.com");
	}

}

package stepDefs;

import pages.*;
import components.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs extends DriverFactory {

	private DriverFactory driverFactory;
	private WebDriver driver;
	
	private ContactPageObjects contactPageOjb = new ContactPageObjects(getDriver());
	private HomePageObjects homePageObj = new HomePageObjects(getDriver());
	
	//setDriver(new DriverFactory.createDriver();
	//120, 4:00, 
		
	// <Hooks>
	@Before (value="@Regression", order=1)
	public void browserSetup() {
		driverFactory = new DriverFactory();
		driver = driverFactory.createDriver();
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
		getDriver().quit();
	//	Don't set driver = null unless using parallel execution
		//driver = null; 
	} 	
	// </Hooks>
	
	
	@Given("The website is loaded")
	public void the_website_is_loaded() {
		getDriver().get(url);
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

package stepDefs;

import pages.*;
import components.*;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StoreStepDefs {

	private ContactPageObjects contactPageOjb = new ContactPageObjects(DriverFactory.getDriver());
	private HomePageObjects homePageObj = new HomePageObjects(DriverFactory.getDriver());

	@Given("The user is on the homepage")
	public void the_user_is_on_the_homepage() {	
		DriverFactory.getDriver().get("https://askomdch.com");
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

	@Given("The user navigates to the Contact page")
	public void the_user_navigates_to_the_contact_page() {
		DriverFactory.getDriver().get("https://askomdch.com");
		contactPageOjb.clickContactTab();

	}

	@Then("The required information is displayed on the Contact page")
	public void the_required_information_is_displayed_on_the_contact_page() {
		Assert.assertEquals(contactPageOjb.emailText(), "askomdch@gmail.com");
	}

}

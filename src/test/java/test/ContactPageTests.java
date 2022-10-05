package test;


import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ContactPageObjects;
import pages.HomePageObjects;

public class ContactPageTests extends TestBaseSetup {

	//pass the driver on any new page instance
	ContactPageObjects contactPageOjb;

	public ContactPageTests(){
		super();
	}
	
	// Initialize page object and navigate to page
	// Note: Methods cannot be run in parallel with this instantiation in @BeforeMethod
	
	@BeforeMethod
	public void homePageTestSetup() {
		//setUp();
		contactPageOjb = new ContactPageObjects(driver);
	}

	@Test
	public void validateContactPageEmail() throws InterruptedException {
		contactPageOjb.clickContactTab();
		Thread.sleep(2000);
		Assert.assertEquals(contactPageOjb.emailText(), "askomdch@gmail.com");
		
	}


}

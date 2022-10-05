package StepDefs;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import appLib.MainLib;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class StepDefs extends MainLib {

	public static WebDriver driver;
	public static Properties prop;
	
	String url;
	String browserName;
	
	@Given("The browser is open and website is loaded")
	public void the_browser_is_open_and_website_is_loaded() {
		
		try {
			FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\config.properties");
			prop = new Properties();
			prop.load(fis);
			browserName = prop.getProperty("browser");
			url = prop.getProperty("url");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//put mutableCapabilities here
		
		//if (browserName.equalsIgnoreCase("chrome")) {
		//WebDriverManager.chromedriver().setup();
		//6 conditions, 3 browser options + local or remote
		//nonlocal: use BrowserFactory class to set desiredCapabilities & browser options
		
	}

	
	@Given("The user adds an Item to the cart")
	public void the_user_adds_an_item_to_the_cart() {
	   
		// Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	

	@When("The user navigates to the cart")
	public void the_user_navigates_to_the_cart() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("The item is displayed in the cart")
	public void the_item_is_displayed_in_the_cart() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}

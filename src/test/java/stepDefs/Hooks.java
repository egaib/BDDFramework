package stepDefs;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import components.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import utils.ConfigReader;

public class Hooks extends DriverFactory {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	public static String url;
	public static String browserName;

	@Before(order=0)
	public void getProperties() {
		configReader = new ConfigReader();
		prop = configReader.initProperties();
	}
	
	@Before(order=1)
	public void browserSetup() {
		browserName = prop.getProperty("browser");
		url = prop.getProperty("url");
		
		driverFactory = new DriverFactory();
		driver = driverFactory.createDriver(browserName);
		
		System.out.println("Setup:");
		System.out.println("Thread Name: " + Thread.currentThread().getName());
		System.out.println("Thread ID: " + Thread.currentThread().getId());
	}

	@After(order=1)
	public void tearDown() {
		System.out.println("Teardown: ");
		System.out.println("Thread Name: " + Thread.currentThread().getName());
		System.out.println("Thread ID: " + Thread.currentThread().getId());
		driver.quit();
		//	Don't set driver = null unless using parallel execution
		//driver = null;
		//44:00 ss on fail
	} 	

}

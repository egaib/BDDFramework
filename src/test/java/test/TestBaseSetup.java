package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBaseSetup {

	// Declare Selenium WebDriver object
	WebDriver driver = null;

	// Setup Chromedriver before all tests
	@BeforeSuite
	public void setUpTest() {
		// Set project path and Chromedriver path
		String projectPath = System.getProperty("user.dir");

		// Set Chromedriver path
		System.setProperty("webdriver.chrome.driver", projectPath + "\\chromedriver\\chromedriver.exe");

	}

	// Get the landing page and wait for the page to load before each test
	@BeforeMethod
	public void getLandingPage() {

		// Initialize Selenium WebDriver object
		driver = new ChromeDriver();

		// Use webdriver to get the landing page
		driver.get("https://demoqa.com");

		// Explicit dynamic wait until Elements text is loaded
		new WebDriverWait(driver, 5)
				.until(ExpectedConditions.textToBe(By.xpath("//h5[contains(text(),'Elements')]"), "Elements"));

	}

	// Teardown after each test is complete
	@AfterMethod
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
	}

}

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

	WebDriver driver = null;
	

	// Setup Chromedriver before all tests
	@BeforeSuite
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\chromedriver\\chromedriver.exe");
	}

	// Before every test, instantiate a new driver, get the landing page, and ensure it has loaded
	@BeforeMethod
	public void getLandingPage() {
		driver = new ChromeDriver();

		// Set the landing page
		driver.get("https://demoqa.com");

		// Set an explicit dynamic wait to confirm the landing page has loaded
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

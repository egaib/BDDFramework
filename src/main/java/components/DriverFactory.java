package components;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();	

	/**
	 * Method used to initialize the Threadlocal driver
	 * @return thread local driver
	 */
	public WebDriver createDriver(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		} else {
			System.out.println(browserName + "is not a valid browser name.");
		}

		getDriver().manage().timeouts().setScriptTimeout(4, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();

		//		contactPageOjb = new ContactPageObjects(driver.get());
		//		homePageObj = new HomePageObjects(driver.get());

		return getDriver();

	}
	//DesiredCapabilities for each of 3 browsers

	//RemoteWebDriver 

	/**
	 * used to get the driver with Threadlocal
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		//calling this returns the threadlocal instance
		return driver.get();
	}

//	public void setDriver(WebDriver driver) {
//		this.driver.set(driver);
//	}





}

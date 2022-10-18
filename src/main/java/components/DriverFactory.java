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


	public static Properties prop;

	public static String url;
	public static String browserName;


//	public WebDriver driver2;
	
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();	

	/**
	 * Used to initialize the threadlocal driver
	 * @return thread local driver
	 */
	public static WebDriver createDriver() {

		try {
			// move properties file read to util pt2/30:00
			FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\config.properties");
			prop = new Properties();
			prop.load(fis);
			browserName = prop.getProperty("browser");
			url = prop.getProperty("url");

			//			if (driver==null) {
			if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver.set(new ChromeDriver());
				//driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver.set(new FirefoxDriver());
			} else if (browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver.set(new EdgeDriver());
			}


			//		}
		} catch (Exception e) {
			e.printStackTrace();
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

	//		 used to refer from other classes
	public static synchronized WebDriver getDriver() {
		//calling this returns the threadlocal instance
		return driver.get();
	}

	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}





}

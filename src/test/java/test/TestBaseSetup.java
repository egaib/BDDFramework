package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBaseSetup {

	public static WebDriver driver;
	public static Properties prop;

	public TestBaseSetup() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Parameters({"browser", "platform", "version"})
	@BeforeMethod
	public void setUp(@Optional String browserName, @Optional String platformName, @Optional String versionName, @Optional Method name) {

//	public static void setUp() {

		//if var = lo	cal, XYZ, if var = grid, else 'param needs to read grid or local'

		int choice = 2;



				if (choice == 1) {
					System.out.println("browser name is : " + browserName);
					String methodName = name.getName();
		
					MutableCapabilities sauceOpts = new MutableCapabilities();
					sauceOpts.setCapability("name", methodName);
					sauceOpts.setCapability("build", "Java-W3C-Examples");
					sauceOpts.setCapability("seleniumVersion", "3.141.59");
					sauceOpts.setCapability("username", "oauth-egaib001-bb174"); //prop or jenkins global secret key
					sauceOpts.setCapability("accessKey", "75028b98-4d8d-4b42-b337-83b852868627"); //prop or jenkins global secret key
					sauceOpts.setCapability("tags", "w3c-chrome-tests");
		
					DesiredCapabilities cap = new DesiredCapabilities();
					cap.setCapability("sauce:options", sauceOpts);
					cap.setCapability("browserVersion", versionName);
					cap.setCapability("platformName", platformName);
		
					if (browserName.equals("chrome")) {
						WebDriverManager.chromedriver().setup();
						cap.setCapability("browserName", "chrome");
					} else if (browserName.equals("firefox")) {
						WebDriverManager.firefoxdriver().setup();
						cap.setCapability("browserName", "firefox");
					}
					//access key specific to saucelabs account
					//https://oauth-egaib001-bb174:75028b98-4d8d-4b42-b337-83b852868627@ondemand.us-west-1.saucelabs.com:443/wd/hub
					
					try {
						//read url from prop file
						driver = new RemoteWebDriver(new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub"), cap); 
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
				}


		if (choice == 2) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://askomdch.com/");

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	// Teardown after each test is complete
	//@AfterMethod
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
	}

}

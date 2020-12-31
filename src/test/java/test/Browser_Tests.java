package test;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.BrowserPageObjects;

public class Browser_Tests extends TestBaseSetup {

	// Declare page object
	BrowserPageObjects browserPageObj = null;

	// Initialize page object and navigate to page
	@BeforeMethod
	public void BrowserTestSetup() {
		browserPageObj = new BrowserPageObjects(driver);
		browserPageObj.clickMainAlertsAppButton();
		browserPageObj.clickBrowserFormButton();
	}

	@Test
	public void BW1() {

		// Open new tab
		browserPageObj.clickNewTabButton();

		// Get window handle
		String parentWindowHandle = driver.getWindowHandle();

		// Get window handles for all open windows and store in a set
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();

		// Iterate through all window handles to find child window
		while (iterator.hasNext()) {
			String childWindowHandle = iterator.next();
			System.out.println(childWindowHandle);

			// Switch to child window
			if (!parentWindowHandle.equalsIgnoreCase(childWindowHandle)) {
				driver.switchTo().window(childWindowHandle);
			}
		}

		// Assert that new tab opens with expected message
		String newTabMessage = browserPageObj.getNewTabMessageText();
		assertEquals(newTabMessage, "This is a sample page");

	}

}

package com.yara.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.yara.pages.LaunchPage;
import com.yara.pages.WelcomePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public abstract class BaseTest {
	private static DesiredCapabilities capabilities;
	public AndroidDriver<MobileElement> driver;
	protected final Logger log = LogManager.getLogger(getClass());

	public BaseTest() {

	}

	@BeforeTest
	public void launchApp() throws InterruptedException, MalformedURLException {

		capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", System.getProperty("deviceName"));
		capabilities.setCapability("udid", System.getProperty("udid"));
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "8.0");
		capabilities.setCapability("skipUnlock", "true");
		capabilities.setCapability("appPackage", "com.yara.lcc.qa");
		capabilities.setCapability("appActivity", "com.yara.lcc.MainActivity");
		capabilities.setCapability("noReset", "false");
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		Thread.sleep(5000);
	}

	@BeforeMethod
	public void setup() {

		LaunchPage launchPage = new LaunchPage(driver);
		WelcomePage welcomePage = new WelcomePage(driver);

		// Select Language
		launchPage.selectEnglish();

		// Click on Agree and Continue
		welcomePage.clickAgreeAndContinue();

	}

	@AfterMethod
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		log.info("Starting after test...");
		driver.quit();
	}
}

package com.yara.pages;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BasePage {
//	protected static WebDriver driver;
	protected AndroidDriver<MobileElement> driver;
	protected static String parentWindow;
	protected static Set<String> handles;
	private static final int pollingDuration = 500;
	private static final int timeoutForWait = 30;
	Object config;
	Object cdata;
	Object data;

	protected final Logger log = LogManager.getLogger(getClass());

	public BasePage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}

	protected void waitForElement(MobileElement element) {
		log.info("Waiting for element : " + element);
		int failureCount = 1;
		boolean visible = false;
		for (int i = 0; i < timeoutForWait; i++) {
			try {
				visible = element.isDisplayed();
				if (visible) {
					break;
				}
			} catch (Exception e) {
				log.error("Trying to locate element --> " + element);
			}
			waitFor(pollingDuration);
			failureCount++;
		}
		if (!visible) {
			log.error("Unable to find element --> " + element + ". Retry count: " + (failureCount - 1));
			throw new NoSuchElementException("Element: " + element + " not found");
		}
	}

	public void clickOnElement(MobileElement element) {
		log.info("Clicking on element: " + element);
		try {
			waitForElement(element);
			element.click();
		} catch (Exception e) {
			log.error(e.getMessage());
			log.error("Not able to click on target element");
		}
	}

	protected boolean waitForElement(MobileElement element, int pollingDuration) {
		boolean visible = false;
		for (int i = 0; i < timeoutForWait; i++) {
			try {
				visible = element.isDisplayed();
				break;
			} catch (Exception e) {
			}
			waitFor(pollingDuration);
		}
		return visible;
	}

	protected void waitFor(int pollingDuration) {
		try {
			Thread.sleep(pollingDuration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean isVisible(WebElement element) {
		boolean visible = false;
		for (int i = 0; i < timeoutForWait; i++) {
			try {
				if (element.isDisplayed()) {
					visible = true;
					break;
				}
			} catch (Exception e) {
			}
			waitFor(pollingDuration);
		}
		return visible;
	}

	@SuppressWarnings("deprecation")
	public void writeTextInField(MobileElement mobileElement, String text) {
		log.info("Typing :" + text + ", on element: " + mobileElement);
		waitForElement(mobileElement);
		driver.getKeyboard().sendKeys(text);
	}

	protected void scrollAndClick(String visibleText) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))")
				.click();
	}

}

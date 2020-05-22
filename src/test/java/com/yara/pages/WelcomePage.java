package com.yara.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WelcomePage extends BasePage {

	public WelcomePage(AndroidDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//*[contains(@content-desc,'btnText_welcome_screen_continue')]")
	private MobileElement agreeAndContinueButton;

	public void clickAgreeAndContinue() {
		log.info("Clicking on Agree and Continue Button...");
		waitForElement(agreeAndContinueButton);
		clickOnElement(agreeAndContinueButton);
	}

}

package com.yara.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LaunchPage extends BasePage {

	public LaunchPage(AndroidDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//*[contains(@content-desc,'btnText_Select_select_language_en')]")
	private MobileElement selectButtonEnglish;

	@AndroidFindBy(xpath = "//*[contains(@content-desc,'btnText_Select_select_language_hi')]")
	private MobileElement selectButtonHindi;

	@AndroidFindBy(xpath = "//*[contains(@content-desc,'btnText_Select_select_language_ta')]")
	private MobileElement selectButtonTamil;

	public void selectEnglish() {
		log.info("Selecting ENGLISH...");
		waitForElement(selectButtonEnglish);
		clickOnElement(selectButtonEnglish);
	}

	public void selectHindi() {
		log.info("Selecting HINDI...");
		waitForElement(selectButtonHindi);
		clickOnElement(selectButtonHindi);
	}

	public void selectTamil() {
		log.info("Selecting TAMIL...");
		waitForElement(selectButtonTamil);
		clickOnElement(selectButtonTamil);
	}

}

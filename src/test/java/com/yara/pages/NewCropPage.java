package com.yara.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewCropPage extends BasePage {

	public NewCropPage(AndroidDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//*[contains(@content-desc,'navBarLeftButton_nav_bar_add_crop')]")
	private MobileElement gearButton;

	@AndroidFindBy(xpath = "//*[contains(@content-desc,'btnText_add_crop')]")
	private MobileElement addCropButton;

	public void clickAddCropButton() {
		log.info("Clicking on Add Crop Button...");
		waitForElement(addCropButton);
		clickOnElement(addCropButton);
	}

}

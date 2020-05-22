package com.yara.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LeafColorChartPage extends BasePage {

	public LeafColorChartPage(AndroidDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//*[contains(@text,'Next')]")
	private MobileElement nextButton;

	@AndroidFindBy(xpath = "//*[contains(@text,'Skip')]")
	private MobileElement skipButton;

	@AndroidFindBy(xpath = "//*[contains(@text,'Start Sampling')]")
	private MobileElement startSamplingButton;

	@AndroidFindBy(xpath = "//*[contains(@content-desc,'circledCheck_mockLeafColorScreen_2')]")
	private MobileElement leafSampleOne;

	@AndroidFindBy(xpath = "//*[contains(@content-desc,'circledCheck_mockLeafColorScreen_3')]")
	private MobileElement leafSampleTwo;

	@AndroidFindBy(xpath = "//*[contains(@content-desc,'circledCheck_mockLeafColorScreen_4')]")
	private MobileElement leafSampleThree;

	@AndroidFindBy(xpath = "//*[contains(@content-desc,'circledCheck_mockLeafColorScreen_5')]")
	private MobileElement leafSampleFour;

	@AndroidFindBy(xpath = "//*[contains(@text,'Next Leaf')]")
	private MobileElement nextLeafButton;

	@AndroidFindBy(xpath = "//*[contains(@text,'Done')]")
	private MobileElement doneButton;

	@AndroidFindBy(xpath = "//*[contains(@text,'Thank You')]")
	private MobileElement thankYouIcon;

	public LeafColorChartPage clickNextButton() {
		log.info("Clicking on Next Button...");
		waitForElement(nextButton);
		clickOnElement(nextButton);
		return this;
	}

	public LeafColorChartPage clickSkipButton() {
		log.info("Clicking on Skip Button...");
		waitForElement(skipButton);
		clickOnElement(skipButton);
		return this;
	}

	public LeafColorChartPage clickStartSamplingButton() {
		log.info("Clicking on Start Sampling Button...");
		waitForElement(startSamplingButton);
		clickOnElement(startSamplingButton);
		return this;
	}

	public LeafColorChartPage clickNextLeafButton() {
		log.info("Clicking on Next Leaf Button...");
		waitForElement(nextLeafButton);
		clickOnElement(nextLeafButton);
		return this;
	}

	public LeafColorChartPage clickDoneButton() {
		log.info("Clicking on Done Button...");
		waitForElement(doneButton);
		clickOnElement(doneButton);
		return this;
	}

	public LeafColorChartPage selectLeafSample(int leafSample) {
		log.info("Selecting Leaf Sample ---> " + leafSample);
		switch (leafSample) {
		case 1:
			waitForElement(leafSampleOne);
			clickOnElement(leafSampleOne);
			break;
		case 2:
			waitForElement(leafSampleTwo);
			clickOnElement(leafSampleTwo);
			break;
		case 3:
			waitForElement(leafSampleThree);
			clickOnElement(leafSampleThree);
			break;
		case 4:
			waitForElement(leafSampleFour);
			clickOnElement(leafSampleFour);
			break;
		default:
			waitForElement(leafSampleFour);
			clickOnElement(leafSampleFour);
			break;
		}
		return this;
	}

	public static int generateRandomNumber() {
		int min = 1;
		int max = 4;
		return (int) (Math.random() * (max - min + 1) + min);
	}

	public void selectAllLeafSamples() {
		for (int i = 0; i < 10; i++) {
			selectLeafSample(generateRandomNumber());
			if (i < 9) {
				clickNextLeafButton();
			} else {
				clickDoneButton();
			}
			waitFor(1000);
		}
	}

	public boolean checkThankYouIconPresent() {
		return isVisible(thankYouIcon);
	}
}

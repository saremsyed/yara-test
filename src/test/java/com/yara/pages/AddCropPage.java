package com.yara.pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.yara.utils.Constants;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddCropPage extends BasePage {

	public AddCropPage(AndroidDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//*[contains(@content-desc,'inputTextBox_txtFarmName')]//*[@index='2']")
	private MobileElement nameOfYourFarmTextField;

	@AndroidFindBy(xpath = "//*[contains(@text,'Save')]")
	private MobileElement saveButton;

	@AndroidFindBy(xpath = "//*[contains(@text,'Non-basmatic')]")
	private MobileElement nonBasmaticRice;

	@AndroidFindBy(xpath = "//*[contains(@text,'Basmatic')]")
	private MobileElement basmaticRice;

	@AndroidFindBy(xpath = "//*[contains(@text,'Boro')]")
	private MobileElement boroRice;

	@AndroidFindBy(xpath = "//*[contains(@text,'Direct-seeded')]")
	private MobileElement directSeededRice;

	@AndroidFindBy(xpath = "//*[contains(@text,'Long')]")
	private MobileElement longGrowingPeriod;

	@AndroidFindBy(xpath = "//*[contains(@text,'Medium')]")
	private MobileElement mediumGrowingPeriod;

	@AndroidFindBy(xpath = "//*[contains(@text,'Short')]")
	private MobileElement shortGrowingPeriod;

	@AndroidFindBy(xpath = "//*[contains(@text,'1 acre')]")
	private MobileElement oneAcreFarmSize;

	@AndroidFindBy(xpath = "//*[contains(@text,'1–5 acres')]")
	private MobileElement oneToFiveAcreFarmSize;

	@AndroidFindBy(xpath = "//*[contains(@text,'>5 acres')]")
	private MobileElement fivePlusAcreFarmSize;

	@AndroidFindBy(xpath = "//*[contains(@content-desc,'img_dtSowingdate')]")
	private MobileElement sowingDatePickerIcon;

	@AndroidFindBy(xpath = "//*[contains(@content-desc,'calendarComp_dtSowingdate')]/android.view.ViewGroup/android.widget.TextView[1]")
	private MobileElement sowingDatePickerMonthAndYear;

	@AndroidFindBy(xpath = "//*[contains(@content-desc,'calendarComp_dtSowingdate')]/android.view.ViewGroup/android.widget.TextView[1]")
	private List<MobileElement> sowingDatePickerDay;

	@AndroidFindBy(xpath = "(//*[contains(@content-desc,'calendarArrowImg_dtSowingdate')])[1]")
	private MobileElement sowingDatePickerPreviousButton;

	@AndroidFindBy(xpath = "//*[contains(@content-desc,'textSave_dtSowingdate')]")
	private MobileElement sowingDatePickerSaveButton;

	@AndroidFindBy(xpath = "//*[contains(@content-desc,'textCancel_dtSowingdate')]")
	private MobileElement sowingDatePickerCancelButton;

	public AddCropPage enterNameOfYourFarm(String farmName) {
		log.info("Entering Farm Name as --> " + farmName);
		waitForElement(nameOfYourFarmTextField);
		clickOnElement(nameOfYourFarmTextField);
		writeTextInField(nameOfYourFarmTextField, farmName);
		return this;
	}

	public void clickOnSave() {
		log.info("Clicking on Save Button");
		waitForElement(saveButton);
		clickOnElement(saveButton);
	}

	public AddCropPage selectRice(String riceType) {
		log.info("Selecting Type of Rice ---> " + riceType);
		switch (riceType) {
		case "boro":
			selectBoroRice();
			break;
		case "basmatic":
			selectBasmaticRice();
			break;
		case "non-basmatic":
			selectNonBasmaticRice();
			break;
		case "direct-seeded":
			selectDirectSeededRice();
			break;
		default:
			selectNonBasmaticRice();
			break;
		}
		return this;
	}

	private void selectNonBasmaticRice() {
		log.info("Clicking on Non Basmatic Rice...");
		waitForElement(nonBasmaticRice);
		clickOnElement(nonBasmaticRice);
	}

	private void selectBasmaticRice() {
		log.info("Clicking on Basmatic Rice...");
		waitForElement(basmaticRice);
		clickOnElement(basmaticRice);
	}

	private void selectBoroRice() {
		log.info("Clicking on Boro Rice...");
		waitForElement(boroRice);
		clickOnElement(boroRice);
	}

	private void selectDirectSeededRice() {
		log.info("Clicking on Direct Seeded Rice...");
		waitForElement(directSeededRice);
		clickOnElement(directSeededRice);
	}

	public AddCropPage selectGrowingPeriod(String growingPeriod) {
		log.info("Selecting Growing Period ---> " + growingPeriod);
		switch (growingPeriod) {
		case "long":
			selectLongGrowingPeriod();
			break;
		case "medium":
			selectMediumGrowingPeriod();
			break;
		case "short":
			selectShortGrowingPeriod();
			break;
		default:
			selectLongGrowingPeriod();
			break;
		}
		return this;
	}

	private void selectLongGrowingPeriod() {
		log.info("Clicking on Long Growing Period...");
		scrollAndClick(Constants.LONG_PERIOD);
	}

	private void selectMediumGrowingPeriod() {
		log.info("Clicking on Medium Growing Period...");
		scrollAndClick(Constants.MEDIUM_PERIOD);
	}

	private void selectShortGrowingPeriod() {
		log.info("Clicking on Short Growing Period...");
		scrollAndClick(Constants.SHORT_PERIOD);
	}

	public AddCropPage selectFarmSize(String farmSize) {
		log.info("Selecting Farm Size ---> " + farmSize);
		switch (farmSize) {
		case "1 acre":
			selectOneAcreFarmSize();
			break;
		case "1-5 acres":
			selectOneToFiveAcreFarmSize();
			break;
		case ">5 acres":
			selectFivePlusAcreFarmSize();
			break;
		default:
			selectOneAcreFarmSize();
			break;
		}
		return this;
	}

	private void selectOneAcreFarmSize() {
		log.info("Clicking on 1 acre Farm Size...");
		scrollAndClick(Constants.ONE_ACRE);
	}

	private void selectOneToFiveAcreFarmSize() {
		log.info("Clicking on 1-5 acres Farm Size...");
		scrollAndClick(Constants.ONE_TO_FIVE_ACRE);
	}

	private void selectFivePlusAcreFarmSize() {
		log.info("Clicking on >5 acres Farm Size...");
		scrollAndClick(Constants.FIVE_PLUS_ACRE);
	}

	public String getMonthAndYear() {
		waitForElement(sowingDatePickerMonthAndYear);
		return sowingDatePickerMonthAndYear.getText();
	}

	public AddCropPage selectSowingDate(String month, String year, int day) {
		clickOnSowingDatePickerIcon();
		// TODO Find Right Locators
		int temp = 1;
		while (temp > 0) {
			if (sowingDatePickerMonthAndYear.getText().contains(month)
					&& sowingDatePickerMonthAndYear.getText().contains(year)) {
				for (MobileElement date : sowingDatePickerDay) {
					int selectedDate = Integer.parseInt(date.getText());
					if (selectedDate == day) {
						clickOnElement(date);
						waitFor(1000);
						break;
					}
				}
				temp = 0;
			} else {
				clickOnSowingDatePickerPreviousButton();
				temp++;
			}
		}
		return this;
	}

	public void clickOnSowingDatePickerIcon() {
		log.info("Clicking on Date Picker Icon...");
		waitForElement(sowingDatePickerIcon);
		clickOnElement(sowingDatePickerIcon);
	}

	public void clickOnSowingDatePickerPreviousButton() {
		log.info("Clicking on Date Picker Previous Button...");
		waitForElement(sowingDatePickerPreviousButton);
		clickOnElement(sowingDatePickerPreviousButton);
	}

}

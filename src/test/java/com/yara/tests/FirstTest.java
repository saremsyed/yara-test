package com.yara.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.yara.pages.AddCropPage;
import com.yara.pages.LeafColorChartPage;
import com.yara.pages.NewCropPage;
import com.yara.utils.Constants;

public class FirstTest extends BaseTest {

	public FirstTest() {
		super();
	}

	Faker faker = new Faker();

	@Test
	public void e2eTest() {

		NewCropPage newCropPage = new NewCropPage(driver);
		AddCropPage addCropPage = new AddCropPage(driver);
		LeafColorChartPage leafColorChartPage = new LeafColorChartPage(driver);

		String farmName = faker.pokemon().name() + " Farm";
		newCropPage.clickAddCropButton();

		addCropPage.enterNameOfYourFarm(farmName)
				.selectRice(Constants.BORO_RICE)
				.selectGrowingPeriod(Constants.SHORT_PERIOD)
				.selectFarmSize(Constants.FIVE_PLUS_ACRE)
//				.selectSowingDate("March", "2019", 19)
				.clickOnSave();

		leafColorChartPage.clickNextButton()
						.clickNextButton()
						.clickStartSamplingButton();
		
		leafColorChartPage.selectAllLeafSamples();
		
		Assert.assertTrue(leafColorChartPage.checkThankYouIconPresent());
		
		log.info("DONE");

	}

}

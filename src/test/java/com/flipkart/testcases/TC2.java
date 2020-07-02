package com.flipkart.testcases;

import org.testng.annotations.Test;

import com.flipkart.library.BaseTest;
import com.flipkart.pages.CartPage;
import com.flipkart.pages.HomePage;
import com.flipkart.pages.ProductPage;

public class TC2 extends BaseTest {
	public String priceTOValidate = "17,490";

	@Test
	public void test() throws Exception {

		HomePage hp = new HomePage(driver, mobileActionUtil);
		hp.clickOnSearchBox();
		hp.enterTextInSearchBox("mobile");
		hp.selectSuggestionOptionText();

		ProductPage pp = new ProductPage(driver, mobileActionUtil);
		pp.clickOnFilterBtn();
		pp.clickOnBrandBtn();

		pp.clickOnOptionCheckBox("Realme");
		pp.clickOnDoneBtn();
		pp.clickOnApplyBtn();
		pp.clickOnSortBtn();
		pp.clickOnLowToHigh();

		pp.clickOnFirstProduct();
		pp.clickOnAddtoCartBtn();

		pp.clickOnCloseSuggestionBox();
		pp.clickOnGotoCartBtn();

		CartPage cp = new CartPage(driver, mobileActionUtil);
		cp.ValidatePrice(priceTOValidate);

	}

}

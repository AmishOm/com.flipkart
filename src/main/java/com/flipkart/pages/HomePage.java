package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.flipkart.library.BasePage;
import com.flipkart.library.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class HomePage extends BasePage {

	/**
	 * @author Amish
	 * @description Constructor to initialize home page mobile elements
	 * @param driver
	 * @param mobileActionUtil
	 */
	public HomePage(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
		super(driver, mobileActionUtil);
	}

	@FindBy(id = "search_widget_textbox")
	private WebElement searchBox;

	@FindBy(id = "search_autoCompleteTextView")
	private WebElement enterSearchBox;

	@FindBy(id = "root_titles")
	private WebElement suggestionOptionText;

	public void clickOnSearchBox() {
		if ((mobileActionUtil.isElementDisplayed(searchBox)))
			mobileActionUtil.clickOnMobileElement(searchBox, "SearchBox");
	}

	public void enterTextInSearchBox(String text) {
		if ((mobileActionUtil.isElementDisplayed(enterSearchBox)))
			mobileActionUtil.sendText(enterSearchBox, text, "EnterTextSerachBox");
	}

	public void selectSuggestionOptionText() {
		if ((mobileActionUtil.isElementDisplayed(enterSearchBox)))
			mobileActionUtil.clickOnMobileElement(suggestionOptionText, "suggestionOptionText");

	}

}

package com.flipkart.pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.flipkart.library.BasePage;
import com.flipkart.library.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class ProductPage extends BasePage {

	/**
	 * @author Amish
	 * @description Constructor to initialize home page mobile elements
	 * @param driver
	 * @param mobileActionUtil
	 */
	public ProductPage(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
		super(driver, mobileActionUtil);
	}

	@FindBy(xpath = "//android.widget.TextView[@text='Filter']")
	private WebElement filterBtn;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Brand')]")
	private WebElement brandBtn;

	@FindBy(xpath = "//android.widget.TextView[@text='DONE']")
	private WebElement doneBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@text='APPLY']")
	private WebElement applyBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Sort']")
	private WebElement sortBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Price -- Low to High']/parent::android.view.ViewGroup/android.widget.ImageView")
	private WebElement lowToHighBtn;
	
	@FindBy(xpath = "//android.widget.ImageView")
	private WebElement firstProduct;
	
	@FindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	private WebElement addtoCartBtn;
	
	@FindBy(id = "cross_icon")
	private WebElement closeSuggestionBox;
	
	@FindBy(xpath = "//android.widget.TextView[@text='GO TO CART']")
	private WebElement gotoCartBtn;

	public void clickOnFilterBtn() {
		if ((mobileActionUtil.isElementDisplayed(filterBtn)))
			mobileActionUtil.clickOnMobileElement(filterBtn, "filterBtn");
	}

	public void clickOnBrandBtn() {
		if ((mobileActionUtil.isElementDisplayed(brandBtn)))
			mobileActionUtil.clickOnMobileElement(brandBtn, "brandBtn");
	}

	public void clickOnDoneBtn() {
		if ((mobileActionUtil.isElementDisplayed(doneBtn)))
			mobileActionUtil.clickOnMobileElement(doneBtn, "doneBtn");
	}
	
	public void clickOnApplyBtn() {
		if ((mobileActionUtil.isElementDisplayed(applyBtn)))
			mobileActionUtil.clickOnMobileElement(applyBtn, "applyBtn");
	}
	public void clickOnSortBtn() {
		if ((mobileActionUtil.isElementDisplayed(sortBtn)))
			mobileActionUtil.clickOnMobileElement(sortBtn, "sortBtn");
	}
	public void clickOnLowToHigh() {
		if ((mobileActionUtil.isElementDisplayed(lowToHighBtn)))
			mobileActionUtil.clickOnMobileElement(lowToHighBtn, "lowToHighBtn");
	}
	public void clickOnFirstProduct() {
		mobileActionUtil.waitForElementStaleness(firstProduct, 2, "firstProduct");
		if ((mobileActionUtil.isElementDisplayed(firstProduct)))
			mobileActionUtil.clickOnMobileElement(firstProduct, "firstProduct");
	}
	public void clickOnAddtoCartBtn() {
		if ((mobileActionUtil.isElementDisplayed(addtoCartBtn)))
			mobileActionUtil.clickOnMobileElement(addtoCartBtn, "addtoCartBtn");
	}
	public void clickOnCloseSuggestionBox() {
		if ((mobileActionUtil.isElementDisplayed(closeSuggestionBox)))
			mobileActionUtil.clickOnMobileElement(closeSuggestionBox, "closeSuggestionBox");
	}
	public void clickOnGotoCartBtn() {
		if ((mobileActionUtil.isElementDisplayed(gotoCartBtn)))
			mobileActionUtil.clickOnMobileElement(gotoCartBtn, "gotoCartBtn");
	}
	
	

	public void clickOnOptionCheckBox(String text) {
		mobileActionUtil.hideKeyboard();
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='" + text
				+ "']/parent::android.view.ViewGroup/android.widget.ImageView"));
		element.click();
		element.click();//one click not working--TODO
	}
	
	
	
	
}

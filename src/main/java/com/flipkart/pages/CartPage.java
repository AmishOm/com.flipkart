package com.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.flipkart.library.BasePage;
import com.flipkart.library.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;

public class CartPage extends BasePage {
	WebDriverWait wait;

	/**
	 * @author Amish
	 * @description Constructor to initialize home page mobile elements
	 * @param driver
	 * @param mobileActionUtil
	 */
	public CartPage(AndroidDriver driver, MobileActionUtil mobileActionUtil) {
		super(driver, mobileActionUtil);
	}

	public void ValidatePrice(String price) {
		try {
			mobileActionUtil.sleepForInterval(5);
			WebElement element = driver
					.findElement(By.xpath("//android.widget.TextView[contains(@text='" + price + "')]"));
			Assert.assertEquals(element.getText().contains(price), true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

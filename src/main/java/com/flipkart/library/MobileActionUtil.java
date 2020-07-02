package com.flipkart.library;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;

public class MobileActionUtil {

	AndroidDriver driver;
	ITestResult result;

	public MobileActionUtil(AndroidDriver driver) {
		this.driver = driver;
	}

	public void info(String description) {
		Reporter.log(description, true);
	}

	public void pass(String description) {
		Reporter.log(description, true);
	}

	public void fail(String description) {
		Reporter.log(description, true);
	}

	public Boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public void clickOnMobileElement(WebElement element, String elementName) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(element)).click();

			pass("Clicking on the Element : " + elementName);
		} catch (Exception e1) {
			fail("Unable to click on the Element :" + elementName);
		}
	}

	public void sendText(WebElement element, String enterText, String elementName) {

		try {
			element.sendKeys(enterText);
			pass("Entering the " + enterText + " Text to the " + elementName);
		} catch (Exception e) {
			fail("Unable to enter the " + enterText + " Text to the " + elementName);
		}
	}

	public void hideKeyboard() {

		try {
			info("Keyboard is already displayed");
			driver.hideKeyboard();
			pass("Hiding the Keyboard");

		} catch (Exception e) {
			fail("Unable to Hide the Keyboard");
		}
	}

	public void waitForElement(WebElement element, long timeOutInSeconds, String elementName) {

		info("Waiting For Element to Visible : " + elementName);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		info(elementName + " is Visible ");

	}

	public void waitForElementStaleness(WebElement element, long timeOutInSeconds, String elementName) {

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.stalenessOf(element));
	}

	public static void sleepForInterval(int interval) {
		try {
			Thread.sleep(interval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
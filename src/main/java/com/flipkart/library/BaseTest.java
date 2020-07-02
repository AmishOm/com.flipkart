package com.flipkart.library;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest implements IAutoConstant {

	/** Variable Declaration for Base Test Configuration**/
	
	public AndroidDriver driver;
	public MobileActionUtil mobileActionUtil;
	

	
	/**
	 * @author Amish
	 * @description Getting parameters from the TestNG
	 * @param deviceName
	 * @param platformName
	 * @param platformVersion
	 * @param automationName
	 * @param appPackage
	 * @param appActivity
	 * @param port
	 * @param udid
	 * @param ip
	 */
	@Parameters({ "deviceName",
				  "platformName",
				  "platformVersion", 
				  "automationName", 
				  "appPackage", 
				  "appActivity",
				  "port",
				  "udid",
				  "ip" })
	@BeforeMethod
	public void beforeConfig(@Optional String deviceName, 
							 @Optional String platformName, 
							 @Optional String platformVersion,
							 @Optional String automationName, 
							 @Optional String appPackage, 
							 @Optional String appActivity,
							 @Optional String port, 
							 @Optional String udid, 
							 @Optional String ip) {


			
			Reporter.log("Running Scripts in  Device",true);
			launchApp(deviceName, 
					  platformName,
					  platformVersion,
					  automationName,
					  appPackage,
					  appActivity,
					  port,
					  udid,
					  ip);
		
	}

	/** Closing the Session in the Device**/
	@AfterMethod
	public void afterClass() {
		closeApp();
	}


	/**
	 * @author Amish
	 * @description Launching the Application
	 * @param deviceName
	 * @param platformName
	 * @param platformVersion
	 * @param automationName
	 * @param appPackage
	 * @param appActivity
	 * @param port
	 * @param udid
	 * @param ip
	 */
	public void launchApp(String deviceName,
								  String platformName, 
								  String platformVersion, 
								  String automationName,
								  String appPackage, 
								  String appActivity, 
								  String port, 
								  String udid, 
								  String ip){
				
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
		capabilities.setCapability(MobileCapabilityType.VERSION, platformVersion);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1200);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
	//	capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_DURATION, 180000);
		capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		capabilities.setCapability(MobileCapabilityType.UDID, udid);
		capabilities.setCapability("autoAcceptAlerts", true);
		capabilities.setCapability("uiautomator2ServerInstallTimeout", 50000);
		capabilities.setCapability("adbExecTimeout", 50000);
		capabilities.setCapability("gpsEnabled", true);
	
		try {
			if (driver != null) {
			}
			URL url = new URL("http://" + ip + ":" + port + "/wd/hub");
			driver = new AndroidDriver<MobileElement>(url, capabilities);
		} catch (MalformedURLException e) 
		{
			e.printStackTrace();
		}
			mobileActionUtil = new MobileActionUtil(driver);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	/**
	 * @author Amish
	 * @description Closing The Driver Session
	 */
	public void closeApp() {
		try {
			if (driver != null) {
				System.out.println("Closing the Application");
				driver.quit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
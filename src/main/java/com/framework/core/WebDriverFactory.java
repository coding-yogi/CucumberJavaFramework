package com.framework.core;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.selendroid.common.SelendroidCapabilities;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFactory {

	public WebDriver getWebDriver(String browser) {
		String os = System.getProperty("os.name").toLowerCase();
        String webDriverType = browser.toLowerCase();
        String executable;

		System.out.println("Executing Tests on OS " + os);

		String workingPath = System.getProperty("user.dir");
		String wdPath = workingPath + "/drivers";

		switch(webDriverType) {
			case "firefox":
				executable = os.contains("win") ? "geckodriver.exe" : "geckodriver";
				System.setProperty("webdriver.gecko.driver", wdPath + "/" + executable);
				return new FirefoxDriver();
			case "chrome":
				executable = os.contains("win") ? "chromedriver.exe" : "chromedriver";
				System.setProperty("webdriver.chrome.driver", wdPath + "/" + executable);
				return new ChromeDriver();
			case "ie":
				System.setProperty("webdriver.ie.driver", wdPath + "/IEDriverServer32.exe");
				return new InternetExplorerDriver();
			default:
				executable = os.contains("win") ? "chromedriver.exe" : "chromedriver";
				System.setProperty("webdriver.chrome.driver", wdPath + "/" + executable);
				return new ChromeDriver();
		}
	}

	public WebDriver getRemoteWebDriver(String URL, DesiredCapabilities dc) throws MalformedURLException {
		return new RemoteWebDriver(new URL(URL),dc);
	}

	public AndroidDriver getAppiumAndroidDriver(String appPackage, String appActivity, String deviceName, String appiumServerURL) throws MalformedURLException {
		//Desired Caps
		DesiredCapabilities DC = new DesiredCapabilities();
		DC.setCapability("automationName", "uiautomator2");
		DC.setCapability("platformName", "Android");
		DC.setCapability("appPackage", appPackage);
		DC.setCapability("appActivity", appActivity);
		DC.setCapability("deviceName", deviceName);

		//Initiate WebDriver
		return new AndroidDriver(new URL(appiumServerURL), DC);
	}

	public AndroidDriver getAndroidChromeDriver(String deviceName, String appiumServerURL, Proxy proxy) throws MalformedURLException {
		//Desired Caps
		DesiredCapabilities DC = new DesiredCapabilities();
		DC.setCapability("automationName", "Appium");
		DC.setCapability("platformName", "Android");
		DC.setCapability("browserName", "Chrome");
		DC.setCapability("deviceName", deviceName);

		if(proxy != null)
			DC.setCapability(CapabilityType.PROXY,proxy);

		//Initiate WebDriver
		return new AndroidDriver(new URL(appiumServerURL), DC);
	}

	public AndroidDriver getSelendroidDriver(String apkPath, String appPackage, String appWaitActivity, String deviceName, String appiumServerURL) throws MalformedURLException {
		//Selendroid Caps
		SelendroidCapabilities DC = new SelendroidCapabilities(appPackage);
		DC.setCapability("appWaitActivity",appWaitActivity);
		DC.setCapability("deviceName",deviceName);
		DC.setCapability("app",apkPath);
		DC.setCapability("automationName", "Selendroid");
		DC.setCapability("platformName", "Android");
		DC.setCapability("newCommandTimeout",3000);

		return new AndroidDriver(new URL(appiumServerURL), DC);
	}
}

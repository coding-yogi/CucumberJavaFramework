package com.autodesk.accounts.pageobjects;

import com.framework.handlers.DataHandler;
import org.openqa.selenium.WebDriver;

public class LaunchApplication {

	private WebDriver driver;
	
	public LaunchApplication(WebDriver driver){
		this.driver = driver;
	}	
	
	public LoginPage launchIdentityApplication() {

		DataHandler dHandler = new DataHandler("identityconfig.json","staticdata.json");
		String url = dHandler.getAppConfig("url").getAsString();

		driver.get(url);
		return new LoginPage(driver);
	}
}

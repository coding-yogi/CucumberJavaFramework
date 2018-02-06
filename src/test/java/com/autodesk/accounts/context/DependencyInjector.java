package com.autodesk.accounts.context;

import com.autodesk.accounts.pageobjects.LoginPage;
import com.autodesk.accounts.pageobjects.ProfilePage;
import com.framework.core.WebDriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


/**
 * Created by i337111 on 04/02/18.
 */
public class DependencyInjector {

    public WebDriver driver;

    //Page Objects
    public LoginPage loginPage;
    public ProfilePage profilePage;
    public WebDriverFactory wdFactory;

    @Before
    public void BeforeScenario() {
        //Initiate Webdriver
        String browser = System.getProperty("browserName");
        wdFactory = new WebDriverFactory();
        driver = (driver != null) ? driver : wdFactory.getWebDriver(browser);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @After
    public void AfterScenario() {
        //quit webdriver
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

package com.autodesk.accounts.context;

import com.autodesk.accounts.pageobjects.LoginPage;
import com.autodesk.accounts.pageobjects.ProfilePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;


/**
 * Created by i337111 on 04/02/18.
 */
public class DependencyInjector {

    public WebDriver driver;

    //Page Objects
    public LoginPage loginPage;
    public ProfilePage profilePage;

    @Before
    public void BeforeScenario() {
        //Initiate Webdriver
        String browser = System.getProperty("browserName");
        driver = (driver != null) ? driver : getWebDriver(browser);
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


    private WebDriver getWebDriver(String browser)  {
        String wdPath = System.getProperty("user.dir") + "/drivers";

        String os = System.getProperty("os.name").toLowerCase();
        String webDriverType = browser.toLowerCase();
        String executable;

        System.out.println("Executing Tests on OS " + os);

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

}

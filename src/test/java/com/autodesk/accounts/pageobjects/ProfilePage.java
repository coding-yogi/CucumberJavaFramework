package com.autodesk.accounts.pageobjects;

import com.framework.base.BasePage;
import com.framework.core.Wrappers;
import org.openqa.selenium.WebDriver;

/**
 * Created by gadrea on 5/5/2015.
 */
public class ProfilePage extends BasePage{

    private WebDriver driver;
    private Wrappers objWrapper;

    public static final String pageTitle = "Autodesk - User Profile";
    String tbProfile = "classname:=profile";

    //Define the constructor
    public ProfilePage(WebDriver driver)
    {
        this.driver = driver;
        objWrapper = new Wrappers(driver);
    }

    public boolean shouldHaveMyProfileTab(){
        return objWrapper.isElementPresent(tbProfile);
    }
}

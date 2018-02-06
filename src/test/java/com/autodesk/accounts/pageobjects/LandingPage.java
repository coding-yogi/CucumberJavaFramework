package com.autodesk.accounts.pageobjects;

import com.framework.core.Wrappers;
import org.openqa.selenium.WebDriver;

/**
 * Created by i337111 on 04/02/18.
 */
public class LandingPage {

    private WebDriver driver;
    private Wrappers objWrapper;

    //Page UI Objects
    public final String btnSignIn = "id:=signin_btn";

    //Define the constructor
    public LandingPage(WebDriver driver)
    {
        this.driver = driver;
        objWrapper = new Wrappers(driver);
    }

    public LoginPage clickSignIn() {
        objWrapper.click(btnSignIn);
        return new LoginPage(driver);
    }
}

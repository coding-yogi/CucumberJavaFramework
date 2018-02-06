package com.autodesk.accounts.pageobjects;

import com.framework.base.BasePage;
import com.framework.core.Wrappers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gadrea on 4/2/2015.
 */
public class LoginPage extends BasePage{

    private WebDriver driver;
    private Wrappers objWrapper;

    public static final String pageTitle = "Autodesk - Sign In";

    //Page UI Objects
    public final String edtUserName = "id:=userName";
    public final String edtPassword = "id:=password";
    public final String btnSubmit = "id:=btnSubmit";
    public final String txtErrors = "xpath:=//span[contains(@class,'field-validation-error')]/span";

    //Define the constructor
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        objWrapper = new Wrappers(driver);
    }

    public LoginPage enterLoginCredentials(String username, String password)
    {
        objWrapper.enterText(edtUserName, username);
        objWrapper.enterText(edtPassword, password);
        return this;
    }

    public <T extends BasePage> T clickSignIn(Class<T> clazz) {
        objWrapper.click(btnSubmit);
        return getNewInstanceOfClass(clazz, driver);
    }

    private List<String> getErrorMessages()
    {
        List<String> lstErrors = new ArrayList<String>();
        List<WebElement> elementErrors = objWrapper.getElements(txtErrors);
        for(WebElement elemError : elementErrors){
            lstErrors.add(elemError.getText());
        }

        return lstErrors;
    }

    public boolean shouldDisplayError(String errorMessage)
    {
        List<String> lstErrorMessages = getErrorMessages();
        for(String strErrorMessage : lstErrorMessages){
            if(strErrorMessage.equals(errorMessage)){
                return true;
            }
        }

        return false;
    }
}

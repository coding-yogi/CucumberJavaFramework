package com.autodesk.accounts.steps;

import com.autodesk.accounts.pageobjects.LaunchApplication;
import com.autodesk.accounts.pageobjects.ProfilePage;
import com.autodesk.accounts.context.DependencyInjector;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

/**
 * Created by i337111 on 31/01/18.
 */
public class LoginSteps extends BaseSteps {

    public LoginSteps(DependencyInjector injector) {
        super(injector);
    }

    @Given("^a user is on login page$")
    public void navigateToLandingPage() {
        injector.loginPage = new LaunchApplication(driver)
                .launchIdentityApplication();
    }

    @When("^he enters .* username and .*password$")
    public void enterCredentials(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        injector.loginPage.enterLoginCredentials(data.get(0).get("username"),data.get(0).get("password"));
    }

    @Given("^he clicks on signin$")
    public void clickSignIn() {
        injector.profilePage = injector.loginPage.clickSignIn(ProfilePage.class);
    }

    @Then("^he should see an error \"([^\"]*)\"$")
    public void validateErrorMessage(String errorMessage)  {
        Assert.assertTrue(injector.loginPage.shouldDisplayError(errorMessage));
    }
}

package com.autodesk.accounts.steps;

import com.autodesk.accounts.context.DependencyInjector;
import cucumber.api.java.en.Then;
import org.testng.Assert;

/**
 * Created by i337111 on 04/02/18.
 */
public class ProfileSteps extends BaseSteps {

    public ProfileSteps(DependencyInjector injector) {
        super(injector);
    }

    @Then("^he should see the profile page?")
    public void isProfilePageDisplayed() {
        Assert.assertTrue(injector.profilePage.shouldHaveMyProfileTab());
    }
}

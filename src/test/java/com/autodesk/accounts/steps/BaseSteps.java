package com.autodesk.accounts.steps;

import com.autodesk.accounts.context.DependencyInjector;
import org.openqa.selenium.WebDriver;

/**
 * Created by i337111 on 04/02/18.
 */
public class BaseSteps {

    WebDriver driver;
    DependencyInjector injector;

    public BaseSteps(DependencyInjector injector) {
        this.injector = injector;
        this.driver = injector.driver;
    }
}

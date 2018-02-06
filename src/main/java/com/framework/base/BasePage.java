package com.framework.base;

import org.openqa.selenium.WebDriver;

/**
 * Created by I337111 on 20/12/2016.
 */
public class BasePage {

    protected BasePage() {

    }

    protected  <T> T getNewInstanceOfClass(Class<T> clazz, WebDriver driver) {
        if(this.getClass().equals(clazz)) {
            return (T)this;
        }

        try {
            return (T) clazz.getDeclaredConstructors()[0].newInstance(driver);
        }
        catch(Exception e) {
            return null;
        }

    }
}

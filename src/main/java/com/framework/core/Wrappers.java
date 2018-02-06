package com.framework.core;

import io.appium.java_client.MobileBy;
import io.appium.java_client.AppiumDriver;

import java.util.List;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.NoSuchElementException;


public class Wrappers {

    private WebDriver driver;

    //Constructor
    public Wrappers(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement getElement(String objDesc) {
        //Delimiters
        String[] delimiters = new String[] {":="};
        String[] arrFindByValues = objDesc.split(delimiters[0]);

        //Get Findby and Value
        String FindBy = arrFindByValues[0].toLowerCase();
        String val = arrFindByValues[1];

        switch(FindBy) {
            case "id":
                return driver.findElement(By.id(val));
            case "name":
                return driver.findElement(By.name(val));
            case "classname":
                return driver.findElement(By.className(val));
            case "linktext":
                return driver.findElement(By.linkText(val));
            case "partiallinktext":
                return driver.findElement(By.partialLinkText(val));
            case "tagname":
                return driver.findElement(By.tagName(val));
            case "cssselector":
                return driver.findElement(By.cssSelector(val));
            case "xpath":
                return driver.findElement(By.xpath(val));
            case "accessibility_id":
                return ((AppiumDriver)driver).findElement(MobileBy.AccessibilityId(val));
            case "appclassname":
                return ((AppiumDriver)driver).findElement(By.className(val));
            case "uiautomator":
                return ((AppiumDriver)driver).findElement(MobileBy.AndroidUIAutomator(val));
            default:
                throw(new InvalidSelectorException("Wrapper method getElement() : Property "  + FindBy + " specified for element is invalid"));
        }
    }

    public List<WebElement> getElements(String objDesc) {
        //Delimiters
        String[] delimiters = new String[] {":="};
        String[] arrFindByValues = objDesc.split(delimiters[0]);

        //Get Findby and Value
        String FindBy = arrFindByValues[0].toLowerCase();
        String val = arrFindByValues[1];

        switch(FindBy) {
            case "id":
                return driver.findElements(By.id(val));
            case "name":
                return driver.findElements(By.name(val));
            case "classname":
                return driver.findElements(By.className(val));
            case "linktext":
                return driver.findElements(By.linkText(val));
            case "partiallinktext":
                return driver.findElements(By.partialLinkText(val));
            case "tagname":
                return driver.findElements(By.tagName(val));
            case "cssselector":
                return driver.findElements(By.cssSelector(val));
            case "xpath":
                return driver.findElements(By.xpath(val));
            case "accessibility_id":
                return ((AppiumDriver)driver).findElements(MobileBy.AccessibilityId(val));
            case "appclassname":
                return ((AppiumDriver)driver).findElements(By.className(val));
            case "uiautomator":
                return ((AppiumDriver)driver).findElements(MobileBy.AndroidUIAutomator(val));
            default:
                throw(new InvalidSelectorException("Wrapper method getElements() : Property "  + FindBy + " specified for element is invalid"));
        }
    }

    public WebElement getChildElement(WebElement parentElem, String objDesc) {
        //Delimiters
        String[] delimiters = new String[] {":="};
        String[] arrFindByValues = objDesc.split(delimiters[0]);

        //Get Findby and Value
        String FindBy = arrFindByValues[0].toLowerCase();
        String val = arrFindByValues[1];

        switch(FindBy) {
            case "id":
                return parentElem.findElement(By.id(val));
            case "name":
                return parentElem.findElement(By.name(val));
            case "classname":
                return parentElem.findElement(By.className(val));
            case "linktext":
                return parentElem.findElement(By.linkText(val));
            case "partiallinktext":
                return parentElem.findElement(By.partialLinkText(val));
            case "tagname":
                return parentElem.findElement(By.tagName(val));
            case "cssselector":
                return parentElem.findElement(By.cssSelector(val));
            case "xpath":
                return parentElem.findElement(By.xpath(val));
            case "accessibility_id":
                return ((AppiumDriver)parentElem).findElement(MobileBy.AccessibilityId(val));
            case "appclassname":
                return ((AppiumDriver)parentElem).findElement(By.className(val));
            case "uiautomator":
                return ((AppiumDriver)parentElem).findElement(MobileBy.AndroidUIAutomator(val));
            default:
                throw(new InvalidSelectorException("Wrapper method getChildElement() : Property "  + FindBy + " specified for element is invalid"));
        }
    }

    public List<WebElement> getChildElements(WebElement parentElem, String objDesc) {
        //Delimiters
        String[] delimiters = new String[] {":="};
        String[] arrFindByValues = objDesc.split(delimiters[0]);

        //Get Findby and Value
        String FindBy = arrFindByValues[0].toLowerCase();
        String val = arrFindByValues[1];

        switch(FindBy) {
            case "id":
                return parentElem.findElements(By.id(val));
            case "name":
                return parentElem.findElements(By.name(val));
            case "classname":
                return parentElem.findElements(By.className(val));
            case "linktext":
                return parentElem.findElements(By.linkText(val));
            case "partiallinktext":
                return parentElem.findElements(By.partialLinkText(val));
            case "tagname":
                return parentElem.findElements(By.tagName(val));
            case "cssselector":
                return parentElem.findElements(By.cssSelector(val));
            case "xpath":
                return parentElem.findElements(By.xpath(val));
            case "accessibility_id":
                return parentElem.findElements(MobileBy.AccessibilityId(val));
            case "appclassname":
                return parentElem.findElements(By.className(val));
            case "uiautomator":
                return parentElem.findElements(MobileBy.AndroidUIAutomator(val));
            default:
                throw(new InvalidSelectorException("Wrapper method getChildElements() : Property "  + FindBy + " specified for element is invalid"));
        }
    }

	public boolean isElementPresent(String strDesc){
        List<WebElement> lst = getElements(strDesc);
        return !(lst == null || lst.size() == 0);
    }

	public boolean isChildElementPresent(WebElement objParent, String strDesc) {
        List<WebElement> lst = getChildElements(objParent,strDesc);
        return !(lst == null || lst.size() == 0);
    }

	public boolean isElementDisplayed(String strDesc) throws InterruptedException {
        WebElement webElement = getElement(strDesc);
        return isElementDisplayed(webElement);
    }

	public boolean isElementDisplayed(WebElement webElement) throws InterruptedException {
        boolean bIsDisplayed = webElement.isDisplayed();
        return  bIsDisplayed;
    }

    public boolean isElementEnabled(String strDesc) throws InterruptedException {
        //Get WebElement
        WebElement webElement = getElement(strDesc);
        return isElementEnabled(webElement);
    }	

    public boolean isElementEnabled(WebElement webElement) throws InterruptedException {
    	//Check if the WebElement is Enabled
        return webElement.isEnabled();
    }	

    public boolean isElementSelected(String strDesc) {
        //Get WebElement
        WebElement webElement = getElement(strDesc);
        return isElementSelected(webElement);
    }

    public boolean isElementSelected(WebElement webElement){
        return webElement.isSelected();
    }

    public Wrappers click(String strDesc) {
        //Initialize
        WebElement webElement = getElement(strDesc);
        return click(webElement);
    }

    public Wrappers click(WebElement objClick) {
        //Check if the object is enabled, if yes click the same
        if (objClick.isDisplayed() && objClick.isEnabled())
            //Click on the object
            objClick.click();
        else
            throw(new ElementNotVisibleException("Wrapper method click() : Element is either not visible or is not enabled"));

        return this;
    }	

    public Wrappers enterText(String strDesc, String strText) {
        WebElement webElement = getElement(strDesc);
        return enterText(webElement,strText);
    }	

    public Wrappers enterText(WebElement objEdit, String strText) {
    	String strDesc = objEdit.toString();

        //Check if the object is enabled, if yes click the same
        if (objEdit.isDisplayed() && objEdit.isEnabled()) {
            //Enter the text in the edit box
            objEdit.clear();
            objEdit.sendKeys(strText);
        }
        else
            throw(new ElementNotVisibleException("Wrapper method enterText() : Element with description " + strDesc + " is either not visible or is not enabled"));

        
        return this;
    }	

    public Wrappers selectOptionFromList(String strDesc, String strText) {
        WebElement webElement = getElement(strDesc);
        return selectOptionFromList(webElement,strText);
    }

    public Wrappers selectOptionFromList(WebElement objSelect, String strText) {
    	String strDesc = objSelect.toString();

        //Check if the object is enabled, if yes click the same
        if (objSelect.isDisplayed() && objSelect.isEnabled()){
            //Set Select Element and select required value by text
            try {
                Select select = new Select(objSelect);
                select.selectByVisibleText(strText);
            }
            catch(WebDriverException ex){
                throw(ex);
            }
        }
        else
            throw(new ElementNotVisibleException("Wrapper method selectOptionFromList() : Element with description " + strDesc + " is either not visible or is not enabled"));

        return this;
    }

    public Wrappers checkCheckBox(String strDesc) {
        //Initialize
        WebElement webElement = getElement(strDesc);
        return checkCheckBox(webElement);
    }

    public Wrappers checkCheckBox(WebElement objChkBox) {
    	String strDesc = objChkBox.toString();

        //Check if the object is enabled, if yes click the same
        if (objChkBox.isDisplayed() && objChkBox.isEnabled()){
            //Check state of check box
            boolean isChecked = objChkBox.isSelected();

            //Check if Not Checked
            if(isChecked == false)
                objChkBox.click();
        }
        else
            throw(new ElementNotVisibleException("Wrapper method checkCheckBox() : Element with description " + strDesc + " is either not visible or is not enabled"));
        
        return this;
    }

    public Wrappers uncheckCheckBox(String strDesc) {
        //Initialize
        WebElement webElement = getElement(strDesc);
        return uncheckCheckBox(webElement);
    }

    public Wrappers uncheckCheckBox(WebElement objChkBox) {
    	String strDesc = objChkBox.toString();

        //Check if the object is enabled, if yes click the same
        if (objChkBox.isDisplayed() && objChkBox.isEnabled()){
            //Check state of check box
            boolean isChecked = objChkBox.isSelected();

            //Check if Checked
            if(isChecked == true)
                objChkBox.click();
        }
        else
            throw(new ElementNotVisibleException("Wrapper method checkCheckBox() : Element with description " + strDesc + " is either not visible or is not enabled"));
        
        return this;
    }

	public String getCurrentBrowser() {
		try {
			Capabilities DC = ((RemoteWebDriver)driver).getCapabilities();
			return DC.getBrowserName();
		}
		catch(WebDriverException e) {
			throw(e);
		}
	}

    public Wrappers rotateDeviceScreen(String Orientation) throws InterruptedException {

        try {
            if (Orientation.equalsIgnoreCase("L"))
                ((AppiumDriver)driver).rotate(ScreenOrientation.LANDSCAPE);
            else
                ((AppiumDriver)driver).rotate(ScreenOrientation.PORTRAIT);

            //wait till orientation change
            Thread.sleep(1000);
        }
        catch(WebDriverException ex){
            throw(ex);
        }

        return this;
    }

    public Wrappers setGeoLocation(String lat, String lon){
        //js
        String Script = "window.navigator.geolocation.getCurrentPosition =  function(success){var position = {'coords' : {'latitude': '" + lat + "', 'longitude': '" + lon + "'}}; success(position);}";

        //Update geolocation
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Object[] args = {null};
        js.executeScript(Script, args);

        return this;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public String getCurrentAndroidActivity(){
        return ((AndroidDriver)driver).currentActivity();
    }

    public Wrappers maximizeWindow() {
        try {
            driver.manage().window().maximize();
        }
        catch(WebDriverException e){
            throw(e);
        }
        
        return this;
    }

	public Wrappers switchToWindowWithName() throws Exception {
		try {
			//driver.switchTo().window(strWindowName);
			//Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
		}
		catch(Exception e) {
			throw(e);
		}
		
		return this;
	}

    public Wrappers waitForAndroidActivity(String expectedActivity,int sec) {
    	int i = 0;
    	String actualActivity="";
    	
    	//Loop for activity
    	while(i<sec) {

    		actualActivity = ((AndroidDriver)driver).currentActivity();
    		if(actualActivity.equals(expectedActivity)){
                return this;
            }
    		
    		try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            //increment
    		i++;
    	}
        
    	throw(new TimeoutException("Timeout occured while waiting for Android Activity " + expectedActivity + " Current Activity is " + actualActivity));
    }

}

package com.smartfocus.test.ui.Utilities;

import com.smartfocus.test.ui.page_objects.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UtilityHover extends Base {

    public static void hover(WebElement baseLocator, WebElement targetLocator) {
        //isDisplayed(baseLocator, 5);
        Actions action = new Actions(driver);
        action.moveToElement(baseLocator).perform();
       // isDisplayed(targetLocator, 5);
        action.moveToElement(targetLocator).click().perform();
    }



}




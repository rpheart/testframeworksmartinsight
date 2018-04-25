package com.smartfocus.test.ui.Utilities;

import com.smartfocus.test.ui.page_objects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.WebElement;

import java.security.acl.Group;

public class UtilityDragger extends Base{



    public static void drag(WebElement filter, WebElement group) {
        Actions action = new Actions(driver);
        filter.isDisplayed();
        action.clickAndHold(filter);
        action.dragAndDrop(filter, group).build().perform();
    }





}

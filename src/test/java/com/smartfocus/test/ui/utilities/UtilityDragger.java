package com.smartfocus.test.ui.utilities;

import com.smartfocus.test.ui.page_objects.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.WebElement;

import java.security.acl.Group;

public class UtilityDragger extends Base{


    public static void drag(WebElement filter, WebElement group) {
        Actions action = new Actions(driver);
        action.clickAndHold(filter);
        action.dragAndDrop(filter, group).build().perform();
    }


}

package com.smartfocus.test.ui.utilities;

import com.smartfocus.test.ui.page_objects.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UtilityFilterDragger extends Base{

    //ONLY IN DEVELOPMENT AT THIS TIME - ONLY IN DEVELOPMENT AT THIS TIME - ONLY IN DEVELOPMENT AT THIS TIME - ONLY IN DEVELOPMENT AT THIS TIME -

    @BeforeClass
    public void setUp(){
        BrowserBase.startBrowser("chrome", "https://qa-sfui.themessagecloud.com");
        Logins login = new Logins();
        login.loginSidevall();
        NewSegment custom = new NewSegment();
        custom.newCustom();
    }

    @Test
    public void dragTest(){
        Actions actions = new Actions(driver);
        RefineSegment dragger = PageFactory.initElements(driver, RefineSegment.class);
//		isDisplayed(dragger.ageRange(), 5);
//		actions.clickAndHold(dragger.ageRange());
//		actions.dragAndDrop(dragger.ageRange(), dragger.getPurchaseFilterGroup()).perform();
    }


}

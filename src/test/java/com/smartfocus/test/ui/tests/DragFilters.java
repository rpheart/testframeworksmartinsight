package com.smartfocus.test.ui.tests;

import com.smartfocus.test.ui.page_objects.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragFilters extends Base {

	
	
	@BeforeClass
	public void setUp(){
		BrowserBase.startBrowser("chrome", "https://qa-sfui.themessagecloud.com");
		Login_sidevall login = new Login_sidevall();
		login.loginSidevall();
		NewSegment custom = new NewSegment();
		custom.newCustom();
	}
	
	@Test
	public void dragTest(){
		Actions actions = new Actions(driver);
		Refine dragger = PageFactory.initElements(driver, Refine.class);
		isDisplayed(dragger.ageRange(), 5);
		actions.clickAndHold(dragger.ageRange());
		actions.dragAndDrop(dragger.ageRange(), dragger.getPurchaseFilterGroup()).perform(); 
	}
	
}

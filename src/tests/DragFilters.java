package tests;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.Base;
import pageObjects.BrowserBase;
import pageObjects.Login_sidevall;
import pageObjects.NewSegment;
import pageObjects.Refine;

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
		isDisplayed(dragger.getFilter(), 5);
		actions.clickAndHold(dragger.getFilter());
		actions.dragAndDrop(dragger.getFilter(), dragger.getPurchaseFilterGroup()).perform(); 
	}
	
}

package tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.Base;
import pageObjects.BrowserBase;
import pageObjects.Login_sidevall;

public class TestLogin extends Base {
	
	//private Login_sidevall login;
	
	By hamburger = By.className("menuPills");
	By view = By.xpath("//*[@id='SFUI_Nav']/div/div/ul/li[1]/i");
	
	@BeforeClass
	public void setUp(){
		//BrowserBase browser = new BrowserBase();
		BrowserBase.startBrowser("chrome", "https://qa-sfui.themessagecloud.com");
		
		//Base.driver = Base.startBrowser("chrome", "https://qa-sfui.themessagecloud.com");
	}
	
	@Test
	public void verifyLogin(){
		Login_sidevall login = new Login_sidevall();
		login.loginSidevall();
		Assert.assertTrue(isDisplayedBy(hamburger, 4));
		Assert.assertTrue(isDisplayedBy(view, 8));
		System.out.println(driver.getTitle());
		}

}
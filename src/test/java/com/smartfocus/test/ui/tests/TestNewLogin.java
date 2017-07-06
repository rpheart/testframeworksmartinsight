package com.smartfocus.test.ui.tests;

import com.smartfocus.test.ui.page_objects.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNewLogin extends Base{

	
	By username = By.id("IDToken1");
	WebElement userid = driver.findElement(username);

	By password = By.id("IDToken2");
	By loginButton = By.id("loginButton");
	
	@BeforeClass
	public static void setup(){
		//driver.startBrowser("chrome", "qa-sfui.themessagecloud.com");	
	}

	@AfterClass
	public static void teardown(){
		driver.close();
	}
	
/*	static {
		driver = new ChromeDriver();
	}*/
	

	
	@Test
	public void loginpage(){
		driver.get("qa-sfui.themessagecloud.com");
		Assert.assertEquals(driver.getTitle(), "SmartFocus: The Market and Technology Leader for E-mail Marketing Software on Demand");
	}
	
	@Test 
	public void fillUserName(){
		type(username, "sidevall");
		Assert.assertEquals(userid.getAttribute("value"), "sidevall");
	}
	
	
	
	
}

package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.Base;
import pageObjects.BrowserBase;
import pageObjects.Login_sidevall;
import pageObjects.NewSegment;
import pageObjects.SegmentNameText;

public class TestCreateNewCustom extends Base {


	@BeforeClass
	public void setUp(){
		BrowserBase.startBrowser("chrome", "https://qa-sfui.themessagecloud.com");
		Login_sidevall login = new Login_sidevall();
		login.loginSidevall();
	}
	
	@Test(priority = 0)
	public void verifyNewCustom(){
		NewSegment custom = new NewSegment();
		custom.newCustom();
		SegmentNameText nameClass = PageFactory.initElements(driver, SegmentNameText.class);
		String segmentName = nameClass.getText();
		System.out.println(segmentName);
		Assert.assertEquals(segmentName, "Custom Segment");
	}
	

	@Test(priority = 1)
	public void verifyNewTimeline(){
		NewSegment timeline = new NewSegment();
		timeline.newTimeline();
		SegmentNameText nameClass = PageFactory.initElements(driver, SegmentNameText.class);
		String segmentName = nameClass.getText();
		System.out.println(segmentName);
		Assert.assertEquals(segmentName, "Timeline Segment");
	}
	
	@Test(priority = 2)
	public void verifyNewAffinity(){
		NewSegment affinity = new NewSegment();
		affinity.newAffinity();
		SegmentNameText nameClass = PageFactory.initElements(driver, SegmentNameText.class);
		String segmentName = nameClass.getText();
		System.out.println(segmentName);
		Assert.assertEquals(segmentName, "Affinity Report");
	}
	
	@AfterClass
	public void end(){
		Base.tearDown();	
	}

	
	 
}

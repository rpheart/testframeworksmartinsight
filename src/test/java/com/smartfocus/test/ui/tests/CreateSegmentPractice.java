package com.smartfocus.test.ui.tests;


import com.smartfocus.test.ui.page_objects.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CreateSegmentPractice extends Base{

	
	
	
	
	@BeforeClass
	public void setUp(){
		BrowserBase.startBrowser("chrome", "https://qa-sfui.themessagecloud.com");
		Login_sidevall login = new Login_sidevall();
		login.loginSidevall();
		NewSegment custom = new NewSegment();
		custom.newCustom();
	}
	

	@Test (priority = 0)
	public void CampaignGroupTest (){
		Refine refine = new Refine();
		refine.addCampaignGroup();
		refine.addCampaignGroup();
		refine = PageFactory.initElements(driver, Refine.class);
		refine.findAddedGroups();
		String groupType = refine.getGroupType(2);
		Assert.assertTrue(groupType.contains("Campaigns: "), "Group position 2 not matched");
		groupType = refine.getGroupType(3);
		Assert.assertTrue(groupType.contains("Campaigns: "));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	@Test (priority = 0)
	public void CampaignGroupTest(){
		Refine refine = new Refine();
		refine.addCampaignGroup();
		refine = PageFactory.initElements(driver, Refine.class);
		refine.findAddedGroups();
		List<WebElement> added = refine.getAddedGroups();
		System.out.println("Groups Found: " + "and total number of" + added.size());
	}
	*/
		
/*
	@Test(priority = 0)
	public void CampaignGroupTest(){
		Refine refineClass = PageFactory.initElements(driver, Refine.class);
		String filterGroupName = refineClass.addCampaignGroup();
		System.out.println(filterGroupName);
		
		List<WebElement> groups = refineClass.getFilterGroups();
		for (int index = 0; index <groups.size(); index++){
			WebElement group = groups.get(index);
			System.out.println("CampaignGroupTest: " + group.getText());
		}
		Assert.assertEquals(filterGroupName, "Campaigns: Last 1 Year(s)");
	}*/
	
/*	@Test(priority = 0)
	public void PurchaseGroupTest(){
			Refine refineClass = PageFactory.initElements(driver, Refine.class);
			String filterGroupName = refineClass.addPurchaseGroup();
			//System.out.println(filterGroupName);
			Assert.assertEquals(filterGroupName, "Purchases: Last 1 Year(s)");
			List<WebElement> groups = refineClass.getFilterGroups();
			for (int index = 0; index <groups.size(); index++){
				WebElement group = groups.get(index);
				System.out.println("PurchaseGroupTest: " + group.getText());
			}
	}
	
	@Test(priority = 1)
	public void CampaignGroupTest(){
			Refine refineClass = PageFactory.initElements(driver, Refine.class);
			String filterGroupName = refineClass.addCampaignGroup();
			System.out.println(filterGroupName);
			
			List<WebElement> groups = refineClass.getFilterGroups();
			for (int index = 0; index <groups.size(); index++){
				WebElement group = groups.get(index);
				System.out.println("CampaignGroupTest: " + group.getText());
			}
			Assert.assertEquals(filterGroupName, "Campaigns: Last 1 Year(s)");
	}*/
	
	/*@Test
	public void CountFilterGroups(){
		List<WebElement> filterGroups = null;
		Refine refineClass = PageFactory.initElements(driver, Refine.class);
		refineClass.addPurchaseGroup();
		refineClass.addCampaignGroup();
		refineClass.addPeopleGroup();
		try {
			Thread.sleep(5000);
		}
		catch (InterruptedException e) {
			
		}
		RefineGlobal2 refineClass2 = PageFactory.initElements(driver, RefineGlobal2.class);
		filterGroups = refineClass2.getAddedFilterGroups();
		Iterator<WebElement> iter = filterGroups.iterator();
		while ( iter.hasNext() ) {
			WebElement we = iter.next();
			System.out.println(we.getText());
		}
	}*/
	
//	
//	@AfterClass
//	public void end(){
//		Base.tearDown();	
//	}
	
}

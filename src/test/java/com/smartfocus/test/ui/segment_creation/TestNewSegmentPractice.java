package com.smartfocus.test.ui.segment_creation;

import com.smartfocus.test.Assert;
import com.smartfocus.test.ui.page_objects.*;
import com.smartfocus.test.ui.utilities.UtilityDragger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.smartfocus.test.ui.page_objects.RefineGlobal;

import javax.rmi.CORBA.Util;

import static org.testng.Assert.assertTrue;

public class TestNewSegmentPractice extends Base {

    RefineGlobal RG;
    LOVFilterConfig lovFilter = new LOVFilterConfig();
    AmountFilterConfig amountFilter = new AmountFilterConfig();
    SegmentTitle editTitle = new SegmentTitle();
    SegmentDescription editDescription = new SegmentDescription();
    HomeNavigation navigation = new HomeNavigation();
    Analyze manager;

    @BeforeClass
    public void setUp(){

        BrowserBase.startBrowser("chrome", "https://qa-sfui.themessagecloud.com");
        Logins login = new Logins();
        login.loginSidevall();
        NewSegment custom = new NewSegment();
        custom.newCustom();
        RG = PageFactory.initElements(driver, RefineGlobal.class);
        manager = PageFactory.initElements(driver, Analyze.class);
    }

    @Test
    public void dragTest() {

        //CHANGE TITLE AND DESCRIPTION
        RG.openTitle();
        editTitle.newTitle("New Segment Title");
        RG.openDescription();
        editDescription.newDescription("New description of segment");

        //ADD FILTER GROUPS AND FILTERS
        RG.getGroup(1, true);
        RG.addPurchaseGroup();
        RG.findAddedGroups()
        RG.findAddedGroups();

        UtilityDragger.drag(RG.ageRange(), RG.getGroup(1));
        for (WebElement checkBox : lovFilter.genericLOV("18-20", "21-24")) {
            checkBox.click(); }
        for (WebElement checkBox : lovFilter.genericLOV("18-20")) {
            checkBox.click();
        }
        lovFilter.saveFilter();


        UtilityDragger.drag(RG.totalSpend(),RG.getGroup(2));
        amountFilter.inBetween("4", "500");
        lovFilter.saveFilter();

        //SAVE SEGMENT

        RG.saveSegment();

  /*      try {
            Thread.sleep(5);
        }
        catch (InterruptedException exception ) {

        }
*/
        navigation.analyze();

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException exceptionn ) {
        }

        //DELETE SEGMENT

        for (WebElement checkBox : manager.segmentList("New Segment Title")) {
            checkBox.click();
        }
        manager.deleteSegment();







/*        RG.findFilterGroup(1);
        RG.addPurchaseGroup();
        UtilityDragger.drag(RG.ageRange(), RG.getGroup(2));
        for (WebElement checkBox : lovFilter.genericLOV("18-20", "21-24")) {
            checkBox.click();
        }
        for (WebElement checkBox : lovFilter.genericLOV("18-20")) {
            checkBox.click();
        }

        lovFilter.saveFilter();*/
    }


/*    public void addFilterTest() {
        Actions actions = new Actions(driver);
        RefineGlobal dragger =  PageFactory.initElements(driver, RefineGlobal.class);
        RefineGlobal filter = new RefineGlobal();
    }*/

/*   @Test
    public void filterPresent() {
        RefineGlobal refine = new RefineGlobal();
        Actions actions = new Actions(driver);
        isDisplayed(refine.ageRange(), 5);
        actions.clickAndHold(refine.ageRange());
        actions.dragAndDrop(refine.ageRange(), refine.firstGroup()).perform();*/
/*        Actions actions = new Actions(driver);
        RefineGlobal dragger = PageFactory.initElements(driver, RefineGlobal.class);
        actions.clickAndHold(dragger.ageRange());
        actions.dragAndDrop(dragger.ageRange(), dragger.firstGroup()).perform();
    }
*/


   /* @Test(priority = 0)
    public void campaignGroupTest (){
        RefineGlobal refine = new RefineGlobal();
        refine.addCampaignGroup();
        refine = PageFactory.initElements(driver, RefineGlobal.class);
        refine.findAddedGroups();
        String groupType = refine.getGroupType(2);
        Assert.assertTrue(groupType.contains("Campaigns: "), "Group position 2 not matched");
        groupType = refine.getGroupType(3);
        Assert.assertTrue(groupType.contains("Campaigns: "));

    }*/


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
/*
	@AfterClass
	public void end(){
		Base.tearDown();
	}


*/


}

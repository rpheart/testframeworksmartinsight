package com.smartfocus.test.ui.segment_creation;

import com.smartfocus.test.ui.page_objects.*;
import com.smartfocus.test.ui.utilities.UtilityDragger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.smartfocus.test.ui.page_objects.RefineGlobal;

import static org.testng.Assert.assertTrue;

public class TestNewSegmentPractice extends Base {

    RefineGlobal RG;
    LOVFilterConfig lovFilter = new LOVFilterConfig();
    AmountFilterConfig amountFilter = new AmountFilterConfig();
    SegmentTitle editTitle = new SegmentTitle();
    SegmentDescription editDescription = new SegmentDescription();
    HomeNavigation navigation = new HomeNavigation();
    Analyze manager;
    SegmentChartViews segmentCharts;


    @BeforeClass
    public void setUp() {

        BrowserBase.startBrowser("chrome", "https://qa-sfui.themessagecloud.com");
        Logins login = new Logins();
        login.loginSidevall();
        NewSegment custom = new NewSegment();
        custom.newCustom();
        RG = PageFactory.initElements(driver, RefineGlobal.class);
        manager = PageFactory.initElements(driver, Analyze.class);
        segmentCharts = PageFactory.initElements(driver, SegmentChartViews.class);
    }


    @Test
    public void dragTest() {

        //CHANGE TITLE AND DESCRIPTION
        RG.openTitle();
        editTitle.newTitle("New Segment Title");
        RG.openDescription();
        editDescription.newDescription("New description of segment");

        //ADD FILTER GROUPS AND FILTERS
        RG.addPurchaseGroup();

        //FILTERS
        UtilityDragger.drag(RG.ageRange(), RG.getDropZone(2));
        for (WebElement checkBox : lovFilter.genericLOV("18-20", "21-24")) {
            checkBox.click();
        }
        for (WebElement checkBox : lovFilter.genericLOV("18-20")) {
            checkBox.click();
        }
        lovFilter.saveFilter();

        UtilityDragger.drag(RG.totalSpend(), RG.getDropZone(2));
        amountFilter.inBetween("4", "500");
        lovFilter.saveFilter();

        //TURN ON TOGGLE

        RG.settingsTab();

        RG.toggleAgeAndGenderSetting();
        RG.toggleRFM();


        //SAVE SEGMENT
        RG.saveSegment();


        //VERIFY SEGMENT RENDERS

        RG.summaryTab();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

        RG.totalSpendChartView();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

        segmentCharts.deptView();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

        for (WebElement dataBar : segmentCharts.genericDataBar("1")) {
            dataBar.click();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

        segmentCharts.categoryView();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }


        RG.segmentRFMChartView();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException exception) {

        }

        for (WebElement scorecard : segmentCharts.genericScorecard( "2", "3")) {
            scorecard.click();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

        segmentCharts.rfmExplore();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

        RG.saveExistingSegment();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }


        navigation.analyze();


        for (WebElement checkBox : manager.segmentList("New Segment Title")) {
            checkBox.click();
        }


        manager.deleteSegment();

    }






/*

    @Test
    public void toggleTest() {

        RG.settingsTab();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

        RG.toggleLockSetting();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

        RG.toggleLockSetting();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

        RG.toggleWorkgroupSetting();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

        RG.toggleWorkgroupSetting();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

        RG.toggleAgeAndGenderSetting();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

        RG.toggleAgeAndGenderSetting();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

        RG.toggleTotalSpendSetting();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

        RG.toggleTotalSpendSetting();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

        RG.toggleRFM();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

        RG.toggleRFM();

    }

*/


/*
	@AfterClass
	public void end(){
		Base.tearDown();
	}


*/


}

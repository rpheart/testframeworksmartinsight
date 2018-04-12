package com.smartfocus.test.ui.segment_creation;

import com.smartfocus.test.ui.page_objects.*;
import com.smartfocus.test.ui.Utilities.UtilityDragger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.smartfocus.test.ui.page_objects.RefineGlobal;

import static org.testng.Assert.assertTrue;

public class TestNewSegmentPractice extends Base {

    RefineGlobal RG;
    LOVFilterConfig lovFilter = new LOVFilterConfig();
    Settings settings = new Settings();
    AmountFilterConfig amountFilter = new AmountFilterConfig();
    SegmentTitle editTitle = new SegmentTitle();
    SegmentDescription editDescription = new SegmentDescription();
    HomeNavigation navigation = new HomeNavigation();
    Analyze manager;
    SegmentChartViews segmentCharts;
    QOSOTemplateConfig qoso;


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
        qoso = PageFactory.initElements(driver, QOSOTemplateConfig.class);
    }


    @Test
    public void dragTest() {

        //CHANGE TITLE AND DESCRIPTION
        RG.openTitle();
        editTitle.newTitle("New Segment Title");
        RG.openDescription();
        editDescription.newDescription("New description of segment");

        RG.findAddedGroups();


        //FILTERS
        UtilityDragger.drag(RG.qosoContainer(), RG.getDropZone(1));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

        UtilityDragger.drag(RG.qosoContainer(), RG.getDropZone(1));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

        qoso.setQosoAmount(1, 2, "between", 5, 100);
        qoso.setQosoQuantity(1, 2, "at least", 2);
        qoso.setQosoItems(1, 2, "department", "Women's", "Ski");
        qoso.setQosoTransactions(1, 2, "any");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }




        UtilityDragger.drag(RG.city(), RG.getDropZone(1));

        lovFilter.toggleLOV(lovFilter.getCityLovList(), "Seattle", "Baltimore");

        lovFilter.saveFilter();

        //ADD FILTER GROUPS AND FILTERS
        RG.addPurchaseGroup();


        UtilityDragger.drag(RG.totalSpend(), RG.getDropZone(2));
        amountFilter.inBetween(4, 500);
        amountFilter.saveFilter();

        //qoso container practice


        UtilityDragger.drag(RG.qosoContainer(), RG.getDropZone(2));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

        UtilityDragger.drag(RG.qosoContainer(), RG.getDropZone(2));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }


        UtilityDragger.drag(RG.city(), qoso.getQOSODropZone(2,3));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

      lovFilter.toggleLOV(lovFilter.getCityLovList(),"Baltimore", "Seattle");

        lovFilter.saveFilter();

        //TURN ON TOGGLE

        RG.settingsTab();

        settings.toggleAgeAndGenderSettingOn();
        settings.toggleRfmSettingOn();


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


        for (WebElement checkBox : manager.segmentCheckboxList("New Segment Title")) {
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

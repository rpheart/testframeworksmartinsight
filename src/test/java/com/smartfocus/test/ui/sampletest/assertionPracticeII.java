package com.smartfocus.test.ui.sampletest;

import com.smartfocus.test.ui.page_objects.*;
import com.smartfocus.test.ui.utilities.UtilityDragger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class assertionPracticeII extends Base{

    RefineGlobal RG;
    LOVFilterConfig lovFilter = new LOVFilterConfig();
    AmountFilterConfig amountFilter = new AmountFilterConfig();
    SegmentTitle editTitle = new SegmentTitle();
    SegmentDescription editDescription = new SegmentDescription();
    HomeNavigation navigation = new HomeNavigation();
    Analyze manager;
    SegmentChartViews segmentCharts;
    QOSOTemplateConfig qoso;

    By homePageLocator = By.id("#SFUI_home_page");

    @BeforeClass
    public void setUp() {

        BrowserBase.startBrowser("chrome", "https://qa-sfui.themessagecloud.com");

        Logins login = new Logins();
        login.loginSidevall();
        Assert.assertTrue(login.loginSuccess(), "Login failed");

        NewSegment custom = new NewSegment();
        custom.newCustom();
        Assert.assertTrue(custom.newSegmentStartSuccess(), "Failed to reach new Custom Segment page");

        RG = PageFactory.initElements(driver, RefineGlobal.class);
        manager = PageFactory.initElements(driver, Analyze.class);
        segmentCharts = PageFactory.initElements(driver, SegmentChartViews.class);
        qoso = PageFactory.initElements(driver, QOSOTemplateConfig.class);
    }


    @Test
    public void assertionTest() {

        //CHANGE TITLE AND DESCRIPTION
        RG.openTitle();
        editTitle.newTitle("Assertion Practice");
        Assert.assertTrue(RG.segmentTitleChangeSuccess("Assertion Practice"), "Failed to update segment title properly");

        RG.openDescription();
        editDescription.newDescription("New description of segment");
        Assert.assertTrue(RG.segmentDescriptionChangeSuccess("New description of Segment"), "Failed to update segment title properly");

        RG.findAddedGroups();


        // First filter group: Purchase, 2 filters (values excluded in second filter)

        UtilityDragger.drag(RG.totalSpend(), RG.getDropZone(1));
        amountFilter.inBetween("5", "1000");
        amountFilter.saveFilter();
        Assert.assertTrue(RG.totalSpendSuccess("between", "5", "1000"), "Failed to set amount(s) properly");


        UtilityDragger.drag(RG.state(), RG.getDropZone(1));
        lovFilter.toggleLOV( "Washington", "California");
        lovFilter.exclude();
        lovFilter.saveFilter();
        Assert.assertTrue(RG.lovCheckedSuccess(RG.filterState, "Washington", "California"), "Failed to check lovs properly");



        // Second filter group: People, 2 QOSO containers, 2 filters in second containers

        RG.addPeopleGroup();

        UtilityDragger.drag(RG.qosoContainer(), RG.getDropZone(2));
        qoso.qosoAmount(2, 1, "between", "5", "100");
        qoso.qosoQuantity(2, 1, "at least", "2");
        qoso.qosoItems(2, 1, "department", "Accessories", "Clothing Accessories", "Women's", "Men's", "Ski");
        qoso.qosoTransactions(2, 1, "all");

        UtilityDragger.drag(RG.qosoContainer(), RG.getDropZone(2));
        qoso.qosoAmount(2, 2, "at most", "500");
        qoso.qosoQuantity(2, 2, "between", "2", "40");
        qoso.qosoItems(2, 2, "category", "Accessories", "Accessories Misc", "Women's Shoes", "Women's Casual Shirts", "Men's Footwear", "Men's Casual Shirts", "Socks");
        qoso.qosoTransactions(2, 2, "any");

        UtilityDragger.drag(RG.ageRange(), qoso.getQOSODropZone(2, 2));
        lovFilter.selectAll();
        lovFilter.toggleLOV( "18-20", "21-24");
        lovFilter.saveFilter();

        UtilityDragger.drag(RG.salesChannel(), qoso.getQOSODropZone(2, 2));
        lovFilter.toggleLOV("Catalog");
        lovFilter.exclude();
        lovFilter.saveFilter();


        // Third filter group: Campaign. And/Or container flipped to AND, 2 filters (1 each half)

        RG.addPurchaseGroup();
        UtilityDragger.drag(RG.andOrContainer(), RG.getDropZone(3));

        UtilityDragger.drag(RG.department(), RG.getBottomDropZone(3));
        lovFilter.selectAll();
        lovFilter.toggleLOV( "Camp", "Climb");
        lovFilter.saveFilter();

        UtilityDragger.drag(RG.category(), RG.getTopDropZone(3));
        lovFilter.selectAll();
        lovFilter.toggleLOV( "Camp Misc", "Daypacks");
        lovFilter.saveFilter();

        RG.andOrButtonAnd(3).click();


        // Settings: All calculations on

        RG.settingsTab();
        RG.toggleAgeAndGenderSetting();
        RG.toggleTotalSpendSetting();
        RG.toggleRFM();


        //Save Segment
        RG.saveSegment();


        //View Summary and Calculation Options

        RG.summaryTab();
        RG.summaryChartView();
        RG.ageAndGenderChartView();
        RG.totalSpendChartView();
        RG.segmentRFMChartView();


        //Delete Segement

/*        navigation.analyze();

        for (WebElement checkBox : manager.segmentList("Assertion Practice")) {
            checkBox.click();
        }

        manager.deleteSegment();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }*/


    }


}

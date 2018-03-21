package com.smartfocus.test.ui.sampletest;

import com.smartfocus.test.ui.page_objects.*;
import com.smartfocus.test.ui.utilities.UtilityDragger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class assertionPractice extends Base{

    RefineGlobal RG;
    LOVFilterConfig lovFilter = new LOVFilterConfig();
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
    public void assertionTest() {

        //CHANGE TITLE AND DESCRIPTION
        RG.openTitle();
        editTitle.newTitle("Assertion Practice");
        RG.openDescription();
        editDescription.newDescription("New description of segment");

        RG.findAddedGroups();


        // First filter group: Purchase, 2 filters (values excluded in second filter)

        UtilityDragger.drag(RG.totalSpend(), RG.getDropZone(1));
        amountFilter.inBetween("5", "1000");
        amountFilter.saveFilter();

        UtilityDragger.drag(RG.state(), RG.getDropZone(1));
        lovFilter.toggleLOV( "Washington", "California");
        lovFilter.exclude();
        lovFilter.saveFilter();


        // Second filter group: People, 2 QOSO containers, 2 filters in second containers

        RG.addPeopleGroup();

        UtilityDragger.drag(RG.qosoContainer(), RG.getDropZone(2));
        qoso.setQosoAmount(2, 1, "between", "5", "100");
        qoso.setQosoQuantity(2, 1, "at least", "2");
        qoso.setQosoItems(2, 1, "department", "Accessories", "Clothing Accessories", "Women's", "Men's", "Ski");
        qoso.setQosoTransactions(2, 1, "all");

        UtilityDragger.drag(RG.qosoContainer(), RG.getDropZone(2));
        qoso.setQosoAmount(2, 2, "at most", "500");
        qoso.setQosoQuantity(2, 2, "between", "2", "40");
        qoso.setQosoItems(2, 2, "category", "Accessories", "Accessories Misc", "Women's Shoes", "Women's Casual Shirts", "Men's Footwear", "Men's Casual Shirts", "Socks");
        qoso.setQosoTransactions(2, 2, "any");

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
        lovFilter.toggleLOV("Camp", "Climb");
        lovFilter.saveFilter();

        UtilityDragger.drag(RG.category(), RG.getTopDropZone(3));
        lovFilter.selectAll();
        lovFilter.toggleLOV("Camp Misc", "Daypacks");
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

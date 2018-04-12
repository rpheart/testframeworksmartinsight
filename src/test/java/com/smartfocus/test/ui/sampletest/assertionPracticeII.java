package com.smartfocus.test.ui.sampletest;

import com.smartfocus.test.ui.Utilities.Scroll;
import com.smartfocus.test.ui.page_objects.*;
import com.smartfocus.test.ui.Utilities.UtilityDragger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class assertionPracticeII extends Base{

    RefineGlobal RG;
    Scroll scroll = new Scroll();
    SegmentDetail segmentDetail = new SegmentDetail();
    Settings settings = new Settings();
    LOVFilterConfig lovFilter = new LOVFilterConfig();
    AmountFilterConfig amountFilter = new AmountFilterConfig();
    SegmentTitle editTitle = new SegmentTitle();
    SegmentDescription editDescription = new SegmentDescription();
    HomeNavigation navigation = new HomeNavigation();
    Analyze manager;
    SegmentChartViews segmentCharts;
    QOSOTemplateConfig qoso;
    View view = new View();


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
        Assert.assertTrue(RG.verifySegmentTitleChange("Assertion Practice"), "Failed to update segment title properly");

        RG.openDescription();
        editDescription.newDescription("New description of segment");
        Assert.assertTrue(RG.verifySegmentDescriptionChange("New description of Segment"), "Failed to update segment title properly");

        RG.findAddedGroups();
        Assert.assertTrue(RG.groupAdded(1, "Purchase"));


        // First filter group: Purchase, 2 filters (values excluded in second filter)

        UtilityDragger.drag(RG.totalSpend(), RG.getDropZone(1));
        amountFilter.inBetween(400, 1000);
        amountFilter.saveFilter();
        Assert.assertTrue(amountFilter.amountFilterSuccess("Total Spend", "between", 400, 1000), "Failed to set amount(s) properly");
/*


        UtilityDragger.drag(RG.state(), RG.getDropZone(1));
        lovFilter.toggleLOV(lovFilter.getStateLovList(),"Washington", "California");
        lovFilter.exclude();
        Assert.assertTrue(lovFilter.lovsExcluded(), "Exclude button not checked.");
        lovFilter.saveFilter();
        Assert.assertTrue(lovFilter.lovCheckedSuccess("State (Exclude)", "Washington", "California"), "Failed to check lovs properly.");
        Assert.assertTrue(lovFilter.lovNotCheckedSuccess("State (Exclude)", "Oregon"), "Failed to find element or did filter LOV is checked.");

        // Second filter group: People, 2 QOSO containers, 2 filters in second containers

        RG.addPeopleGroup();
        Assert.assertTrue(RG.groupAdded(2, "People"));

        UtilityDragger.drag(RG.qosoContainer(), RG.getDropZone(2));
        qoso.setQosoAmount(2, 1, "between", 5, 100);
        Assert.assertTrue(qoso.checkQosoAmount(2, 1, "between $5 and $100"), "Incorrect amount displayed");
        qoso.setQosoQuantity(2, 1, "at least", 2);
        Assert.assertTrue(qoso.checkQosoQuantity(2, 1, "at least 2"), "Incorrect quantity displayed");
        qoso.setQosoItems(2, 1, "department", "Accessories", "Clothing Accessories", "Women's", "Men's", "Ski");
        waitThreeSeconds();
        Assert.assertTrue(qoso.checkQosoItems(2, 1, "department", "Accessories", "Clothing Accessories", "Women's", "Men's", "Ski"));
        qoso.setQosoTransactions(2, 1, "all");
        Assert.assertTrue(qoso.checkQosoTransaction(2, 1, "all"));


        UtilityDragger.drag(RG.qosoContainer(), RG.getDropZone(2));
        qoso.setQosoAmount(2, 2, "at most", 500);
        Assert.assertTrue(qoso.checkQosoAmount(2, 2, "at most $500"),"Incorrect amount displayed");
        qoso.setQosoQuantity(2, 2, "between", 2, 40);
        Assert.assertTrue(qoso.checkQosoQuantity(2, 2, "between 2 and 40"), "Incorrect quantity displayed");
        qoso.setQosoItems(2, 2, "category", "Accessories", "Accessories Misc", "Women's Shoes", "Women's Casual Shirts", "Men's Footwear", "Men's Casual Shirts", "Socks");
        Assert.assertTrue(qoso.checkQosoItems(2, 2, "category", "Accessories", "Accessories Misc", "Women's Shoes", "Women's Casual Shirts", "Men's Footwear", "Men's Casual Shirts", "Socks"));
        qoso.setQosoTransactions(2, 2, "any");
        Assert.assertTrue(qoso.checkQosoTransaction(2, 2, "any"));


        UtilityDragger.drag(RG.ageRange(), qoso.getQOSODropZone(2, 2));
        lovFilter.selectAll("Age Range");
        lovFilter.toggleLOV(lovFilter.getAgeRangeLovList(),"18-20", "21-24");
        lovFilter.saveFilter();
        Assert.assertTrue(qoso.checkQosoLovNotChecked(2, 2, "Age Range","18-20", "21-24" ), "QOSO filter not set correctly");

        UtilityDragger.drag(RG.salesChannel(), qoso.getQOSODropZone(2, 2));
        lovFilter.toggleLOV(lovFilter.getSalesChannelLovList(),"Catalog");
        lovFilter.exclude();
        Assert.assertTrue(lovFilter.lovsExcluded(), "Exclude button not checked.");
        lovFilter.saveFilter();
        Assert.assertTrue(lovFilter.lovCheckedSuccess("Catalog"),"Failed to find element or did filter LOV is checked.");

        // Third filter group: Campaign. And/Or container flipped to AND, 2 filters (1 each half)

        RG.addPurchaseGroup();
        Assert.assertTrue(RG.groupAdded(3, "Purchase"), "Filter group not added or added in the correct position");
        Assert.assertTrue(RG.verifyFilterGroupAndOrOperator(2, "And"), "And/Or operator not set properly");


        UtilityDragger.drag(RG.andOrContainer(), RG.getDropZone(3));
        Assert.assertTrue(RG.verifyAndOrContainerOperator(3, "Or"), "Wrong operator selected or not availeble, i.e. and/or container not added properly.");

        UtilityDragger.drag(RG.department(), RG.getBottomDropZone(3));
        lovFilter.selectAll("Department");
        lovFilter.toggleLOV( lovFilter.getDepartmentLovList(),"Camp", "Climb");
        lovFilter.saveFilter();
        Assert.assertTrue(lovFilter.lovNotCheckedSuccess("Department", "Camp", "Climb"), "Failed to unclick segment");

        UtilityDragger.drag(RG.category(), RG.getTopDropZone(3));
        lovFilter.selectAll("Category");
        lovFilter.toggleLOV( lovFilter.getCategoryLovList(),"Camp Misc", "Daypacks");
        lovFilter.saveFilter();
        Assert.assertTrue(lovFilter.lovNotCheckedSuccess("Category", "Camp Misc", "Daypacks"));

        RG.setAndOrContainerButtonAnd(3).click();
        Assert.assertTrue(RG.verifyAndOrContainerOperator(3, "And"), "And/Or button not properly set.");

*/
        // Settings: All calculations on

        RG.settingsTab();

/*
        Assert.assertTrue(settings.verifyAgeAndGenderNotEnabled(), "Age and Gender setting enabled, unexpectedly.");
        settings.toggleAgeAndGenderSettingOn();
        Assert.assertTrue(settings.verifyAgeAndGenderEnabled(), "Age and Gender setting not enabled, unexpectedly.");

        Assert.assertTrue(settings.verifyTotalSpendNotEnabled(), "Total Spend setting enabled, unexpectedly.");
        settings.toggleTotalSpendSettingOn();
        Assert.assertTrue(settings.verifyTotalSpendEnabled(), "Total Spend setting not enabled, unexpectedly.");
        settings.toggleTotalSpendSettingOff();
        Assert.assertTrue(settings.verifyTotalSpendNotEnabled(), "Total Spend setting not enabled, unexpectedly.");
        settings.toggleTotalSpendSettingOn();
        Assert.assertTrue(settings.verifyTotalSpendEnabled(), "Total Spend setting not enabled, unexpectedly.");

        Assert.assertTrue(settings.verifyRfmNotEnabled(), "RFM setting enabled, unexpectedly.");
        settings.toggleRfmSettingOn();
        Assert.assertTrue(settings.verifyRfmEnabled(), "RFM setting not enabled, unexpectedly.");
*/

        scroll.scrollToElement(settings.getAutoExportEmailToggle());

        Assert.assertTrue(settings.verifyAutoExportEmailNotEnabled(), "Auto Export to email already enabled, unexpectedly");
        settings.toggleAutoExportEmailOn();
        Assert.assertTrue(settings.verifyAutoExportEmailEnabled(), "Auto export to email not enabled, unexpectedly.");

        scroll.scrollToElement(settings.getAutoExportSFTPToggle());

        Assert.assertTrue(settings.verifyAutoExportSFTPNotEnabled(), "Auto Export to SFTP already enabled, unexpectedly");
        settings.toggleAutoExportSFTPOn();
        Assert.assertTrue(settings.verifyAutoExportSFTPEnabled(), "Auto export to SFTP not enabled, unexpectedly.");


        //Save Segment
        RG.saveSegment();
        //Assert.assertTrue(RG.verifySegmentSavedKnownCount("388"), "People count not matching results");
        Assert.assertTrue(RG.verifySegmentSavedUnknownCount(), "People count does not match");


   /*     //View Summary and Calculation Options

        RG.summaryTab();
        segmentDetail.renderSummaryTab();
        Assert.assertTrue(segmentDetail.verifySummaryRendered(), "Summary graphics did not render.");

        segmentDetail.renderAgeAndGender();
        Assert.assertTrue(segmentDetail.verifyAgeAndGenderRendered(), "The Age and Gender chart did not render.");

        segmentDetail.renderTotalSpend();
        Assert.assertTrue(segmentDetail.verifyTotalSpendRendered(), "The Total Spend by Product Chart did not render");

        segmentDetail.renderRFM();
        Assert.assertTrue(segmentDetail.verifyRfmRendered(), "The scorecards for RFM did not render");

*/
        navigation.analyze();

        Assert.assertTrue(manager.verifySegmentExportSuccess("Email", "Assertion Practice"), "Export failed.");
        Assert.assertTrue(manager.verifySegmentExportSuccess("SFTP", "Assertion Practice"), "Export failed.");


        //Delete Segement

        navigation.view();
        waitThreeSeconds();
        view.selectViewableSegment("Assertion Practice");
        view.findViewableSegment("Assertion Practice");


        navigation.analyze();
        manager.cloneSegment("Assertion Practice", "Assertion Practice CLONE");
        Assert.assertTrue(manager.verifySegmentPresent("Assertion Practice CLONE"));
        manager.openSegment("Assertion Practice CLONE");
        RG.saveSegment();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

        navigation.analyze();
        manager.deleteSegment("Assertion Practice");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }


    }


}

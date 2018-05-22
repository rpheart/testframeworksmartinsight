package com.smartfocus.test.ui.SmokeTest;

import com.smartfocus.test.ui.Utilities.Scroll;
import com.smartfocus.test.ui.page_objects.Settings;
import com.smartfocus.test.ui.Utilities.UtilityDragger;
import com.smartfocus.test.ui.page_objects.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class C9347exportsFromSegmentDetail extends Base {

    //THIS TEST ONLY COVERS c9347

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



    @BeforeClass
    public void setUp() {

        BrowserBase.startBrowser("chrome", "https://qa-sfui.themessagecloud.com");

        Logins login = new Logins();
        login.loginSidevall();
        Assert.assertTrue(login.loginSuccess(), "Login failed");

        NewSegment custom = new NewSegment();
        custom.newCustom();
        Assert.assertTrue(custom.verifyNewSegmentStartStarted(), "Failed to reach new Custom Segment page");

        RG = PageFactory.initElements(driver, RefineGlobal.class);
        manager = PageFactory.initElements(driver, Analyze.class);
        segmentCharts = PageFactory.initElements(driver, SegmentChartViews.class);
        qoso = PageFactory.initElements(driver, QOSOTemplateConfig.class);
    }

    @AfterTest
    public void quit() {
        tearDown();
    }


    @Test
    public void c9347Test() {

        //CHANGE TITLE AND DESCRIPTION
        RG.openTitle();
        editTitle.newTitle("C9347");
        Assert.assertTrue(RG.verifySegmentTitleChange("C9347"), "Failed to update segment title properly");

        RG.openDescription();
        editDescription.newDescription("New description of segment for C9347");
        Assert.assertTrue(RG.verifySegmentDescriptionChange("New description of segment for C9347"), "Failed to update segment title properly");

        RG.findAddedGroups();
        Assert.assertTrue(RG.groupAdded(1, "Purchase"));

        UtilityDragger.drag(RG.totalSpend(), RG.getDropZone(1));
        amountFilter.inBetween(500, 1000);
        amountFilter.saveFilter();
        Assert.assertTrue(amountFilter.amountFilterSuccess("Total Spend", "between", 500, 1000), "Failed to set amount(s) properly");

        //Save Segment
        scroll.scrollToByElement(RG.getSaveButton());
        RG.saveSegment();
        //Assert.assertTrue(RG.verifySegmentSavedKnownCount("388"), "People count not matching results");
        Assert.assertTrue(RG.verifySegmentSavedUnknownCount(), "People count does not match");


        RG.summaryTab();
        segmentDetail.renderSummaryTab();
        Assert.assertTrue(segmentDetail.verifySummaryRendered(), "Summary graphics did not render.");

        //Segment detail exports

        RG.exportToDownload();
        waitOneSecond();
        RG.exportToEmail();
        waitOneSecond();
        RG.exportToSFTP();
        waitOneSecond();


        navigation.analyze();

        Assert.assertTrue(manager.verifySegmentExportSuccess("Email", "C9347"), "Export failed.");
        Assert.assertTrue(manager.verifySegmentExportSuccess("SFTP", "C9347"), "Export failed.");
        Assert.assertTrue(manager.verifySegmentExportSuccess("Download", "C9347"), "Export Failed");


        navigation.analyze();
        manager.deleteSegment("C9347");
        Assert.assertTrue(manager.verifySegmentDeleted("C9347"), "Segment not deleted, i.e. still present");

    }


}

package com.smartfocus.test.ui.SmokeTest;

import com.smartfocus.test.ui.Utilities.Scroll;
import com.smartfocus.test.ui.page_objects.Settings;
import com.smartfocus.test.ui.Utilities.UtilityDragger;
import com.smartfocus.test.ui.page_objects.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class C9313SplitSegment extends Base {
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
/*

    @AfterTest
    public void quit() {
        tearDown();
    }
*/

    @Test
    public void C9313Test() {


        //CHANGE TITLE AND DESCRIPTION
        RG.openTitle();
        editTitle.newTitle("C9313");
        Assert.assertTrue(RG.verifySegmentTitleChange("C9313"), "Failed to update segment title properly");

        RG.openDescription();
        editDescription.newDescription("New description of segment for C9313");
        Assert.assertTrue(RG.verifySegmentDescriptionChange("New description of segment for C9313"), "Failed to update segment title properly");

        RG.findAddedGroups();
        Assert.assertTrue(RG.groupAdded(1, "Purchase"));


        UtilityDragger.drag(RG.state(), RG.getDropZone(1));
        lovFilter.toggleLOV(lovFilter.getStateLovList(),"Washington", "California", "Oregon");
        Assert.assertTrue(lovFilter.lovCheckedSuccess("State", "Washington", "California", "Oregon"), "Failed to check lovs properly.");

        scroll.scrollToByElement(RG.getSaveButton());
        RG.saveSegment();
        //Assert.assertTrue(RG.verifySegmentSavedKnownCount("388"), "People count not matching results");
        Assert.assertTrue(RG.verifySegmentSavedUnknownCount(), "People count does not match");


        //View Summary and Calculation Options

        RG.summaryTab();
        segmentDetail.renderSummaryTab();
        Assert.assertTrue(segmentDetail.verifySummaryRendered(), "Summary graphics did not render.");


        navigation.analyze();
        Assert.assertTrue(manager.verifySegmentPresent("C9313"), "segment not shown in list of segments");
        manager.splitSegmentTwo("C9313", 50,50);
        Assert.assertTrue(manager.verifySegmentPresent("C9313 - Split 1"));
        waitOneSecond();
        Assert.assertTrue(manager.verifySegmentPresent("C9313 - Split 2"));

        manager.openSegment("C9313 - Split 1");
        Assert.assertTrue(RG.verifySegmentSavedUnknownCount(), "People count does not match");
        RG.summaryTab();
        segmentDetail.renderSummaryTab();
        Assert.assertTrue(segmentDetail.verifySummaryRendered(), "Summary graphics did not render.");

        navigation.analyze();
        manager.deleteSegment("C9313 - Split 1");
        Assert.assertTrue(manager.verifySegmentDeleted("C9313 - Split 1"), "Segment not deleted, i.e. still present");
        waitOneSecond();
        manager.deleteSegment("C9313 - Split 2");
        Assert.assertTrue(manager.verifySegmentDeleted("C9313 - Split 2"), "Segment not deleted, i.e. still present");
        waitOneSecond();
        manager.deleteSegment("C9313");
        Assert.assertTrue(manager.verifySegmentDeleted("C9313"), "Segment not deleted, i.e. still present");


    }


}

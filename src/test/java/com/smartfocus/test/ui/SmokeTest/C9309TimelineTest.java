package com.smartfocus.test.ui.SmokeTest;

import com.smartfocus.test.ui.page_objects.*;
import com.smartfocus.test.ui.Utilities.UtilityDragger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class C9309TimelineTest extends Base {

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
        custom.newTimeline();
        RG = PageFactory.initElements(driver, RefineGlobal.class);
        manager = PageFactory.initElements(driver, Analyze.class);
        segmentCharts = PageFactory.initElements(driver, SegmentChartViews.class);
        qoso = PageFactory.initElements(driver, QOSOTemplateConfig.class);
    }

    @Test
    public void C9309timelineTest() {

        //CHANGE TITLE AND DESCRIPTION
        RG.openTitle();
        editTitle.newTitle("C9309");
        Assert.assertTrue(RG.verifySegmentTitleChange("C9309"), "Failed to update segment title properly");

        RG.openDescription();
        editDescription.newDescription("New description of C9309");
        Assert.assertTrue(RG.verifySegmentDescriptionChange("New description of C9309"), "Failed to update segment title properly");


        RG.findAddedGroups();
        Assert.assertTrue(RG.groupAdded(1, "Purchase"));


        UtilityDragger.drag(RG.totalSpend(), RG.getDropZone(1));
        amountFilter.inBetween(25, 500);
        amountFilter.saveFilter();
        Assert.assertTrue(amountFilter.amountFilterSuccess("Total Spend", "between", 25, 500), "Failed to set amount(s) properly");

        //Save Segment
        RG.saveTimelineSegment();
        //Assert.assertTrue(RG.verifySegmentSavedKnownCount("388"), "People count not matching results");
        Assert.assertTrue(RG.verifySegmentSavedUnknownCount(), "People count does not match");




    }


}

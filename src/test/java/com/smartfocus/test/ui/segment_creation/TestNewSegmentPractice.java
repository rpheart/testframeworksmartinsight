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
    public void setUp() {

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

        RG.toggleRFM();


        //SAVE SEGMENT

        RG.saveSegment();

        RG.summaryTab();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

        RG.ageAndGenderCalcTab();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }


        RG.totalSpendCalcTab();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

        RG.segmentRFMCalctab();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }

        RG.summaryCalcTab();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException exception) {

        }
        navigation.analyze();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {
        }

        //DELETE SEGMENT

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

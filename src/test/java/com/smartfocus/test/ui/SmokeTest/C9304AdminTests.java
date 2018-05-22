package com.smartfocus.test.ui.SmokeTest;

import com.smartfocus.test.ui.Utilities.Scroll;
import com.smartfocus.test.ui.page_objects.Settings;
import com.smartfocus.test.ui.page_objects.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class C9304AdminTests extends Base {


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
    AdminPage admin = new AdminPage();


    @BeforeClass
    public void setUp() {

        BrowserBase.startBrowser("chrome", "https://qa-sfui.themessagecloud.com");

        Logins login = new Logins();
        login.loginSidevall();
        Assert.assertTrue(login.loginSuccess(), "Login failed");


        RG = PageFactory.initElements(driver, RefineGlobal.class);
        manager = PageFactory.initElements(driver, Analyze.class);
        segmentCharts = PageFactory.initElements(driver, SegmentChartViews.class);
        qoso = PageFactory.initElements(driver, QOSOTemplateConfig.class);
    }

/*    @AfterTest
    public void quit() {
        tearDown();
    }*/

    @Test
    public void c9304Test() {

        navigation.siAdmin();


        admin.switchAdminIFrame();
        waitThreeSeconds();

        //Data page assertions
        Assert.assertTrue(admin.verifyTablesPageRendered(), "Tables tab/page did not render properly.");
        Assert.assertTrue(admin.verifyLoadRulesPageRendered(), "Load Rules tab/page did not render properly");
        Assert.assertTrue(admin.verifyAllFiltersPageRendered(), "All filters tab/page did not render properly");

        //Systems page assertions
        Assert.assertTrue(admin.verifySiteMaintenancePage(), "Site Settings tab/page did not render properly");
        Assert.assertTrue(admin.verifySiteSettingsPage(), "Site maintenance tab/page did not render properly");
        Assert.assertTrue(admin.verifystringcustomizationPage(), "String Customization tab/page did not render properly");

    }

}

package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdminPage extends Base {

    By iFrameBy = By.xpath(("//body[@class='modal-open']/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div/iframe"));

    By modal = By.xpath("//*[@class='modal-open']");



    public void iFrame() {
        int frameIndex = 0;
        List<WebElement> listFrames = driver.findElements(By.tagName("iframe"));
        System.out.print("list frames " + listFrames.size());
        driver.switchTo().frame(listFrames.get(frameIndex));
    }



    public void switchAdminIFrame() {
        waitThreeSeconds();
        waitThreeSeconds();

        isDisplayedBy(modal, 45);
        click(modal);
        waitThreeSeconds();
        waitThreeSeconds();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrameBy));

        isDisplayedBy(modal, 45);
        click(modal);

/*        WebElement foundFrame = find(iFrameBy);
        driver.switchTo().frame(foundFrame);*/
    }

    public void exitIFrame() {
        driver.switchTo().defaultContent();
    }


    public By getModal() {
        return modal;
    }

    By dataPage = By.xpath("//li[@id='nav-data']");
    By systemPage = By.cssSelector("//li[@id='nav-system']");

/*    public void getHomeAdminPage() {
        int i = 0;
        while (isDisplayedBy(modal, 20) != false) {
            if ( i == 5 ) {
                break;
            }
            i++;
            waitThreeSeconds();
            ();
        }
        find(modal);
    }*/


    By tablesPage = By.xpath("//a[@class='navSliderItemFirst navSliderItem selected' or @class='navSliderItemFirst navSliderItem selected']/div[@class='underline' and contains (text(), 'Tables')]");
    By tablesButton = By.xpath("//div[@class='table-load-status']/input[@id='submitFormButton']");


    public boolean verifyTablesPageRendered() {
        isDisplayedBy(dataPage, 15);
        click(dataPage);
        isDisplayedBy(tablesPage, 10);
        click(tablesPage);
        if ( isDisplayedBy(tablesButton, 180) ) {
            return true;
        }
        return false;
    }

    By loadRulePage = By.xpath("//a[@class='navSliderItem selected' or @class='navSliderItemFirst selected']/div[@class='underline' and contains (text(), 'Load Rules')]");
    By loadRulesGridTable = By.xpath("//div[@class='load-rule-grid slickgrid_801756 ui-widget']");

    public boolean verifyLoadRulesPageRendered() {
        isDisplayedBy(dataPage, 30);
        click(dataPage);
        isDisplayedBy(loadRulePage, 10);
        click(loadRulePage);
        if ( isDisplayedBy(loadRulesGridTable, 180) ) {
            return true;
        }
        return false;
    }

    By allFiltersPage = By.xpath("//a[@class='navSliderItem selected' or @class='navSliderItem selected']/div[@class='underline' and contains (text(), 'All Filters')]");
    By allFiltersGridTable = By.xpath("//div[@class='filter-tables-grid slickgrid_171160 ui-widget']");

    public boolean verifyAllFiltersPageRendered() {
        isDisplayedBy(dataPage, 30);
        click(dataPage);
        isDisplayedBy(allFiltersPage, 10);
        click(allFiltersPage);
        if ( isDisplayedBy(allFiltersGridTable, 180) ) {
            return true;
        }
        return false;
    }


    By siteMaintenancePage = By.xpath("//a[@class='navSliderItemFirst navSliderItem]/div[@class='underline' and contains (text(), 'Site Maintenance')]");
    By postLoadGearIcon = By.xpath("//i[@class='pull-left post-load-button']");

    public boolean verifySiteMaintenancePage() {
        isDisplayedBy(systemPage, 30);
        click(systemPage);
        isDisplayedBy(siteMaintenancePage, 10);
        click(siteMaintenancePage);
        if ( isDisplayedBy(postLoadGearIcon, 180) ) {
            return true;
        }
        return false;
    }

    By siteSettingsPage = By.xpath("//a[@class='navSliderItem]/div[@class='underline' and contains (text(), 'Site Maintenance')]");
    By siteSettingsHeader = By.xpath("//div[@class='slider-heading' and contains(text(), 'Site Settings')]");

    public boolean verifySiteSettingsPage() {
        isDisplayedBy(systemPage, 30);
        click(systemPage);
        isDisplayedBy(siteSettingsPage, 10);
        click(siteSettingsPage);
        if ( isDisplayedBy(siteSettingsHeader, 180) ) {
            return true;
        }
        return false;
    }


    By stringCustomizationPage = By.xpath("//a[@class='navSliderItem]/div[@class='underline' and contains (text(), 'String Customization')]");
    By stringCustomizationHeader = By.xpath("//div[@class='slider-heading' and contains(text(), 'String Customization')]");

    public boolean verifystringcustomizationPage() {
        isDisplayedBy(systemPage, 30);
        click(systemPage);
        isDisplayedBy(stringCustomizationPage, 10);
        click(stringCustomizationPage);
        if ( isDisplayedBy(stringCustomizationHeader, 180) ) {
            return true;
        }
        return false;
    }

}

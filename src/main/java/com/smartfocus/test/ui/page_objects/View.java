package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.testng.FileAssert.fail;

public class View extends Base {


    By viewHome = By.cssSelector(".pageTabTopBarControls");




    public boolean verifyViewTab() {
        String viewHomeText = find(viewHome).getText();
        if ( viewHomeText.equalsIgnoreCase("Analysis & Segments") ) {
            return true;
        }
        return false;
    }

    By dashboardConfigButton = By.cssSelector(".SFUI_subnav_menu_right");
    By dashboardSearchTextBox = By.xpath("//div[@class='innerSearchContainer']/input");
    String segmentCheckboxTemplate = "//div[@class='pslsLineItemTitle ellipsis' and contains(text(), 'segmentName')]/../div[1]";

    //Viewable implies that the segment is in the subnavigation bar. It becomes viewable by toggling it on from the dashboard configuration dropdown menu.
    public void selectViewableSegment(String segmentName) {
        isDisplayedBy(dashboardConfigButton, 10);
        click(dashboardConfigButton);
        isDisplayedBy(dashboardSearchTextBox, 5);
        click(dashboardSearchTextBox);
        find(dashboardSearchTextBox).clear();
        find(dashboardSearchTextBox).sendKeys(segmentName);
        find(dashboardSearchTextBox).sendKeys(Keys.ENTER);

        waitThreeSeconds();

        String pattern = segmentCheckboxTemplate.replace("segmentName", segmentName);
        By location = By.xpath(pattern);
        WebElement checkBox = find(location);
        isDisplayed(checkBox, 10);
        checkBox.click();
        click(dashboardConfigButton);
    }


    By toggleSubNavLeftButton = By.xpath("//i[@class='SFUI_subnav_arrow_left canScroll']");

    By toggleSubNavRightButton = By.xpath("//div[@class='rightArrowPill']/i[@class='SFUI_subnav_arrow_right canScroll']");

    String segmentPillsTemplate = "//div[@class='subnavPill' or @class='subnavPill ui-sortable-handle']//*[contains(text(), 'segmentName')]/..";


    public void findViewableSegment(String segmentName) {
        String pattern = segmentPillsTemplate.replace("segmentName", segmentName);
        By segmentNamePill = By.xpath(pattern);
        WebElement segmentPill = find(segmentNamePill);
        waitThreeSeconds();

        try{
            WebElement toggleLeft = ExpectedConditions.visibilityOfElementLocated(toggleSubNavLeftButton).apply(driver);
            while (toggleLeft != null) {
                click(toggleSubNavLeftButton);
                toggleLeft = ExpectedConditions.visibilityOfElementLocated(toggleSubNavLeftButton).apply(driver);
            }
        }
            catch (Exception e) {
            //ignoring exception
            }

            WebElement toggleRight = ExpectedConditions.visibilityOfElementLocated(toggleSubNavRightButton).apply(driver);
            try {
            while (toggleRight != null) {
                click(toggleSubNavRightButton);


                toggleRight = ExpectedConditions.visibilityOfElementLocated(toggleSubNavRightButton).apply(driver);
            }
        }
        catch (Exception e) {
            // ignoring exception
        }

        isDisplayedBy(segmentNamePill, 10);
        click(segmentNamePill);

    }
}


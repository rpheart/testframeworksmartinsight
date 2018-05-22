package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SegmentDetail extends Base {

    By summaryTab = By.cssSelector(".mainSummaryTab");


    public void renderSegmentDetailSummary() {
        isDisplayedBy(summaryTab, 5);
        click(summaryTab);
    }
    //SUMMARY CALCULATION TAB CONTROLS
    By summaryCalculationsTab = By.xpath("//div[@class='underline' and contains (text(), 'Summary')]");
    By ageAndGenderCalculationsTab = By.xpath("//div[@class='underline' and contains (text(), 'Age & Gender')]");
    By totalSpendCalculationsTab = By.xpath("//div[@class='underline' and contains (text(), 'Total Spend by Product')]");
    By rfmCalculationsTab = By.xpath("//div[@class='underline' and contains (text(), 'Segment RFM')]");


    By summaryChartTab = By.xpath("//div[@class='navSlider']//*[contains(text(), \"Summary\")]");
    By summaryGraphic = By.xpath("//div[@class='refineSummaryDetail active item' or @class='refineSummaryDetail item' or @class='refineSummaryDetail item active']/div[1]/div[1]/div[1]/div[2]");

    public void renderSummaryTab() {
        isDisplayedBy(summaryChartTab, 10);
        click(summaryChartTab);
    }

    public boolean verifySummaryRendered() {
        if ( isDisplayedBy(summaryGraphic, 180) ) {
            return true;
        }
        return false;
    }

    // AGE & GENDER AGE & GENDER AGE & GENDER AGE & GENDER AGE & GENDER AGE & GENDER AGE & GENDER AGE & GENDER AGE & GENDER

    By ageAndGenderChartTab = By.xpath("//div[@class='navSlider']//*[contains(text(), \"Age & Gender\")]");
    By ageAndGenderChart = By.xpath("//div[@class='item refineSummaryGender active']/div[1]/div[1]/div[2]");

    public void renderAgeAndGender() {
        isDisplayedBy(ageAndGenderChartTab, 10);
        click(ageAndGenderChartTab);
    }

    public boolean verifyAgeAndGenderRendered() {
        if ( isDisplayedBy(ageAndGenderChart, 500) ) {
            return true;
        }
        return false;
    }


    // TOTAL SPEND TOTAL SPEND TOTAL SPEND TOTAL SPEND TOTAL SPEND TOTAL SPEND TOTAL SPEND TOTAL SPEND TOTAL SPEND TOTAL SPEND

    By totalSpendChartTab = By.xpath("//div[@class='navSlider']//*[contains(text(), \"Total Spend by Product\")]");
    By totalSpendChart = By.xpath("//div[@class='totalSpendChartSection']/div[3]/div[1]");

    public void renderTotalSpend() {
        isDisplayedBy(totalSpendChartTab, 10);
        click(totalSpendChartTab);
    }

    public boolean verifyTotalSpendRendered() {
        if ( isDisplayedBy(totalSpendChart, 300)) {
            return true;
        }
        return false;
    }


    //starting point for all RFM (segment detail, widget, view) = class  is rfm-viewport

    By segmentRFMChartTab = By.xpath("//div[@class='navSlider']//*[contains(text(), \"Segment RFM\")]");
    By rfmChart = By.xpath("//div[@class='topCustomersHero hero']/div[1]/i"); //This is only the human figure icon, so as to avoid a use case where people count is 0 and no scorecards available.

    public void renderRFM() {
        isDisplayedBy(segmentRFMChartTab, 10);
        click(segmentRFMChartTab);
    }

    public boolean verifyRfmRendered() {
        isDisplayedBy(segmentRFMChartTab, 10);
        ensureFirstScorecardVisible();
        if (isDisplayedBy(rfmChart, 300) ) {
            return true;
        }
        return false;
    }


    By toggleRightButton = By.xpath("//div[@class='pull-left storyCardButton']/i[@class='nextArrow']");
    By toggleLeftButton = By.xpath("//div[@class='pull-left storyCardButton']/i[@class='previousArrow']");


    public void toggleScorecardsRight() {
        isDisplayedBy(toggleRightButton, 10);
        click(toggleRightButton);
    }

    public void toggleScorecardsLeft() {
        isDisplayedBy(toggleLeftButton, 5);
        click(toggleLeftButton);
    }

    public void ensureFirstScorecardVisible() {
            while ((ExpectedConditions.visibilityOfElementLocated(toggleLeftButton)).equals(true)) {
                click(toggleLeftButton);
            }
    }


    public void exportToSFTP() {

    }





    //only works for segment detail page, not made for View or RFM widget.
    public void compareRfmCountsToPeopleCount(String peopleCount, String totalRFMCount) {

    }








}

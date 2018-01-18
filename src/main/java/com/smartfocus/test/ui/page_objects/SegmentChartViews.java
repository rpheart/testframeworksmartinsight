package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SegmentChartViews extends Base {


    //SUMMARY CONTROLS

    //AGE AND GENDER CONTROLS

    //TOTAL SPEND BY PRODUCT CONTROLS

    By totalSpendDropdown = By.cssSelector(".btn.dropdown-toggle.btn-link-style.chart-view-dropdown");
    By allDepartments = By.xpath("//a[@class='chartViewAction' and contains(text(), ' All Departments ')]");
    By allCategories = By.xpath("//a[@class='chartViewAction' and contains(text(), ' All Categories ')]");
    By allSubCategories = By.xpath("//a[@class='chartViewAction' and contains(text(), ' All Subcategories ')]");
    By allBrands = By.xpath("//a[@class='chartViewAction' and contains(text(), ' All Brands ')]");

    By totalSpendChartGrid = By.cssSelector(".axisBaseLine.bottom");



    //By summaryCalculationsTab = By.xpath("//div[@class='underline' and contains (text(), 'Summary')]");

    //SEGMENT RMF CONTROLS

    By rfmScorecardGrid = By.cssSelector(".rfm-carousel-container");

    By rfmExploreButton = By.cssSelector(".rfm-explore-button");


    //SUMMARY METHODS



    // AGE AND GENDER CONTROLS




    //TOTAL SPEND BY PRODUCT METHODS

    public void deptView() {
        isDisplayedBy(totalSpendDropdown, 5);
        click(totalSpendDropdown);
        isDisplayedBy(allDepartments, 5);
        click(allDepartments);
        isDisplayedBy(totalSpendChartGrid, 1000);
    }

    public void categoryView() {
        isDisplayedBy(totalSpendDropdown, 5);
        click(totalSpendDropdown);
        isDisplayedBy(allCategories, 5);
        click(allCategories);
        isDisplayedBy(totalSpendChartGrid, 1000);
    }

    public void subCategoryView() {
        isDisplayedBy(totalSpendDropdown, 5);
        click(totalSpendDropdown);
        isDisplayedBy(allSubCategories, 5);
        click(allSubCategories);
        isDisplayedBy(totalSpendChartGrid, 1000);
    }

    public void brandView() {
        isDisplayedBy(totalSpendDropdown, 5);
        click(totalSpendDropdown);
        isDisplayedBy(allBrands, 5);
        click(allBrands);
        isDisplayedBy(totalSpendChartGrid, 1000);
    }


    String dataBarPattern = "//*[@class='axis  xAxis']/div[2]/div[2]/div[z]/div[3]/div/div[3]";

    public List<WebElement> genericDataBar(String... positions) {
        List<WebElement> dataBars = new ArrayList<>();
        isDisplayedBy(totalSpendChartGrid, 5);
        for (String position : positions) {
            String pattern = dataBarPattern.replace("z", position);
            By location = By.xpath(pattern);
            WebElement filterCheck = find(location);
            dataBars.add(filterCheck);
        }
        return dataBars;
    }



    //SEGMENT RMF METHODS

    String rfmCheckboxPattern = "//div[@class='sfui-carousel']/div[z]/div[1]/i";

    public List<WebElement> genericScorecard(String... positions) {
        List<WebElement> scorecards = new ArrayList<>();
        isDisplayedBy(rfmScorecardGrid, 5);
        for (String position : positions) {
            String pattern = rfmCheckboxPattern.replace("z", position);
            By location = By.xpath(pattern);
            WebElement scorecardCheck = find(location);
            scorecards.add(scorecardCheck);
        }
        return scorecards;
    }

    public void rfmExplore() {
        isDisplayedBy(rfmExploreButton, 5);
        click(rfmExploreButton);
    }



}

package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class LOVFilterConfig extends Base {

    By modal = By.cssSelector(".grid-canvas");
    By saveFilterButton = By.cssSelector(".btn.saveBtn.modalFilterSave");
    By cancelFilterButton = By.cssSelector(".btn.cancelBtn.modalFilterCancel");
    By includeToggle = By.xpath("//*[@id='modalFilterContents']//*[@class='btn btnInclude']");
    By excludeToggle = By.xpath("//*[@id='modalFilterContents']//*[@class='btn btnExclude']");
    By lovList = By.xpath("//div[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    By filterSearchBox = By.xpath("//div[@id='modalFilterContents']//*[@class='form-control search-query textSelectable']");
    By selectAllButton = By.xpath("//div[@id='modalFilterContents']//*[@class='selectAll']");
    By unselectAllButton = By.xpath("//div[@id='modalFilterContents']//*[@class='unselectAll']");


    String lovPattern = "//div[@class='ui-widget-content slick-row even' or @class='ui-widget-content slick-row odd']//*[contains(text(), \"lovValue\")]/../div[1]/i";
    String lovName = "//div[@class='ui-widget-content slick-row even' or @class='ui-widget-content slick-row odd']//*[contains(text(), \"lovValue\")]";


    List<String> lovs = new ArrayList<>();

    public List<WebElement> getCheckBoxes() {
        return checkBoxes;
    }

    public List<String> getLovs() {
        return lovs;
    }

    public void searchLOV(String... labels) {

    }


    public void toggleLOV(String... labels) {
        isDisplayedBy(lovList, 5);

        for (String label : labels) {
            String pattern = lovPattern.replace("lovValue", label);
            By location = By.xpath(pattern);

            String namePattern = lovName.replace("lovValue", label);

            isDisplayedBy(filterSearchBox, 5);
            click(filterSearchBox);
            find(filterSearchBox).clear();
            find(filterSearchBox).sendKeys(label);

            WebElement filterCheck = find(location);
            checkBoxes.add(filterCheck);
            filterCheck.click();


            By relativeLocation = By.xpath(namePattern);
            filterCheck = find(relativeLocation);

            String lovTitle = filterCheck.getText();

            lovs.add(lovTitle);
            System.out.println(lovTitle);

        }
    }



    public void selectAll() {
        isDisplayedBy(lovList, 5);
        click(selectAllButton);
    }

    public void unselectAll() {
        isDisplayedBy(lovList, 5);
        click(unselectAllButton);
    }


    public void saveFilter() {
        isDisplayedBy(saveFilterButton, 5);
        click(saveFilterButton);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exception) {

        }
    }

    public void cancelFilter() {
        isDisplayedBy(cancelFilterButton, 5);
        click(cancelFilterButton);
    }

    public void include() {
        isDisplayedBy(includeToggle, 5);
        click(includeToggle);
    }

    WebElement includeChecked;

    public boolean lovsIncluded() {
        includeChecked = driver.findElement(By.xpath("//div[@class='modal-title available-filter']/../../div[3]/div[1]/div[2]/div[1]/label[@class='btn btnInclude active']"));
        if ( isDisplayed(excludeChecked, 5) ) {
            return true;
        }
        return false;
    }

    public void exclude() {
        isDisplayedBy(excludeToggle, 5);
        click(excludeToggle);
    }

    WebElement excludeChecked;

    public boolean lovsExcluded() {
        excludeChecked = driver.findElement(By.xpath("//div[@class='modal-title available-filter']/../../div[3]/div[1]/div[2]/div[1]/label[@class='btn btnExclude active']"));
        if ( isDisplayed(excludeChecked, 5) ) {
            return true;
        }
        return false;
    }


    String appliedLovFilterTemplate = "//div[@class='applied_filter_items']//*[contains(text(), \"filterName\")]/../..";
    String lovCheckedPattern = "//div[@class='ui-widget-content slick-row even' or @class='ui-widget-content slick-row odd']//*[contains(text(), \"lovValue\")]/../div[1]/i[@class = 'insightsCheckBox topOffsetSevenPx checked']";
    String lovNotCheckedPattern = "//div[@class='ui-widget-content slick-row even' or @class='ui-widget-content slick-row odd']//*[contains(text(), \"lovValue\")]/../div[1]/i[@class = 'insightsCheckBox topOffsetSevenPx']";

    List<WebElement> checkBoxes = new ArrayList<>();

    public boolean lovCheckedSuccess (String filter, String... labels) {
        String appliedFilterPattern = appliedLovFilterTemplate.replace("filterName", filter);
        By theAppliedFilter = By.xpath(appliedFilterPattern);
        WebElement appliedFilter = find(theAppliedFilter);
        doubleClick(appliedFilter);
        isDisplayedBy(filterSearchBox, 5);

        for (String label : labels) {
            String pattern = lovCheckedPattern.replace("lovValue", label);
            By location = By.xpath(pattern);

            isDisplayedBy(filterSearchBox, 5);
            click(filterSearchBox);
            find(filterSearchBox).clear();
            find(filterSearchBox).sendKeys(label);

            WebElement filterCheck = find(location);
            checkBoxes.add(filterCheck);
            filterCheck.getText();

            if ( !filterCheck.isDisplayed() ) {
                return false;
            }
        }
        saveFilter();
        return true;
    }

    public boolean lovNotCheckedSuccess (String filter, String... labels) {
        String appliedFilterPattern = appliedLovFilterTemplate.replace("filterName", filter);
        By theappliedFilter = By.xpath(appliedFilterPattern);
        WebElement appliedFilter = find(theappliedFilter);
        doubleClick(appliedFilter);
        isDisplayedBy(filterSearchBox, 5);

        for (String label : labels) {
            String pattern = lovNotCheckedPattern.replace("lovValue", label);
            By location = By.xpath(pattern);

            isDisplayedBy(filterSearchBox, 5);
            click(filterSearchBox);
            find(filterSearchBox).clear();
            find(filterSearchBox).sendKeys(label);

            WebElement filterCheck = find(location);
            checkBoxes.add(filterCheck);
            filterCheck.getText();

            if ( !filterCheck.isDisplayed() ) {
                return false;
            }
        }
        saveFilter();
        return true;
    }






}

/*

        SCROLL to bottom


            @FindBy(xpath = "//div[@class='slick-viewport']")
    public WebElement scrollDIV;

    public WebElement scrollContainer() {
        isDisplayed(scrollDIV, 5);
        return scrollDIV;
    }

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[1];", driver.findElement(By.className("slick-viewport")), 10000);
*/

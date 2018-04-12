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

    String lovList = "//div[@class='modal-title available-filter' and contains(text(), \"filterName\")]/../..//*[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']";

    By campaignNameLovList = By.xpath("//div[@class='modal-title available-filter' and contains(text(), 'Campaign Name')]/../..//*[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    public WebElement getCampaignNameLovList() {
        isDisplayedBy(campaignNameLovList, 10);
        return find(campaignNameLovList);
    }

    By marketingEventEmailLovList = By.xpath("//div[@class='modal-title available-filter' and contains(text(), 'Marketing Event Email')]/../..//*[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    public WebElement getMarketingEventEmailLovList() {
        isDisplayedBy(marketingEventEmailLovList, 10);
        return find(marketingEventEmailLovList);
    }

    By eventTypeLovList = By.xpath("//div[@class='modal-title available-filter' and contains(text(), 'Event Type')]/../..//*[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    public WebElement getEventTypeLovList() {
        isDisplayedBy(eventTypeLovList, 10);
        return find(eventTypeLovList);
    }

    By reportedCampaignLovList = By.xpath("//div[@class='modal-title available-filter' and contains(text(), 'Reported Campaign')]/../..//*[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    public WebElement getReportedCampaignLovList() {
        isDisplayedBy(reportedCampaignLovList, 10);
        return find(reportedCampaignLovList);
    }

    By ageRangeLovList = By.xpath("//div[@class='modal-title available-filter' and contains(text(), 'Age Range')]/../..//*[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    public WebElement getAgeRangeLovList() {
        isDisplayedBy(ageRangeLovList, 10);
        return find(ageRangeLovList);
    }

    By cityLovList = By.xpath("//div[@class='modal-title available-filter' and contains(text(), 'City')]/../..//*[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    public WebElement getCityLovList() {
        isDisplayedBy(cityLovList, 10);
        return find(cityLovList);
    }

    By countryLovList = By.xpath("//div[@class='modal-title available-filter' and contains(text(), 'Country')]/../..//*[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    public WebElement getCountryLovList() {
        isDisplayedBy(countryLovList, 10);
        return find(countryLovList);
    }

    By genderLovList = By.xpath("//div[@class='modal-title available-filter' and contains(text(), 'Gender')]/../..//*[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    public WebElement getGenderLovList() {
        isDisplayedBy(genderLovList, 10);
        return find(genderLovList);
    }

    By peopleLoyaltyLovList = By.xpath("//div[@class='modal-title available-filter' and contains(text(), 'People Loyalty')]/../..//*[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    public WebElement getPeopleLoyaltyLovList() {
        isDisplayedBy(peopleLoyaltyLovList, 10);
        return find(peopleLoyaltyLovList);
    }

    By stateLovList = By.xpath( "//div[@class='modal-title available-filter' and contains(text(), 'State')]/../..//*[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    public WebElement getStateLovList() {
        isDisplayedBy(stateLovList, 10);
        return find(stateLovList);
    }

    By customSegmentsLovList = By.xpath("//div[@class='modal-title available-filter' and contains(text(), 'Custom Segments')]/../..//*[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    public WebElement getCustomSegmentsLovList() {
        isDisplayedBy(customSegmentsLovList, 10);
        return find(customSegmentsLovList);
    }

    By salesChannelLovList = By.xpath("//div[@class='modal-title available-filter' and contains(text(), 'Channel')]/../..//*[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    public WebElement getSalesChannelLovList() {
        isDisplayedBy(salesChannelLovList, 10);
        return find(salesChannelLovList);
    }

    By storeNameLovList = By.xpath("//div[@class='modal-title available-filter' and contains(text(), 'Store Name')]/../..//*[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    public WebElement getStoreNameLovList() {
        isDisplayedBy(storeNameLovList, 10);
        return find(storeNameLovList);
    }

    By storeCityLovList = By.xpath("//div[@class='modal-title available-filter' and contains(text(), 'Store: City')]/../..//*[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    public WebElement getStoreCityLovList() {
        isDisplayedBy(storeCityLovList, 10);
        return find(storeCityLovList);
    }

    By storeCountryLovList = By.xpath("//div[@class='modal-title available-filter' and contains(text(), 'Store: Country')]/../..//*[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    public WebElement getStoreCountryLovList() {
        isDisplayedBy(storeCountryLovList, 10);
        return find(storeCountryLovList);
    }

    By storeZipCodeLovList = By.xpath("//div[@class='modal-title available-filter' and contains(text(), 'Store: Zip Code')]/../..//*[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    public WebElement getStoreZipCodeLovList() {
        isDisplayedBy(storeZipCodeLovList, 10);
        return find(storeZipCodeLovList);
    }

    By storeRegionLovList = By.xpath("//div[@class='modal-title available-filter' and contains(text(), 'Store: Region')]/../..//*[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    public WebElement getStoreRegionLovList() {
        isDisplayedBy(storeRegionLovList, 10);
        return find(storeRegionLovList);
    }

    By storeStateLovList = By.xpath("//div[@class='modal-title available-filter' and contains(text(), 'Store: State')]/../..//*[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    public WebElement getStoreStateLovList() {
        isDisplayedBy(marketingEventEmailLovList, 10);
        return find(storeStateLovList);
    }

    By brandLovList = By.xpath("//div[@class='modal-title available-filter' and contains(text(), 'Brand')]/../..//*[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    public WebElement getBrandLovList() {
        isDisplayedBy(brandLovList, 10);
        return find(brandLovList);
    }

    By categoryLovList = By.xpath("//div[@class='modal-title available-filter' and contains(text(), 'Purchase: Category')]/../..//*[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    public WebElement getCategoryLovList() {
        isDisplayedBy(categoryLovList, 10);
        return find(categoryLovList);
    }

    By departmentLovList = By.xpath("//div[@class='modal-title available-filter' and contains(text(), 'Purchase: Department')]/../..//*[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    public WebElement getDepartmentLovList() {
        isDisplayedBy(departmentLovList, 10);
        return find(departmentLovList);
    }

    By vendorNameLovList = By.xpath("//div[@class='modal-title available-filter' and contains(text(), 'Purchase: Vendor Name')]/../..//*[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
     public WebElement getVendorNameLovList() {
         isDisplayedBy(vendorNameLovList, 10);
        return find(vendorNameLovList);
    }


    public void toggleLOV(WebElement filterName, String... labels) {

        isDisplayed(filterName, 30);

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


    public void selectAll(String filterName) {
        By lovListElement = By.xpath(lovList.replace("filterName", filterName));
        isDisplayedBy(lovListElement, 30);
        click(selectAllButton);
    }

    public void unselectAll(String filterName) {
        By lovListElement = By.xpath(lovList.replace("filterName", filterName));
        isDisplayedBy(lovListElement, 30);
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

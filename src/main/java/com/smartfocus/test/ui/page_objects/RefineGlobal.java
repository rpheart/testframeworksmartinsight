package com.smartfocus.test.ui.page_objects;

import com.sun.javafx.css.CalculatedValue;
import com.sun.org.apache.xpath.internal.res.XPATHErrorResources;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;



public class RefineGlobal extends Base {

    // Add filter group dropdown elements
    By AddGroup = By.cssSelector(".create-time-period-text");
    By AddPurchaseGroup = By.cssSelector("#create_grouping_SalesTransaction");
    By AddCampaignGroup = By.cssSelector("#create_grouping_CampaignTransaction");
    By AddPeopleGroup = By.cssSelector("#create_grouping_Customer");
    By editTitle = By.cssSelector(".refineSegmentTitle.textSelectable.ellipsis.text-selectable");
    By editDescription = By.cssSelector(".refineSegmentDescription.textSelectable.ellipsis.text-selectable");

    By notCalculated = By.cssSelector("//div[@class='cust-count-span' and contains(text(), ' Not Yet Calculated')]");
    By updatingCount = By.cssSelector(".progress.progress-striped.active");
    By countComplete = By.cssSelector((".cust-count-span"));

    //save button and its dropdown elements
    By saveButton = By.cssSelector(".btn.save-update");
    By saveDropdownButton = By.cssSelector(".btn.dropdown-toggle.save-update-dropdown");
    By saveFromDropdown = By.cssSelector(".ddm-item-text.menuSaveUpdate");
    By cloneFromDropdown = By.cssSelector(".ddm-item-text.menuCloneUpdate");
    By splitFromDropdown = By.cssSelector(".ddm-item-text.menuSplitSegment");

    By saveTitleButton = By.cssSelector(".btn.okBtn.modalSave");

    //SEGMENT CONFIGURATION TAB CONTROLS
    By summaryTab = By.cssSelector(".mainSummaryTab");
    By refineTab = By.cssSelector(".mainRefineTab");
    By settingsTab = By.cssSelector(".mainSettingsTab");

    //SUMMARY CALCULATION TAB CONTROLS
    By summaryCalculationsTab = By.xpath("//div[@class='underline' and contains (text(), 'Summary')]");
    By ageAndGenderCalculationsTab = By.xpath("//div[@class='underline' and contains (text(), 'Age & Gender')]");
    By totalSpendCalculationsTab = By.xpath("//div[@class='underline' and contains (text(), 'Total Spend by Product')]");
    By rfmCalculationsTab = By.xpath("//div[@class='underline' and contains (text(), 'Segment RFM')]");

    //SETTINGS TOGGLE CONTROLS

    By lockedSegmentToggle = By.xpath("//*[@class='locked-segment']/div/div");
    By workGroupToggle = By.xpath("//*[@class='grouped-segmentation']/div/div");
    By ageAndGenderToggle = By.xpath("//*[@class='generate-demo']/div/div");
    By totalSpendToggle = By.xpath("//*[@class='generate-product']/div/div");
    By rfmToggle = By.xpath("//*[@class='generate-rfm']/div/div");




    //Filter Group list element
    List<WebElement> groups = new ArrayList<>();

    public List<WebElement> getGroups() {
        return groups;
    }

    public WebElement getGroup(int position) {
        return getGroup(position, false);
    }

    public WebElement getGroup(int position, boolean refresh) {
        if ( refresh ) {
            findAddedGroups();
        }
        if ( position > groups.size() ) {
            throw new AssertionError("Invalid index. max indice is " + groups.size());
        }
        return groups.get(position - 1);
    }

    public int findAddedGroups() {
        groups = null;
        groups = driver.findElements(By.xpath("//*[@id='refine']/div/div/div/div[2]/div[2]/div[2]/div[*]/div[2]/div[1]/div/div/div[3]"));
        return groups.size();
    }

    public WebElement getDropZone(int position) {
        WebElement dropZone = groups.get(position-1).findElement(By.xpath("//*[@id='refine']/div/div/div/div[2]/div[2]/div[2]/div[" + position + "]/div[2]/div[1]/ul"));
        return dropZone;
    }


    public String getGroupType(int position) {
        String type = null;
        if ( position > groups.size() ) {
            return null;
        }
        WebElement group = groups.get(position - 1);
        type = group.getText();
        return type;
    }


    //ADD FILTER GROUPS ADD FILTER GROUPS ADD FILTER GROUPS ADD FILTER GROUPS ADD FILTER GROUPS


    public WebElement addPurchaseGroup() {
        isDisplayedBy(AddGroup, 5);
        click(AddGroup);
        isDisplayedBy(AddPurchaseGroup, 5);
        click(AddPurchaseGroup);
        int lastGroup = groups.size();
        WebElement fg = findFilterGroup(lastGroup + 1);
        isDisplayed(fg, 5);
        findAddedGroups();
        return fg;
    }


//ADD FILTERS   ADD FILTERS   ADD FILTERS   ADD FILTERS   ADD FILTERS   ADD FILTERS   ADD FILTERS   ADD FILTERS   ADD FILTERS

    @FindBy(xpath = "//div[@class='available_container_items']//*[contains(text(), 'And/Or Template')]")
    public WebElement templateAndOr;

    public WebElement andOrContainer() {
        isDisplayed(templateAndOr, 5);
        return templateAndOr;
    }


    @FindBy(xpath = "//div[@class='available_container_items']//*[contains(text(), 'Quantity Of/Spend On Template')]")
    public WebElement templateQoso;

    public WebElement qosoContainer() {
        isDisplayed(templateQoso, 5);
        return templateQoso;
    }


    String filterGroupPattern = "//*[@id='refine']/div/div/div/div[2]/div[2]/div[2]/div[i]/div[2]/div[1]/ul";

    public WebElement findFilterGroup(int position) {
        By location = By.xpath(filterGroupPattern.replace("[i]", String.format("%s%d%s", "[", position, "]")));
        groups.add(position - 1, findString(location));
        return groups.get(position - 1);
    }

    String filterGroupAndOrTopPattern = "//*[@id='refine']/div/div/div/div[2]/div[2]/div[2]/div[a]/div[2]/div[1]/ul/li/div[3]/ul[1]";

    public WebElement findTop(int positionA) {
        By location = By.xpath(filterGroupAndOrTopPattern.replace("[a]", String.format("%s%d%s", "[", positionA, "]")));
        groups.add(positionA - 1, findString(location));
        return groups.get(positionA - 1);
    }


    String filterGroupAndOrBottomPattern = "//*[@id='refine']/div/div/div/div[2]/div[2]/div[2]/div[b]/div[2]/div[1]/ul/li/div[3]/ul[2]";

    public WebElement findBottom(int positionB) {
        By location = By.xpath(filterGroupAndOrBottomPattern.replace("[b]", String.format("%s%d%s", "[", positionB, "]")));
        groups.add(positionB - 1, findString(location));
        return groups.get(positionB - 1);
    }


    @FindBy(xpath = "//*[@id='refine']/div/div/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/ul/li/div[3]/ul[1]")
    public WebElement filterGroup1Top;

    public WebElement firstGroupTop() {
        return filterGroup1Top;
    }

    @FindBy(xpath = "//*[@id='refine']/div/div/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/ul/li/div[3]/ul[2]")
    public WebElement FilterGroup1Bottom;

    public WebElement firstGroupBottom() {
        return FilterGroup1Bottom;
    }

    public void clickOr() {
        isDisplayedBy(AddGroup, 5);
        click(AddGroup);
        isDisplayedBy(AddPurchaseGroup, 5);
        click(AddPurchaseGroup);

    }

    public void openTitle() {
        isDisplayedBy(editTitle, 5);
        click(editTitle);
    }

    public void openDescription() {
        isDisplayedBy(editDescription, 5);
        click(editDescription);
    }


    public void summaryTab() {
        isDisplayedBy(summaryTab, 5);
        click(summaryTab);
    }

    public void refineTab() {
        isDisplayedBy(refineTab, 5);
        click(refineTab);
    }

    public void settingsTab() {
        isDisplayedBy(settingsTab, 5);
        click(settingsTab);
    }


    public void summaryChartView() {
        isDisplayedBy(summaryCalculationsTab,5);
        click(summaryCalculationsTab);
    }

    public void ageAndGenderChartView() {
        isDisplayedBy(ageAndGenderCalculationsTab, 5);
        click(ageAndGenderCalculationsTab);
    }

    public void totalSpendChartView() {
        isDisplayedBy(totalSpendCalculationsTab, 5);
        click(totalSpendCalculationsTab);
    }

    public void segmentRFMChartView() {
        isDisplayedBy(rfmCalculationsTab, 5);
        click(rfmCalculationsTab);
    }


    //FILTERS

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Campaign Name')]")
    public WebElement filterCampaignName;

    public WebElement campaignName() {
        isDisplayed(filterCampaignName, 5);
        return filterCampaignName;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Emails Clicked')]")
    public WebElement filterEmailsClicked;

    public WebElement emailsClicked() {
        isDisplayed(filterEmailsClicked, 5);
        return filterEmailsClicked;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Emails Converted')]")
    public WebElement filterEmailsConverted;

    public WebElement emailsConverted() {
        isDisplayed(filterEmailsConverted, 5);
        return filterEmailsConverted;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Emails Opened')]")
    public WebElement filterEmailsOpened;

    public WebElement emailsOpened() {
        isDisplayed(filterEmailsOpened, 5);
        return filterEmailsOpened;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Emails Sent')]")
    public WebElement filterEmailsSent;

    public WebElement emailsSent() {
        isDisplayed(filterEmailsSent, 5);
        return filterEmailsSent;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Event Click Type')]")
    public WebElement filterEmailsClickType;

    public WebElement emailsClickType() {
        isDisplayed(filterEmailsClickType, 5);
        return filterEmailsClickType;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Event Type')]")
    public WebElement filterEventType;

    public WebElement eventType() {
        isDisplayed(filterEventType, 5);
        return filterEventType;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Marketing Event Email')]")
    public WebElement filterMarketingEventEmail;

    public WebElement marketingEventEmail() {
        isDisplayed(filterMarketingEventEmail, 5);
        return filterMarketingEventEmail;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Product Name')]")
    public WebElement filterProductName;

    public WebElement productName() {
        isDisplayed(filterProductName, 5);
        return filterProductName;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Rate: Click-to-Open')]")
    public WebElement filterRateClickToOpen;

    public WebElement rateClickToOpen() {
        isDisplayed(filterRateClickToOpen, 5);
        return filterRateClickToOpen;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Rate: Click-to-Sent')]")
    public WebElement filterRateClickToSent;

    public WebElement rateClickToSent() {
        isDisplayed(filterRateClickToSent, 5);
        return filterRateClickToSent;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Rate: Convert-to-Click')]")
    public WebElement filterRateConvertToClick;

    public WebElement rateConvertToClick() {
        isDisplayed(filterRateConvertToClick, 5);
        return filterRateConvertToClick;
    }


    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Rate: Convert-to-Sent')]")
    public WebElement filterRateConvertToSent;

    public WebElement rateConvertToSent() {
        isDisplayed(filterRateConvertToSent, 5);
        return filterRateConvertToSent;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Rate: Open-to-Sent')]")
    public WebElement filterRateOpenToSent;

    public WebElement rateOpenToSent() {
        isDisplayed(filterRateOpenToSent, 5);
        return filterRateOpenToSent;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Reported Campaign')]")
    public WebElement filterReportedCampaign;

    public WebElement reportedCampaign() {
        isDisplayed(filterReportedCampaign, 5);
        return filterReportedCampaign;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Age Range')]")
    public WebElement filterAgeRange;

    public WebElement ageRange() {
        isDisplayed(filterAgeRange, 5);
        return filterAgeRange;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'City')]")
    public WebElement filterCity;

    public WebElement city() {
        isDisplayed(filterCity, 5);
        return filterCity;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Customer Id')]")
    public WebElement filterCustomerID;

    public WebElement customerID() {
        isDisplayed(filterCustomerID, 5);
        return filterCustomerID;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Gender')]")
    public WebElement filterGender;

    public WebElement gender() {
        isDisplayed(filterGender, 5);
        return filterGender;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'People Loyalty')]")
    public WebElement filterPeopleLoyalty;

    public WebElement peopleLoyalty() {
        isDisplayed(filterPeopleLoyalty, 5);
        return filterPeopleLoyalty;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'State')]")
    public WebElement filterState;

    public WebElement state() {
        isDisplayed(filterState, 5);
        return filterState;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Custom Segments')]")
    public WebElement filterCustomSegments;

    public WebElement customSegments() {
        isDisplayed(filterCustomSegments, 5);
        return filterCustomSegments;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Sales Channel')]")
    public WebElement filterSalesChannel;

    public WebElement salesChannel() {
        isDisplayed(filterSalesChannel, 5);
        return filterSalesChannel;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Store Name')]")
    public WebElement filterStoreName;

    public WebElement storeName() {
        isDisplayed(filterStoreName, 5);
        return filterStoreName;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Store: City')]")
    public WebElement filterStoreCity;

    public WebElement storeCity() {
        isDisplayed(filterStoreCity, 5);
        return filterStoreCity;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Store: Country')]")
    public WebElement filterStoreCountry;

    public WebElement storeCountry() {
        isDisplayed(filterStoreCountry, 5);
        return filterStoreCountry;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Store: District')]")
    public WebElement filterStoreDistrict;

    public WebElement storeDistrict() {
        isDisplayed(filterStoreDistrict, 5);
        return filterStoreDistrict;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Store: District Manager')]")
    public WebElement filterStoreDistrictManager;

    public WebElement storeDistrictManager() {
        isDisplayed(filterStoreDistrictManager, 5);
        return filterStoreDistrictManager;
    }


    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Store: Manager')]")
    public WebElement filterStoreManager;

    public WebElement storeManager() {
        isDisplayed(filterStoreManager, 5);
        return filterStoreManager;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Store: Region')]")
    public WebElement filterStoreRegion;

    public WebElement storeRegion() {
        isDisplayed(filterStoreRegion, 5);
        return filterStoreRegion;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Store: State')]")
    public WebElement filterStoreState;

    public WebElement storeState() {
        isDisplayed(filterStoreState, 5);
        return filterStoreState;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Store: ZIP Code')]")
    public WebElement filterStoreZipCode;

    public WebElement storeZipCode() {
        isDisplayed(filterStoreZipCode, 5);
        return filterStoreZipCode;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Store: Zone')]")
    public WebElement filterStoreZone;

    public WebElement storeZone() {
        isDisplayed(filterStoreZone, 5);
        return filterStoreZone;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Brand')]")
    public WebElement filterBrand;

    public WebElement storeBrand() {
        isDisplayed(filterBrand, 5);
        return filterBrand;
    }







    


    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Total Spend')]")
    public WebElement filterTotalSpend;

    public WebElement totalSpend() {
        isDisplayed(filterTotalSpend, 5);
        return filterTotalSpend;
    }


    //SETTINGS TOGGLES, SETTINGS TOGGLES,SETTINGS TOGGLES, SETTINGS TOGGLES, SETTINGS TOGGLES, SETTINGS TOGGLES,

    public void toggleLockSetting() {
        isDisplayedBy(lockedSegmentToggle, 5);
        click(lockedSegmentToggle);
    }

    public void toggleWorkgroupSetting() {
        isDisplayedBy(workGroupToggle, 5);
        click(workGroupToggle);
    }

    public void toggleAgeAndGenderSetting() {
        isDisplayedBy(ageAndGenderToggle, 5);
        click(ageAndGenderToggle);
    }

    public void toggleTotalSpendSetting() {
        isDisplayedBy(totalSpendToggle,5);
        click(totalSpendToggle);
    }

    public void toggleRFM() {
        isDisplayedBy(rfmToggle, 5);
        click(rfmToggle);
    }


    public void saveSegment() {
        isDisplayedBy(saveButton, 5);
        click(saveButton);
        isDisplayedBy(notCalculated, 10);
        isDisplayedBy(updatingCount, 10);
        isNotDisplayedBy(updatingCount, 150);
        isDisplayedBy(countComplete, 200);
    }

    public void saveExistingSegment() {
        isDisplayedBy(saveButton, 5);
        click(saveButton);
        isDisplayedBy(saveTitleButton, 5);
        click(saveTitleButton);
        isDisplayedBy(notCalculated, 10);
        isDisplayedBy(updatingCount, 10);
        isNotDisplayedBy(updatingCount, 150);
        isDisplayedBy(countComplete, 200);
    }

    public void addCampaignGroup() {
        isDisplayedBy(AddGroup, 5);
        click(AddGroup);
        isDisplayedBy(AddCampaignGroup, 5);
        click(AddCampaignGroup);
        //isDisplayed(group, 5);
        //return group.getText();
    }

    public void addPeopleGroup() {
        isDisplayedBy(AddGroup, 5);
        click(AddGroup);
        isDisplayedBy(AddPeopleGroup, 5);
        click(AddPeopleGroup);
        //isDisplayed(group, 5);
        //return group.getText();
    }

/*

    // SAVE, CLONE, SPLIT FROM SEGMENT DETAIL
    public void saveAndUpdate() {
        isDisplayedBy(saveButton, 5);
        click(saveButton);
    }

    public void savefromDropdown() {
        isDisplayedBy(saveDropdownButton, 5);
        click(saveDropdownButton);
        isDisplayedBy(saveFromDropdown, 5);
        click(saveFromDropdown);
    }

    public void cloneFromSegment() {
        isDisplayedBy(saveDropdownButton, 5);
        click(saveDropdownButton);
        isDisplayedBy(cloneFromDropdown, 5);
        click(cloneFromDropdown);
    }

    public void splitFromSegment() {
        isDisplayedBy(saveDropdownButton, 5);
        click(saveDropdownButton);
        isDisplayedBy(splitFromDropown, 5);
        click(splitFromDropown);
    }
*/

//THIS IS FOR GETTING THE GROUP NAME BACK FROM THOSE THAT WERE ADDED
/*

    public void findAddedGroups() {
        WebElement addedGroup = null;
        addedGroups = new ArrayList<>();
        int i = 1;
        while (i < 100) {
            try {
                addedGroup = driver.findElement(By.xpath("//*[@id='refine']/div/div/div/div[2]/div[2]/div[2]/div[" + i
                        + "]/div[2]/div[1]/div/div/div[3]"));
                if ( addedGroup != null ) {
                    addedGroups.add(addedGroup);

                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
            }
            i++;
        }
    }
*/

}

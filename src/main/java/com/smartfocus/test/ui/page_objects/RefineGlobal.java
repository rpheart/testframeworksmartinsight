package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;


public class RefineGlobal extends Base {

    // Add filter group dropdown elements
    By addGroup = By.cssSelector(".create-time-period-text");
    By addPurchaseGroup = By.cssSelector("#create_grouping_SalesTransaction");
    By addCampaignGroup = By.cssSelector("#create_grouping_CampaignTransaction");
    By addPeopleGroup = By.cssSelector("#create_grouping_Customer");
    By editTitle = By.cssSelector(".refineSegmentTitle.textSelectable.ellipsis.text-selectable");
    By editDescription = By.cssSelector(".refineSegmentDescription.textSelectable.ellipsis.text-selectable");

    By analyzeButton = By.xpath("//li[@class='logo_button optimize_button' or @class='logo_button optimize_button selected_product']");

    public By getSaveButton() {
        return saveButton;
    }

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



    //LOV ASSERTION CONTROLS
    By lovList = By.xpath("//div[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    By filterSearchBox = By.xpath("//div[@id='modalFilterContents']//*[@class='form-control search-query textSelectable']");
    By selectAllButton = By.xpath("//div[@id='modalFilterContents']//*[@class='selectAll']");
    By unselectAllButton = By.xpath("//div[@id='modalFilterContents']//*[@class='unselectAll']");
    LOVFilterConfig lovFilter = new LOVFilterConfig();


    String segmentTitleText;
    String segmentDescriptionText;


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
        groups = driver.findElements(By.xpath("//*[@class='applied_filter_items']/div[*]/div[2]/div[1]/div/div/div[3]"));

        return groups.size();
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

    //WHERE TO DROP THAT FILTER? GETDROPZONE IS DEFAULT, BUT ALSO INCLUDED HERE IS TOP/BOTTOM AND SPEND ON
    public WebElement getDropZone(int position) {
        WebElement dropZone = groups.get(position-1).findElement(By.xpath("//*[@class='applied_filter_items']/div[" + position + "]/div[2]/div[1]/ul"));
        return dropZone;
    }

    public WebElement getTopDropZone(int position) {
        WebElement dropZone = groups.get(position-1).findElement(By.xpath("//*[@class='applied_filter_items']/div[" + position + "]/div[2]/div[1]/ul/li/div[3]/ul[1]"));
        return dropZone;
    }

    public WebElement getBottomDropZone(int position) {
        WebElement dropZone = groups.get(position-1).findElement(By.xpath("//*[@class='applied_filter_items']/div[" + position + "]/div[2]/div[1]/ul/li/div[3]/ul[2]"));
        return dropZone;
    }

  //  public WebElement getSpendOnDropZone()


    //ADD FILTER GROUPS ADD FILTER GROUPS ADD FILTER GROUPS ADD FILTER GROUPS ADD FILTER GROUPS

    String addedGroupTemplate = "//div[@class='applied_filter_items']/div[position]/div[2]/div[1]/div/div//*[contains(text(), \"filterGroupType\")]";
    String appliedGroupText;


    public WebElement addPurchaseGroup() {
        isDisplayedBy(addGroup, 5);
        click(addGroup);
        isDisplayedBy(addPurchaseGroup, 5);
        click(addPurchaseGroup);
        int lastGroup = groups.size();
        WebElement fg = findFilterGroup(lastGroup + 1);
        isDisplayed(fg, 5);
        findAddedGroups();
        return fg;
    }

    public WebElement addCampaignGroup() {
        isDisplayedBy(addGroup, 5);
        click(addGroup);
        isDisplayedBy(addCampaignGroup, 5);
        click(addCampaignGroup);
        int lastGroup = groups.size();
        WebElement fg = findFilterGroup(lastGroup + 1);
        isDisplayed(fg, 5);
        findAddedGroups();
        return fg;
    }

    public WebElement addPeopleGroup() {
        isDisplayedBy(addGroup, 5);
        click(addGroup);
        isDisplayedBy(addPeopleGroup, 5);
        click(addPeopleGroup);
        int lastGroup = groups.size();
        WebElement fg = findFilterGroup(lastGroup + 1);
        isDisplayed(fg, 5);
        findAddedGroups();
        return fg;
    }


    public boolean groupAdded(int groupPosition, String addedFilterGroup) {
        isDisplayedBy(editTitle, 5);
        String appliedGroupPattern = addedGroupTemplate.replace("position",  String.format("%d", groupPosition)).replace("filterGroupType", addedFilterGroup);
        appliedGroupText = driver.findElement(By.xpath(appliedGroupPattern)).getText();

        if ( appliedGroupText.contains(addedFilterGroup) ) {
            return true;
        }
        return false;
    }



    String manageFilterGroupGearIconTemplate = "//div[@class='applied_filter_items']/div[position]/div[2]/div[1]/div/div/div[4]/div[3]";
    String manageFilterButtonTemplate = "//div[@class='applied_filter_items']/div[position]/div[2]/div[1]/div/div/div[4]/div[3]/ul/li[1]";
    String relativePeriodInputTemplate = "//div[@class='applied_filter_items']/div[position]/div[2]/div[1]/div/div/div[4]/div[3]/ul/div/div/div[2]/ul[1]/li[2]/div[2]/div[1]/div[1]/div[1]/div[1]/input";
    String qualifierRelativePeriodButtonTemplate = "//div[@class='applied_filter_items']/div[position]/div[2]/div[1]/div/div/div[4]/div[3]/ul/div/div/div[2]/ul[1]/li[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a";


    String doneManageButtonTemplate = "//div[@class='applied_filter_items']/div[position]/div[2]/div[1]/div/div/div[4]/div[3]/ul/div/div/div[3]/a[1]";

    String relativePeriodTemplate = "//div[@class='applied_filter_items']/div[position]/div[2]/div[1]/div/div/div[4]/div[3]/ul/div/div/div[2]/ul[1]/li[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul/li[z]";

    public void manageFilterGroupRelativePeriod (int position, int relativeTimePeriod, String qualifier) {
        By manageFilterGroupGearIcon = By.xpath(manageFilterGroupGearIconTemplate.replace("position", String.format("%d", position)));
        isDisplayedBy(manageFilterGroupGearIcon, 10);
        click(manageFilterGroupGearIcon);
        By manageFilterButton = By.xpath(manageFilterButtonTemplate.replace("position", String.format("%d", position)));
        isDisplayedBy(manageFilterButton, 10);
        click(manageFilterButton);
        waitOneSecond();
        By relativePeriodInput = By.xpath(relativePeriodInputTemplate.replace("position", String.format("%d",position)));
        click(relativePeriodInput);
        find(relativePeriodInput).clear();
        find(relativePeriodInput).sendKeys(String.format("%d", relativeTimePeriod));

        By qualifierRelativePeriodButton = By.xpath(qualifierRelativePeriodButtonTemplate.replace("position", String.format("%d",position)));
        isDisplayedBy(qualifierRelativePeriodButton, 10);
        click(qualifierRelativePeriodButton);

        if ( qualifier.equalsIgnoreCase("days") ) {
            By relativePeriodDays = By.xpath(relativePeriodTemplate.replace("position", String.format("%d", position)).replace("z", "1"));
            click(relativePeriodDays);
        } else if (qualifier.equalsIgnoreCase("weeks") ) {
            By relativePeriodWeeks = By.xpath(relativePeriodTemplate.replace("position", String.format("%d", position)).replace("z", "2"));
            click(relativePeriodWeeks);
        } else if (qualifier.equalsIgnoreCase("months") ) {
            By relativePeriodMonths = By.xpath(relativePeriodTemplate.replace("position", String.format("%d", position)).replace("z", "3"));
            click(relativePeriodMonths);
        } else if ( qualifier.equalsIgnoreCase("years") ) {
            By relativePeriodYears = By.xpath(relativePeriodTemplate.replace("position", String.format("%d", position)).replace("z", "4"));
            click(relativePeriodYears);
        }

        By doneManageButton = By.xpath(doneManageButtonTemplate.replace("position", String.format("%d", position)));
        isDisplayedBy(doneManageButton, 10);
        click(doneManageButton);

    }

    String lookBackPeriodTextTemplate = "//div[@class='applied_filter_items']/div[position]/div[2]/div[1]/div/div/div[3]/span";

    public Boolean verifyFilterGroupRelativePeriod(int position, String expectedValueandQualifyingRange) {
        By lookBackPeriod = By.xpath(lookBackPeriodTextTemplate.replace("position", String.format("%d", position)));

        String trimmedLookBackPeriodText = find(lookBackPeriod).getText().replace("Last ", "").replaceAll("\\(", "").replaceAll("\\)", "");
        System.out.println(trimmedLookBackPeriodText);

        if ( trimmedLookBackPeriodText.equalsIgnoreCase(expectedValueandQualifyingRange) ) {
            return true;
        }
        return false;
    }



    String andOrFilterGroupOperatorTemplate = "//div[@class='applied_filter_items']/div[position]/div[1]/div/button[@class='btn btn-default btnAndOr btnAnd active' and contains(text(), 'AndOrText')]";
        // THE POSITION OF THE AND/OR OPERATOR IS BASED ON ORDER OF AND/OR'S. THIS IS TO SAY, THE FIRST AND/OR OPERATOR POSITION IS BETWEEN FILTER GROUPS 1 AND 2
    public boolean verifyFilterGroupAndOrOperator(int position, String AndOr) {
        By andOrfilterGroupOperator = By.xpath(andOrFilterGroupOperatorTemplate.replace("position", String.format("%d", position + 1)).replace("AndOrText", AndOr));
        WebElement andOrWebElement = find(andOrfilterGroupOperator);
        String andOrOperatorText = andOrWebElement.getText();

        if ( AndOr.equalsIgnoreCase(andOrOperatorText) ) {
            return true;
        }
        return false;
    }





//ADD FILTERS   ADD FILTERS   ADD FILTERS   ADD FILTERS   ADD FILTERS   ADD FILTERS   ADD FILTERS   ADD FILTERS   ADD FILTERS

    @FindBy(xpath = "//div[@class='available_container_items']//*[contains(text(), 'And/Or Template')]")
    public WebElement templateAndOr;

    public WebElement andOrContainer() {
        isDisplayed(templateAndOr, 5);
        return templateAndOr;
    }

    public WebElement setAndOrContainerButtonAnd(int position) {
        WebElement andButton = groups.get(position-1).findElement(By.xpath("//*[@class='applied_filter_items']/div[" + position + "]/div[2]/div[1]/ul/li/div[3]/div/div/div/button[1]"));
        return andButton;
    }

    public WebElement setAndOrContainerButtonOr(int position) {
        WebElement dropZone = groups.get(position-1).findElement(By.xpath("//*[@class='applied_filter_items']/div[" + position + "]/div[2]/div[1]/ul/li/div[3]/div/div/div/button[2]"));
        return dropZone;
    }


    String andOrEnabledContainer= "//*[@class='applied_filter_items']/div[position]/div[2]/div[1]/ul/li/div[3]/div/div/div/button[@class='btn btn-default btnAndOr btnAndOrText active' and contains(text(), 'AndOrText')]";
    String enabledButtonText;

    public boolean verifyAndOrContainerOperator(int filterGroup, String AndOr) {
        By foundAndORButton = By.xpath(andOrEnabledContainer.replace("position", String.format("%d", filterGroup)).replace("AndOrText", AndOr));
        WebElement foundAndOrButton = find(foundAndORButton);
        isDisplayed(foundAndOrButton, 5);
        enabledButtonText = find(foundAndORButton).getText();
       if ( enabledButtonText.equalsIgnoreCase(AndOr) ) {
           return true;
       }
        return false;
    }



    @FindBy(xpath = "//div[@class='available_container_items']//*[contains(text(), 'Quantity Of/Spend On Template')]")
    public WebElement templateQoso;

    public WebElement qosoContainer() {
        isDisplayed(templateQoso, 5);
        return templateQoso;
    }

    By qosoContainerBy = By.xpath("//div[@class='available_container_items']//*[contains(text(), 'Quantity Of/Spend On Template')]");

    public WebElement qosoContainerBy() {
        WebElement foundQosoContainer =find(qosoContainerBy);
        return foundQosoContainer;

    }

    String filterGroupPattern = "//*[@class='applied_filter_items']/div[i]/div[2]/div[1]/ul";

    public WebElement findFilterGroup(int position) {
        By location = By.xpath(filterGroupPattern.replace("[i]", String.format("%s%d%s", "[", position, "]")));
        groups.add(position - 1, findString(location));
        return groups.get(position - 1);
    }

    String filterGroupAndOrTopPattern = "//*[@class='applied_filter_items']/div[a]/div[2]/div[1]/ul/li/div[3]/ul[1]";

    public WebElement findTop(int positionA) {
        By location = By.xpath(filterGroupAndOrTopPattern.replace("[a]", String.format("%s%d%s", "[", positionA, "]")));
        groups.add(positionA - 1, findString(location));
        return groups.get(positionA - 1);
    }

    String filterGroupAndOrBottomPattern = "//*[@class='applied_filter_items']/div[b]/div[2]/div[1]/ul/li/div[3]/ul[2]";

    public WebElement findBottom(int positionB) {
        By location = By.xpath(filterGroupAndOrBottomPattern.replace("[b]", String.format("%s%d%s", "[", positionB, "]")));
        groups.add(positionB - 1, findString(location));
        return groups.get(positionB - 1);
    }



    //EDITING TITLE AND DESCRIPTION (SEE ALSO CLASSES SEGMENT TITLE AND SEGMENT DESCRIPTION FOR POP-UP CONTROLS)

    public void openTitle() {
        isDisplayedBy(editTitle, 5);
        click(editTitle);
    }

    public boolean verifySegmentTitleChange(String newTitle) {
        isDisplayedBy(editTitle, 5);
        segmentTitleText = driver.findElement(By.cssSelector(".refineSegmentTitle.textSelectable.ellipsis.text-selectable")).getText();
        if (segmentTitleText.equalsIgnoreCase(newTitle)) {
            return true;
        }
        return false;
    }

    public void openDescription() {
        isDisplayedBy(editDescription, 5);
        click(editDescription);
    }

    public boolean verifySegmentDescriptionChange(String newDescription) {
        isDisplayedBy(editTitle, 5);
        segmentDescriptionText = driver.findElement(By.cssSelector(".refineSegmentDescription.textSelectable.ellipsis.text-selectable")).getText();
        if (segmentDescriptionText.equalsIgnoreCase(newDescription)) {
            return true;
        }
        return false;
    }

    //MAIN NAVIGATION BETWEEN THE THREE TABS FOR EACH SEGMENT (SUMMARY, REFINE, SETTINGS) |  MAIN NAVIGATION BETWEEN THE THREE TABS FOR EACH SEGMENT (SUMMARY, REFINE, SETTINGS)

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

    //SEGMENT DETAIL PAGE (SEE ALSO CLASS "SEGMENT CHART VIEW")  |  SEGMENT DETAIL PAGE (SEE ALSO CLASS "SEGMENT CHART VIEW")

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

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Birthday')]")
    public WebElement filterBirthday;

    public WebElement birthday() {
        isDisplayed(filterBirthday, 5);
        return filterBirthday;
    }

        @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'City')]")
    public WebElement filterCity;

    public WebElement city() {
        isDisplayed(filterCity, 5);
        return filterCity;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Country')]")
    public WebElement filterCountry;

    public WebElement country() {
        isDisplayed(filterCountry, 5);
        return filterCountry;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Customer Id')]")
    public WebElement filterCustomerID;

    public WebElement customerID() {
        isDisplayed(filterCustomerID, 5);
        return filterCustomerID;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Education Level')]")
    public WebElement filterEducationLevel;

    public WebElement educationLevel() {
        isDisplayed(filterEducationLevel, 5);
        return filterEducationLevel;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Family Status')]")
    public WebElement filterFamilyStatus;

    public WebElement familyStatus() {
        isDisplayed(filterFamilyStatus, 5);
        return filterFamilyStatus;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Gender')]")
    public WebElement filterGender;

    public WebElement gender() {
        isDisplayed(filterGender, 5);
        return filterGender;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Income')]")
    public WebElement filterIncome;

    public WebElement income() {
        isDisplayed(filterIncome, 5);
        return filterIncome;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Marital Status')]")
    public WebElement filterMaritalStatus;

    public WebElement maritalStatus() {
        isDisplayed(filterMaritalStatus, 5);
        return filterMaritalStatus;
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

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Category')]")
    public WebElement filterCategory;

    public WebElement category() {
        isDisplayed(filterCategory, 5);
        return filterCategory;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Department')]")
    public WebElement filterDepartment;

    public WebElement department() {
        isDisplayed(filterDepartment, 5);
        return filterDepartment;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Purchase Count')]")
    public WebElement filterPurchaseCount;

    public WebElement purchaseCount() {
        isDisplayed(filterPurchaseCount, 5);
        return filterPurchaseCount;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Purchase Frequency')]")
    public WebElement filterPurchaseFrequency;

    public WebElement purchaseFrequency() {
        isDisplayed(filterPurchaseFrequency, 5);
        return filterPurchaseFrequency;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Purchase Recency')]")
    public WebElement filterPurchaseRecency;

    public WebElement purchaseRecency() {
        isDisplayed(filterPurchaseRecency, 5);
        return filterPurchaseRecency;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'SKU')]")
    public WebElement filterSku;

    public WebElement sku() {
        isDisplayed(filterSku, 5);
        return filterSku;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Style')]")
    public WebElement filterStyle;

    public WebElement style() {
        isDisplayed(filterStyle, 5);
        return filterStyle;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Sub-Category')]")
    public WebElement filterSubCategory;

    public WebElement subCategory() {
        isDisplayed(filterSubCategory, 5);
        return filterSubCategory;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Total Spend')]")
    public WebElement filterTotalSpend;

    public WebElement totalSpend() {
        isDisplayed(filterTotalSpend, 5);
        return filterTotalSpend;
            }


    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Transaction Spend')]")
    public WebElement filterTransactionSpend;

    public WebElement transactionSpend() {
        isDisplayed(filterTransactionSpend, 5);
        return filterTransactionSpend;
    }

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Vendor Name')]")
    public WebElement filterVendorName;

    public WebElement vendorName() {
        isDisplayed(filterVendorName, 5);
        return filterVendorName;
    }




    By notCalculated = By.xpath("//div[@class='cust-count-span' and contains(text(), ' Not Yet Calculated')]");
    By updatingCount = By.xpath("//div[@class='refine-status-and-save']/div[@class='refine-count-messaging']/div[@class='progress progress-striped active']");

    By countComplete = By.cssSelector((".cust-count-span"));

    public void saveSegment() {
        isDisplayedBy(notCalculated, 10);
        isDisplayedBy(saveButton, 5);
        click(saveButton);
        isDisplayedBy(updatingCount, 10);
        isNotDisplayedBy(updatingCount, 150);
        isDisplayedBy(countComplete, 200);
    }


    By summarySegmentTotalPeople = By.cssSelector(".cskpi-value.cskpi-seg-total-customer-value");

    public boolean verifySegmentSavedKnownCount(String peopleCount) {
        isDisplayedBy(countComplete, 120);
        String peopleCountText = find(countComplete).getText();
        System.out.println(peopleCountText);
        if ( peopleCountText.contains( peopleCount) ) {

            return true;
        }

        summaryTab();
        String segmentTotalPeopleText = find(summarySegmentTotalPeople).getText();
        System.out.println(segmentTotalPeopleText);
        if ( segmentTotalPeopleText.equalsIgnoreCase(peopleCount) ) {
            return true;
        }

        return false;
    }

    String peopleCountTemplate = "//div[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']//*[contains(text(), 'segmentName')]/../../div[4]/div[1]/span";

    public boolean verifySegmentSavedUnknownCount() {
        isDisplayedBy(countComplete, 240);
        waitOneSecond();
        String peopleCountText = find(countComplete).getText();
        System.out.println(peopleCountText);
        summaryTab();
        isDisplayedBy(summarySegmentTotalPeople, 60);
        String segmentTotalPeopleText = find(summarySegmentTotalPeople).getText();
        System.out.println(segmentTotalPeopleText);
        if ( peopleCountText.contains(segmentTotalPeopleText) ) {
            return true;
        }
        return false;
    }


    public void saveTimelineSegment() {
        isDisplayedBy(saveButton, 5);
        click(saveButton);
        isDisplayedBy(updatingTimeline, 10);
    }

    By customerCountElement = By.xpath("//div[@class='customer-count']");
            //customer count is from timeline detail page

    By updatingTimeline = By.xpath("//div[@class='refine-count-messaging']/div[@class='progress progress-striped active']");

    public boolean verifyTimelineSavedUnknownCount(String segmentName) {
        isDisplayedBy(updatingTimeline, 10);
        try {
            WebElement foundUpdatingTimeline = ExpectedConditions.visibilityOfElementLocated(updatingTimeline).apply(driver);
            while (foundUpdatingTimeline.isDisplayed()) {
                waitThreeSeconds();
                foundUpdatingTimeline = ExpectedConditions.visibilityOfElementLocated(updatingTimeline).apply(driver);
            }
        } catch (Exception e) {
            //ignoring exception
        }
        waitOneSecond();
        isDisplayedBy(summaryTab, 10);
        click(summaryTab);
        String customerCountString = find(customerCountElement).getText();
        System.out.println(customerCountString);
        isDisplayedBy(analyzeButton, 5);
        click(analyzeButton);
        waitOneSecond();
        By peopleCountElement = By.xpath(peopleCountTemplate.replace("segmentName", segmentName));
        isDisplayedBy(peopleCountElement, 30);
        String peopleCountString = find(peopleCountElement).getText();
        System.out.println(peopleCountString);

        if ( peopleCountString.contains(customerCountString) ) {
            return true;
        }
        return false;
    }

    /*   public boolean groupAdded(String groupPosition, String addedFilterGroup) {
        isDisplayedBy(editTitle, 5);
        String appliedGroupPattern = addedGroupTemplate.replace("position", groupPosition).replace("filterGroupType", addedFilterGroup);
        appliedGroupText = driver.findElement(By.xpath(appliedGroupPattern)).getText();

        if ( appliedGroupText.contains(addedFilterGroup) ) {
            return true;
        }
        return false;
    }

    String andOrFilterGroupOperatorTemplate = "//div[@class='applied_filter_items']/div[position]/div[1]/div/button[@class='btn btn-default btnAndOr btnAnd active' and contains(text(), 'AndOrText')]";

    public boolean verifyFilterGroupAndOrOperator(int position, String AndOr) {
        By andOrfilterGroupOperator = By.xpath(andOrFilterGroupOperatorTemplate.replace("position", String.format("%d", position + 1)).replace("AndOrText", AndOr));
        WebElement andOrWebElement = find(andOrfilterGroupOperator);
        String andOrOperatorText = andOrWebElement.getText();

        if ( AndOr.equalsIgnoreCase(andOrOperatorText) ) {
            return true;
        }
        return false;
    }
*/

    public void saveExistingSegment() {
        isDisplayedBy(saveButton, 5);
        click(saveButton);
        isDisplayedBy(notCalculated, 10);
        isDisplayedBy(updatingCount, 10);
        isNotDisplayedBy(updatingCount, 150);
        isDisplayedBy(countComplete, 200);
    }

    By disabledExportButton = By.xpath("//div[@class='btn dropdown-toggle trigger-export neverExported disabled']");

    By exportButton = By.xpath("//div[@class='btn-group segmentActionsDropDown']");
    By exportDownload = By.xpath("//ul[@class='dropdown-menu exportDropDownMenu dropDownMenu pull-right']//*[@class='ddm-item-text exportAction' and contains(text(), \"Download\")]");
    By exportDownloadModalButton = By.xpath("//div[@class='titleDiv' and contains(text(), 'Export')]/../div[3]/div[1]/a[2]");

    By exportEmail = By.xpath("//ul[@class='dropdown-menu exportDropDownMenu dropDownMenu pull-right']//*[@class='ddm-item-text exportAction' and contains(text(), \"Export to Smart Email\")]");
    By exportSFTPFTP = By.xpath("//ul[@class='dropdown-menu exportDropDownMenu dropDownMenu pull-right']//*[@class='ddm-item-text exportAction' and contains(text(), \"Export To SFTP/FTP\")]");
    By exportCustomReports = By.xpath("//ul[@class='dropdown-menu exportDropDownMenu dropDownMenu pull-right']//*[@class='ddm-item-text exportAction' and contains(text(), \"Download\")]");


    public void exportToDownload() {
        try{
            WebElement foundDisabledButton = ExpectedConditions.visibilityOfElementLocated(disabledExportButton).apply(driver);
            while (foundDisabledButton.isDisplayed()) {
                waitThreeSeconds();
                foundDisabledButton = ExpectedConditions.visibilityOfElementLocated(disabledExportButton).apply(driver);
            }
        }
        catch (Exception e) {
            //ignoring exception
        }
        isDisplayedBy(exportButton, 180);
        click(exportButton);
        isDisplayedBy(exportDownload, 5);
        click(exportDownload);
        isDisplayedBy(exportDownloadModalButton, 10);
        click(exportDownloadModalButton);
    }

    public void exportToEmail() {
        try{
            WebElement foundDisabledButton = ExpectedConditions.visibilityOfElementLocated(disabledExportButton).apply(driver);
            while (foundDisabledButton.isDisplayed()) {
                waitThreeSeconds();
                foundDisabledButton = ExpectedConditions.visibilityOfElementLocated(disabledExportButton).apply(driver);
            }
        }
        catch (Exception e) {
            //ignoring exception
        }
        isDisplayedBy(exportButton, 180);
        click(exportButton);
        isDisplayedBy(exportEmail, 5);
        click(exportEmail);
    }

    public void exportToSFTP() {
        try{
            WebElement foundDisabledButton = ExpectedConditions.visibilityOfElementLocated(disabledExportButton).apply(driver);
            while (foundDisabledButton.isDisplayed()) {
                waitThreeSeconds();
                foundDisabledButton = ExpectedConditions.visibilityOfElementLocated(disabledExportButton).apply(driver);
            }
        }
        catch (Exception e) {
            //ignoring exception
        }
        isDisplayedBy(exportButton, 180);
        click(exportButton);
        isDisplayedBy(exportSFTPFTP, 5);
        click(exportSFTPFTP);
        isDisplayedBy(exportDownloadModalButton, 10);
        click(exportDownloadModalButton);
    }

    public void exportCustomReports() {
        try{
            WebElement foundDisabledButton = ExpectedConditions.visibilityOfElementLocated(disabledExportButton).apply(driver);
            while (foundDisabledButton.isDisplayed()) {
                waitThreeSeconds();
                foundDisabledButton = ExpectedConditions.visibilityOfElementLocated(disabledExportButton).apply(driver);
            }
        }
        catch (Exception e) {
            //ignoring exception
        }
        isDisplayedBy(exportButton, 10);
        click(exportButton);
        isDisplayedBy(exportCustomReports, 5);
        click(exportCustomReports);
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

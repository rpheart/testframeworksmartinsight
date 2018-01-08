package com.smartfocus.test.ui.page_objects;

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


    //Filter Group list element
    List <WebElement> groups = new ArrayList<>();

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

    public void findGroup() {
        WebElement addedGroup = null;
        int i = 1;
        while (i < 100) {
            try {
                addedGroup = driver.findElement(By.xpath("//*[@id='refine']/div/div/div/div[2]/div[2]/div[2]/div[" + i
                        + "]/div[2]/div[1]/div/div/div[3]"));
                if ( addedGroup != null ) {
                    groups.add(addedGroup);

                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
            }
            i++;
        }
        WebElement fg = findFilterGroup(1);
        isDisplayed(fg, 5);
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

/*
    public WebElement findGroup(int position) {

    }
*/

    public WebElement addPurchaseGroup() {
        isDisplayedBy(AddGroup, 5);
        click(AddGroup);
        isDisplayedBy(AddPurchaseGroup, 5);
        click(AddPurchaseGroup);
        int lastGroup = groups.size();
        WebElement fg = findFilterGroup(lastGroup + 1);
        isDisplayed(fg, 5);
        return fg;
    }



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

    public WebElement  findFilterGroup(int position) {
        By location = By.xpath(filterGroupPattern.replace("[i]", String.format("%s%d%s", "[", position, "]")));
        groups.add(position-1, findString(location));
        return groups.get(position-1);
    }

    String filterGroupAndOrTopPattern = "//*[@id='refine']/div/div/div/div[2]/div[2]/div[2]/div[a]/div[2]/div[1]/ul/li/div[3]/ul[1]";

    public WebElement findTop(int positionA) {
        By location = By.xpath(filterGroupAndOrTopPattern.replace("[a]", String.format("%s%d%s", "[", positionA, "]")));
        groups.add(positionA-1, findString(location));
        return groups.get(positionA-1);
    }


    String filterGroupAndOrBottomPattern = "//*[@id='refine']/div/div/div/div[2]/div[2]/div[2]/div[b]/div[2]/div[1]/ul/li/div[3]/ul[2]";

    public WebElement findBottom(int positionB) {
        By location = By.xpath(filterGroupAndOrBottomPattern.replace("[b]", String.format("%s%d%s", "[", positionB, "]")));
        groups.add(positionB-1, findString(location));
        return groups.get(positionB-1);
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


//FILTERS
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

    @FindBy(xpath = "//div[@class='available_filters_container']//*[contains(text(), 'Total Spend')]")
    public WebElement filterTotalSpend;

    public WebElement totalSpend() {
        isDisplayed(filterTotalSpend, 5);
        return filterTotalSpend;
    }


    public void saveSegment() {
        isDisplayedBy(saveButton, 5);
        click(saveButton);
/*        isDisplayedBy(notCalculated, 10);
        isDisplayedBy(updatingCount, 10);
        isNotDisplayedBy(updatingCount, 150);
        isDisplayedBy(countComplete, 200);*/
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

}
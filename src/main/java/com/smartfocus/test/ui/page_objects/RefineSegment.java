package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RefineSegment extends Base {


    //FILTER GROUPS - FILTER GROUPS - FILTER GROUPS - FILTER GROUPS - FILTER GROUPS - FILTER GROUPS - FILTER GROUPS

    By AddGroup = By.cssSelector(".create-time-period-text");
    By AddPurchaseGroup = By.cssSelector("#create_grouping_SalesTransaction");
    By AddCampaignGroup = By.cssSelector("#create_grouping_CampaignTransaction");
    By AddPeopleGroup = By.cssSelector("#create_grouping_Customer");


    public void addPurchaseGroup() {
        isDisplayedBy(AddGroup, 5);
        click(AddGroup);
        isDisplayedBy(AddPurchaseGroup, 5);
        click(AddPurchaseGroup);
    }

    public void addCampaignGroup() {
        isDisplayedBy(AddGroup, 5);
        click(AddGroup);
        isDisplayedBy(AddCampaignGroup, 5);
        click(AddCampaignGroup);
    }

    public void addPeopleGroup() {
        isDisplayedBy(AddGroup, 5);
        click(AddGroup);
        isDisplayedBy(AddPeopleGroup, 5);
        click(AddPeopleGroup);
    }


    public List<WebElement> getAddedGroups() {
        return addedGroups;
    }

    private List<WebElement> addedGroups;

    public void findAddedGroups() {
        WebElement addedGroup = null;
        addedGroups = new ArrayList<>();
        int i = 1;
        while (i < 100) {
            try {
                addedGroup = driver.findElement(By.xpath("//*[@id='refine']/div/div/div/div[2]/div[2]/div[2]/div[" + i
                        + "]/div[2]/div[1]/div/div/div[3]"));
                if (addedGroup != null) {
                    addedGroups.add(addedGroup);

                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
            }
            i++;
        }
    }

    public String getGroupType(int position) {
        String type = null;
        if (position > addedGroups.size()) {
            return null;
        }
        WebElement group = addedGroups.get(position - 1);
        type = group.getText();
        return type;
    }


//FILTERS - FILTERS - FILTERS - FILTERS - FILTERS - FILTERS - FILTERS - FILTERS - FILTERS - FILTERS - FILTERS - FILTERS - FILTERS - FILTERS - FILTERS -


    @FindBy(css = "#segment_bucket segment_bucket_available")
    private WebElement filterList;
    List<WebElement> filters = filterList.findElements(By.tagName("li"));

    public WebElement getLOVFilter(String name) {

        ArrayList<String> filterName = new ArrayList<>();
        for (int i = 1; i < filterName.size(); i++) {
            WebElement filters = filterList.findElement(
                    By.xpath("//*[@id='refine']/div/div/div/div[2]/div[1]/div/div[5]/ul/li[" + (i + 1) + "]"));
            if (filters.getText().trim().equals(name)) {
                filters.isDisplayed();
                return filters;
            }
        }
        return null;
    }


    public void dragFilter(WebElement source, WebElement target) {
        //how to make source = filter of choice?
        isDisplayed(source, 3);
        Actions dragger = new Actions(driver);
        dragger.clickAndHold(source);
        dragger.dragAndDrop(source, target).perform();
    }


    public void selectLOVs(WebElement filter) {
        int count = findElements(By.xpath("//input[@name='group1']")).size();
        for(int i = 0;i<count;i++) {

            String text = findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value");

            if (text.equals("18-20")) {
                findElements(By.xpath("//input[@name='group1']")).get(i).click();
            }
        }
    }


    @FindBy(xpath = "//*[@id='refine']/div/div/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/ul")
    private WebElement purchaseFilterGroup;

    public WebElement getPurchaseFilterGroup() {
        return purchaseFilterGroup;
    }







}

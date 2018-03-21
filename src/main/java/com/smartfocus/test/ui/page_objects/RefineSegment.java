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






}

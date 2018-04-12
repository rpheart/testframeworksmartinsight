package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;



public class AmountFilterConfig extends Base {

    By valueQualifier = By.cssSelector(".form-control.comparator-select");
    By saveFilterButton = By.cssSelector(".btn.saveBtn.modalFilterSave");
    By cancelFilterButton = By.cssSelector(".btn.cancelBtn.modalFilterCancel");
    By valueEntryMost =  By.xpath("//*[@id='modalFilterContents']/div[2]/div/div[1]/div[3]/div[2]/div[2]/input");
    By valueEntryLeast = By.xpath("//*[@id='modalFilterContents']/div[2]/div/div[1]/div[3]/div[2]/div[1]/input");
    By valueEntryBetween1 = By.xpath("//*[@id='modalFilterContents']/div[2]/div/div[1]/div[3]/div[2]/div[3]/input[1]");
    By valueEntryBetween2 = By.xpath("//*[@id='modalFilterContents']/div[2]/div/div[1]/div[3]/div[2]/div[3]/input[2]");
    By modal = By.cssSelector(".aggregated-filter-view-leadingLabel");


    public void atMost(int value) {
        isDisplayedBy(valueQualifier, 5);

        click(valueQualifier);
        Select qualifier = new Select(driver.findElement(valueQualifier));
        qualifier.selectByIndex(1);
        click(modal);

        isDisplayedBy(valueEntryMost, 5);
        click(valueEntryMost);
        type(valueEntryMost, String.format("%d", value));
    }



    public void atLeast (int value) {
        isDisplayedBy(valueQualifier, 5);

        click(valueQualifier);
        Select qualifier = new Select(driver.findElement(valueQualifier));
        qualifier.selectByIndex(0);
        click(modal);

        isDisplayedBy(valueEntryLeast, 5);
        click(valueEntryLeast);
        type(valueEntryLeast, String.format("%d", value));
    }


    public void inBetween(int value1, int value2) {
        isDisplayedBy(valueQualifier, 5);

        click(valueQualifier);
        Select qualifier = new Select(find(valueQualifier));
        qualifier.selectByIndex(2);
        click(modal);

        isDisplayedBy(valueEntryBetween1, 5);
        click(valueEntryBetween1);
        type(valueEntryBetween1, String.format("%d", value1));

        isDisplayedBy(valueEntryBetween2, 5);
        click(valueEntryBetween2);
        type(valueEntryBetween2, String.format("%d", value2));
    }


    public void saveFilter() {
        isDisplayedBy(saveFilterButton, 5);
        click(saveFilterButton);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException exception ) {

        }
    }

    public void cancelFilter() {
        isDisplayedBy(cancelFilterButton, 5);
        click(cancelFilterButton);
    }

    String appliedLovFilterTemplate = "//div[@class='applied_filter_items']//*[contains(text(), \"filterName\")]/../div[3]";
    String amountFilter;
    String amountFilterText;
    String amountFilterTemplateText = "qualifier value in the selected time period.";

    public Boolean amountFilterSuccess(String filter, String qualifier, int... value) {
        String appliedFilterPattern = appliedLovFilterTemplate.replace("filterName", filter);
        By theappliedFilter = By.xpath(appliedFilterPattern);
        WebElement appliedFilter = find(theappliedFilter);
        isDisplayed(appliedFilter, 5);
        amountFilterText = appliedFilter.getText();
        if ( qualifier.equalsIgnoreCase("at least") ) {
            amountFilter = amountFilterTemplateText.replace("qualifier", qualifier).replace("value", String.format("%d", value[0]));
        } else if ( qualifier.equalsIgnoreCase("at most") ) {
            amountFilter = amountFilterTemplateText.replace("qualifier", qualifier).replace("value", String.format("%d", value[0]));
        } else if ( qualifier.equalsIgnoreCase("between") ) {
            amountFilter = amountFilterTemplateText.replace("qualifier", qualifier).replace("value", String.format("$%d and $%d", value[0], value[1]));
        }

        if ( amountFilterText.contains(amountFilter) ) {
            return true;
        }
        return false;
    }









}

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

    //@FindBy(className = "form-control comparator-select")

//    @FindBy(xpath = "//*[@id='modalFilterContents']/div[2]/div/div[1]/div[3]/div[2]/select")
//    public WebElement valueQualifier;



    public void atMost(String value) {
        isDisplayedBy(valueQualifier, 5);

        click(valueQualifier);
        Select qualifier = new Select(driver.findElement(valueQualifier));
        qualifier.selectByIndex(1);
        click(modal);

        isDisplayedBy(valueEntryMost, 5);
        click(valueEntryMost);
        type(valueEntryMost, value);
    }



    public void atLeast (String value) {
        isDisplayedBy(valueQualifier, 5);

        click(valueQualifier);
        Select qualifier = new Select(driver.findElement(valueQualifier));
        qualifier.selectByIndex(0);
        click(modal);

        isDisplayedBy(valueEntryLeast, 5);
        click(valueEntryLeast);
        type(valueEntryLeast, value);
    }


    public void inBetween(String value1, String value2) {
        isDisplayedBy(valueQualifier, 5);

        click(valueQualifier);
        Select qualifier = new Select(driver.findElement(valueQualifier));
        qualifier.selectByIndex(2);
        click(modal);

        isDisplayedBy(valueEntryBetween1, 5);
        click(valueEntryBetween1);
        type(valueEntryBetween1, value1);

        isDisplayedBy(valueEntryBetween2, 5);
        click(valueEntryBetween2);
        type(valueEntryBetween2, value2);
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


}

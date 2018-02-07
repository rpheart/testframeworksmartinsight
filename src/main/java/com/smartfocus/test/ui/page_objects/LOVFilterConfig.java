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
    By includeToggle = By.cssSelector(".btn.btnInclude");
    By excludeToggle = By.cssSelector(".btn.btnExclude");
    By lovList = By.xpath("//div[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']");
    By filterSearchBox = By.xpath("//div[@id='modalFilterContents']//*[@class='form-control search-query textSelectable']");
    By selectAllButton = By.xpath("//div[@id='modalFilterContents']//*[@class='selectAll']");
    By unselectAllButton = By.xpath("//div[@id='modalFilterContents']//*[@class='unselectAll']");


    String lovPattern = "//div[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']//*[contains(text(), 'filterName')]/../div[1]/i";




    public List<WebElement> genericLOV(String... labels) {
        List<WebElement> checkBoxes = new ArrayList<>();

        isDisplayedBy(lovList, 5);

        for (String label : labels) {
            String pattern = lovPattern.replace("filterName", label);
            By location = By.xpath(pattern);

            isDisplayedBy(filterSearchBox, 5);
            click(filterSearchBox);
            find(filterSearchBox).clear();
            find(filterSearchBox).sendKeys(label);

            WebElement filterCheck = find(location);
            checkBoxes.add(filterCheck);
            filterCheck.click();
        }
        return checkBoxes;
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
            Thread.sleep(2000);
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

    public void exclude() {
        isDisplayedBy(excludeToggle, 5);
        click(excludeToggle);
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

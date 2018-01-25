package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.ArrayList;
import java.util.List;

public class QOSOTemplateConfig extends Base {


    //QOSO TEMPLATE CONTROLS

    By amountDropdown = By.xpath("//div[@class='popupLabel' and contains (text(), ' Spend Amounts ')]/../div[2]");
    By quantityDropdown = By.xpath("//div[@class='popupLabel' and contains (text(), ' Quantities ')]/../div[2]");
    // THESE ARE INPUT XPATHS
    // By amountDropdown = By.xpath("//div[@class='popupLabel' and contains (text(), ' Spend Amounts ')]/../div[2]/div[3]/input");
    //By quantityDropdown = By.xpath("//div[@class='popupLabel' and contains (text(), ' Quantities ')]/../div[2]/div[3]/input");

    By anyValue = By.cssSelector("[data-value='ANY']");
    By atLeastValue = By.cssSelector("[data-value='GTE']");
    By atMostValue = By.cssSelector("[data-value='LTE']");
    By inBetweenValue = By.cssSelector("[data-value='IN_RANGE']");


    By inputAmount = By.xpath("//div[@class='popupLabel' and contains (text(), ' Spend Amounts ')]/../div[2]/div[2]/input");
    By inputQuantity = By.xpath("//div[@class='popupLabel' and contains (text(), ' Quantities ')]/../div[2]/div[2]/input");
    //*[@id="refine"]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/ul/li/div[2]/div[4]/div[1]/div/div[2]/div[2]/input[1]

    By inputSecondQuantity = By.xpath("//div[@class='popupLabel' and contains (text(), ' Quantities ')]/../div[2]/div[2]/input[2]");


    By valueSpendAmount = By.xpath("//li[@class='qoso base-rule-container rule-container']/div[2]/div[2]/div[1]/div/div[2]/div[2]/input[1]");
    By valueSpendAmountBetween1 = By.xpath("//li[@class='qoso base-rule-container rule-container']/div[2]/div[2]/div[1]/div/div[2]/div[2]/input[1]");
    By valueSpendAmountBetween2 = By.xpath("//li[@class='qoso base-rule-container rule-container']/div[2]/div[2]/div[1]/div/div[2]/div[2]/input[2]");

    By valueQuantityAmount = By.xpath("//li[@class='qoso base-rule-container rule-container']/div[2]/div[4]/div[1]/div/div[2]/div[2]/input[1]");
    By valueQuantityAmountBetween1 = By.xpath("//li[@class='qoso base-rule-container rule-container']/div[2]/div[4]/div[1]/div/div[2]/div[2]/input[1]");
    By valueQuantityAmountBetween2 = By.xpath("//li[@class='qoso base-rule-container rule-container']/div[2]/div[4]/div[1]/div/div[2]/div[2]/input[2]");

    By itemAnyProduct = By.xpath("//li[@class='dd-option' and contains (text(), 'any product')]");
    By itemDepartment = By.xpath("//li[@class='dd-option' and contains (text(), 'department')]");
    By itemCategory = By.xpath("//li[@class='dd-option' and contains (text(), 'category')]");
    By itemSubCategory = By.xpath("//li[@class='dd-option' and contains (text(), 'subcategory')]");
    By itemSKU = By.xpath("//li[@class='dd-option' and contains (text(), 'sku')]");
    By itemBrand = By.xpath("//li[@class='dd-option' and contains (text(), 'brand')]");

    By transactionAll = By.xpath("//li[@class='dd-option' and contains (text(), 'all transactions')]");
    By transactionAnySingle = By.xpath("//li[@class='dd-option' and contains (text(), 'any single transaction')]");


    By safeSpot = By.cssSelector(".time-range-image.cpm-sprite-Purchases_Group_Static");



    List<WebElement> qosoContainers = new ArrayList<>();


    public WebElement getGroup(int position, boolean refresh) {
        if ( refresh ) {
            findAddedQOSOContainers();
        }
        if ( position > qosoContainers.size() ) {
            throw new AssertionError("Invalid index. max indice is " + qosoContainers.size());
        }
        return qosoContainers.get(position - 1);
    }

    public int findAddedQOSOContainers() {
        qosoContainers = null;
        qosoContainers = driver.findElements(By.cssSelector(".qoso.base-rule-container.rule-container"));
        return qosoContainers.size();
    }


    //WHERE TO DROP THAT FILTERS IN QOSO CONTAINER
    public WebElement getQOSODropZone(int group, int qosoOrder) {
        findAddedQOSOContainers();
        WebElement dropZone = qosoContainers.get(group - 1).findElement(By.xpath("//div[@class='applied_filter_items']/div[" + group + "]/div[2]/div[1]/ul/li[" + qosoOrder + "]/div[3]/ul"));
        return dropZone;
    }


    // - QOSO CONTROLS - QOSO CONTROLS - QOSO CONTROLS - QOSO CONTROLS - QOSO CONTROLS - QOSO CONTROLS - QOSO CONTROLS - QOSO CONTROLS - QOSO CONTROLS

/*
    String filterGroupPattern = "//*[@id='refine']/div/div/div/div[2]/div[2]/div[2]/div[i]/div[2]/div[1]/ul";

    public WebElement findFilterGroup(int position) {
        By location = By.xpath(filterGroupPattern.replace("[i]", String.format("%s%d%s", "[", position, "]")));
        groups.add(position - 1, findString(location));
        return groups.get(position - 1);
    }
*/

    List<WebElement> inputValues = new ArrayList<>();

    public List<WebElement> getInputs() {
        return inputValues;
    }

    public WebElement getInput(int position) {
        return getInputPosition(position, false);
    }

    public WebElement getInput(int position, boolean refresh) {
        if ( refresh ) {
            findQuantityInputs();
        }
        if ( position > inputValues.size() ) {
            throw new AssertionError("Invalid index. max indice is " + groups.size());
        }
        return inputValues.get(position - 1);
    }

    public int findQuantityInputs() {
        inputValues = null;
        inputValues = driver.findElements(By.cssSelector("//div[@class='value val1' or @class=value val2']"));
        return inputValues.size();
    }

    public String getInputType(int position, boolean refresh) {
        String type = null;
        if ( position > inputValues.size() ) {
            return null;
        }
        WebElement group = inputValues.get(position - 1);
        type = group.getText();
        return type;
    }







    String qosoQuantityButtonPattern = "//*[@id='refine']/div/div/div/div[2]/div[2]/div[2]/divgroup/div[2]/div[1]/ul/liqosoOrderNumber/div[2]/div[4]/span";

    public WebElement qosoQuantity(int filterGroup, int qosoOrder, String amount, String... value) {
        findAddedQOSOContainers();
        By quantityButton = By.xpath(qosoQuantityButtonPattern.replace("group", String.format("%s%d%s", "[", filterGroup, "]")).replace("qosoOrderNumber", String.format("%s%d%s", "[", qosoOrder, "]")));
        isDisplayedBy(quantityButton, 5);
        click(quantityButton);
        isDisplayedBy(quantityDropdown, 5);
        click(quantityDropdown);

        if ( amount.equalsIgnoreCase("any quantity") ) {
            isDisplayedBy(anyValue, 5);
            click(anyValue);

            click(safeSpot);
        } else if ( amount.equalsIgnoreCase("at least") ) {
            isDisplayedBy(atLeastValue, 5);
            click(atLeastValue);
            isDisplayedBy(inputQuantity, 5);
            click(inputQuantity);
            find(inputQuantity).clear();
            find(inputQuantity).sendKeys(value);

            click(safeSpot);
        } else if ( amount.equalsIgnoreCase("at most") ) {
            isDisplayedBy(atMostValue, 5);
            click(atMostValue);
            isDisplayedBy(inputQuantity, 5);
            click(inputQuantity);
            find(inputQuantity).clear();
            find(inputQuantity).sendKeys(value);

            click(safeSpot);
        } else if ( amount.equalsIgnoreCase("between") ) {


            isDisplayedBy(inBetweenValue, 5);
            click(inBetweenValue);
            isDisplayedBy(inputQuantity, 5);
            click(inputQuantity);
            find(inputQuantity).clear();
            find(inputQuantity).sendKeys(value[0]);
            isDisplayedBy(inputSecondQuantity, 5);
            click(inputSecondQuantity);
            find(inputSecondQuantity).clear();
            find(inputSecondQuantity).sendKeys(value[1]);

            click(safeSpot);
        }

        return null;

    }

    String qosoAmountButtonPattern = "//*[@id='refine']/div/div/div/div[2]/div[2]/div[2]/divgroup/div[2]/div[1]/ul/liqosoOrderNumber/div[2]/div[2]/span";

    public WebElement qosoAmount(int filterGroup, int qosoOrder, String amount, String... value) {
        findAddedQOSOContainers();
        By amountButton = By.xpath(qosoAmountButtonPattern.replace("group", String.format("%s%d%s", "[", filterGroup, "]")).replace("qosoOrderNumber", String.format("%s%d%s", "[", qosoOrder, "]")));
        isDisplayedBy(amountButton, 5);
        click(amountButton);
        isDisplayedBy(amountDropdown, 5);
        click(amountDropdown);

        if ( amount.equalsIgnoreCase("any amount") ) {
            isDisplayedBy(anyValue, 5);
            click(anyValue);
        } else if ( amount.equalsIgnoreCase("at least") ) {
            isDisplayedBy(atLeastValue, 5);
            click(atLeastValue);
        } else if ( amount.equalsIgnoreCase("at most") ) {
            isDisplayedBy(atMostValue, 5);
            click(atMostValue);
        } else if ( amount.equalsIgnoreCase("between") ) {
            isDisplayedBy(inBetweenValue, 5);
            click(inBetweenValue);
        }

        isDisplayedBy(inputAmount, 5);
        click(inputAmount);
        find(inputAmount).clear();
        find(inputAmount).sendKeys(value);


        click(safeSpot);

        return null;

    }



}
package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class QOSOTemplateConfig extends Base {


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



    List<WebElement> inputValues = new ArrayList<>();

    public List<WebElement> getInputs() {
        return inputValues;
    }

    public WebElement getInput(int position) {
        return getInputPosition(position, false);
    }

    public WebElement getInputPosition(int position, boolean refresh) {
        if ( refresh ) {
            findQuantityInputs();
        }
        if ( position > inputValues.size() ) {
            throw new AssertionError("Invalid index. max indice is " + inputValues.size());
        }
        return inputValues.get(position - 1);
    }

    public int findQuantityInputs() {
        inputValues = null;
        inputValues = driver.findElements(By.xpath("//div[@class='value val1' or @class='value val2']"));
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



    // OVERALL QOSO ELEMENTS
    String qosoContainer = "//*[@id='refine']/div/div/div/div[2]/div[2]/div[2]/divgroup/div[2]/div[1]/ul/liqosoOrderNumber";



    //AMOUNT SPECIFIC ELEMENTS
  // @FindBy(className = )


   @FindBy(xpath = "//div[@class='inline-description']/div[2]/span")
   public WebElement amountButton;

    //By amountButton = By.xpath("//div[@class='inline-description']/div[2]/span");

    @FindBy (xpath = "//div[@class='popupLabel' and contains (text(), ' Spend Amounts ')]/../div[2]")
    public WebElement amountDropdown;

    @FindBy (xpath = "//div[@class='popupLabel' and contains (text(), ' Spend Amounts ')]/../div[2]/ul/li[1]")
    public WebElement amountAnyAmount;

    @FindBy (xpath = "//div[@class='popupLabel' and contains (text(), ' Spend Amounts ')]/../div[2]/ul/li[2]")
    public WebElement amountAtLeast;

    @FindBy(xpath = "//div[@class='popupLabel' and contains (text(), ' Spend Amounts ')]/../div[2]/ul/li[3]")
    public WebElement amountAtMost;

    @FindBy(xpath = "//div[@class='popupLabel' and contains (text(), ' Spend Amounts ')]/../div[2]/ul/li[4]")
    public WebElement amountBetween;

    @FindBy(xpath = "//div[@class='popupLabel' and contains (text(), ' Spend Amounts ')]/../div[2]/div[2]/input")
    public WebElement inputAmount;

    @FindBy(xpath = "//div[@class='popupLabel' and contains (text(), ' Spend Amounts ')]/../div[2]/div[2]/input[2]")
    public WebElement inputSecondAmount;



    public WebElement qosoAmount(int filterGroup, int qosoOrder, String amount, String... value) {
        findAddedQOSOContainers();

        By foundQOSOContainer = By.xpath(qosoContainer.replace("group", String.format("%s%d%s", "[", filterGroup, "]")).replace("qosoOrderNumber", String.format("%s%d%s", "[", qosoOrder, "]")));
        //By foundQOSOContainer = (By)By.xpath(qosoContainer.replace("group", String.format("%s%d%s", "[", filterGroup, "]")).replace("qosoOrderNumber", String.format("%s%d%s", "[", qosoOrder, "]")));

        By amountButton1 = By.xpath("//div[@class='inline-description']/div[2]/span");

        isDisplayed(foundQOSOContainer.findElement(amountButton),5);
        foundQOSOContainer.findElement(amountButton).click();

        isDisplayed(foundQOSOContainer.findElement(amountDropdown), 5);
        foundQOSOContainer.findElement(amountDropdown).click();


        if ( amount.equalsIgnoreCase("any quantity") ) {
            isDisplayed(foundQOSOContainer.findElement(amountAnyAmount), 5);
            foundQOSOContainer.findElement(amountAnyAmount).click();
            click(safeSpot);
        } else if ( amount.equalsIgnoreCase("at least") ) {
            isDisplayed(foundQOSOContainer.findElement(amountAtLeast), 5);
            foundQOSOContainer.findElement(amountAtLeast).click();
            findQuantityInputs();
            isDisplayed(foundQOSOContainer.findElement(inputAmount), 5);
            foundQOSOContainer.findElement(inputAmount).click();
            foundQOSOContainer.findElement(inputAmount).clear();
            foundQOSOContainer.findElement(inputAmount).sendKeys(value);
            click(safeSpot);
        } else if ( amount.equalsIgnoreCase("at most") ) {
            isDisplayed(foundQOSOContainer.findElement(amountAtMost), 5);
            foundQOSOContainer.findElement(amountAtMost).click();
            findQuantityInputs();
            isDisplayed(foundQOSOContainer.findElement(inputAmount), 5);
            foundQOSOContainer.findElement(inputAmount).click();
            foundQOSOContainer.findElement(inputAmount).clear();
            foundQOSOContainer.findElement(inputAmount).sendKeys(value);
            click(safeSpot);
        } else if ( amount.equalsIgnoreCase("between") ) {
            isDisplayed(foundQOSOContainer.findElement(amountBetween), 5);
            foundQOSOContainer.findElement(amountBetween).click();
            findQuantityInputs();
            isDisplayed(foundQOSOContainer.findElement(inputAmount), 5);
            foundQOSOContainer.findElement(inputAmount).click();
            foundQOSOContainer.findElement(inputAmount).clear();
            foundQOSOContainer.findElement(inputAmount).sendKeys(value);
            isDisplayed(foundQOSOContainer.findElement(inputSecondAmount), 5);
            foundQOSOContainer.findElement(inputSecondAmount).click();
            foundQOSOContainer.findElement(inputSecondAmount).clear();
            foundQOSOContainer.findElement(inputSecondAmount).sendKeys(value[1]);
            click(safeSpot);
        }
        return null;
    }


    //QUANTITY SPECIFIC ELEMENTS

    @FindBy(xpath = "//div[@class='inline-description']/div[4]/span")
    public WebElement quantityButton;

    @FindBy(xpath = "//div[@class='popupLabel' and contains (text(), ' Quantities ')]/../div[2]")
    public WebElement quantityDropDown;

    @FindBy(xpath = "//div[@class='popupLabel' and contains (text(), ' Quantities ')]/../div[2]/ul/li[1]")
    public WebElement quantityAnyQuantity;

    @FindBy(xpath = "//div[@class='popupLabel' and contains (text(), ' Quantities ')]/../div[2]/ul/li[2]")
    public WebElement quantityAtLeast;

    @FindBy(xpath = "//div[@class='popupLabel' and contains (text(), ' Quantities ')]/../div[2]/ul/li[3]")
    public WebElement quantityAtMost;

    @FindBy(xpath = "//div[@class='popupLabel' and contains (text(), ' Quantities ')]/../div[2]/ul/li[4]")
    public WebElement quantityBetween;

    @FindBy(xpath = "//div[@class='popupLabel' and contains (text(), ' Quantities ')]/../div[2]/div[2]/input")
    public WebElement inputQuantity;

    @FindBy(xpath = "//div[@class='popupLabel' and contains (text(), ' Quantities ')]/../div[2]/div[2]/input[2]")
    public WebElement inputSecondQuantity;


    public WebElement qosoQuantity(int filterGroup, int qosoOrder, String amount, String... value) {
        findAddedQOSOContainers();

        By foundQOSOContainer = By.xpath(qosoContainer.replace("group", String.format("%s%d%s", "[", filterGroup, "]")).replace("qosoOrderNumber", String.format("%s%d%s", "[", qosoOrder, "]")));

        isDisplayed(foundQOSOContainer.findElement(quantityButton),5);
        foundQOSOContainer.findElement(quantityButton);

        isDisplayed(foundQOSOContainer.findElement(quantityDropDown), 5);
        foundQOSOContainer.findElement(quantityDropDown).click();


        if ( amount.equalsIgnoreCase("any quantity") ) {
            isDisplayed(foundQOSOContainer.findElement(quantityAnyQuantity), 5);
            foundQOSOContainer.findElement(quantityAnyQuantity).click();
            click(safeSpot);
        } else if ( amount.equalsIgnoreCase("at least") ) {
            isDisplayed(foundQOSOContainer.findElement(quantityAtLeast), 5);
            foundQOSOContainer.findElement(quantityAtLeast).click();
            findQuantityInputs();
            isDisplayed(foundQOSOContainer.findElement(inputQuantity), 5);
            foundQOSOContainer.findElement(inputQuantity).click();
            foundQOSOContainer.findElement(inputQuantity).clear();
            foundQOSOContainer.findElement(inputQuantity).sendKeys(value);
            click(safeSpot);
        } else if ( amount.equalsIgnoreCase("at most") ) {
            isDisplayed(foundQOSOContainer.findElement(quantityAtMost), 5);
            foundQOSOContainer.findElement(quantityAtMost).click();
            findQuantityInputs();
            isDisplayed(foundQOSOContainer.findElement(inputQuantity), 5);
            foundQOSOContainer.findElement(inputQuantity).click();
            foundQOSOContainer.findElement(inputQuantity).clear();
            foundQOSOContainer.findElement(inputQuantity).sendKeys(value);
            click(safeSpot);
        } else if ( amount.equalsIgnoreCase("between") ) {
            isDisplayed(foundQOSOContainer.findElement(quantityBetween), 5);
            foundQOSOContainer.findElement(quantityBetween).click();
            findQuantityInputs();
            isDisplayed(foundQOSOContainer.findElement(inputQuantity), 5);
            foundQOSOContainer.findElement(inputQuantity).click();
            foundQOSOContainer.findElement(inputQuantity).clear();
            foundQOSOContainer.findElement(inputQuantity).sendKeys(value);
            isDisplayed(foundQOSOContainer.findElement(inputSecondQuantity), 5);
            foundQOSOContainer.findElement(inputSecondQuantity).click();
            foundQOSOContainer.findElement(inputSecondQuantity).clear();
            foundQOSOContainer.findElement(inputSecondQuantity).sendKeys(value[1]);
            click(safeSpot);
        }
        return null;
    }


    // Item/Product specific controls

    String lovPattern = "//div[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']//*[contains(text(), 'filterName')]/../div[1]/i";

    @FindBy(xpath = "//div[@class='inline-description']/div[6]/span")
    public WebElement itemButton;

    @FindBy(xpath = "//div[@class='popupLabel' and contains (text(), ' Items ')]/../div[2]")
    public WebElement itemDropdown;

    @FindBy(xpath = "//div[@class='popupLabel' and contains (text(), ' Items ')]/../div[2]/ul/li[1]")
    public WebElement itemAnyProduct;

    @FindBy(xpath = "//div[@class='popupLabel' and contains (text(), ' Items ')]/../div[2]/ul/li[2]")
    public WebElement itemDepartment;

    @FindBy(xpath = "//div[@class='popupLabel' and contains (text(), ' Items ')]/../div[2]/ul/li[3]")
    public WebElement itemCategory;

    @FindBy(xpath = "//div[@class='popupLabel' and contains (text(), ' Items ')]/../div[2]/ul/li[4]")
    public WebElement itemSubCategory;

    @FindBy(xpath = "//div[@class='popupLabel' and contains (text(), ' Items ')]/../div[2]/ul/li[5]")
    public WebElement itemSKU;

    @FindBy(xpath = "//div[@class='popupLabel' and contains (text(), ' Items ')]/../div[2]/ul/li[5]")
    public WebElement itemBrand;

    @FindBy(xpath = "//div[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']")
    public WebElement lovList;

    @FindBy(xpath = "//div[@class='lov-area']//*[@class='form-control search-query textSelectable']")
    public WebElement filterSearchBox;

    public void qosoItems(int filterGroup, int qosoOrder, String itemLevel, String... values) {
        findAddedQOSOContainers();

        By foundQOSOContainer = By.xpath(qosoContainer.replace("group", String.format("%s%d%s", "[", filterGroup, "]")).replace("qosoOrderNumber", String.format("%s%d%s", "[", qosoOrder, "]")));

        isDisplayed(foundQOSOContainer.findElement(itemButton),5);
        foundQOSOContainer.findElement(itemButton);

        isDisplayed(foundQOSOContainer.findElement(itemDropdown), 5);
        foundQOSOContainer.findElement(itemDropdown).click();


        if ( itemLevel.equalsIgnoreCase("any product") ) {
            isDisplayed(foundQOSOContainer.findElement(itemAnyProduct), 5);
            foundQOSOContainer.findElement(itemAnyProduct).click();
        } else if ( itemLevel.equalsIgnoreCase("department") ) {
            isDisplayed(foundQOSOContainer.findElement(itemDepartment), 5);
            foundQOSOContainer.findElement(itemDepartment).click();
            List<WebElement> checkBoxes = new ArrayList<>();


        } else if ( itemLevel.equalsIgnoreCase("category") ) {
            isDisplayed(foundQOSOContainer.findElement(itemCategory), 5);
            foundQOSOContainer.findElement(itemCategory).click();
        } else if ( itemLevel.equalsIgnoreCase("subcategory") ) {
            isDisplayed(foundQOSOContainer.findElement(itemSubCategory), 5);
            foundQOSOContainer.findElement(itemSubCategory).click();
        } else if ( itemLevel.equalsIgnoreCase("SKU") ) {
            isDisplayed(foundQOSOContainer.findElement(itemSKU), 5);
            foundQOSOContainer.findElement(itemSKU).click();
        } else if ( itemLevel.equalsIgnoreCase("SKU") ) {
            isDisplayed(foundQOSOContainer.findElement(itemSKU), 5);
            foundQOSOContainer.findElement(itemSKU).click();
        } else if ( itemLevel.equalsIgnoreCase("Brand") ) {
            isDisplayed(foundQOSOContainer.findElement(itemBrand), 5);
            foundQOSOContainer.findElement(itemBrand).click();
        }

        isDisplayed(foundQOSOContainer.findElement(lovList), 5);
        List<WebElement> checkBoxes = new ArrayList<>();
        for (String value : values) {
            String pattern = lovPattern.replace("filterName", value);
            By location = By.xpath(pattern);

            isDisplayed(foundQOSOContainer.findElement(filterSearchBox),5);
            foundQOSOContainer.findElement(filterSearchBox).click();
            foundQOSOContainer.findElement(filterSearchBox).clear();
            foundQOSOContainer.findElement(filterSearchBox).sendKeys(value);

            WebElement filterCheck = find(location);
            checkBoxes.add(filterCheck);
            filterCheck.click();
        }
        click(safeSpot);

    }



    //Transaction Specific Controls

    @FindBy(xpath = "//div[@class='inline-description']/div[8]/span")
    public WebElement transactionButton;

    @FindBy(xpath = "//div[@class='popupLabel' and contains (text(), ' Transactions ')]/../div[2]")
    public WebElement transactionDropdown;

    @FindBy(xpath = "//li[@class='dd-option' and contains (text(), 'all transactions')]")
    public WebElement transactionAll;

    @FindBy(xpath = "//li[@class='dd-option' and contains (text(), 'any single transaction')]")
    public WebElement transactionAnySingle;


    public WebElement qosoTransactions(int filterGroup, int qosoOrder, String transaction) {
        findAddedQOSOContainers();

        By foundQOSOContainer = By.xpath(qosoContainer.replace("group", String.format("%s%d%s", "[", filterGroup, "]")).replace("qosoOrderNumber", String.format("%s%d%s", "[", qosoOrder, "]")));

        isDisplayed(foundQOSOContainer.findElement(transactionButton),5);
        foundQOSOContainer.findElement(transactionButton);

        isDisplayed(foundQOSOContainer.findElement(transactionDropdown), 5);
        foundQOSOContainer.findElement(transactionDropdown).click();


        if ( transaction.equalsIgnoreCase("all") ) {
            isDisplayed(foundQOSOContainer.findElement(transactionAll), 5);
            foundQOSOContainer.findElement(transactionAll).click();

        } else if ( transaction.equalsIgnoreCase("any") ) {
            isDisplayed(foundQOSOContainer.findElement(transactionAnySingle), 5);
            foundQOSOContainer.findElement(transactionAnySingle).click();
        }
        click(safeSpot);
        return null;
    }



}
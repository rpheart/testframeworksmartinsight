package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


import java.util.ArrayList;
import java.util.List;

public class QOSOTemplateConfig extends Base {


    By safeSpot = By.cssSelector(".applied_filter_area_title_bar");

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
    String qosoAmountButton = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]/div[2]/div[2]/span";
    String qosoAmountDropdown = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Spend Amounts ')]/../div[2]";
    String qosoAmountAnyAmount = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Spend Amounts ')]/../div[2]/ul/li[1]";
    String qosoAmountAtLeast = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Spend Amounts ')]/../div[2]/ul/li[2]";
    String qosoAmountAtMost = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Spend Amounts ')]/../div[2]/ul/li[3]";
    String qosoAmountBetween = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Spend Amounts ')]/../div[2]/ul/li[4]";
    String qosoAmountInput = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Spend Amounts ')]/../div[2]/div[2]/input[1]";
    String qosoAmountSecondInput = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Spend Amounts ')]/../div[2]/div[2]/input[2]";


    public WebElement setQosoAmount(int filterGroup, int qosoOrder, String amount, String... value) {
        findAddedQOSOContainers();

        By foundAmountButton = By.xpath(qosoAmountButton.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
        WebElement amountButton = find(foundAmountButton);
        isDisplayed(amountButton, 5);
        amountButton.click();

        By foundAmountDropdown = By.xpath(qosoAmountDropdown.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
        WebElement amountDropDown = find(foundAmountDropdown);
        isDisplayed(amountDropDown, 5);
        amountDropDown.click();

        By foundAmountInput = By.xpath(qosoAmountInput.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
        WebElement amountInput = find(foundAmountInput);

        By foundAmountSecondInput = By.xpath(qosoAmountSecondInput.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
        WebElement amountSecondInput = find(foundAmountSecondInput);

        if ( amount.equalsIgnoreCase("any quantity") ) {
            By foundAmountAnyAmount = By.xpath(qosoAmountAnyAmount.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
            WebElement amountAnyAmount = find(foundAmountAnyAmount);
            isDisplayed(amountAnyAmount, 5);
            amountAnyAmount.click();
            click(safeSpot);
        } else if ( amount.equalsIgnoreCase("at least") ) {
            By foundAmountAtLeast = By.xpath(qosoAmountAtLeast.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
            WebElement amountAtLeast = find(foundAmountAtLeast);
            isDisplayed(amountAtLeast, 5);
            amountAtLeast.click();
            isDisplayed(amountInput, 5);
            amountInput.click();
            amountInput.clear();
            amountInput.sendKeys(value[0]);
            click(safeSpot);
        } else if ( amount.equalsIgnoreCase("at most") ) {
            By foundAmountAtMost = By.xpath(qosoAmountAtMost.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
            WebElement amountAtMost = find(foundAmountAtMost);
            isDisplayed(amountAtMost, 5);
            amountAtMost.click();
            isDisplayed(amountInput, 5);
            amountInput.click();
            amountInput.clear();
            amountInput.sendKeys(value[0]);
            click(safeSpot);
        } else if ( amount.equalsIgnoreCase("between") ) {
            By foundAmountBetween = By.xpath(qosoAmountBetween.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
            WebElement amountBetween = find(foundAmountBetween);
            isDisplayed(amountBetween, 5);
            amountBetween.click();
            isDisplayed(amountInput, 5);
            amountInput.click();
            amountInput.clear();
            amountInput.sendKeys(value[0]);
            isDisplayed(amountSecondInput, 5);
            amountSecondInput.click();
            amountSecondInput.clear();
            amountSecondInput.sendKeys(value[1]);
            click(safeSpot);
        }
        return null;
    }

    String amountValueDisplayed;

    public Boolean checkQosoAmount(int filterGroup, int qosoOrder, String amountAndValue) {
        findAddedQOSOContainers();
        By foundAmountButton = By.xpath(qosoAmountButton.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
        WebElement amountButton = find(foundAmountButton);
        isDisplayed(amountButton, 5);
        amountValueDisplayed = amountButton.getText();
        if ( amountValueDisplayed.equalsIgnoreCase(amountAndValue) ) {
            return true;
        }
    return false;
    }

    //QUANTITY SPECIFIC ELEMENTS

    String qosoQuantityButton = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]/div[2]/div[4]/span";
    String qosoQuantityDropdown = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Quantities ')]/../div[2]";
    String qosoQuantityAnyAmount = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Quantities ')]/../div[2]/ul/li[1]";
    String qosoQuantityAtLeast = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Quantities ')]/../div[2]/ul/li[2]";
    String qosoQuantityAtMost = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Quantities ')]/../div[2]/ul/li[3]";
    String qosoQuantityBetween = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Quantities ')]/../div[2]/ul/li[4]";
    String qosoQuantityInput = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Quantities ')]/../div[2]/div[2]/input[1]";
    String qosoQuantitySecondInput = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Quantities ')]/../div[2]/div[2]/input[2]";

    public WebElement setQosoQuantity(int filterGroup, int qosoOrder, String quantity, String... value) {
        findAddedQOSOContainers();

        By foundQuantityButton = By.xpath(qosoQuantityButton.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
        WebElement quantityButton = find(foundQuantityButton);
        isDisplayed(quantityButton, 5);
        quantityButton.click();

        By foundQuantityDropdown = By.xpath(qosoQuantityDropdown.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
        WebElement quantityDropdown = find(foundQuantityDropdown);
        isDisplayed(quantityDropdown, 5);
        quantityDropdown.click();

        By foundQuantityInput = By.xpath(qosoQuantityInput.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
        WebElement quantityInput = find(foundQuantityInput);

        By foundQuantitySecondInput = By.xpath(qosoQuantitySecondInput.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
        WebElement quantitySecondInput = find(foundQuantitySecondInput);

        if ( quantity.equalsIgnoreCase("any quantity") ) {
            By foundQuantityAnyAmount = By.xpath(qosoQuantityAnyAmount.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
            WebElement quantityAnyAmount = find(foundQuantityAnyAmount);
            isDisplayed(quantityAnyAmount, 5);
            quantityAnyAmount.click();
            click(safeSpot);
        } else if ( quantity.equalsIgnoreCase("at least") ) {
            By foundQuantityAtLeast = By.xpath(qosoQuantityAtLeast.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
            WebElement quantityAtLeast = find(foundQuantityAtLeast);
            isDisplayed(quantityAtLeast, 5);
            quantityAtLeast.click();
            isDisplayed(quantityInput, 5);
            quantityInput.click();
            quantityInput.clear();
            quantityInput.sendKeys(value[0]);
            click(safeSpot);
        } else if ( quantity.equalsIgnoreCase("at most") ) {
            By foundQuantityAtMost = By.xpath(qosoQuantityAtMost.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
            WebElement quantityAtMost = find(foundQuantityAtMost);
            isDisplayed(quantityAtMost, 5);
            quantityAtMost.click();
            isDisplayed(quantityInput, 5);
            quantityInput.click();
            quantityInput.clear();
            quantityInput.sendKeys(value[0]);
            click(safeSpot);
        } else if ( quantity.equalsIgnoreCase("between") ) {
            By foundQuantityBetween = By.xpath(qosoQuantityBetween.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
            WebElement quantityBetween = find(foundQuantityBetween);
            isDisplayed(quantityBetween, 5);
            quantityBetween.click();
            isDisplayed(quantityInput, 5);
            quantityInput.click();
            quantityInput.clear();
            quantityInput.sendKeys(value[0]);
            isDisplayed(quantitySecondInput, 5);
            quantitySecondInput.click();
            quantitySecondInput.clear();
            quantitySecondInput.sendKeys(value[1]);
            click(safeSpot);
        }
        return null;
    }

    String quantityValueDisplayed;

    public Boolean checkQosoQuantity(int filterGroup, int qosoOrder, String amountAndValue) {
        findAddedQOSOContainers();
        By foundQuantityButton = By.xpath(qosoQuantityButton.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
        WebElement quantityButton = find(foundQuantityButton);
        isDisplayed(quantityButton, 5);
        quantityValueDisplayed = quantityButton.getText();
        System.out.println(amountAndValue);
        System.out.println(quantityValueDisplayed);
        if ( quantityValueDisplayed.equalsIgnoreCase(amountAndValue) ) {
            return true;
        }
        return false;
    }

/*    public Boolean qosoAmountSuccess(int filterGroup, int qosoOrder, String amountAndValue) {
        findAddedQOSOContainers();
        By foundAmountButton = By.xpath(qosoAmountButton.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
        WebElement amountButton = find(foundAmountButton);
        isDisplayed(amountButton, 5);
        amountValueDisplayed = amountButton.getText();
        if ( amountValueDisplayed.equalsIgnoreCase(amountAndValue) ) {
            return true;
        }
    return false;
    }*/

    // Item/Product specific controls

    String qosoItemButton = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]/div[2]/div[6]/span";
    String qosoItemDropdown = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Items ')]/../div[2]";
    String qosoItemAnyProduct = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Items ')]/../div[2]/ul/li[1]";
    String qosoItemDepartment = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Items ')]/../div[2]/ul/li[2]";
    String qosoItemCategory = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Items ')]/../div[2]/ul/li[3]";
    String qosoItemSubCategory = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Items ')]/../div[2]/ul/li[4]";
    String qosoItemSKU = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Items ')]/../div[2]/ul/li[5]";
    String qosoItemBrand = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Items ')]/../div[2]/ul/li[6]";

    String lovPattern = "//div[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']//*[contains(text(), \"filterName\")]/../div[1]/i";

    @FindBy(xpath = "//div[@class='lov-area']//*[@class='form-control search-query textSelectable']")
    public WebElement filterSearchBox;

    By qosoFilterSearchTextBox = By.xpath("//div[@class='lov-area']//*[@class='form-control search-query textSelectable']");
    By filterSearchtextBox = By.xpath("//div[@id='modalFilterContents']//*[@class='form-control search-query textSelectable']");


    public void setQosoItems(int filterGroup, int qosoOrder, String itemLevel, String... LOVs) {
        findAddedQOSOContainers();

        By foundItemButton = By.xpath(qosoItemButton.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
        WebElement itemButton = find(foundItemButton);
        isDisplayed(itemButton, 5);
        itemButton.click();

        By foundItemDropdown = By.xpath(qosoItemDropdown.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
        WebElement itemDropDown = find(foundItemDropdown);
        isDisplayed(itemDropDown, 5);
        itemDropDown.click();

        if ( itemLevel.equalsIgnoreCase("any product") ) {
            By foundItemAnyProduct = By.xpath(qosoItemAnyProduct.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
            WebElement itemAnyProduct = find(foundItemAnyProduct);
            isDisplayed(itemAnyProduct, 5);
            itemAnyProduct.click();
            click(safeSpot);
        } else if ( itemLevel.equalsIgnoreCase("department") ) {
            By foundItemDepartment = By.xpath(qosoItemDepartment.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
            WebElement itemDepartment = find(foundItemDepartment);
            isDisplayed(itemDepartment, 5);
            itemDepartment.click();

            List<WebElement> checkBoxes = new ArrayList<>();
            for (String lov : LOVs) {
                String pattern = lovPattern.replace("filterName", lov);
                By location = By.xpath(pattern);

                isDisplayed(filterSearchBox,5);
                filterSearchBox.click();
                filterSearchBox.clear();
                filterSearchBox.sendKeys(lov);

                WebElement filterCheck = find(location);
                checkBoxes.add(filterCheck);
                filterCheck.click();
            }
            click(safeSpot);
        } else if ( itemLevel.equalsIgnoreCase("category") ) {
            By foundItemCategory = By.xpath(qosoItemCategory.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
            WebElement itemCategory = find(foundItemCategory);
            isDisplayed(itemCategory, 5);
            itemCategory.click();

            List<WebElement> checkBoxes = new ArrayList<>();
            for (String lov : LOVs) {
                String pattern = lovPattern.replace("filterName", lov);
                By location = By.xpath(pattern);

                isDisplayed(filterSearchBox,5);
                filterSearchBox.click();
                filterSearchBox.clear();
                filterSearchBox.sendKeys(lov);

                WebElement filterCheck = find(location);
                checkBoxes.add(filterCheck);
                filterCheck.click();
            }
            click(safeSpot);
        } else if ( itemLevel.equalsIgnoreCase("subcategory") ) {
            By foundItemSubCategory = By.xpath(qosoItemSubCategory.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
            WebElement itemSubCategory = find(foundItemSubCategory);
            isDisplayed(itemSubCategory, 5);
            itemSubCategory.click();

            List<WebElement> checkBoxes = new ArrayList<>();
            for (String lov : LOVs) {
                String pattern = lovPattern.replace("filterName", lov);
                By location = By.xpath(pattern);

                isDisplayed(filterSearchBox,5);
                filterSearchBox.click();
                filterSearchBox.clear();
                filterSearchBox.sendKeys(lov);

                WebElement filterCheck = find(location);
                checkBoxes.add(filterCheck);
                filterCheck.click();
            }
            click(safeSpot);
        } else if ( itemLevel.equalsIgnoreCase("SKU") ) {
            By foundItemSKU = By.xpath(qosoItemSKU.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
            WebElement itemSKU = find(foundItemSKU);
            isDisplayed(itemSKU, 5);
            itemSKU.click();

            List<WebElement> checkBoxes = new ArrayList<>();
            for (String lov : LOVs) {
                String pattern = lovPattern.replace("filterName", lov);
                By location = By.xpath(pattern);

                isDisplayed(filterSearchBox,5);
                filterSearchBox.click();
                filterSearchBox.clear();
                filterSearchBox.sendKeys(lov);

                WebElement filterCheck = find(location);
                checkBoxes.add(filterCheck);
                filterCheck.click();
            }
            click(safeSpot);
        } else if ( itemLevel.equalsIgnoreCase("Brand") ) {
            By foundItemBrand = By.xpath(qosoItemBrand.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
            WebElement itemSKU = find(foundItemBrand);
            isDisplayed(itemSKU, 5);
            itemSKU.click();

            List<WebElement> checkBoxes = new ArrayList<>();
            for (String lov : LOVs) {
                String pattern = lovPattern.replace("filterName", lov);
                By location = By.xpath(pattern);

                isDisplayed(filterSearchBox, 5);
                filterSearchBox.click();
                filterSearchBox.clear();
                filterSearchBox.sendKeys(lov);

                WebElement filterCheck = find(location);
                checkBoxes.add(filterCheck);
                filterCheck.click();
            }
            click(safeSpot);
        }
    }


    String itemValuesDisplayed;
    String appliedFilterTemplate = "//div[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]/div[3]/ul/li/div/div[@class='available-filter' and contains (text(), 'appliedFilter')]";
    String lovCheckedPattern = "//div[@class='ui-widget-content slick-row even' or @class='ui-widget-content slick-row odd']//*[text()= \"lovValue\"]/../div[1]/i[@class = 'insightsCheckBox topOffsetSevenPx checked']";
    String lovNotCheckedPattern = "//div[@class='ui-widget-content slick-row even' or @class='ui-widget-content slick-row odd']//*[text()= \"lovValue\"]/../div[1]/i[@class = 'insightsCheckBox topOffsetSevenPx']";
    List<WebElement> checkBoxes = new ArrayList<>();

    By saveFilterButton = By.cssSelector(".btn.saveBtn.modalFilterSave");

    public void saveFilter() {
        isDisplayedBy(saveFilterButton, 5);
        click(saveFilterButton);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exception) {

        }
    }

    public Boolean checkQosoItems(int filterGroup, int qosoOrder, String itemLevel, String... labels) {
        findAddedQOSOContainers();
        By foundItemButton = By.xpath(qosoItemButton.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
        WebElement itemButton = find(foundItemButton);
        isDisplayed(itemButton, 5);
        itemValuesDisplayed = itemButton.getText();
        itemButton.click();

        if ( !itemValuesDisplayed.contains(itemLevel) ) {
            return false;
        }

        for (String label : labels) {
            String pattern = lovCheckedPattern.replace("lovValue", label);
            By location = By.xpath(pattern);

            isDisplayedBy(qosoFilterSearchTextBox, 5);

            click(qosoFilterSearchTextBox);
            find(qosoFilterSearchTextBox).clear();
            find(qosoFilterSearchTextBox).sendKeys(label);

            WebElement filterCheck = find(location);
            checkBoxes.add(filterCheck);
            filterCheck.getText();

            if ( !filterCheck.isDisplayed() ) {
                return false;
            }
        }
        click(safeSpot);
        return true;

    }



    public boolean checkQosoLovChecked(String filterGroup, String qosoOrder, String filter, String... labels) {
        findAddedQOSOContainers();
        String foundItemButton = appliedFilterTemplate.replace("group", filterGroup).replace("qosoOrderNumber",  qosoOrder).replace("appliedFilter", filter);
        By theAppliedFilter = By.xpath(foundItemButton);
        WebElement appliedFilter = find(theAppliedFilter);
        doubleClick(appliedFilter);
        isDisplayed(filterSearchBox, 5);

        for (String label : labels) {
            String pattern = lovCheckedPattern.replace("lovValue", label);
            By location = By.xpath(pattern);

            isDisplayedBy(filterSearchtextBox, 5);

            click(filterSearchtextBox);
            find(filterSearchtextBox).clear();
            find(filterSearchtextBox).sendKeys(label);

            WebElement filterCheck = find(location);
            checkBoxes.add(filterCheck);
            filterCheck.getText();

            if ( !filterCheck.isDisplayed() ) {
                return false;
            }
        }
        saveFilter();
        return true;

    }

    public boolean checkQosoLovNotChecked(String filterGroup, String qosoOrder, String filter, String... labels) {
        findAddedQOSOContainers();
        String foundItemButton = appliedFilterTemplate.replace("group", filterGroup).replace("qosoOrderNumber", qosoOrder).replace("appliedFilter",  filter);
        By theAppliedFilter = By.xpath(foundItemButton);
        WebElement appliedFilter = find(theAppliedFilter);
        doubleClick(appliedFilter);
        isDisplayed(filterSearchBox, 5);

        for (String label : labels) {
            String pattern = lovNotCheckedPattern.replace("lovValue", label);
            By location = By.xpath(pattern);

            isDisplayedBy(filterSearchtextBox, 5);

            click(filterSearchtextBox);
            find(filterSearchtextBox).clear();
            find(filterSearchtextBox).sendKeys(label);

            WebElement filterCheck = find(location);
            checkBoxes.add(filterCheck);
            filterCheck.getText();

            if ( !filterCheck.isDisplayed() ) {
                return false;
            }
        }
        saveFilter();
        return true;

    }


    //Transaction Specific Controls
    String qosoTransactionButton = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]/div[2]/div[8]/span";
    String qosoTransactionDropdown = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Transactions ')]/../div[2]";
    String qosoTransactionAll = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Transactions ')]/../div[2]/ul/li[1]";
    String qosoTransactionAnySingle = "//*[@class='applied_filter_items']/div[group]/div[2]/div[1]/ul/li[qosoOrderNumber]//div[@class='popupLabel' and contains (text(), ' Transactions ')]/../div[2]/ul/li[2]";

    public WebElement setQosoTransactions(int filterGroup, int qosoOrder, String transaction) {
        findAddedQOSOContainers();

        By foundTransactionButton = By.xpath(qosoTransactionButton.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
        WebElement transactionButton = find(foundTransactionButton);
        isDisplayed(transactionButton, 5);

        transactionButton.click();

        By foundTransactionDropdown = By.xpath(qosoTransactionDropdown.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
        WebElement transactionDropDown = find(foundTransactionDropdown);
        isDisplayed(transactionDropDown, 5);
        transactionDropDown.click();

        if ( transaction.equalsIgnoreCase("all") ) {
            By foundTransactionAll = By.xpath(qosoTransactionAll.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
            WebElement transactionsAll = find(foundTransactionAll);
            isDisplayed(transactionsAll, 5);
            transactionsAll.click();
        } else if ( transaction.equalsIgnoreCase("any") ) {
            By foundTransactionAnySingle = By.xpath(qosoTransactionAnySingle.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
            WebElement transactionAnySingle = find(foundTransactionAnySingle);
            isDisplayed(transactionAnySingle, 5);
            transactionAnySingle.click();
        }
        click(safeSpot);
        return null;
    }


    public Boolean checkQosoTransaction(int filterGroup, int qosoOrder, String transactionType) {
        findAddedQOSOContainers();
        By foundTransactionButton = By.xpath(qosoTransactionButton.replace("group", String.format("%d", filterGroup)).replace("qosoOrderNumber", String.format("%d", qosoOrder)));
        WebElement transactionButton = find(foundTransactionButton);
        isDisplayed(transactionButton, 5);
        itemValuesDisplayed = transactionButton.getText();
        System.out.print(itemValuesDisplayed);
        System.out.print(transactionType);
        if ( itemValuesDisplayed.contains(transactionType) ) {
            return true;
        }
        return false;


    }









}

 /*       By foundQOSOContainer = By.xpath(qosoContainer.replace("group", String.format("%s%d%s", "[", filterGroup, "]")).replace("qosoOrderNumber", String.format("%s%d%s", "[", qosoOrder, "]")));

        WebElement qoso = find(foundQOSOContainer);
        WebElement AB = (qoso.findElement(By.xpath("//div[@class='inline-description']/div[2]/span")));

        isDisplayed(AB, 5);
        AB.click();
*/

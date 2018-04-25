package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;
import java.util.List;

import static org.testng.FileAssert.fail;


public class Analyze extends Base {


    By modal = By.cssSelector(".grid-canvas");
    By deleteSegmentButton = By.cssSelector(".delete-icon");
    By confirmDeleteButton = By.cssSelector(".btn.okBtn");
    // By confirmDeleteButton = By.xpath("//*[@class='btn okBtn']//*[text()='Remove']");

    By unSelectAll = By.xpath("//div[@class='selectAllDiv']/a[2]");
    By selectAll = By.xpath("//div[@class='selectAllDiv']/a[1]");


    By searchBoxSegments = By.xpath("//input[@class='form-control search-query textSelectable']");

    public void searchForASegment(String segmentName) {
        isDisplayedBy(searchBoxSegments, 10);
        find(searchBoxSegments).click();
        find(searchBoxSegments).clear();
        find(searchBoxSegments).sendKeys(segmentName);
        waitOneSecond();
    }

    public void clearSearchBox() {
        isDisplayedBy(searchBoxSegments, 10);
        find(searchBoxSegments).click();
        find(searchBoxSegments).clear();
    }

    //CHECKBOX CLICKING

    String listPattern = "//div[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']//*[contains(text(), 'segmentName')]/../../div[1]/i";

    public List<WebElement> segmentCheckboxList(String... labels) {
        List<WebElement> checkBoxes = new ArrayList<>();
        isDisplayedBy(modal, 5);
        for (String label : labels) {
            String pattern = listPattern.replace("segmentName", label);
            By location = By.xpath(pattern);
            WebElement segmentCheck = find(location);
            checkBoxes.add(segmentCheck);

        }
        return checkBoxes;
    }


    String exportPattern = "//div[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']//*[contains(text(), 'segmentName')]/../../div[7]";

    public List<WebElement> segmentExportList(String... labels) {
        List<WebElement> exportHoverElements = new ArrayList<>();
        isDisplayedBy(modal, 10);
        for (String label : labels) {
            String pattern = exportPattern.replace("segmentName", label);
            By location = By.xpath(pattern);
            WebElement hoverCheck = find(location);
            exportHoverElements.add(hoverCheck);
        }
        return exportHoverElements;
    }

        //This is the date shown in the far right column of segment list
    String exportDatePattern = "//div[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']//*[contains(text(), 'segmentName')]/../../div[7]/div[1]/div[@class='mple-statusDate dropdown']";
        //This is the icon next to the date. Specifically when it is spinning, i.e. processing
    String exportPatternIconProcessing = "//div[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']//*[contains(text(), 'segmentName')]/../../div[7]/div[1]/div[@class='mple-statusIcon']/i[@class='export-statusIcon-processing']";
        //Generic
    String exportPatternIconResult = "//div[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']//*[contains(text(), 'segmentName')]/../../div[7]/div[1]/div[@class='mple-statusIcon']";

    String exportedPopUpPattern = "//div[@class='lep-title' and contains(text(), 'segmentName')]/../../div[2]/div[5]/div[1]/div[@class='ui-widget-content slick-row even' or @class='ui-widget-content slick-row odd']/div[@class='slick-cell l2 r2 cbs-value' and contains(text(), 'exportType')]/..//div[@class='leps-status']";
   // String exportStatus;
    By safeSpot = By.xpath("//div[@class='pageTabTopBarTitle']");


    public boolean verifySegmentExportSuccess(String exportType, String segmentTitle) {

        isDisplayedBy(modal, 10);
        By exportDate = By.xpath(exportDatePattern.replace("segmentName", segmentTitle));
        isDisplayedBy(exportDate, 120);
        By exportResultIconProcessing = By.xpath(exportPatternIconProcessing.replace("segmentName", segmentTitle));
        waitOneSecond();
/*        try{
            WebElement processing = ExpectedConditions.visibilityOfElementLocated(exportResultIconProcessing).apply(driver);
            while (processing.isDisplayed()) {
                waitFiveSeconds();
                driver.navigate().refresh();
                isDisplayedBy(modal, 60);
                processing = ExpectedConditions.visibilityOfElementLocated(exportResultIconProcessing).apply(driver);
            }
        }
        catch (Exception e) {
            //ignoring exception
        }*/

        By exportResultIcon = By.xpath(exportPatternIconResult.replace("segmentName", segmentTitle));
        isDisplayedBy(exportResultIcon, 120);
        waitOneSecond();

        isDisplayedBy(exportDate, 30);
        click(exportDate);

        if ( exportType.equalsIgnoreCase("SFTP") ) {
            try {
                By exportStatusTextBy = By.xpath(exportedPopUpPattern.replace("segmentName", segmentTitle).replace("exportType", exportType));
                WebElement exportStatusTextElement = find(exportStatusTextBy);
                String exportStatusText = exportStatusTextElement.getText().trim();
                System.out.println("Pre while loop export status text: " + exportStatusText);

                while (exportStatusText.equalsIgnoreCase("Processing")) {
                    waitThreeSeconds();
                    driver.navigate().refresh();
                    waitThreeSeconds();
                    isDisplayedBy(modal, 30);
                    isDisplayedBy(exportDate, 20);
                    click(exportDate);
                    waitOneSecond();
                    exportStatusTextElement = find(exportStatusTextBy);
                    isDisplayed(exportStatusTextElement, 5);
                    exportStatusText = exportStatusTextElement.getText().trim();
                    exportStatusText.equalsIgnoreCase("Processing");
                    System.out.println(exportStatusText);
                }
                System.out.println("Export to SFTP status: " + exportStatusText);
            }
            catch (Exception e) {
                //ignoring exception
            }
        } else if ( exportType.equalsIgnoreCase("Email") ) {
            try {
                By exportStatusTextBy = By.xpath(exportedPopUpPattern.replace("segmentName", segmentTitle).replace("exportType", exportType));
                WebElement exportStatusTextElement = find(exportStatusTextBy);
                String exportStatusText = exportStatusTextElement.getText().trim();
                System.out.println("Pre while loop export status text: " + exportStatusText);

                while (exportStatusText.equalsIgnoreCase("Processing")) {
                    waitThreeSeconds();
                    driver.navigate().refresh();
                    waitThreeSeconds();
                    isDisplayedBy(modal, 30);
                    isDisplayedBy(exportDate, 20);
                    click(exportDate);
                    waitOneSecond();
                    exportStatusTextElement = find(exportStatusTextBy);
                    isDisplayed(exportStatusTextElement, 5);
                    exportStatusText = exportStatusTextElement.getText().trim();
                    exportStatusText.equalsIgnoreCase("Processing");
                    System.out.println(exportStatusText);

                }
                System.out.println("Export to Email status: " + exportStatusText);
            }
            catch (Exception e) {
                //ignoring exception
            }
        }else if ( exportType.equalsIgnoreCase("Download") ) {
            try {
                By exportStatusTextBy = By.xpath(exportedPopUpPattern.replace("segmentName", segmentTitle).replace("exportType", exportType));
                WebElement exportStatusTextElement = find(exportStatusTextBy);
                String exportStatusText = exportStatusTextElement.getText().trim();
                System.out.println("Pre while loop export status text: " + exportStatusText);

                while (exportStatusText.equalsIgnoreCase("Processing")) {
                    waitThreeSeconds();
                    driver.navigate().refresh();
                    waitThreeSeconds();
                    isDisplayedBy(modal, 30);
                    isDisplayedBy(exportDate, 20);
                    click(exportDate);
                    waitOneSecond();
                    exportStatusTextElement = find(exportStatusTextBy);
                    isDisplayed(exportStatusTextElement, 5);
                    exportStatusText = exportStatusTextElement.getText().trim();
                    exportStatusText.equalsIgnoreCase("Processing");
                    System.out.println(exportStatusText);
                }
                System.out.println("Export to Download status: " + exportStatusText);
            }
            catch (Exception e) {
                //ignoring exception
            }
        }else if ( exportType.equalsIgnoreCase("Custom") ) {
            try {
                By exportStatusTextBy = By.xpath(exportedPopUpPattern.replace("segmentName", segmentTitle).replace("exportType", exportType));
                WebElement exportStatusTextElement = find(exportStatusTextBy);
                String exportStatusText = exportStatusTextElement.getText().trim();
                System.out.println("Pre while loop export status text: " + exportStatusText);

                while (exportStatusText.equalsIgnoreCase("Processing")) {
                    waitThreeSeconds();
                    driver.navigate().refresh();
                    waitThreeSeconds();
                    isDisplayedBy(modal, 30);
                    isDisplayedBy(exportDate, 20);
                    click(exportDate);
                    waitOneSecond();
                    exportStatusTextElement = find(exportStatusTextBy);
                    isDisplayed(exportStatusTextElement, 5);
                    exportStatusText = exportStatusTextElement.getText().trim();
                    exportStatusText.equalsIgnoreCase("Processing");
                    System.out.println(exportStatusText);
                }
                System.out.println("Export to Custom Reports status: " + exportStatusText);
            }
            catch (Exception e) {
                //ignoring exception
            }
        }

        By exportStatusTextBy = By.xpath(exportedPopUpPattern.replace("segmentName", segmentTitle).replace("exportType", exportType));
        WebElement exportStatusTextElement = find(exportStatusTextBy);
        String exportStatusText = exportStatusTextElement.getText();

        if ( exportStatusText.contains("Success") ) {
            click(safeSpot);
            return true;
        }
        return false;

    }



    By cloneButton = By.xpath("//div[@class='btn btnCloneItem']");
    By newCloneTitleTextBox = By.xpath("//*[@class='cloneName textSelectable form-control']");
    By okButtonClone = By.xpath("//div[@class='titleDiv' and contains(text(), 'Clone Segment')]/../div[3]/a[1]");


    public void cloneSegment(String segmentToCloneTitle, String cloneSegmentName) {
        isDisplayedBy(unSelectAll, 10);
        click(unSelectAll);
        for (WebElement checkbox : segmentCheckboxList(segmentToCloneTitle)) {
            checkbox.click();
        }
        isDisplayedBy(cloneButton, 10);
        click(cloneButton);

        isDisplayedBy(newCloneTitleTextBox, 5);
        find(newCloneTitleTextBox).clear();
        find(newCloneTitleTextBox).sendKeys(cloneSegmentName);
        click(okButtonClone);
        waitOneSecond();
    }

    By splitButton = By.xpath("//div[@class='btn btnSplitItem']");
    By splitPercentageTextBox = By.xpath("//div[@class='split-segment-percentage textSelectable form-control']");
    By splitOne = By.xpath("//input[@id='split_0']");
    By splitTwo = By.xpath("//input[@id='split_1']");
    By saveSplit = By.xpath("//a[@class='btn okBtn modalDone do-split']");

    public void splitSegmentTwo(String segmentToSplit, int... splitPercentages) {
    //ArrayList<Integer> percentageTextBoxes = new ArrayList<Integer>();

        isDisplayedBy(unSelectAll, 10);
        click(unSelectAll);

        for (WebElement checkbox : segmentCheckboxList(segmentToSplit)) {
            checkbox.click();
        }
        isDisplayedBy(splitButton, 10);
        click(splitButton);

        waitOneSecond();

        find(splitOne).click();
        find(splitOne).clear();
        find(splitOne).sendKeys(String.format("%d", splitPercentages[0]));

        find(splitTwo).click();
        find(splitTwo).clear();
        find(splitTwo).sendKeys(String.format("%d", splitPercentages[1]));

        click(saveSplit);
        waitOneSecond();


    }


//This is used for clones and splits, mainly.

    String segmentPattern = "//div[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']//*[contains(text(), 'segmentName')]";

    public boolean verifySegmentPresent (String segmentName) {
/*        driver.navigate().refresh();
        isDisplayedBy(modal, 30);*/
        isDisplayedBy(unSelectAll, 60);
        click(unSelectAll);
        By segmentToVerify = By.xpath(segmentPattern.replace("segmentName", segmentName));
        try{
            while (find(segmentToVerify).isDisplayed() != true) {
                click(safeSpot);
                waitFiveSeconds();
                driver.navigate().refresh();
                find(segmentToVerify);
            }
        }
        catch (Exception e) {
            //ignoring exception
        }

        if ( isDisplayedBy(segmentToVerify, 60) ) {
            return true;
        }
        return false;
    }

    public void openSegment(String segmentName) {
        By segment = By.xpath(segmentPattern.replace("segmentName", segmentName));
        isDisplayedBy(segment, 5);
        click(segment);
        waitOneSecond();
    }

    public void deleteSegment(String... segmentTitle) {
        waitOneSecond();
        for (WebElement checkBox : segmentCheckboxList(segmentTitle)) {
            isDisplayed(checkBox, 10);
            checkBox.click();
        }
        isDisplayedBy(deleteSegmentButton, 5);
        click(deleteSegmentButton);
        waitOneSecond();

        isDisplayedBy(confirmDeleteButton, 5);
        click(confirmDeleteButton);
    }

    By segmentDeletePopUp = By.xpath("//div[id='delete-done']");

    public boolean verifySegmentDeleted(String segmentName) {
//        isDisplayedBy(segmentDeletePopUp, 15);
        waitOneSecond();
        driver.navigate().refresh();
        isDisplayedBy(modal, 30);
        waitOneSecond();
        By segment = By.xpath(segmentPattern.replace("segmentName", segmentName));
        try {
            find(segment);
            return false;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return true;
        }

    }

}

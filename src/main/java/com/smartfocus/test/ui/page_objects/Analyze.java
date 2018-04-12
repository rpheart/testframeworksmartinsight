package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.testng.FileAssert.fail;


public class Analyze extends Base {


    By modal = By.cssSelector(".grid-canvas");
    By deleteSegmentButton = By.cssSelector(".delete-icon");
    By confirmDeleteButton = By.cssSelector(".btn.okBtn");
    // By confirmDeleteButton = By.xpath("//*[@class='btn okBtn']//*[text()='Remove']");

    By unSelectAll = By.xpath("//div[@class='selectAllDiv']/a[2]");
    By selectAll = By.xpath("//div[@class='selectAllDiv']/a[1]");

    //CHECKBOX CLICKING

    String listPattern = "//div[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']//*[contains(text(), 'segmentName')]/../../div[1]/i";
    String exportPattern = "//div[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']//*[contains(text(), 'segmentName')]/../../div[7]";

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

    String exportDatePattern = "//div[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']//*[contains(text(), 'Assertion Practice')]/../../div[7]/div[1]/div[@class='mple-statusDate dropdown']";
    String exportPatternIconProcessing = "//div[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']//*[contains(text(), 'segmentName')]/../../div[7]/div[1]/div[@class='mple-statusIcon']/i[@class='export-statusIcon-processing']";
    String exportPatternIconResult = "//div[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']//*[contains(text(), 'segmentName')]/../../div[7]/div[1]/div[@class='mple-statusIcon']";

    String exportedPattern = "//div[@class='lep-title' and contains(text(), 'segmentName')]/../../div[2]/div[5]/div[1]/div[@class='ui-widget-content slick-row even' or @class='ui-widget-content slick-row odd']/div[@class='slick-cell l2 r2 cbs-value' and contains(text(), 'exportType')]/..//div[@class='leps-status']";
    String exportStatus;
    By safeSpot = By.xpath("//div[@class='pageTabTopBarTitle']");


    public boolean verifySegmentExportSuccess(String exportType, String segmentTitle) {

        isDisplayedBy(modal, 10);
        By exportDate = By.xpath(exportDatePattern.replace("segmentName", segmentTitle));
        isDisplayedBy(exportDate, 30);
        By exportResultIconProcessing = By.xpath(exportPatternIconProcessing.replace("segmentName", segmentTitle));
        waitOneSecond();
        try{
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
        }

        By exportResultIcon = By.xpath(exportPatternIconResult.replace("segmentName", segmentTitle));
        isDisplayedBy(exportResultIcon, 120);
        waitThreeSeconds();

        /*  CURRENT BUG THAT DOES NOT UPDATE WITHOUT REFRESH.
        By exportIconProcessing = By.xpath(exportPatternIconProcessing.replace("segmentName", segmentTitle));
        isDisplayedBy(exportIconProcessing, 30);
        new WebDriverWait(driver, 300).until(ExpectedConditions.invisibilityOfElementLocated(exportIconProcessing));*/

        try{
            for (WebElement export : segmentExportList(segmentTitle)) {
                export.click();
                waitOneSecond();
            }
            By exportedStatus = By.xpath(exportedPattern.replace("segmentName", segmentTitle).replace("exportType", exportType));
            WebElement exportStatusElement = find(exportedStatus);
            exportStatus = exportStatusElement.getText();
            while (exportStatus == "Processing") {
                click(safeSpot);
                driver.navigate().refresh();
            }
        }
        catch (Exception e) {
            //ignoring exception
        }

        for (WebElement export : segmentExportList(segmentTitle)) {
            export.click();
            waitOneSecond();
        }

        if ( exportType.equalsIgnoreCase("SFTP") ) {
            By exportedStatus = By.xpath(exportedPattern.replace("segmentName", segmentTitle).replace("exportType", exportType));
            WebElement exportStatusElement = find(exportedStatus);
            exportStatus = exportStatusElement.getText();
            while (exportStatus == "Processing") {
                click(safeSpot);
                waitFiveSeconds();
                driver.navigate().refresh();
                isDisplayedBy(exportDate, 30);
                for (WebElement export : segmentExportList(segmentTitle)) {
                    export.click();
                    waitOneSecond();
                }
                exportStatus = exportStatusElement.getText();
            }
            System.out.println("SFTP export status: " + exportStatus);
        } else if ( exportType.equalsIgnoreCase("Email") ) {
            By exportedStatus = By.xpath(exportedPattern.replace("segmentName", segmentTitle).replace("exportType", exportType));
            WebElement exportStatusElement = find(exportedStatus);
            exportStatus = exportStatusElement.getText();
            while (exportStatus == "Processing") {
                click(safeSpot);
                waitFiveSeconds();
                driver.navigate().refresh();
                isDisplayedBy(exportDate, 30);
                for (WebElement export : segmentExportList(segmentTitle)) {
                    export.click();
                    waitOneSecond();
                }
                exportStatus = exportStatusElement.getText();
            }
            System.out.println("Email export status: " + exportStatus);
        } else if ( exportType.equalsIgnoreCase("Download") ) {
            By exportedStatus = By.xpath(exportedPattern.replace("segmentName", segmentTitle).replace("exportType", exportType));
            WebElement exportStatusElement = find(exportedStatus);
            exportStatus = exportStatusElement.getText();
            while (exportStatus == "Processing") {
                click(safeSpot);
                waitFiveSeconds();
                driver.navigate().refresh();
                isDisplayedBy(exportDate, 30);
                for (WebElement export : segmentExportList(segmentTitle)) {
                    export.click();
                    waitOneSecond();
                }
                exportStatus = exportStatusElement.getText();
            }
            System.out.println("Download  export status: " + exportStatus);
        } else if ( exportType.equalsIgnoreCase("Custom") ) {
            By exportedStatus = By.xpath(exportedPattern.replace("segmentName", segmentTitle).replace("exportType", exportType));
            WebElement exportStatusElement = find(exportedStatus);
            exportStatus = exportStatusElement.getText();
            while (exportStatus == "Processing") {
                click(safeSpot);
                waitFiveSeconds();
                driver.navigate().refresh();
                isDisplayedBy(exportDate, 30);
                for (WebElement export : segmentExportList(segmentTitle)) {
                    export.click();
                    waitOneSecond();
                }
                exportStatus = exportStatusElement.getText();
            }
            System.out.println("Custom export status: " + exportStatus);
        }

        if ( exportStatus.contains("Success") ) {
            click(safeSpot);
            return true;
        }
        return false;


    }


    public void deleteSegment(String... segmentTitle) {
        for (WebElement checkBox : segmentCheckboxList(segmentTitle)) {
            checkBox.click();
        }
        isDisplayedBy(deleteSegmentButton, 5);
        click(deleteSegmentButton);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException exception) {
        }

        isDisplayedBy(confirmDeleteButton, 5);
        click(confirmDeleteButton);
    }

    By cloneButton = By.xpath("//div[@class='btn btnCloneItem']");
    By newCloneTitleTextBox = By.xpath("//*[@class='cloneName textSelectable form-control']");
    By okButtonClone = By.xpath("//div[@class='titleDiv' and contains(text(), 'Clone Segment')]/../div[3]/a[1]");


    public void cloneSegment(String segmentToCloneTitle, String cloneSegmentName) {
        for (WebElement checkbox : segmentCheckboxList(segmentToCloneTitle)) {
            checkbox.click();
        }
        isDisplayedBy(cloneButton, 10);
        click(cloneButton);

        isDisplayedBy(newCloneTitleTextBox, 5);
        find(newCloneTitleTextBox).clear();
        find(newCloneTitleTextBox).sendKeys(cloneSegmentName);
        click(okButtonClone);
    }


//This is used for clones and splits, mainly.

    String segmentPattern = "//div[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']//*[contains(text(), 'segmentName')]";

    public boolean verifySegmentPresent (String segmentName) {
        isDisplayedBy(unSelectAll, 60);
        click(unSelectAll);
        By segmentToVerify = By.xpath(segmentPattern.replace("segmentName", segmentName));
       /* isDisplayedBy(segmentToVerify, 30);
        WebElement segment = find(segmentToVerify);*/
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

        if ( isDisplayedBy(segmentToVerify, 5) ) {
            return true;
        }
        return false;
    }



    public void openSegment(String segmentName) {
        By segment = By.xpath(segmentPattern.replace("segmentName", segmentName));
        isDisplayedBy(segment, 5);
        click(segment);
    }

}

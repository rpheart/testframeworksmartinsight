package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;



public class Analyze extends Base {


    By modal = By.cssSelector(".grid-canvas");
    By deleteSegmentButton = By.cssSelector(".delete-icon");
    By confirmDeleteButton = By.cssSelector(".btn.okBtn");
   // By confirmDeleteButton = By.xpath("//*[@class='btn okBtn']//*[text()='Remove']");



    //CHECKBOX CLICKING

    String listPattern = "//div[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']//*[contains(text(), 'z')]/../../div[1]/i";

    public List<WebElement> segmentList(String... labels) {
        List<WebElement> checkBoxes = new ArrayList<>();
        isDisplayedBy(modal, 5);
        for (String label : labels) {
            String pattern = listPattern.replace("z", label);
            By location = By.xpath(pattern);
            WebElement segmentCheck = find(location);
            checkBoxes.add(segmentCheck);
        }
        return checkBoxes;
    }

    public void deleteSegment() {
        isDisplayedBy(deleteSegmentButton, 5);
        click(deleteSegmentButton);
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException exceptionn ) {
        }

        isDisplayedBy(confirmDeleteButton, 5);
        click(confirmDeleteButton);
    }


}

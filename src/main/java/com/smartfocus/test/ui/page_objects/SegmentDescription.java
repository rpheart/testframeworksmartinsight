package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;

public class SegmentDescription extends Base {

    By editDescription = By.id("descriptionText");
    By saveTitleButton = By.xpath("//*[@id='refine-segmentation-section']/div[1]/div[5]/div[2]/div/div[3]/a[1]");


    public void newDescription (String newDescription) {
        if ( ! isDisplayedBy(editDescription, 5) ) {
            System.out.println("cannot find textbox");
        }
        find(editDescription).sendKeys(newDescription);
        isDisplayedBy(saveTitleButton, 5);
        find(saveTitleButton).click();
    }
}

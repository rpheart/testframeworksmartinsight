package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;


public class SegmentTitle extends Base {


    By editSegment = By.cssSelector(".form-control.newTitle.textSelectable");
    By saveTitleButton = By.cssSelector(".btn.okBtn.modalSave");


    public void newTitle(String newTitle) {
        isDisplayedBy(editSegment, 5);
        find(editSegment).clear();
        find(editSegment).sendKeys(newTitle);
        isDisplayedBy(saveTitleButton, 5);
        click(saveTitleButton);
    }

}

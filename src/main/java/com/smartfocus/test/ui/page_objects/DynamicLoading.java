package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicLoading extends Base {

    By saveButton = By.cssSelector(".btn.save-update");
    By view = By.className("logo_button insight_button");
    By customText = By.id("finish");
    By calculatingBar = By.cssSelector(".progress-bar");

    public DynamicLoading(WebDriver driver) {
        super();
    }

    public void saveSegment (WebElement loading) {
        isDisplayedBy(saveButton, 5);
        click(saveButton);
    }

    public void navBarView (String exampleNumber){
        visit("/dynamic_loading/" + exampleNumber);
        click(view);
    }

    public Boolean finishTextPresent() {
        return isDisplayedBy(customText, 3);
    }

}

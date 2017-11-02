package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoading extends Base {

    By saveAndUpdate = By.cssSelector("#save&update button");
    By view = By.className("logo_button insight_button");
    By customText = By.id("finish");

    public DynamicLoading(WebDriver driver) {
        super();
    }

    public void save (String exampleNumber) {
        visit("/dynamic_loading/" + exampleNumber);
        click(saveAndUpdate);
    }

    public void navBarView (String exampleNumber){
        visit("/dynamic_loading/" + exampleNumber);
        click(view);
    }

    public Boolean finishTextPresent() {
        return isDisplayedBy(customText, 3);
    }

}

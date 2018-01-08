package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class HomeNavigation extends Base {

    By viewButton = By.cssSelector(".logo_button.insight_button");
    By analyzeButton = By.cssSelector(".logo_button.optimize_button.selected_product");
    By personalizationButton = By.cssSelector(".logo_button.define_button.selected_product");
    By adminButton = By.cssSelector(".btn-group.pull-right.open");
    By siAdmin = By.cssSelector(".SF_admin_button");


    public void analyze(){
        isDisplayedBy(analyzeButton, 5);
        click(analyzeButton);
    }

    public void view() {
        isDisplayedBy(viewButton, 5);
        click(viewButton);
    }

    public void personalization() {
        isDisplayedBy(personalizationButton, 5);
        click(personalizationButton);
    }

    public void siAdmin() {
        isDisplayedBy(adminButton,5);
        click(adminButton);
        isDisplayedBy(siAdmin, 5);
        click(siAdmin);
    }

















}

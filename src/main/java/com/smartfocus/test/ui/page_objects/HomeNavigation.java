package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class HomeNavigation extends Base {

    By viewButton = By.xpath("//li[@class='logo_button insight_button' or @class='logo_button insight_button selected_product']");
    By analyzeButton = By.xpath("//li[@class='logo_button optimize_button' or @class='logo_button optimize_button selected_product']");
    By personalizationButton = By.xpath("//li[@class='logo_button define_button' or @class='logo_button define_button selected_product']");
    By emailButton = By.xpath("//li[@class='logo_button engage_button' or @class='logo_button engage_button selected_product']");
    By adminButton = By.cssSelector(".btn-group.pull-right");
    By siAdmin = By.cssSelector(".SF_admin_button");
    By unSelectAll = By.xpath("//div[@class='selectAllDiv']/a[2]");


    public void analyze(){
        isDisplayedBy(analyzeButton, 5);
        click(analyzeButton);
        isDisplayedBy(unSelectAll, 60);
        click(unSelectAll);
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

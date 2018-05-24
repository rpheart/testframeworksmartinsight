package com.smartfocus.test.ui.Utilities;

import com.smartfocus.test.ui.page_objects.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import sun.awt.windows.WEmbeddedFrame;


public class Scroll extends Base {


    public void scrollToByElement(By element) {
        WebElement foundElement = find(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(foundElement);
        actions.perform();

    }

    By containerBy = By.cssSelector(".available_filters_container");

    @FindBy(xpath = "//div[@class='available_container_items']//*[contains(text(), 'And/Or Template')]")
    public WebElement templateAndOr;

    public WebElement andOrContainer() {
        return templateAndOr;
    }


    public void scrollToElementInContainer(WebElement element) {
        WebElement container = find(containerBy);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollTop=arguments[1].offsetTop",
                container,
                element);
    }

    public void scrollToTopOfFilterContainer() {
        WebElement container = find(containerBy);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollTop=arguments[0].offsetTop",
                container);
    }

    By filterGroupContainer = By.xpath("//div[@class='tab-container-inner-wrapper']");

    public void scrollToTopofFilterGroupContainer() {
        WebElement container = find(filterGroupContainer);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollTop=arguments[0].offsetTop",
                container);
    }


    public void scrollToElement (WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }






}



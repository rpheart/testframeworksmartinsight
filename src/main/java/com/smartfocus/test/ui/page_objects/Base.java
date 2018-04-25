package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

import static org.testng.FileAssert.fail;

public class Base {

    public static WebDriver driver;

    public static void visit(String url) {
        driver.get(url);
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }


    public WebElement findString (By xpath) {
        return driver.findElement(xpath);
    }


/*
    public List<WebElement> findElements (WebElement locator) {
        return driver.findElement(locator);
    }
*/

    public void type (By locator, String inputText) {
        find(locator).sendKeys(inputText);
    }

    public void click (By locator) {
        find(locator).click();
    }


    public void doubleClick(WebElement locator) {
        Actions action = new Actions(driver);
        action.doubleClick(locator).perform();
    }




    public void waitFor (ExpectedCondition<WebElement> condition, Integer timeout) {
        timeout = timeout != null ? timeout : 10;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
    }

    private void waitUntil (ExpectedCondition<Boolean> condition, Integer timeout) {
        timeout = timeout != null ? timeout : 10;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
    }

    public void waitOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exception) {

        }
    }

    public void waitThreeSeconds() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {

        }
    }

    public void waitFiveSeconds() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException exception) {

        }
    }

    public Boolean isDisplayed(WebElement locator, int maxWaitTime) {
        try {
           waitFor(ExpectedConditions.visibilityOf(locator), maxWaitTime);
        } catch (org.openqa.selenium.TimeoutException exception) {
            System.out.println(locator);
            fail("Element not found or rendered. Consider extending wait time or reevaluate locator.");
        }
        return true;
    }

    public Boolean isNotDisplayed(WebElement locator, int maxWaitTime) {
        try {
            waitFor(ExpectedConditions.visibilityOf(locator), maxWaitTime);
        } catch (org.openqa.selenium.TimeoutException exception) {
            fail("Element not located or rendered. Consider extending wait time or reevaluate locator.");
        }
        return true;
    }

    public Boolean isDisplayedBy (By locator, int maxWaitTime){
        try {
            waitFor(ExpectedConditions.visibilityOfElementLocated(locator), maxWaitTime);
        } catch (org.openqa.selenium.TimeoutException exception) {
            fail("Element not located or rendered. Consider extending wait time or reevaluate locator.");
        }
        return true;
    }

    public Boolean isDisplayedByWait (By locator, int maxWaitTime){
        try {
            waitFor(ExpectedConditions.visibilityOfElementLocated(locator), maxWaitTime);
        } catch (org.openqa.selenium.TimeoutException exception) {
            return null;
        }
        return true;
    }



    public Boolean isNotDisplayedBy (By locator, int maxWaitTime) {
        try {
            waitUntil(ExpectedConditions.invisibilityOfElementLocated(locator), maxWaitTime);
        } catch (org.openqa.selenium.TimeoutException exception) {
            fail("Element not located or rendered. Consider extending wait time or reevaluate locator.");
        }
        return true;
    }

    public static void tearDown() {

        driver.close();
        driver.quit();
    }



/*    public Boolean isDisplayed(WebElement locator, int maxWaitTime) {
        try {
           waitFor(ExpectedConditions.visibilityOf(locator), maxWaitTime);
        } catch (org.openqa.selenium.TimeoutException exception) {
            return false;
        }
        return true;
    }

  public Boolean isDisplayedE(WebElement, int maxWaitTime) {
        try {
            waitFor(ExpectedConditions.visibilityOf(WebElement), maxWaitTime);
        } catch (org.openqa.selenium.TimeoutException exception) {
            return false;
        }
        return true;
    }
*/



}

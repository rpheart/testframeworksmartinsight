package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public class NewSegment extends Base {
    By analyzeButton = By.xpath("//li[@class='logo_button optimize_button' or @class='logo_button optimize_button selected_product']");
    By create = By.className("pageTabTopBarActionCreate");
    By createCustom = By.className("customSegmentLine");
    By createTimeline = By.className("timelineSegmentLine");
    By createAffinity = By.className("affinityLine");

    By segmentTitle = By.cssSelector(".refineSegmentTitle.textSelectable.ellipsis.text-selectable");

    String segmentTitleText;
    String timelineTitleText;



    RefineGlobal RG;

    public void analyze(){
        isDisplayedBy(analyzeButton, 10);
        click(analyzeButton);
    }

    public void createButton(){
        isDisplayedBy(create, 120);
        click(create);
    }

    public void createCustom(){
        isDisplayedBy(createCustom, 10);
        click(createCustom);
    }

    public boolean verifyNewSegmentStartStarted() {
        isDisplayedBy(segmentTitle, 5);
        segmentTitleText = driver.findElement(By.cssSelector(".refineSegmentTitle.textSelectable.ellipsis.text-selectable")).getText();
        if (segmentTitleText.equalsIgnoreCase("Custom Segment")) {
            return true;
        }
        return false;
    }

    public void createTimeline(){
        isDisplayedBy(createTimeline, 10);
        click(createTimeline);
    }

    public boolean verifyNewTimelineStarted() {
        isDisplayedBy(segmentTitle, 10);
        timelineTitleText = find(segmentTitle).getText();
        if ( timelineTitleText.equalsIgnoreCase("Timeline Segment") ) {
            return true;
        }
        return false;
    }

    public void createAffinity(){
        isDisplayedBy(createAffinity, 10);
        click(createAffinity);
    }

    public void newCustom(){
        RG = PageFactory.initElements(driver, RefineGlobal.class);
        analyze();
        createButton();
        createCustom();
        RG.findAddedGroups();
    }

    public void newTimeline(){
        RG = PageFactory.initElements(driver, RefineGlobal.class);
        analyze();
        createButton();
        createTimeline();
        RG.findAddedGroups();

    }

    public void newAffinity(){
        RG = PageFactory.initElements(driver, RefineGlobal.class);
        analyze();
        createButton();
        createAffinity();
        RG.findAddedGroups();
    }


}

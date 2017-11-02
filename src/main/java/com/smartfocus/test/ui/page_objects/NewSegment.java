package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;

public class NewSegment extends Base {

    By analyze = By.xpath("//*[@id='SFUI_Nav']/div/div/ul/li[2]");
    By create = By.className("pageTabTopBarActionCreate");
    By createCustom = By.className("customSegmentLine");
    By createTimeline = By.className("timelineSegmentLine");
    By createAffinity = By.className("affinityLine");


    public void analyze(){
        click(analyze);
    }

    public void createButton(){
        isDisplayedBy(create, 10);
        click(create);
    }

    public void createCustom(){
        isDisplayedBy(createCustom, 10);
        click(createCustom);
    }

    public void createTimeline(){
        isDisplayedBy(createTimeline, 10);
        click(createTimeline);
    }

    public void createAffinity(){
        isDisplayedBy(createAffinity, 10);
        click(createAffinity);
    }

    public void newCustom(){
        analyze();
        createButton();
        createCustom();
    }

    public void newTimeline(){
        analyze();
        createButton();
        createTimeline();
    }

    public void newAffinity(){
        analyze();
        createButton();
        createAffinity();
    }


}

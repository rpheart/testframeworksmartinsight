package com.smartfocus.test.ui.page_objects;

import com.smartfocus.test.ui.Utilities.UtilityHover;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Email extends Base {



    By emailTab = By.xpath("//div[@class='logo_button engage_button selected_product']");

    @FindBy(xpath = "//div[@id='engage-list-management']")
            public WebElement listMgmtSegmentListButton;

    @FindBy(xpath = "//*[@id='engage-list-management']/div[2]/div/ul/li[1]/ul/li/ul/li[2]")
            public WebElement listMgmtButton;

    By updateFlash = By.xpath("//div[@id='alternativeContent']/div/a");

    String exportedEmailsTemplate = "//div[@class='si-module-area']//";

    public void verifySegmentExported(String segmentName) {
        isDisplayedBy(emailTab, 4);
        click(emailTab);

        isDisplayed(listMgmtButton, 10);
        UtilityHover.hover(listMgmtButton, listMgmtSegmentListButton);

/*        try {
            while (ExpectedConditions.visibilityOfElementLocated(updateFlash).equals(true)) ;
            click(updateFlash);
        }
        catch (Exception e) {
            throw (e);
        }*/





    }


}

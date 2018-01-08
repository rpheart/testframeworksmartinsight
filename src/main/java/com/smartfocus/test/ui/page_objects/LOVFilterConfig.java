package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LOVFilterConfig extends Base {



    By modal = By.cssSelector(".grid-canvas");
    By saveFilterButton = By.cssSelector(".btn.saveBtn.modalFilterSave");
    By cancelFilterButton = By.cssSelector(".btn.cancelBtn.modalFilterCancel");
    By includeToggle = By.cssSelector(".btn.btnInclude");
    By excludeToggle = By.cssSelector(".btn.btnExclude");

    String lovPattern = "//div[@class='ui-widget-content slick-row odd' or @class='ui-widget-content slick-row even']//*[contains(text(), 'z')]/../div[1]/i";

    public List<WebElement> genericLOV(String... labels) {
        List<WebElement> checkBoxes = new ArrayList<>();
        isDisplayedBy(modal, 5);
        for (String label : labels) {
            String pattern = lovPattern.replace("z", label);
            By location = By.xpath(pattern);
            WebElement filterCheck = find(location);
            checkBoxes.add(filterCheck);
        }
        return checkBoxes;
    }

    public void saveFilter() {
        isDisplayedBy(saveFilterButton, 5);
        click(saveFilterButton);
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException exceptionn ) {

        }
    }

    public void cancelFilter() {
        isDisplayedBy(cancelFilterButton, 5);
        click(cancelFilterButton);
    }

    public void include() {
        isDisplayedBy(includeToggle, 5);
        click(includeToggle);
    }
    public void exclude() {
        isDisplayedBy(excludeToggle, 5);
        click(excludeToggle);
    }


}

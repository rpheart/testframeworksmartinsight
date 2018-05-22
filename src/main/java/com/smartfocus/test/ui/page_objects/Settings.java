package com.smartfocus.test.ui.page_objects;

import com.smartfocus.test.ui.page_objects.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Settings extends Base {
    //SETTINGS TOGGLES, SETTINGS TOGGLES,SETTINGS TOGGLES, SETTINGS TOGGLES, SETTINGS TOGGLES, SETTINGS TOGGLES,

    //SETTINGS TOGGLE CONTROLS

    By lockedSegmentToggle = By.xpath("//*[@class='locked-segment']/div/div");
    By workGroupToggle = By.xpath("//*[@class='grouped-segmentation']/div/div");
    By ageAndGenderToggle = By.xpath("//*[@class='generate-demo']/div/div");
    By ageAndGenderEnabled = By.xpath("//*[@data-type='generate-demo']/div[@class='slide-toggle-box on']");
    By ageAndGenderNotEnabled = By.xpath("//*[@data-type='generate-demo']/div[@class='slide-toggle-box']");
    By totalSpendToggle = By.xpath("//*[@class='generate-product']/div/div");
    By totalSpendEnabled = By.xpath("//*[@data-type='generate-product']/div[@class='slide-toggle-box on']");
    By totalSpendNotEnabled = By.xpath("//*[@data-type='generate-product']/div[@class='slide-toggle-box']");
    By rfmToggle = By.xpath("//*[@class='generate-rfm']/div/div");
    By rfmEnabled = By.xpath("//*[@data-type='generate-rfm']/div[@class='slide-toggle-box on']");
    By rfmNotEnabled = By.xpath("//*[@data-type='generate-rfm']/div[@class='slide-toggle-box']");

    By autoExportEmailToggle = By.xpath("//div[@class='auto-email']/div/div");
    By autoExportEmailEnabled = By.xpath("//div[@class='auto-email']/div/div[@class='slide-toggle-box on']");
    By autoExportEmailNotEnabled = By.xpath("//div[@class='auto-email']/div/div[@class='slide-toggle-box']");

    By autoExportSFTPToggle = By.xpath("//div[@class='auto-sftp']/div/div");
    By autoExportSFTPEnabled = By.xpath("//div[@class='auto-sftp']/div/div[@class='slide-toggle-box on']");
    By autoExportSFTPNotEnabled = By.xpath("//div[@class='auto-sftp']/div/div[@class='slide-toggle-box']");



    public void toggleLockSetting() {
        isDisplayedBy(lockedSegmentToggle, 5);
        click(lockedSegmentToggle);
    }

    public void toggleWorkgroupSetting() {
        isDisplayedBy(workGroupToggle, 5);
        click(workGroupToggle);
    }

    public void toggleAgeAndGenderSettingOn() {
        isDisplayedBy(ageAndGenderToggle, 5);
        if ( isNotDisplayedBy(ageAndGenderEnabled, 5) ) {
            click(ageAndGenderToggle);
        }
    }

    public void toggleAgeAndGenderSettingOff() {
        isDisplayedBy(ageAndGenderToggle, 5);
        if ( isNotDisplayedBy(ageAndGenderNotEnabled, 5) ) {
            click(ageAndGenderToggle);
        }
    }

    public boolean verifyAgeAndGenderEnabled() {
        isDisplayedBy(ageAndGenderToggle, 10);
        if ( isDisplayedBy(ageAndGenderEnabled, 1) ) {
            return true;
        }
        return false;
    }
    public boolean verifyAgeAndGenderNotEnabled() {
        isDisplayedBy(ageAndGenderToggle, 10);
        if ( isDisplayedBy(ageAndGenderNotEnabled, 1) ) {
            return true;
        }
        return false;
    }

    public void toggleTotalSpendSettingOn() {
        isDisplayedBy(totalSpendToggle, 5);
        if ( isNotDisplayedBy(totalSpendEnabled, 1) ) {
            click(totalSpendToggle);
        }
    }

    public void toggleTotalSpendSettingOff() {
        isDisplayedBy(totalSpendToggle, 5);
        if ( isNotDisplayedBy(totalSpendNotEnabled, 1) ) {
            click(totalSpendToggle);
        }
    }

    public boolean verifyTotalSpendEnabled() {
        if ( isDisplayedBy(totalSpendEnabled, 5) ) {
            return true;
        }
        return false;
    }

    public boolean verifyTotalSpendNotEnabled() {
        if ( isDisplayedBy(totalSpendNotEnabled, 5) ) {
            return true;
        }
        return false;
    }


    public void toggleRfmSettingOn() {
        isDisplayedBy(rfmToggle, 5);
        if ( isNotDisplayedBy(rfmEnabled, 5) ) {
            click(rfmToggle);
        }
    }

    public void toggleRfmSettingOff() {
        isDisplayedBy(rfmToggle, 5);
        if ( isNotDisplayedBy(rfmNotEnabled, 5) ) {
            click(rfmToggle);
        } else {
            verifyRfmEnabled();
        }
    }

    public boolean verifyRfmEnabled() {
        if ( isDisplayedBy(rfmEnabled, 5) ) {
            return true;
        }
        return false;
    }

    public boolean verifyRfmNotEnabled() {
        if ( isDisplayedBy(rfmNotEnabled, 5) ) {
            return true;
        }
        return false;
    }


    public By getAutoExportEmailToggle() {
        return autoExportEmailToggle;
    }

    public void toggleAutoExportEmailOn() {
        isDisplayedBy(autoExportEmailToggle, 5);
        if ( isNotDisplayedBy(autoExportEmailEnabled, 5) ) {
            click(autoExportEmailToggle);
        } else {
            verifyAutoExportEmailEnabled();
        }
    }

    public void toggleAutoExportEmailOff() {
        isDisplayedBy(autoExportEmailToggle, 5);
        if ( isNotDisplayedBy(autoExportEmailNotEnabled, 5) ) {
            click(autoExportEmailToggle);
        } else {
            verifyAutoExportEmailNotEnabled();
        }
    }

    public boolean verifyAutoExportEmailEnabled() {
        if ( isDisplayedBy(autoExportEmailEnabled, 5) ) {
            return true;
        }
        return false;
    }

    public boolean verifyAutoExportEmailNotEnabled() {
        if ( isDisplayedBy(autoExportEmailNotEnabled, 5) ) {
            return true;
        }
        return false;
    }

    public By getAutoExportSFTPToggle() {
        return autoExportSFTPToggle;
    }

    public void toggleAutoExportSFTPOn() {
        isDisplayedBy(autoExportSFTPToggle, 5);
        if ( isNotDisplayedBy(autoExportSFTPEnabled, 5) ) {
            click(autoExportSFTPToggle);
        } else {
            verifyAutoExportSFTPEnabled();
        }
    }

    public void toggleAutoExportSFTPOff() {
        isDisplayedBy(autoExportSFTPToggle, 5);
        if ( isNotDisplayedBy(autoExportSFTPNotEnabled, 5) ) {
            click(autoExportSFTPToggle);
        } else {
            verifyAutoExportEmailNotEnabled();
        }
    }

    public boolean verifyAutoExportSFTPEnabled() {
        if ( isDisplayedBy(autoExportSFTPEnabled, 5) ) {
            return true;
        }
        return false;
    }

    public boolean verifyAutoExportSFTPNotEnabled() {
        if ( isDisplayedBy(autoExportSFTPNotEnabled, 5) ) {
            return true;
        }
        return false;
    }




}

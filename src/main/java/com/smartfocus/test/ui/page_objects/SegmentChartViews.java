package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;

public class SegmentCalculationOptions extends Base {


    //SUMMARY CONTROLS

    //AGE AND GENDER CONTROLS

    //TOTAL SPEND BY PRODUCT CONTROLS

    By totalSpendDropdown = By.cssSelector(".btn-group.dropdown.open");
    By allDepartmentsButton = By.xpath("//div[@class='dropdown-menu pull-right' and contains(text(), ' All Departments ')]");
    By allCategoriesButton = By.xpath("//div[@class='dropdown-menu pull-right' and contains(text(), ' All Categories ')]");


    //By summaryCalculationsTab = By.xpath("//div[@class='underline' and contains (text(), 'Summary')]");

    //SEGMENT RMF CONTROLS






    //SUMMARY METHODS



    // AGE AND GENDER CONTROLS

    public void deptView() {
        isDisplayedBy(totalSpendDropdown, 5);
        click(totalSpendDropdown);
        isDisplayedBy(allDepartmentsButton, 5);
        click(allDepartmentsButton);
    }

    public void categoryView() {
        isDisplayedBy(totalSpendDropdown, 5);
        click(totalSpendDropdown);
        isDisplayedBy(allCategoriesButton, 5);
        click(allCategoriesButton);
    }


    //TOTAL SPEND BY PRODUCT METHODS



    //SEGMENT RMF METHODS



}

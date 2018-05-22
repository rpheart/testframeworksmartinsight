package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;

public class TimelineDetail extends Base {


    By customerCountChartTitle = By.xpath("//div[@class='timeline-segment-container']/div[1]/div[2]/div[@class='timeline-header-text' and contains(text(), 'Customer Count')]");
    By customerCountContainer = By.xpath("//div[@class='timeline-header-text' and contains(text(), 'Customer Count')]/../../..");
    By customerCountChartAxis = By.xpath("//div[@class='timeline-segment-container']/div[1]/div[2]/div[@class='timeline-header-text' and contains(text(), 'Customer Count')]/../../../div[@class='timeline-header-content-area']/div[1]/div[1]/div[1]");

    By gainsAndLossesChartTitle = By.xpath("//div[@class='timeline-segment-container']/div[1]/div[2]/div[@class='timeline-header-text' and contains(text(), 'Gains and Losses')]");
    By gainsAndLossesContainer = By.xpath("//div[@class='timeline-header-text' and contains(text(), 'Gains and Losses')]/../../..");
    By gainsAndLossesChartAxis = By.xpath("//div[@class='timeline-segment-container']/div[1]/div[2]/div[@class='timeline-header-text' and contains(text(), 'Gains and Losses')]/../../../div[@class='timeline-header-content-area']/div[1]/div[1]/div[1]");

    By customersWithTranscationsChartTitle = By.xpath("//div[@class='timeline-segment-container']/div[1]/div[2]/div[@class='timeline-header-text' and contains(text(), 'Customers with Transactions')]");
    By customersWithTranscationsContainer = By.xpath("//div[@class='timeline-header-text' and contains(text(), 'Customers with Transactions')]/../../..");
    By customersWithTranscationsChartAxis = By.xpath("//div[@class='timeline-segment-container']/div[1]/div[2]/div[@class='timeline-header-text' and contains(text(), 'Customers with Transactions')]/../../../div[@class='timeline-header-content-area']/div[1]/div[1]/div[1]");

    By totalSpendChartTitle = By.xpath("//div[@class='timeline-segment-container']/div[1]/div[2]/div[@class='timeline-header-text' and contains(text(), 'Total Spend')]");
    By totalSpendContainer = By.xpath("//div[@class='timeline-header-text' and contains(text(), 'Total Spend')]/../../..");
    By totalSpendChartAxis = By.xpath("//div[@class='timeline-segment-container']/div[1]/div[2]/div[@class='timeline-header-text' and contains(text(), 'Total Spend')]/../../../div[@class='timeline-header-content-area']/div[1]/div[1]/div[1]");

    By averageTotalSpendChartTitle = By.xpath("//div[@class='timeline-segment-container']/div[1]/div[2]/div[@class='timeline-header-text' and contains(text(), 'Average Total Spend')]");
    By averageTotalSpendContainer = By.xpath("//div[@class='timeline-header-text' and contains(text(), 'Average Total Spend')]/../../..");
    By averageTotalSpendChartAxis = By.xpath("//div[@class='timeline-segment-container']/div[1]/div[2]/div[@class='timeline-header-text' and contains(text(), 'Average Total Spend')]/../../../div[@class='timeline-header-content-area']/div[1]/div[1]/div[1]");

    By averageTransactionSpendChartTitle = By.xpath("//div[@class='timeline-segment-container']/div[1]/div[2]/div[@class='timeline-header-text' and contains(text(), 'Average Transaction Spend')]");
    By averageTransactionSpendContainer = By.xpath("//div[@class='timeline-header-text' and contains(text(), 'Average Transaction Spend')]/../../..");
    By averageTransactionSpendChartAxis = By.xpath("//div[@class='timeline-segment-container']/div[1]/div[2]/div[@class='timeline-header-text' and contains(text(), 'Average Transaction Spend')]/../../../div[@class='timeline-header-content-area']/div[1]/div[1]/div[1]");

    By firstTimeBuyersChartTitle = By.xpath("//div[@class='timeline-segment-container']/div[1]/div[2]/div[@class='timeline-header-text' and contains(text(), 'First Time Buyers')]");
    By firstTimeBuyersContainer = By.xpath("//div[@class='timeline-header-text' and contains(text(), 'First Time Buyers')]/../../..");
    By firstTimeBuyersChartAxis = By.xpath("//div[@class='timeline-segment-container']/div[1]/div[2]/div[@class='timeline-header-text' and contains(text(), 'First Time Buyers')]/../../../div[@class='timeline-header-content-area']/div[1]/div[1]/div[1]");

    By secondTimeBuyersChartTitle = By.xpath("//div[@class='timeline-segment-container']/div[1]/div[2]/div[@class='timeline-header-text' and contains(text(), 'Second Time Buyers')]");
    By secondTimeBuyersContainer = By.xpath("//div[@class='timeline-header-text' and contains(text(), 'Second Time Buyers')]/../../..");
    By secondTimeBuyersChartAxis = By.xpath("//div[@class='timeline-segment-container']/div[1]/div[2]/div[@class='timeline-header-text' and contains(text(), 'Second Time Buyers')]/../../../div[@class='timeline-header-content-area']/div[1]/div[1]/div[1]");

    By repeatBuyersChartTitle = By.xpath("//div[@class='timeline-segment-container']/div[1]/div[2]/div[@class='timeline-header-text' and contains(text(), 'Repeat Buyers')]");
    By repeatBuyersContainer = By.xpath("//div[@class='timeline-header-text' and contains(text(), 'Repeat Buyers')]/../../..");
    By repeatBuyersChartAxis = By.xpath("//div[@class='timeline-segment-container']/div[1]/div[2]/div[@class='timeline-header-text' and contains(text(), 'Repeat Buyers')]/../../../div[@class='timeline-header-content-area']/div[1]/div[1]/div[1]");

    By totalSpendByProductChartTitle = By.xpath("//div[@class='timeline-segment-container']/div[1]/div[2]/div[@class='timeline-header-text' and contains(text(), 'Total Spend by Product')]");
    By totalSpendByProductContainer = By.xpath("//div[@class='timeline-header-text' and contains(text(), 'Total Spend by Product')]/../../..");
    By totalSpendByProductChartAxis = By.xpath("//div[@class='timeline-segment-container']/div[1]/div[2]/div[@class='timeline-header-text' and contains(text(), 'Total Spend by Product')]/../../../div[@class='timeline-header-content-area']/div[1]/div[1]/div[1]");

    By totalSpendByProductProductLevel = By.xpath("//div[@class='timeline-segment-header-selection-view pull-left']/span[@class='timeline-segment-header-selection-view-title']");
    By totalSpendByProductItems = By.xpath("//div[@class='timeline-segment-header-selection-view pull-left']/span[@class='timeline-segment-header-selection-view-title']");
    By totalSpendByProductChartViewButton = By.xpath("//div[@class='btn timeline-segment-header-selection-configuration config-button']");


    public boolean verifyCustomerCountChart() {
        isDisplayedBy(customerCountChartTitle, 10);
        if ( isDisplayedBy(customerCountChartAxis, 60) ) {
            return true;
        }
        return false;
    }









}

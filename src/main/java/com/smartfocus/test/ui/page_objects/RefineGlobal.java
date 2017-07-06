package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RefineGlobal extends Base {
	
		// FILTERGROUPS AND RELATED ELEMENTS
	
	By AddGroup = By.cssSelector(".create-time-period-text");
	By AddPurchaseGroup = By.cssSelector("#create_grouping_SalesTransaction");
	By AddCampaignGroup = By.cssSelector("#create_grouping_CampaignTransaction");
	By AddPeopleGroup = By.cssSelector("#create_grouping_Customer");
	
/*	@FindAll( {
		@FindBy(xpath="//*[@id='refine']/div/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div/div[3]")
	})	
		private List<WebElement> AddedFilterGroups;
			//AddedFilterGroup(0) = PurchaseGroup;
	
	@FindBy(xpath="//*[@id='refine']/div/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div/div[3]")
	private WebElement group;
*/
	
	
/*	public List<WebElement> getAddedFilterGroups() {
		return AddedFilterGroups;
	}
*/
	public void addPurchaseGroup() {
		isDisplayedBy(AddGroup, 5);
		click(AddGroup);
		isDisplayedBy(AddPurchaseGroup, 5);
		click(AddPurchaseGroup);
		//isDisplayed(group, 5);
		//return group.getText();
		}
	
	
	public void addCampaignGroup() {
		isDisplayedBy(AddGroup, 5);
		click(AddGroup);
		isDisplayedBy(AddCampaignGroup, 5);
		click(AddCampaignGroup);		
		//isDisplayed(group, 5);
		//return group.getText();
	}
	
	public void addPeopleGroup() {
		isDisplayedBy(AddGroup, 5);
		click(AddGroup);
		isDisplayedBy(AddPeopleGroup, 5);
		click(AddPeopleGroup);
		//isDisplayed(group, 5);
		//return group.getText();
	}
	
	// FILTERS AND CONTAINERS (i.e. And/Or, QOSO)
	
	
		// CAMPAIGN FILTERS
	
	
	
	
		// PEOPLE FILTERS
	
	@FindBy(xpath="//*[@id='refine']/div/div/div/div[2]/div[1]/div/div[5]/ul/li[17]/div")
	private List<WebElement> filterAgeRange;
	
		// CUSTOM SEGMENTS FILTER
	
	
		// LOCATION FILTERS
	
	
		// PRODUCT AND PURCHASE FILTERS
	
	
	
		// CONTAINERS
	
	@FindBy(xpath="//*[@id='refine']/div/div/div/div[2]/div[1]/div/div[2]/div[2]/ul/li[1]")
		private List<WebElement> AndOr;
	
	@FindBy(xpath="//*[@id='refine']/div/div/div/div[2]/div[1]/div/div[2]/div[2]/ul/li[2]")
		private List<WebElement> QOSO;
		
	
		// SEARCH FILTERS TEXT BOX
	
	@FindBy(xpath="//*[@id='refine']/div/div/div/div[2]/div[1]/div/div[4]/div/div/div/div/input")	
		private List<WebElement> FilterSearch;

}
 
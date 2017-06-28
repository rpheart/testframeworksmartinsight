package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SegmentNameText extends Base {

	//@FindBy(xpath="//*[@id='refine-segmentation-section']/div[1]/div[1]/div[6]/div[2]/div")
	//private WebElement SegmentTitle;
	By SegmentTitle = By.xpath("//*[@id='refine-segmentation-section']/div[1]/div[1]/div[6]/div[2]/div");
	
	@FindBy(xpath="//*[@id='refine-segmentation-section']/div[1]/div[3]/div[2]/div")
	private WebElement SegmentTitleModal;
	
	@FindBy(xpath="//*[@id='refine-segmentation-section']/div[1]/div[3]/div[2]/div/div[2]/input")
	private WebElement SegmentText;
	
	
	
	public String getText() {
		isDisplayedBy(SegmentTitle,5);
		click(SegmentTitle);
		isDisplayed(SegmentText, 5);
		return SegmentText.getAttribute("value");

	}

}

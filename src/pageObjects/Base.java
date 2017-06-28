package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static WebDriver driver;
	
	public static void visit(String url) {
		driver.get(url);
	}
	
	public WebElement find(By locator) {
		return driver.findElement(locator);
	}
	public WebElement findString(By xpath) {
		return driver.findElement(xpath);
	}
	
	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}
	
	
	public void type(By locator, String inputText) {
		find(locator).sendKeys(inputText);
	}  
	
	public void click(By locator) {
		find(locator).click();
	}
	
	
	public Boolean isDisplayed(WebElement locator, int maxWaitTime) {
		try {
			waitFor(ExpectedConditions.visibilityOf(locator), maxWaitTime);
		} catch (org.openqa.selenium.TimeoutException exception) {
			return false;
		}
		return true;
		
	}
	
	public Boolean isDisplayedBy(By locator, int maxWaitTime) {
		try {
			waitFor(ExpectedConditions.visibilityOfElementLocated(locator), maxWaitTime);
		} catch (org.openqa.selenium.TimeoutException exception) {
			return false;
		}
		return true;
	}

	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeout) {
		timeout = timeout != null ? timeout : 5;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(condition);
		
	}
	
	public static void tearDown() {
		driver.quit();
		
	}
	
	
}

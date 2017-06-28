package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoMan1 {

	public static void main(String[] args) {

	WebDriver ChromeDriver = new ChromeDriver();
	ChromeDriver.manage().window().maximize(); 
	ChromeDriver.get("http://qa-sfui.themessagecloud.com");

		WebElement loginInput = ChromeDriver.findElement(By.id("IDToken1"));
		loginInput.sendKeys("SIDEVALL");
		
		WebElement passwordInput = ChromeDriver.findElement(By.id("IDToken2"));
		passwordInput.sendKeys("HeadCheese!9");
		
		WebElement loginButton = ChromeDriver.findElement(By.id("loginButton"));
		loginButton.click();
		
		ChromeDriver.close();
	}

}

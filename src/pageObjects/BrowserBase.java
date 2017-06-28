package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserBase extends Base {
	
	
	public static WebDriver startBrowser (String browserName, String url){
		if (browserName.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
			visit(url);
			driver.manage().window().maximize();
		}
		else if (browserName.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
			visit(url);
			driver.manage().window().maximize();
		}
		else if (browserName.equalsIgnoreCase("explorer")){
			driver = new InternetExplorerDriver();
			visit(url);
			driver.manage().window().maximize();
		}
	
		return driver;
	}
	
}

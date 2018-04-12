package com.smartfocus.test.ui.page_objects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.Map;

public class BrowserBase extends Base {

    public static WebDriver startBrowser (String browserName, String url){
        if (browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();

            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.plugins", 1);
            prefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
            prefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);
            // Enable Flash for this site
            prefs.put("PluginsAllowedForUrls", "https://qa-sfui.themessagecloud.com");
          //  prefs.put("PluginsAllowedForUrls", "https://preprod.themessagecloud.com");
            options.setExperimentalOption("prefs", prefs);


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

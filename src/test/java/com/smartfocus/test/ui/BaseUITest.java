package com.smartfocus.test.ui;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

/**
 * Created by mario on 11/1/2017.
 */
public class BaseUITest {
    @BeforeSuite
    public static void initiliazeSuite() {

    }

    @AfterSuite
    public static void shutdown() {

    }

    @DataProvider(name = "myData")
    public static Object[][] getData() {
        return new Object[][] {
                { "arg1a", "arg2a" },
                { "arg1b", "arg2b" }
        };
    }
}

package com.smartfocus.test.ui.sampletest;

import com.smartfocus.test.Assert;
import com.smartfocus.test.ui.BaseUITest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by mario on 11/1/2017.
 */
public class SampleTest extends BaseUITest {
    public static String myGlobalObject = null;

    @BeforeClass
    public static void setMyGlobalObject() {
        myGlobalObject = "Test";
    }

    @Test(enabled = true, groups = {"sample"}, dataProvider = "myData")
    public void testDataProvider(String arg1, String arg2) {
        Assert.assertNotNull(arg1, "arg1 is null");
        Assert.assertNotNull(arg2, "arg2 is null");
        System.out.println("arg1:" + arg1);
        System.out.println("arg2:" + arg2);
    }

    @AfterClass
    public static void clearObjects() {
        myGlobalObject = null;
    }
}

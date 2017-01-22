package com.yorel.incredible.acceptance;

import com.yorel.incredible.core.WebDriverFactory;
import org.junit.AfterClass;

public class BaseTest {
    @AfterClass
    public static void tearDown(){
        WebDriverFactory.closeDrvier();
    }
}

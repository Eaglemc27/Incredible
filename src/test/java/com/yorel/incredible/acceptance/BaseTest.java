package com.yorel.incredible.acceptance;

import com.yorel.incredible.core.WebDriverFactory;
import org.junit.jupiter.api.AfterAll;

public class BaseTest {
    @AfterAll
    public static void tearDown(){
        WebDriverFactory.closeDrvier();
    }
}

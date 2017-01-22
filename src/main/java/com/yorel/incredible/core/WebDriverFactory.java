package com.yorel.incredible.core;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if(driver == null)
            driver = createDriver();
        return driver;

    }

    private static WebDriver createDriver() {
        String browser = Config.BROWSER;
        switch (browser) {
            case "Chrome":
                ChromeDriverManager.getInstance().setup();
                return new ChromeDriver();
            case "Firefox":
                FirefoxDriverManager.getInstance().setup();
                return new FirefoxDriver();
            case "IE":
                InternetExplorerDriverManager.getInstance().setup();
                return new InternetExplorerDriver();
            case "Edge":
                EdgeDriverManager.getInstance().setup();
                return new EdgeDriver();
            default:
                throw new RuntimeException("Unknown browser: " + browser);
        }
    }

    public static void closeDrvier() {
        if(driver != null)
            driver.quit();
    }
}

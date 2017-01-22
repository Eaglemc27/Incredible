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

import java.util.concurrent.ConcurrentHashMap;

public class WebDriverFactory {

    private static ConcurrentHashMap<Long, WebDriver> driver = new ConcurrentHashMap();

    public static WebDriver getDriver() {
        long threadId = Thread.currentThread().getId();
        driver.computeIfAbsent(threadId, k -> createDriver());
        return driver.get(threadId);

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
        driver.forEach((number, webdriver) -> {
          if(webdriver != null)
              webdriver.quit();
        });
        }
}

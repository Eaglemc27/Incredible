package com.yorel.incredible;

import com.yorel.incredible.core.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Proxy;
import java.util.Set;

public class API {

    public static SmartElement s(By by){
        return (SmartElement) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{SmartElement.class},
                                new SmartElementProxy(new ElementFinder(getWebDriver(), by, 0)));
    }

    private static WebDriver getWebDriver() {
        return WebDriverFactory.getDriver();
    }

    public static SmartElement s(String cssSelector){
        return s(By.cssSelector(cssSelector));
    }

    public static void open(String url) {
        if (url.startsWith("http")) {
            getWebDriver().get(url);
        } else {
            getWebDriver().get(Config.BASE_URL + url);
        }
    }

    public static void openNewTab(String url){
        String currentTab = getWebDriver().getWindowHandle();
        ((JavascriptExecutor)getWebDriver()).executeScript("window.open();");
        Set handles = getWebDriver().getWindowHandles();
        handles.remove(currentTab);
        getWebDriver().switchTo().window((String) handles.iterator().next());
    }

    public static void closeTab() {
        Set handles = getWebDriver().getWindowHandles();
        String currentTab = getWebDriver().getWindowHandle();
        getWebDriver().close();
        handles.remove(currentTab);
        getWebDriver().switchTo().window((String) handles.iterator().next());
    }
}

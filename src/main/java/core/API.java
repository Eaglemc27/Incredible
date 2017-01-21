package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Proxy;

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

    public static void open(String url){
        getWebDriver().get(url);
    }
}

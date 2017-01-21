package core;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    private static WebDriver driver;

    static WebDriver getDriver() {
        if(driver == null)
            driver = createDriver();
        return driver;

    }

    private static WebDriver createDriver() {
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver();
    }

    public static void closeDrvier() {
        if(driver != null)
            driver.quit();
    }
}

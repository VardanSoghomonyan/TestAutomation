package driver_manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
    }

//    public static getDriver() {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
//        initializeDriver();
//    }

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }
}
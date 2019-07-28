package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class ProjectSetup {
    protected WebDriver driver;

    public ProjectSetup(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementVisible(WebElement element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClickable(WebElement element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
    }

}
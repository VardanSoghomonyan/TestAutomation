import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class ProjectSetup {
    protected WebDriver driver;

    protected ProjectSetup (WebDriver driver){
        this.driver = driver;
    }

    public void waitForElementVisible (By by){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementClickable (By by){
        new WebDriverWait(driver, 120).until(ExpectedConditions.elementToBeClickable(by));
    }
//    public void clickabilityAndVisisbilityOfElement (By by){
//        new WebDriverWait(driver, 120).until(ExpectedConditions.);
//    }

    public void clickBtn(By by){
        driver.findElement(by).click();
    }

    public List<WebElement> elementList (By by){
        List<WebElement> list = driver.findElements(by);
        return list;
    }
}

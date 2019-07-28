package page_objects.gmail_page_object;

import business_objects.gmail_business_objects.GmailUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailPasswordPage extends GmailPageSetup {

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordField;

    @FindBy(css = "#passwordNext")
    public WebElement passwordNext;

    public GmailPasswordPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public GmailPasswordPage fillPassword (String password) {
        waitForElementVisible(passwordField);
        passwordField.sendKeys(password);
        return this;
    }

    public void clickLogin() {
        waitForElementClickable(passwordNext);
        passwordNext.click();
    }

    public GmailLogoutPage fillPasswordAndClickLogin (GmailUser user) {
        fillPassword(user.getPassword());
        clickLogin();
        return new GmailLogoutPage(driver);
    }

}

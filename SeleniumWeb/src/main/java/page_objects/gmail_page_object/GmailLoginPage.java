package page_objects.gmail_page_object;

import business_objects.gmail_business_objects.GmailUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPage extends GmailPageSetup {

    @FindBy(css = "#identifierId")
    public WebElement emailField;

    @FindBy(css = ".RveJvd.snByac")
    public WebElement nextButton;

    public GmailLoginPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public GmailLoginPage openHomePage (){
        driver.get("https://gmail.com");
        return this;
    }

    public GmailLoginPage fillEmail(String email) {
        waitForElementVisible(emailField);
        emailField.sendKeys(email);
        return this;
    }

    public void clickNext() {
        waitForElementClickable(nextButton);
        nextButton.click();
    }

    public GmailPasswordPage fillEmailAndClickNext (GmailUser user) {
        fillEmail(user.getEmail());
        clickNext();
        return new GmailPasswordPage(driver);
    }

}

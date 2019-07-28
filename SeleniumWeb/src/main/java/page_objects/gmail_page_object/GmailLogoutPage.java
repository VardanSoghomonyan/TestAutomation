package page_objects.gmail_page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLogoutPage extends GmailPageSetup{

    @FindBy(css = ".gb_xa.gbii")
    public WebElement MyAccount;

    @FindBy(css = "#gb_71")
    public WebElement SignOutButton;

    public GmailLogoutPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public GmailLoginPage logout (){
        waitForElementClickable(MyAccount);
        MyAccount.click();
        SignOutButton.click();
        return new GmailLoginPage (driver);
    }

}

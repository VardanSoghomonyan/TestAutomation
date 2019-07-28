package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header extends ProjectSetup {
    //    protected final By SEARCH_INPUT = By.cssSelector("#twotabsearchtextbox");
//    protected By searchButton = By.xpath("//div[@class='nav-search-submit nav-sprite']");
    protected String searchableWord = "headphone";

    @FindBy(css = "#twotabsearchtextbox")
    protected WebElement SEARCH_INPUT;

    @FindBy(xpath = "//div[@class='nav-search-submit nav-sprite']")
    protected WebElement searchButton;

    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public Header fillSearchInput() {
        waitForElementVisible(SEARCH_INPUT);
        SEARCH_INPUT.sendKeys(searchableWord);
        return this;
    }

    public SearchResultPage clickOnSearchBtn() {
        searchButton.click();
        return new SearchResultPage(driver);
    }

}

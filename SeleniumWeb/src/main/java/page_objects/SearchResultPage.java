package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage extends HomePage {
//    protected By searchedList = By.cssSelector(".a-size-medium.a-color-base.a-text-normal");
//    protected By addToCart = By.cssSelector("#add-to-cart-button");
    private String firstResultName;

    @FindAll(@FindBy(css = ".a-size-medium.a-color-base.a-text-normal"))
    protected List<WebElement> searchedListElement;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ViewCartPage selectFirstResult() {
        this.firstResultName = searchedListElement.get(1).getText();
        searchedListElement.get(1).click();
        return new ViewCartPage(driver);
    }

    public String getFirstResultName() {
        return firstResultName;
    }

}

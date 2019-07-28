package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCartPage extends ProjectSetup {
//    protected By viewCartButton = By.cssSelector("a[href='/gp/cart/view.html/ref=uss_cart']");

    @FindBy(css = "#add-to-cart-button")
    protected WebElement addToCart;

    @FindBy(css = "a[href='/gp/cart/view.html/ref=uss_cart']")
    protected WebElement viewCartButton;


    public ViewCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ViewCartPage clickOnAddToCartButton() {
        addToCart.click();
        return this;
    }

    public ItemsInCartPage clickOnViewCartButton() {
        waitForElementClickable(viewCartButton);
        viewCartButton.click();
        return new ItemsInCartPage(driver);
    }

}

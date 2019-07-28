package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ItemsInCartPage extends Header {

//    protected By itemsInCartSelector = By.cssSelector(".a-size-medium.sc-product-title.a-text-bold");

    @FindBys(@FindBy(css = ".a-size-medium.sc-product-title.a-text-bold"))
    public List<WebElement> itemsInCart;


    public ItemsInCartPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);

    }

    public boolean isTheItemInCart (List<WebElement> list, String name){
        boolean isExist = false;
        for (WebElement item: list) {
            if (item.getText().trim().equals(name)) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }

}

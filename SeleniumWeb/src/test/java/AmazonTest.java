import driver_manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.Header;
import page_objects.HomePage;
import page_objects.ItemsInCartPage;
import page_objects.SearchResultPage;

public class AmazonTest {
    WebDriver driver = DriverManager.getDriver();

//    protected WebDriverWait wait;


    @BeforeClass
    public void precondition() {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        wait = new WebDriverWait(driver, 10);
    }

    @Test(description = "Find headphone in Amazon")
    public void amazonSearchTest() {

        new HomePage(driver).visitHomePage();

        Header headerObject = new Header(driver).fillSearchInput();

//                .searchButton.click();

        SearchResultPage searchResultPageObject = headerObject.clickOnSearchBtn();
        searchResultPageObject
                .selectFirstResult()

//        ViewCartPage ViewCartPageObject = new ViewCartPage(driver);
//        ViewCartPageObject
                .clickOnAddToCartButton()
                .clickOnViewCartButton();

        ItemsInCartPage ItemsInCartPageObject = new ItemsInCartPage(driver);
        Assert.assertTrue(ItemsInCartPageObject.isTheItemInCart(ItemsInCartPageObject.itemsInCart, searchResultPageObject.getFirstResultName()), "Item is missing");

    }

    @AfterClass
    public void postCondition() {
        driver.close();
        driver.quit();
    }
}

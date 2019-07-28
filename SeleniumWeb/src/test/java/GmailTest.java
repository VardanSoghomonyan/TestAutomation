import business_objects.gmail_business_objects.GmailUser;
import driver_manager.DriverManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import page_objects.gmail_page_object.GmailLoginPage;
import utils.FileDataReader;

import java.lang.reflect.Array;

public class GmailTest {
    private GmailUser astvac;
    WebDriver driver ;/*= DriverManager.getDriver();*/

    @DataProvider(name = "user data")
    public Object[][] credentials (){
//        return new String[][]{{"testastvac@gmail.com", "Aa123456!"},
//                {"testastvac@gmail.com", "Aa123456!"}};
        FileDataReader dataReader = new FileDataReader();
        return dataReader.get2DArrayFromJsonFile("src/test/resources/user_data.json");
    }

    @BeforeMethod
//    @Parameters ({"username", "password"})
    public void preconditions (/*String name, String password*/){
//        astvac = new GmailUser(name, password);
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Login in gmail.com", dataProvider = "user data")
    public void loginInGmail(String username, String password) throws InterruptedException {
        astvac = new GmailUser(username, password);
        new GmailLoginPage(driver)
                .openHomePage()
                .fillEmailAndClickNext(astvac)
                .fillPasswordAndClickLogin(astvac)
                .logout()
                .openHomePage();
        Thread.sleep(5000);
    }

    @AfterMethod
    public void postConditions(){
        driver.close();
        driver.quit();
        driver = null;
    }

}

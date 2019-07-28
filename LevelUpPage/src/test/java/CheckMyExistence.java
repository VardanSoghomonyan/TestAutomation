import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class CheckMyExistence {

    WebDriver driver;


    @BeforeClass
    public void preConditions () {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test (description = "FInd me in a student list")
    public void checkMeInTheList(){
        LevelUpHome levelUpHomeObject = new LevelUpHome(driver);
        levelUpHomeObject.openUrl(levelUpHomeObject.HOMEPAGE_URL);
        levelUpHomeObject.waitForElementClickable(levelUpHomeObject.STUDENTS_BUTTON);
        levelUpHomeObject.clickBtn(levelUpHomeObject.STUDENTS_BUTTON);
        FindMeInStudents findMeInStudentsObject = new FindMeInStudents(driver);
        levelUpHomeObject.waitForElementClickable(findMeInStudentsObject.STUDENT_LIST_LOCATION);
        List<WebElement> studentsList = levelUpHomeObject.elementList(findMeInStudentsObject.STUDENT_LIST_LOCATION);
        String name = "Vardan Soghomonyan";
        Assert.assertTrue(findMeInStudentsObject.isStudentExist(studentsList, name), "Name is not exist");
    }

    @AfterMethod
    public void postConditions () {
        driver.close();
        driver.quit();
    }
}

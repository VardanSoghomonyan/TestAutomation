import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LevelUpHome extends ProjectSetup {

    public final String HOMEPAGE_URL = "https://levelup.am/uk";
    protected final By STUDENTS_BUTTON = By.xpath("//a[contains(@href,'students')]");


    protected LevelUpHome(WebDriver driver) {
        super(driver);
    }
    public void openUrl (String url){
        driver.get(url);
    }
}

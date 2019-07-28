import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindMeInStudents extends ProjectSetup {

    protected final By STUDENT_LIST_LOCATION = By.xpath("//div[contains(@class, 'info-block')]/h3");

    protected FindMeInStudents(WebDriver driver) {
        super(driver);
    }

    public boolean isStudentExist(List<WebElement> list, String name) {
        boolean is = false;
        for (WebElement item : list) {
            if (item.getText().equals(name)) {
                is = true;
                break;
            }
        }
        return is;
    }
}


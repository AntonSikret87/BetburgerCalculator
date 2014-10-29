package Tests;

import data.Settings;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Дом
 * Date: 25.12.13
 * Time: 13:20
 * To change this template use File | Settings | File Templates.
 */
public class BaseTest extends Settings {

    @BeforeMethod(groups = {"good", "bad"})
    public void openBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
        setDriver(new ChromeDriver());
        getDriver().manage().window().setSize(new Dimension(1440, 900)); // развернёт браузер на весь экран
    }

//     public BaseTest Logout() throws InterruptedException{
//         getDriver().findElement(By.xpath(".//*[@id='userNavigationLabel']")).click();
//         wait(2000);
//         getDriver().findElement(By.xpath(".//*[@id='logout_form']/label/input")).click();
//         wait(2000);
//         return new BaseTest();
//     }

    @AfterMethod(groups = {"good", "bad"})
    public void after() throws IOException, InterruptedException {
//      BaseTest logout = Logout();
        getDriver().close();
    }
}

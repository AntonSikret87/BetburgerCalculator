package Tests;

import Methods.MainPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

/**
 * Created by sikret on 27.08.2014.
 */
public class MainPageTest extends BaseTest {

    public MainPageTest GoToAuthorize() throws InterruptedException, IOException {
        goHome();
        MainPage signIn = new MainPage();
        signIn.GoToSignIn();
        String _Email = signIn.getProperty("EmailValue.good");
        signIn.Email(_Email);
        wait(1000);
        String _Password = signIn.getProperty("PasswordValue.good");
        signIn.Password(_Password);
        signIn.SignInBTN();
        assertEquals("×\nSigned in successfully.", getDriver().findElement(By.xpath("//div[2]/div")).getText());
        wait(2000);
        return new MainPageTest();
    }

    @Test(groups = {"good"})
    public void LogIn() throws InterruptedException, IOException {
        MainPageTest signin = new MainPageTest();
        signin.GoToAuthorize();
    }
}

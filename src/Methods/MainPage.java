package Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by sikret on 27.08.2014.
 */
public class MainPage extends PageBase {
    public WebElement SignInLink;
    public WebElement EmailField;
    public WebElement PasswordField;
    public WebElement SignInbtn;
    public WebElement LogoutBtn;

    public MainPage() throws IOException {               //використовується у всіх тестах

        super();

    }

    public void Init() {                 //використовується у всіх тестах

    }
    public CalculatePage GoToCalc() throws InterruptedException, IOException {
        SignInLink = getDriver().findElement(By.xpath("html/body/div[1]/div/div[2]/ul[1]/li[5]/a"));
        SignInLink.click();
        return new CalculatePage();
    }

    public void GoToSignIn() throws InterruptedException, IOException {
        SignInLink = getDriver().findElement(By.xpath(getProperty("SignInLink.xpath")));
        SignInLink.click();

    }
    public void Email(String _Email) throws InterruptedException {
        EmailField = getDriver().findElement(By.xpath(getProperty("EmailField.xpath")));
        EmailField.click();
        EmailField.clear();
        EmailField.sendKeys(_Email);

    }

    public void Password(String _Password) throws InterruptedException {
        PasswordField = getDriver().findElement(By.xpath(getProperty("PasswordField.xpath")));
        PasswordField.click();
        PasswordField.clear();
        PasswordField.sendKeys(_Password);
    }

    public void SignInBTN() throws InterruptedException {
        SignInbtn = getDriver().findElement(By.xpath(getProperty("SignInBTN.xpath")));
        SignInbtn.click();
    }
    public void Logout() throws InterruptedException, IOException {
        LogoutBtn = getDriver().findElement(By.xpath(getProperty("Logout.xpath")));
        LogoutBtn.click();

    }


}

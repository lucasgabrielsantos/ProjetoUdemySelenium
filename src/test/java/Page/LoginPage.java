package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver nav) {
        super(nav);
    }

    public LoginFormPage clicarSignIn() {
        nav.findElement(By.linkText("Sign in")).click();

    return new LoginFormPage(nav);
    }

}
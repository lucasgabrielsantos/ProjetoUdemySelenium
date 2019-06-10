package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver nav;

    public LoginPage(WebDriver nav) {
        this.nav = nav;
    }
    public LoginFormPage ClicarLogin() {
        nav.findElement(By.linkText("Sign in")).click();

    return new LoginFormPage(nav);
    }

}
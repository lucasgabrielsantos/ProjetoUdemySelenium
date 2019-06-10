package Page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginFormPage extends BasePage {


    public LoginFormPage(WebDriver nav) {
        super(nav);
    }

    public LoginFormPage digiteLogin(String login) {
        nav.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);

        return this;
    }

    public LoginFormPage digiteSenha(String password) {
        nav.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);

        return this;
    }

    public SecretaPage clicarNoSign() {
        nav.findElement(By.linkText("SIGN IN")).click();

        return new SecretaPage(nav);
    }

    public SecretaPage fazerLogin(String login, String senha) {
       digiteLogin(login);
       digiteSenha(senha);
       clicarNoSign();

        return new SecretaPage(nav);
    }
}







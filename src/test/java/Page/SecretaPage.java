package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import suporte.Web;

public class SecretaPage extends BasePage {

    public SecretaPage(WebDriver nav) {
        super(nav);
    }

    public Mepage clicarMe(){
            nav.findElement(By.className("me")).click();

        return new Mepage(nav);
        }
}


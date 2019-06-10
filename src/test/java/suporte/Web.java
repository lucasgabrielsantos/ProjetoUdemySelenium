package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {
    public static WebDriver createChrome(){
        System.setProperty("webdriver.chrome.driver", "\\C:\\Users\\lgabriel\\drivers\\chromedriver.exe");

        //criando objeto navegador
        WebDriver nav = new ChromeDriver();
        nav.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //navegando até a pagina
        nav.get("http://www.juliodelima.com.br/taskit/");

        return  nav;
    }
}

package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {
    public static final String USERNAME = "lucasgabrieldoss1";
    public static final String AUTOMATE_KEY = "EehuiPcm8wRmGU6ggNJp";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createChrome(){
        System.setProperty("webdriver.chrome.driver", "\\C:\\Users\\lgabriel\\drivers\\chromedriver.exe");

        //criando objeto navegador
        WebDriver nav = new ChromeDriver();
        nav.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //navegando até a pagina
        nav.get("http://www.juliodelima.com.br/taskit/");

        return  nav;
    }
    public static WebDriver createBrowserStack(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "74.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1920x1080");

        WebDriver nav = null;
        try {
            nav = new RemoteWebDriver(new URL(URL), caps);

            nav.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            //navegando até a pagina
            nav.get("http://juliodelima.com.br/taskit/");

        } catch (MalformedURLException e ){
            System.out.println("Houveram problemas com a URL: " + e.getMessage());
        }

        return nav;
    }
}

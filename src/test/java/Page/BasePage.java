package Page;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver nav;

    public  BasePage (WebDriver nav){
        this.nav = nav;

    }
}

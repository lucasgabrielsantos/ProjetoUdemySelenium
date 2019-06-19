package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver nav;

    public BasePage(WebDriver nav) {
        this.nav = nav;
    }

    public String capturarTextoToast() {
        return nav.findElement(By.id("toast-container")).getText();
    }
}

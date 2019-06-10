package Page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Mepage extends BasePage {

    public Mepage(WebDriver nav) {
        super(nav);
    }

    public Mepage ClicarAbaMoreDataAbout() {
        nav.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        return this;
    }

    public AddContactPage ClicarNoBotaoAddMoreDataAboutYou(){

        nav.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        return new AddContactPage(nav);
    }
}

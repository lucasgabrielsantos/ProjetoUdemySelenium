package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddContactPage extends BasePage {
        public AddContactPage(WebDriver nav) {
            super(nav);
        }
        public AddContactPage escolherTipoDeContato(String tipo) {
            WebElement campoType = nav.findElement(By.id("addmoredata")).findElement(By.name("type"));
            new Select(campoType).selectByVisibleText(tipo);

            return this;
        }
        public AddContactPage digitarContato(String contato) {
            nav.findElement(By.id("addmoredata")).findElement(By.name("contact")).sendKeys(contato);

            return this;
        }
        public Mepage clicarSalvar() {
            nav.findElement(By.id("addmoredata")).findElement(By.linkText("SAVE")).click();

            return new Mepage(nav);

        }
        public Mepage AdicionarContato(String tipo, String contato){
            escolherTipoDeContato(tipo);
            digitarContato(contato);
            clicarSalvar();
            return new Mepage(nav);

        }
    }

package tests;

import static org.junit.Assert.*;

import jdk.management.resource.internal.inst.FileInputStreamRMHooks;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Generator;
import javax.naming.Name;
import java.util.concurrent.TimeUnit;

        @RunWith(DataDrivenTestRunner.class)
        @DataLoader(filePaths = "InformacoesUsuarioTests.csv")

        public class InformacoesUsuarioTests {
          private WebDriver nav;


            @Rule
            public TestName testeName = new TestName();

            @Before
            public void setUp() {

                System.setProperty("webdriver.chrome.driver", "\\C:\\Users\\lgabriel\\drivers\\chromedriver.exe");

                //criando objeto navegador
                nav = new ChromeDriver();
                nav.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                //navegando até a pagina
                nav.get("http://www.juliodelima.com.br/taskit/");

                //Clicando no link "Sign in"
                nav.findElement(By.linkText("Sign in")).click();

                //Identificando o formulario de login
                WebElement formSignInbox = nav.findElement(By.id("signinbox"));

                //Digitar no campo com nome "login" dentro da class "signinbox" com o texto "julio0001"
                formSignInbox.findElement(By.name("login")).sendKeys("julio0001");

                //Digitar no campo com nome "password" dentro da class "signinbox"
                formSignInbox.findElement(By.name("password")).sendKeys("123456");

                //Clicando no link "SIGN IN"
                nav.findElement(By.linkText("SIGN IN")).click();

                nav.findElement(By.className("me")).click();

                nav.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
            }

                @Test
                public void  testAdicionaUmaInformacaoAdicionalDoUsuario(@Param(name="tipo")String tipo, @Param(name = "contato")String contato, @Param(name = "msg") String mensagemEsperada){

                nav.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
                WebElement popupAddMoreData = nav.findElement(By.id("addmoredata"));

                WebElement campoType = popupAddMoreData.findElement(By.name("type"));
                new Select(campoType).selectByVisibleText(tipo);

                popupAddMoreData.findElement(By.name("contact")).sendKeys(contato);

                popupAddMoreData.findElement(By.linkText("SAVE")).click();

                WebElement mensagemPop = nav.findElement(By.id("toast-container"));
                String msg = mensagemPop.getText();
                assertEquals(mensagemEsperada, msg);


            }

                @Test
                public void removerUmContatoDeUmUsuario() {

                //Utilizando following-sibling:a para encontrar um link abaixo, ou preceding para encontrar um acima.
                nav.findElement(By.xpath("//span[text()=\"+5531999991111\"]//following-sibling::a")).click();

                //Confirmar a janela JS
                nav.switchTo().alert().accept();

                WebElement mensagemPop = nav.findElement(By.id("toast-container"));
                String msg = mensagemPop.getText();
                assertEquals("Rest in peace, dear phone!", msg);

                Screenshot.tirar(nav, "C:\\Users\\lgabriel\\Desktop\\UdemyProjeto\\Screenshot" + Generator.dataHoraParaArquivo() + testeName.getMethodName() + ".png");

                WebDriverWait aguardar = new WebDriverWait(nav, 10);
                aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));

                nav.findElement(By.linkText("Logout")).click();

            }

            @After
            public void tearDown(){

                //Fechando o navegador
                nav.quit();

            }
}

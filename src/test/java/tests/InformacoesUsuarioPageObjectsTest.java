package tests;

import Page.BasePage;
import Page.LoginFormPage;
import Page.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import suporte.Web;

public class InformacoesUsuarioPageObjectsTest{
        private WebDriver nav;

        @Before
            public void SetUp(){
                nav = Web.createChrome();
            }

        @Test
            public void testAdicionaUmaInformacaoAdicionalDoUsuario() {
                new LoginPage(nav)
                        .clicarSignIn()
                        .fazerLogin("julio0001","123456")
                        .clicarMe()
                        .ClicarAbaMoreDataAbout()
                        .ClicarNoBotaoAddMoreDataAboutYou()
                        .AdicionarContato("Phone","+5511999988881");
            }

            @After
            public void tearDown() {
                //nav.quit();

            }
        }

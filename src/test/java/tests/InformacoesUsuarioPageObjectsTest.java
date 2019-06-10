package tests;

import Page.LoginFormPage;
import Page.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import suporte.Web;

public class InformacoesUsuarioPageObjectsTest {
    private WebDriver nav;

        @Before
        public void SetUp() {
            nav = Web.createChrome();

        }

        @Test
        public void testAdicionaUmaInformacaoAdicionalDoUsuario() {
            new LoginPage(nav)
                    .ClicarLogin()
                    .fazerLogin("julio0001","123456");
        }

        @After
        public void tearDown() {
            nav.quit();

        }
    }
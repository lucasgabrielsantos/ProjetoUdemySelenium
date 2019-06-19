package tests;

import Page.LoginPage;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import suporte.Web;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioTests.csv")
public class InformacoesUsuarioPageObjectsTest{
        private WebDriver nav;

        @Before
            public void SetUp() {
            nav = Web.createBrowserStack();
        }
        @Test
            public void testAdicionaUmaInformacaoAdicionalDoUsuario(
                    @Param(name="login")String login,
                    @Param(name="senha")String senha,
                    @Param(name="tipo")String tipo,
                    @Param(name="contato")String contato,
                    @Param(name="msg")String msgEsperada
            ) {
                String textoToast = new LoginPage(nav)
                        .clicarSignIn()
                        .fazerLogin(login,senha)
                        .clicarMe()
                        .ClicarAbaMoreDataAbout()
                        .ClicarNoBotaoAddMoreDataAboutYou()
                        .AdicionarContato(tipo,contato)
                        .capturarTextoToast();
            assertEquals(msgEsperada, textoToast);
            }

            @After
            public void tearDown() {
            
               nav.quit();

            }
        }

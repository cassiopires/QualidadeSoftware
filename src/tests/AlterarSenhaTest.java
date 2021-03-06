package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import classes.Driver;
import classes.Elemento;
import classes.Pagina;
import classes.PaginaLogin;
import classes.Validador;

public class AlterarSenhaTest {
	private WebDriver driver;

	@Test
	public void testAlterarSenhaUsuarioPush() throws Exception {
		this.driver = Driver.getDriver();
		
		PaginaLogin.login(this.driver);

		Elemento.digitarPorNome(driver, "visitante_senha", "zarag0za");
		
		Elemento.digitarPorNome(driver, "visitante_senha_conf", "zarag0za");
		
		Elemento.clicarPorNome(driver, "salvar");
		
		Elemento.clicarOkAlert(this.driver);
		
		Validador.validarResultado("http://www2.trf4.jus.br/trf4/controlador.php?acao=push_altera_cadastro&msg=Suas", driver.getCurrentUrl().substring(0, 79));
	}

}
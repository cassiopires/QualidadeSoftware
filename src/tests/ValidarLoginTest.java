package tests;

import java.io.Console;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import classes.Driver;
import classes.Elemento;
import classes.Pagina;
import classes.PaginaLogin;
import classes.Validador;

public class ValidarLoginTest {
	private WebDriver driver;

	@Test
	public void testeValidarUsuarioValido() throws Exception {
		this.driver = Driver.getDriver();
		
		PaginaLogin.setUsuarioSenha("cle@trf4.jus.br", "zarag0za");
		
		PaginaLogin.login(this.driver);
		
		Validador.validarResultado("http://www2.trf4.jus.br/trf4/controlador.php?acao=push_altera_cadastro&validacao=1", driver.getCurrentUrl());
	}
	
	@Test
	public void testeValidarUsuarioInvalido() throws Exception {
		this.driver = Driver.getDriver();
		
		PaginaLogin.setUsuarioSenha("cle@trf4.jus.br", "teste-teste");
		
		PaginaLogin.login(this.driver);
		
		Elemento.clicarOkAlert(this.driver);
		
		Validador.validarResultado("http://www2.trf4.jus.br/trf4/controlador.php?acao=push_login&processo=&origem=", driver.getCurrentUrl());
    }

}
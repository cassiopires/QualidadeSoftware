package tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import classes.Driver;
import classes.PaginaCadastro;
import classes.PaginaLogin;
import classes.Validador;

public class ListarProcessosTest {
	private WebDriver driver;

	@Test
	public void testeListarProcessos() throws Exception {
		this.driver = Driver.getDriver();
		
		PaginaLogin.login(this.driver);

		PaginaCadastro.listarProcessos(this.driver);

		Validador.validarResultado("http://www2.trf4.jus.br/trf4/controlador.php?acao=push_processos&pagina=1&aviso=", driver.getCurrentUrl());
	}

}
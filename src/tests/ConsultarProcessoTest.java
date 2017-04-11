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
import classes.PaginaProcessos;
import classes.Validador;

public class ConsultarProcessoTest {
	private WebDriver driver;

	@Test
	public void testListarMeusProcessosConsultarProcesso() throws Exception {
		this.driver = Driver.getDriver();
		
		PaginaLogin.login(this.driver);

		PaginaCadastro.listarProcessos(this.driver);
		
		PaginaProcessos.clicarNoLink(this.driver, "5087701-14.2014.404.7100");
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		
		Validador.validarResultado("http://www2.trf4.jus.br/trf4/controlador.php?acao=consulta_processual_resultado_pesquisa&selForma=NU&txtValor=50877011420144047100&selOrigem=RS", driver.getCurrentUrl());
    }

}
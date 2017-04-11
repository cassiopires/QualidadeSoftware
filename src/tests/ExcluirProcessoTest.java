package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import classes.Driver;
import classes.Elemento;
import classes.Pagina;
import classes.PaginaLogin;
import classes.Validador;

public class ExcluirProcessoTest {
	private WebDriver driver;

	@Test
	public void testListarProcessosExcluirProcesso() {
		this.driver = Driver.getDriver();
		
		PaginaLogin.login(this.driver);
		
		Elemento.clicarPorNome(this.driver, "push");

		Elemento.clicarPorNome(this.driver, "exc_50086743420174040000");
		
		Elemento.clicarPorNome(this.driver, "remover");
		
		Pagina.esperar(1000);
		
		Elemento.clicarOk(this.driver);
		
		Pagina.esperar(1000);
		
		Elemento.clicarOk(this.driver);
		
		Validador.validarResultado("http://www2.trf4.jus.br/trf4/controlador.php?acao=push_processos&pagina=1&aviso=1%20processo(s)%20exclu%EDdo(s).", driver.getCurrentUrl());
	}

}
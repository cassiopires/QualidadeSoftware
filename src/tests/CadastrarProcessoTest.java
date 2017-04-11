package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import classes.Driver;
import classes.Elemento;
import classes.Pagina;
import classes.PaginaLogin;
import classes.Validador;

public class CadastrarProcessoTest {
	private WebDriver driver;

	@Test
	public void testListarProcessosCadastrarProcesso() {
        this.driver = Driver.getDriver();
		
		PaginaLogin.login(this.driver);
		
		Elemento.clicarPorNome(this.driver, "push");
		
		Elemento.clicarPorId(this.driver, "num_proc");
		
		Elemento.digitarPorId(this.driver, "num_proc", "50086743420174040000");
		
		Elemento.selecionarPorId(this.driver, "origem", "trf4");
		
		Elemento.clicarPorNome(this.driver, "Pesquisar");
		
		Pagina.esperar(1000);

		Elemento.clicarOk(this.driver);
		
		Validador.validarResultado("http://www2.trf4.jus.br/trf4/controlador.php?acao=push_processos&pagina=1&aviso=1%20processo(s)%20cadastrado(s).", driver.getCurrentUrl());
	}

}
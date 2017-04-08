package classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaLogin {

	public static void login(WebDriver driver) {
		Pagina.redirecionar(driver, Driver.baseUrl + "trf4/controlador.php?acao=push_login");
		Elemento.digitarPorId(driver, "visitante_email", "cle@trf4.jus.br");
		Elemento.digitarPorNome(driver, "visitante_senha", "zarag0za");
		Elemento.clicarPorNome(driver, "submit");
	}

}

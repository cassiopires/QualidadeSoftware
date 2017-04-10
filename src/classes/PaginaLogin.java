package classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaLogin {
	
	private static String usuario = "cle@trf4.jus.br";
	private static String senha = "zarag0za";

	public static void setUsuarioSenha(String novoUsuario, String novaSenha) {
		usuario = novoUsuario;
		senha = novaSenha;
	}
	
	public static void login(WebDriver driver) {
		Pagina.redirecionar(driver, Driver.baseUrl + "trf4/controlador.php?acao=push_login");
		Elemento.digitarPorId(driver, "visitante_email", usuario);
		Elemento.digitarPorNome(driver, "visitante_senha", senha);
		Elemento.clicarPorNome(driver, "submit");
	}

}

package classes;

import org.openqa.selenium.WebDriver;

public class Pagina {
	
	public static void redirecionar(WebDriver driver, String destino) {
		driver.get(destino);
	}

}

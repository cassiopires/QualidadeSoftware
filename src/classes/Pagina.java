package classes;

import org.openqa.selenium.WebDriver;

public class Pagina {
	
	public static void redirecionar(WebDriver driver, String destino) {
		driver.get(destino);
	}

	public static void esperar(int milissegundos) {
		try {
			Thread.sleep(milissegundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}

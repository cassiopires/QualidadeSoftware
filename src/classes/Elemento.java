package classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Elemento {

	public static void digitarPorId(WebDriver driver, String elemento, String valor) {
		driver.findElement(By.id(elemento)).clear();
		driver.findElement(By.id(elemento)).sendKeys(valor);
	}
	
	public static void digitarPorNome(WebDriver driver, String elemento, String valor) {
		driver.findElement(By.name(elemento)).clear();
		driver.findElement(By.name(elemento)).sendKeys(valor);
	}
	
	public static void clicarPorId(WebDriver driver, String elemento) {
		driver.findElement(By.id(elemento)).click();
	}
	
	public static void clicarPorNome(WebDriver driver, String elemento) {
		driver.findElement(By.name(elemento)).click();
	}

	public static void clicarPorLink(WebDriver driver, String elemento) {
		driver.findElement(By.linkText(elemento)).click();
	}
	
}

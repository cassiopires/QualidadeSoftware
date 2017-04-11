package classes;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

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
	
	public static String clicarOkAlert(WebDriver driver) {
		Pagina.esperar(2000);

		if (Driver.tipo == "phantom") {
			((JavascriptExecutor) driver).executeScript("window.alert = function(msg){};");
			return "";
		} else {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			alert.accept();
			return alertText;
		}
	}
	
	public static String clicarOkConfirm(WebDriver driver) {
		Pagina.esperar(2000);

		if (Driver.tipo == "phantom") {
			((JavascriptExecutor) driver).executeScript("window.confirm = function(msg){return true;};");
			return "";
		} else {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			alert.accept();
			return alertText;
		}
	}
	
	public static void selecionarPorId(WebDriver driver, String elemento, String valor) {
		Select droplist = new Select(driver.findElement(By.id(elemento)));   
		droplist.selectByValue(valor);
	}
	
}

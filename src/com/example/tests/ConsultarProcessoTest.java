package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.example.classes.Driver;
import com.example.classes.PaginaCadastro;
import com.example.classes.PaginaLogin;
import com.example.classes.PaginaProcessos;
import com.example.classes.Validador;

public class ConsultarProcessoTest {
	private WebDriver driver;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testListarMeusProcessosConsultarProcesso() throws Exception {
		this.driver = Driver.getDriver();
		
		PaginaLogin.login(this.driver);

		PaginaCadastro.listarProcessos(this.driver);
		
		PaginaProcessos.clicarNoLink(this.driver, "5090554-93.2014.404.7100");
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		
		Validador.validarResultado("http://www2.trf4.jus.br/trf4/controlador.php?acao=consulta_processual_resultado_pesquisa&selForma=NU&txtValor=50905549320144047100&selOrigem=TRF", driver.getCurrentUrl());
    }

	@After
	public void tearDown() throws Exception {
		this.driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			this.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			this.driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = this.driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}

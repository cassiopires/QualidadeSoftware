package tests;

import java.io.Console;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import classes.Driver;
import classes.PaginaLogin;
import classes.Validador;

public class ValidarLoginTest {
	private WebDriver driver;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testeValidarUsuarioValido() throws Exception {
		this.driver = Driver.getDriver();
		
		PaginaLogin.setUsuarioSenha("cle@trf4.jus.br", "zarag0za");
		PaginaLogin.login(this.driver);
		
		Validador.validarResultado("http://www2.trf4.jus.br/trf4/controlador.php?acao=push_altera_cadastro&validacao=1", driver.getCurrentUrl());
	}
	
	@Test
	public void testeValidarUsuarioInvalido() throws Exception {
		this.driver = Driver.getDriver();
		
		PaginaLogin.setUsuarioSenha("cle@trf4.jus.br", "teste-teste");
		PaginaLogin.login(this.driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = this.driver.switchTo().alert();
        alert.accept();
		
		Validador.validarResultado("http://www2.trf4.jus.br/trf4/controlador.php?acao=push_login&processo=&origem=", driver.getCurrentUrl());
    }

	@After
	public void tearDown() throws Exception {
		/*this.driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}*/
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

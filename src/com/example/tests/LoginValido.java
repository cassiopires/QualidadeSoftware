package com.example.tests;

import java.io.Console;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginValido {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.firefox.marionette","C:\\Users\\alu201630836\\Downloads\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "http://www2.trf4.jus.br/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLoginValido() throws Exception {
    driver.get(baseUrl + "trf4/controlador.php?acao=push_login");
    driver.findElement(By.id("visitante_email")).clear();
    driver.findElement(By.id("visitante_email")).sendKeys("cle@trf4.jus.br");
    driver.findElement(By.name("visitante_senha")).clear();
    driver.findElement(By.name("visitante_senha")).sendKeys("300572");
    driver.findElement(By.name("submit")).click();
    Thread.sleep(1000);
    String expected = "http://www2.trf4.jus.br/trf4/controlador.php?acao=push_altera_cadastro&validacao=1";
	assertEquals(expected, driver.getCurrentUrl());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
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

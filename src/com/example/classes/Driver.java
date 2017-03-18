package com.example.classes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

	public static WebDriver driver;	
	public static String baseUrl;

	public static WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.firefox.marionette","C:\\Users\\alu201630836\\Downloads\\geckodriver.exe");
			driver = new FirefoxDriver();
			baseUrl = "http://www2.trf4.jus.br/";
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		return driver;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

}
package classes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

	public static WebDriver driver;	
	public static String baseUrl;

	public static WebDriver getDriver() {
		if (driver == null) {			
			String OS = System.getProperty("os.name").toLowerCase();
			
			if (OS.indexOf("win") >= 0) {
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();

				//System.setProperty("webdriver.firefox.marionette","src\\libs\\geckodriver.exe");
				//driver = new FirefoxDriver();
			} else {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/usr/local/bin/phantomjs");
				driver = new PhantomJSDriver(cap);		
			}	
			
			baseUrl = "http://www2.trf4.jus.br/";
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		return driver;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

}
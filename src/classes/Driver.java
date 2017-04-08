package classes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

	public static WebDriver driver;	
	public static String baseUrl;

	public static WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "src\\libs\\chromedriver.exe");
			driver = new ChromeDriver();
		    
			//System.setProperty("webdriver.firefox.marionette","src\\libs\\geckodriver.exe");
			//driver = new FirefoxDriver();
			
			baseUrl = "http://www2.trf4.jus.br/";
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		return driver;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

}
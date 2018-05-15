import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultipleBrowsersConfigFile {
	private WebDriver driver=null;//class variable to access outside in after also
	//private String browser="chrome";
	//private String browser="firefox";
	private String browser;
	private String url;
	@Before
	public void setUp() throws Exception{
		Properties prop=new Properties();//to read data from config file
		prop.load(new FileInputStream("C:/Users/satya/Desktop/browsers.config"));//in quotes path to brower.config file//loading files
		                                                                     //delegates to handling exception to jvm
		                                                   //if u use try catch..will try to load file and if does not find goes to exception
		                                                 //exception is super class of all other exceptions.
		browser=prop.getProperty("browser");
		url = prop.getProperty("url");
		switch(browser){
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
	}
	}

	@Test
	public void test() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Desktop\\geckodriver-v0.17.0-win64\\geckodriver.exe");
		//create an object
		
		
		//driver=new ChromeDriver();//firefox driver is a class that impliments web driver interface
		//driver belongs to interface, so we can use driver everywhere 
		//driver.get("https://www.google.com");
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\satya\\Desktop\\geckodriver-v0.17.0-win64\\geckodriver.exe");
		//create an object
		// driver=new FirefoxDriver();//firefox driver is a class that impliments web driver interface
		//driver belongs to interface, so we can use driver everywhere 
		driver.get(url);
		
	}
	@After
	public void tearDown() throws InterruptedException{
		
		driver.quit();
	}
	
	

}

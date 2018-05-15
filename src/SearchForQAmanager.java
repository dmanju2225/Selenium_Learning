import junit.framework.TestCase;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchForQAmanager extends TestCase {
	private WebDriver driver;
	
	  private String baseUrl;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\satya\\Desktop\\geckodriver-v0.17.0-win64\\geckodriver.exe");
	    driver = new FirefoxDriver();
	    baseUrl = "http://hrm.portnov.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testSearchForQaManager() throws Exception {
	    driver.get(baseUrl + "/symfony/web/index.php/auth/login");
	    assertEquals("OrangeHRM", driver.getTitle());
	    driver.findElement(By.id("txtUsername")).clear();
	    driver.findElement(By.id("txtUsername")).sendKeys("admin");
	    driver.findElement(By.id("txtPassword")).clear();
	    driver.findElement(By.id("txtPassword")).sendKeys("orangehrm");
	    driver.findElement(By.id("btnLogin")).click();
	    assertEquals("OrangeHRM", driver.getTitle());
	    new Select(driver.findElement(By.id("empsearch_job_title"))).selectByVisibleText("QA Manager");
	    /*
	     * Select x =  new Select(driver.findElement(By.id("empsearch_job_title")));
	     * x.
	     */
	    driver.findElement(By.id("searchBtn")).click();
	    assertEquals("OrangeHRM", driver.getTitle());
	    assertThat("Software Development Manager", is(not(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[5]")).getText())));
	    assertThat("QA Engineer", is(not(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[5]")).getText())));
	    driver.findElement(By.id("welcome")).click();
	    driver.findElement(By.linkText("Logout")).click();
	    assertEquals("OrangeHRM", driver.getTitle());
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
}

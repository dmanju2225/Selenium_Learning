import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Elements2 {
private WebDriver driver;
	@Before
	public void setUp() throws Exception {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		driver.get("http://book.theautomatedtester.co.uk/");
		WebElement linkch2=driver.findElement(By.linkText("Chapter2"));
		linkch2.click();
		driver.findElement(By.linkText("Index")).click();
	}

}

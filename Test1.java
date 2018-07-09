package rashi.sele_grid;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {
	public static RemoteWebDriver driver;
	public static String url = "http://www.google.com";
	
	@BeforeClass
	@Parameters({ "browser" })
	public void setUp(String browser) throws MalformedURLException {
		driver = Grid.getDriver(browser);
		driver.manage().window().maximize();
	}
	
	@Test
	public void testPageTitle1() {
		driver.navigate().to("http://www.google.com");
		String PageTitle = driver.getTitle();
		Assert.assertTrue(PageTitle.equalsIgnoreCase("Google"), "Page title not match");
	}
	
	@Test
	public void testValueToSearch() {
		System.out.println("Opening Google..");
		driver.navigate().to(url);
		driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys("Rashi");
	}

	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			System.out.println("Close browser");
			driver.quit();
		}
	}

}

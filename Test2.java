package rashi.sele_grid;
import java.net.MalformedURLException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test2 {
	public static RemoteWebDriver driver;
	public static String url = "http://www.google.com";
	
	@BeforeClass
	@Parameters({ "browser" })
	public void setUp(String browser) throws MalformedURLException {
		driver = Grid.getDriver(browser);
		driver.manage().window().maximize();
	}
	
	@Test
	public void testPageTitle2() {
		driver.navigate().to(url);
		String PageTitle = driver.getTitle();
		Assert.assertTrue(PageTitle.equalsIgnoreCase("Google"), "Page title not match");
	}

	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			System.out.println("Close browser");
			driver.quit();
		}
	
}}
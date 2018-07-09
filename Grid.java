package rashi.sele_grid;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Grid {
	public static RemoteWebDriver getDriver(String browser) throws MalformedURLException {
		return new RemoteWebDriver(new URL("http://10.0.36.73:4444/wd/hub"), getBrowser(browser));
	}
	
	private static DesiredCapabilities getBrowser(String browserType) {
		if(browserType.equals("chrome")) {
			System.out.println("Opening chrome driver");
			return DesiredCapabilities.chrome();
		}
		else {
			System.out.println("browser : " + browserType + " is invalid, Launching Chrome as browser of choice..");
			return DesiredCapabilities.chrome();
		}
	}
}

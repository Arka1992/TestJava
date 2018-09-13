package CommonUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {

	public static WebDriver Driver;

	public void getBrowser() {
		if (Constants.Browser.equalsIgnoreCase("Firefox")) {
			Driver = new FirefoxDriver();
		} else if (Constants.Browser.equalsIgnoreCase("Chrome")) {
			
			//System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("webdriver.Chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			Driver = new ChromeDriver();
		} else if (Constants.Browser.equalsIgnoreCase("InternetExplora")) {
			System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer_x64_3.5.1\\IEDriverServer.exe");
			Driver = new InternetExplorerDriver();
		} else {
			Driver = new FirefoxDriver();
		}
		
	}
	public void PassURL()
	{
		Browser.Driver.get(Constants.URL);
	}

}

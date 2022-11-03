package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenshotCapture;

public class BaseClass {

	WebDriver driver;
	ScreenshotCapture sc;
	public static Properties prop;

	public static void testBasic() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//resources//Properties//Config.properties");
		prop.load(ip);
	}

	@BeforeMethod
	@Parameters("Browser")
	public void beforeMethod(String str) throws IOException {
		testBasic();

		if (str.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\DriverFiles\\chromedriver.exe");
			// System.setProperty("webdriver.chrome.driver", "D:\\Beya\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (str.equals("Edge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\DriverFiles\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.get(prop.getProperty("BaseURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}

	@AfterMethod
	public void afterMethod(ITestResult itestResult) throws IOException {

		// If the test fails, the screenshot is captured
		if (itestResult.getStatus() == ITestResult.FAILURE) {
			sc = new ScreenshotCapture();
			sc.catureScreenshotFailures(driver, itestResult.getName());
		}

		driver.close();
	}
}

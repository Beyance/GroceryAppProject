package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public void presenceOfElement(WebDriver driver,String locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}
}

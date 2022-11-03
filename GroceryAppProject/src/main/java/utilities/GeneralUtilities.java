package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities // increases reusabilities
{
	

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public void selectDropdownValue(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		select.getFirstSelectedOption();
		//WebElement selectedElement = select.getFirstSelectedOption();
		//String selectedText = selectedElement.getText();
		//return selectedText;
	}
	
	public String getSelecetdDropdownValue(WebElement element, String text)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
		WebElement selectedElement = select.getFirstSelectedOption();
		String selectedText = selectedElement.getText();
		return selectedText;
		
	}
	public String getAlertMessage(WebDriver driver)
	{
		String message = driver.switchTo().alert().getText();
		return message;
	}
	
	public String getBackgroundColor(WebElement element) {
		
		String bgColor =element.getCssValue("background-color");
		return bgColor;
	}
	
	public String getFontSize(WebElement element) {
		
		String fontSize = element.getCssValue("font-size");
		return fontSize;
	}
	 public boolean getPresenceOfAnElement(WebElement element) {
		 
		 boolean val = element.isDisplayed();
			return val;
	 }
	 
	 public boolean getCheckboxSelection(WebElement element)
	 {
		 element.click();
		 return element.isEnabled();
	 }
	 
	 public String getPageURL(WebDriver driver)
	 {
		 String pageurl = driver.getCurrentUrl();
		//System.out.println("Current url : "+pageurl);
		 return pageurl;
	 }
	 
	 public String getPageTitle(WebDriver driver)
	 {
		 String pageTitle = driver.getTitle();
		
		 return pageTitle;
	 }
}

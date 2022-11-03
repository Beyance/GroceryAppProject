package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class AdminUsers {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public AdminUsers(WebDriver driver) 
	{

		this.driver = driver;
		PageFactory.initElements(driver, this);
		

	}

	@FindBy(xpath = "//p[text()='Admin Users']")
	WebElement adminUser;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement passWord;
	
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement userType;
	
	@FindBy(xpath = "//div//button[@name='Create']")
	WebElement saveButton;
	
	@FindBy(xpath = "//div//table//tbody//tr[1]//td[2]")
	WebElement userTypeSelected;
	
	public void clickAdminUser()
	{
		adminUser.click();
	}
	
	public void clickNewButton()
	{
		newButton.click();
	}
	
	public void enterUserName(String uname)
	{
		userName.sendKeys(uname);
	}
	
	public void enterPassword(String pword)
	{
		passWord.sendKeys(pword);
	}
	
	public void selectUserType(String utype)
	{
		gu.selectDropdownValue(userType, utype);
	}
	
	public void clickSaveButton()
	{
		saveButton.click();
	}
	
	public String getUserType()
	{
		return gu.getElementText(userTypeSelected);
	}
	
	public String getAdminUsersPageURL()
	{
		return gu.getPageURL(driver);
		
	}
	public String getAdminUsersPageTitle()
	{
		return gu.getPageTitle(driver);
		
	}
	
}

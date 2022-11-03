package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ExpenseCategoryPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ExpenseCategoryPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(xpath = "//input[@id='name']")
	WebElement textTitle;

	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement itemAddedAlertMessage;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement itemExistAlertMessage;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButtonOne;

	@FindBy(xpath = "//input[@id='un']")
	WebElement searchTextTitle;

	@FindBy(xpath = "//button[@value='sr']")
	WebElement searchButtonTwo;

	@FindBy(xpath = "//div[@class='card-body table-responsive p-0']//table//tbody//tr//td[1]")
	List<WebElement> tableValue;
	
	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	WebElement expenseHead;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;
	
	@FindBy(xpath = "//h3[@class='card-title']")
	WebElement informationBoxHeading;

//	@FindBy(xpath="//div[@class='card-body table-responsive p-0']//table//tbody//tr[1]//td[2]//a//i[@class='fas fa-trash-alt']")
//	WebElement deletebut;

	public void newButtonClick() {
		newButton.click();
	}

	public void inputText(String text) {
		textTitle.sendKeys(text);
	}

	public void saveButtonClick() {
		saveButton.click();
	}

	public String getNewItemAddedMessage() {

		return gu.getElementText(itemAddedAlertMessage);
	}

	public String getItemalreadyExistMessage() {
		return gu.getElementText(itemExistAlertMessage);
	}

	public void clickSearchButton() {
		searchButtonOne.click();
	}

	public void inputSearchText(String searchText) {
		searchTextTitle.sendKeys(searchText);
	}

	public void clickSearchButtonTwo() {
		searchButtonTwo.click();
	}

	public String searchExpectedCategory(String eText) {
		String aText = null;
		for (int i = 0; i < tableValue.size(); i++) {
			if (tableValue.get(i).getText().equals(eText)) {

				aText = eText;

			}

		}
		return aText;
	}

	public String getDeletePopupMessage(String name) throws InterruptedException {
		WebElement deleteIcon;
		// String message = null;
		for (int i = 0; i < tableValue.size(); i++) {
			if (tableValue.get(i).getText().equals(name)) {

				deleteIcon = driver
						.findElement(By.xpath("//div[@class='card-body table-responsive p-0']//table//tbody//tr["
								+ (i + 1) + "]//td[2]//a//i[@class='fas fa-trash-alt']"));
				deleteIcon.click();
				break;
			}

		}

		//Thread.sleep(2000);
		return gu.getAlertMessage(driver);
	}
	
	public String getNewButtonColor()
	{
		
		return gu.getBackgroundColor(newButton);
	}
	
	public String getExpenseCategoryHeadingSize()
	{
		
		return gu.getFontSize(expenseHead);
	}
	
	public void resetButtonClick()
	{
		resetButton.click();
	}
	
	public boolean checkInformationBoxPresence()
	{
		
		return gu.getPresenceOfAnElement(informationBoxHeading);
	}

//	public String getAlertMessage()
//	{
//		String message = driver.switchTo().alert().getText();
//		return message;
//	}

}

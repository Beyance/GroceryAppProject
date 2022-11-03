package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.AdminUsers;
import elementRepository.LoginPage;

public class AdminUsersTestCases extends BaseClass {
	
	LoginPage lp;
	AdminUsers au;
	// Testcase 13 : 
  @Test(enabled = false)
  public void verifyNewAdminUserCreation() {
	  lp = new LoginPage(driver);
	  au = new AdminUsers(driver);
	   
	  lp.performLogin("admin", "admin");
	  au.clickAdminUser();
	  au.clickNewButton();
	  au.enterUserName("uname1");
	  au.enterPassword("pword");
	  au.selectUserType("Staff");
	  au.clickSaveButton();
	  String actual = au.getUserType();
	  String expected = "staff";
	  Assert.assertEquals(actual, expected, "WWrong user selected");
	  
	  
  }
  
	//Testcase 14 : 
  @Test(enabled = false)
  public void verifyAdminUsersPageURL() {
	  lp = new LoginPage(driver);
	  au = new AdminUsers(driver);
	   
	  lp.performLogin("admin", "admin");
	  au.clickAdminUser();
	  String actual = au.getAdminUsersPageURL();
	  String expected = "https://groceryapp.uniqassosiates.com/admin/list-admin";
	  
	  Assert.assertEquals(actual, expected, "Page URL is not matching");
	  
  }
  // Test case 15 : 
  @Test
  public void verifyAdminUsersPageTitle() {
	  
  
	  lp = new LoginPage(driver);
	  au = new AdminUsers(driver);
	   
	  lp.performLogin("admin", "admin");
	  au.clickAdminUser();
	  
	  String actual = au.getAdminUsersPageTitle();
	  String expected = "Admin Users | 7rmart supermarket";
	  Assert.assertEquals(actual, expected, "Page Title is not matching");
  }
  
}

package com.assignmentDNB.test;


import java.io.IOException;
import org.testng.Assert;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.assignmentDNB.pom.LoginPageObject;
import com.assignmentDNB.resources.UtilityClass;
import com.aventstack.extentreports.Status;




public class LoginPageTest extends UtilityClass {
	
	public static LoginPageObject reqLogin ;

	@BeforeTest
	public void BeforeTest() throws IOException {
		reqLogin = new LoginPageObject(browserInvoke());
	
	}


	@Test

	public void firstTestCase() throws IOException {
	  
		test = extent.createTest("Verify login with invalid credential", "Checking the Title");
		test.log(Status.INFO, "Test Started");
	    reqLogin.username().sendKeys(getUsername());
		reqLogin.password().sendKeys(getPassword());
		reqLogin.submit().click();
		Assert.assertEquals(reqLogin.errorMessage().getText(),"Invalid credentials");
			
  }
  
  
  @Test
  public void secondTestCase() throws IOException {
	  
	  test = extent.createTest("Verify user after login", "Checking the Title");
	  test.log(Status.INFO, "Test Started");
	  String loginDetails= reqLogin.usertext().getText();
	  String UserDetails[]= split(loginDetails);
	  reqLogin.username().sendKeys(UserDetails[0]);
	  reqLogin.password().sendKeys(UserDetails[1]);
	  reqLogin.submit().click();
	  reqLogin.loggedInUser().isDisplayed();
	  String [] user = reqLogin.loggedInUser().getText().split("\\s+");
	  test.log(Status.INFO, "User is  :  "+ user[1]);
	  Assert.assertTrue(false);
	  
	
  }
  
 
 
}
  

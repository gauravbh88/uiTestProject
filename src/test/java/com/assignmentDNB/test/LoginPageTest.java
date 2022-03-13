package com.assignmentDNB.test;


import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.assignmentDNB.pom.LoginPageObject;
import com.assignmentDNB.resources.UtilityClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;





public class LoginPageTest extends UtilityClass {
	
	public static LoginPageObject reqLogin ;
	ExtentTest test;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	
	@BeforeTest

	public void BeforeTest() throws IOException {
	
		
		htmlReporter = new ExtentHtmlReporter("TestReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
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
		test.log(Status.PASS, "Invalid Creadential login verfified");	
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
	  String user = reqLogin.loggedInUser().getText();
	  test.log(Status.PASS, "Welcome Message Displayed :  "+ user );
	  Assert.assertTrue(false);
	  
	
  }
  
  
  
  @AfterTest
  public void afterTest() {
	  extent.flush();
	  driver.quit();
	  
  }
  
  @AfterMethod
  public void afterMethod(ITestResult result) throws IOException {
	  
	  if(result.getStatus() == ITestResult.FAILURE) {
		  
		  String screenShotPath = getScreenShot(driver);
		  test.log(Status.FAIL, "Test failed,   Error :" + result.getThrowable());
		  test.log(Status.FAIL, "Error Screenshot :" + test.addScreenCaptureFromPath(screenShotPath));
				  
				
	  }
  	}
  
 
}
  

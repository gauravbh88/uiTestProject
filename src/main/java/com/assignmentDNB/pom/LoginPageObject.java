package com.assignmentDNB.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {
	
public WebDriver driver;
	
	By username= By.xpath("//*[@id='txtUsername']");
	By password= By.xpath("//*[@id='txtPassword']");
	By submit= By.xpath("//*[@id='btnLogin']");
	By errorMessage = By.xpath("//*[@id='spanMessage']");
	By usertext = By.xpath("(//div/span)[1]");
	By loggedInUser = By.xpath("//*[@id='welcome']");
	

	
	public LoginPageObject(WebDriver driver) {
		
		this.driver=driver;
	}

	
	public WebElement username( )
	{
		return driver.findElement(username);
	}
	
	public WebElement password( )
	{
		return driver.findElement(password);
	}
	
	public WebElement submit( )
	{
		return driver.findElement(submit);
	}
	
	public WebElement usertext( )
	{
		return driver.findElement(usertext);
	}
	
	public WebElement errorMessage( )
	{
		return driver.findElement(errorMessage);
	}
	
	public WebElement loggedInUser( )
	{
		return driver.findElement(loggedInUser);
	}
}

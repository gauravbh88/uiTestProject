package com.assignmentDNB.resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import java.util.Properties;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilityClass {
	
	public static WebDriver driver;

	//public static Logger log = LogManager.getLogger(utility.class);
	
// Getting the values of property from data.properties file	
	
public String getProrpertiesValue(String keyword) throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream fis= new FileInputStream("src\\main\\resources\\data.properties");
	    prop.load(fis);
	    String value= prop.getProperty(keyword);
	//    log.debug(value + "returned for property: "+ keyword );
	    return value;
	    
	   	}

public String getUsername() throws IOException {
	
	String userName =  getProrpertiesValue("userName");
	
	return userName;
	
	
}

public String getPassword() throws IOException {
	
	String password =  getProrpertiesValue("password");
	
	return password;
	
	
}

	

	public WebDriver browserInvoke() throws IOException
	{
		if(getProrpertiesValue("browser").equals("chrome"))
		{
		WebDriverManager.chromedriver().browserVersion("77.0.3865.40").setup();
   	  	ChromeOptions options = new ChromeOptions();
   	  	driver = new ChromeDriver(options); 
   	  	driver.get(getProrpertiesValue("baseURL"));
		return driver;
		}
		return driver;
	}

	public String[] split  (String text) {
		
		String[] firstSplit = text.split("\\|");
		  
		  String firstSplitPart1 = firstSplit[0]; 
		  String firstSplitPart2 = firstSplit[1]; 
		  
		  String[] secondSplitPart1 = firstSplitPart1.split(":");
		  String[] secondSplitPart2 = firstSplitPart2.split(":");
		  
		  
		  
		  String[] userDetails = new String[2];
		  userDetails[0] = secondSplitPart1[1];;
		  userDetails[1] = secondSplitPart2[1];
		  
		  userDetails[0] = userDetails[0].replaceAll(" ", "");
		  userDetails[1] = userDetails[1] .replaceAll(" ", "");
		  userDetails[1] = userDetails[1].substring(0, userDetails[1].length()-1); 
		  
		  
		  return(userDetails);
		
	}
	
	
	     
	    public static String getScreenShot(WebDriver driver) throws IOException
	    {
	    	TakesScreenshot ts = (TakesScreenshot)driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String dest = "Screenshot/screenshot.png";
	        File destination = new File(dest);
	        FileUtils.copyFile(source, destination);      
	                     
	        return dest;
	  
	   

	}
	
}
	
	



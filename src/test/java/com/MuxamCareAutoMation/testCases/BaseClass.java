package com.MuxamCareAutoMation.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.MuxamCareAutoMation.utilities.ReadConfig;




public class BaseClass {
	
	//To rwead data from Readconfig.java, first we will create an object here
	ReadConfig readconfig=new ReadConfig();  //readconfig object is created, now this object will be used to 
	                                         //call all of the methods described in ReadConfig.java files
	                                         // constructor ReadConfig() will invoke by this object readconfig
	
	
	// In the BaseClass we do not hard code variable values, in real life there are hundreds of variables
	// some of the variables are used in many test cases, so to maintain all the common variables, we will create 
	//a properties file, the name of the file is config.properties file. it is just like a text file. we will put
	//all BaseClass variable values in this file, to read all variable values from properties file, 
	//we will create another utility file, ReadConfig.java, this is a simple java class, will read the variable values from
	//Config.properties file.
	public String baseURL=readconfig.getApplicationURL(); //readconfig will get value of URL from method getApplicationURL
	                                                      //in the ReadConfig.java
	public String username=readconfig.getUserName();
	public String password=readconfig.getPassword();
	public String role=readconfig.getRole();
	public static WebDriver driver;
	public static Logger logger;
	
	
	@Parameters("browser")      //will take browser parameter from TestNG.xml file, will run desired browser by using browser variable.
	@BeforeClass
	public void setup(String br)   // br=browser variable will get value from TestNG.xml file
	
	{
		
		
		//To include Log to your project.
		 logger= Logger.getLogger("MuxamCareAutomation"); // initiated logger object class for logs
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))	
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver=new FirefoxDriver();
			}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver=new InternetExplorerDriver();
		}
	    
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);  //Wait 10 seconds before performing any activity
		driver.get(baseURL);
	}
	
	@AfterClass
	public void tearDown()    //at the end of test case quit the browser
	{
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + "png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot is taken!");
	
	}
}

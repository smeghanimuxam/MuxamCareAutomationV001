package com.MuxamCareAutoMation.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;

//import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.MuxamCareAutoMation.pageobjects.LoginPageObjects;

public class TC_LoginTest_001 extends BaseClass    //inherit BaseClass methods @BeforeClass and @AfterClass

{
    @Test
	public void loginTest() throws InterruptedException, IOException
	
	{
		
		driver.get(baseURL);  //baseURL value from BaseClass
		
		//driver.manage().window().maximize();
		
		logger.info("URL is opened");
		LoginPageObjects lp=new LoginPageObjects(driver);  //LoginPageObjects class should be public in page object class to access it here
		
		
		// To erase any existing text on usename box
		
		Thread.sleep(3000);
		
	WebElement UserInput = driver.findElement(By.xpath("//*[@id=\"Login1_txtUserName\"]"));
	UserInput.clear();
		lp.setUserName(username);   //method setUserName() from page object
		logger.info("User Name is Entered!");
		System.out.println("INFO:--->User Name Entered!");                       	//and username from BaseClass
		lp.setPassword(password); 
		logger.info("Password Entered!");
		lp.clickSignin();
		logger.info("Singn Button is clicked!");
		
		
					
		lp.clickRole(role);
		logger.info("Role is clicked and entered!");
		lp.clickDone();
		
		String Expt_id ="PRM of the Wiregrass, LLC";
		String Act_id = driver. findElement(By.id("lblOrgGrpName")).getText();
				if (Expt_id.equals(Act_id))
				{ 
					Assert.assertTrue(true);
					System.out.println("INFO --> Login Successfull");
					logger.info("Congratulations! Login is successfull!!!");
				}
				
				else  
				{   captureScreen(driver, "logintest"); //Calling captureScreen method from BaseClass to capture screen
				                                        // on Failure.
					Assert.assertTrue(false);
					logger.info("Login test Failed!!!");
					System.out.println("Login Failed!!!");
					//System.out.println("INFO:--->Loginf Failed!");
				{
		
				}
		Thread.sleep(3000);
		
		                                   
				}	
		String page=driver.getTitle();
		System.out.println(page);
	}
}
	


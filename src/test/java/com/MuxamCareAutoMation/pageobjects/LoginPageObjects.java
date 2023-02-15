package com.MuxamCareAutoMation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects 

{
WebDriver ldriver; //create a driver object, ldriver=local driver
	
	// Creating Constructor for login page. - - -  
	
	public LoginPageObjects(WebDriver rdriver)  // passing rdriver as parameter, rdriver=remote driver
	
	{
	
	  ldriver=rdriver; // initiating driver object ldriver
	  PageFactory.initElements(rdriver, this);  //initiating rdriver
	  
	}
	
	// Finding  object elements on login page
	 
      @FindBy(name="Login1$txtUserName")
	  @CacheLookup
	  WebElement txtUserName;
        
        
	
	  @FindBy(name="Login1$txtPassword")
	  @CacheLookup
	  WebElement txtPassword;
	  
	  @FindBy(name="Login1$btnLogin")
	  @CacheLookup
	  WebElement btnSignin;
	  
	  @FindBy(name="SelectRole1$ddlSelectRole")
	  @CacheLookup
	  WebElement role;
	  
	  
	  @FindBy(name="SelectRole1$btnSelectRole")
	  @CacheLookup
	  WebElement done;
	  
	  @FindBy(id="lnkBtnLogOff")
	  @CacheLookup
	  WebElement logout;
	  
	
        //Three Action Methods for all three elements- - -
	
	  public void setUserName(String uname)
	  
	  {
		  txtUserName.sendKeys(uname);
		  
	  }
		 
      public void setPassword(String pwd)
	  
	  {
    	  txtPassword.sendKeys(pwd);
		  
	  } 
      
      public void clickSignin()
	  
	  {
    	  btnSignin.click();
		  
	  }
      
      public void clickRole(String role1)
      {
      
      role.click();
      role.sendKeys(role1);
      }
      
      public void clickDone()
      {
    	  done.click();
      }
      
      public void logout()
      {
    	  
    	  logout.click();
      }

}




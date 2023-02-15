package com.MuxamCareAutoMation.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.MuxamCareAutoMation.pageobjects.LoginPageObjects;
import com.MuxamCareAutoMation.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass

{
    @Test(dataProvider="LoginData")  //Same name from DataProvider in the below code.
	public void loginDDT(String user, String pwd)   //The DataProvider is passing two parameters username and password.
	{
    	LoginPageObjects lp =new LoginPageObjects(driver); //to call the methods from LoginpageObject, we have to create 
    	                                                   //an object of LoginPageObjects class
                                                             //setUserName method is called by lp LoginPageObjects object
    	WebElement UserInput = driver.findElement(By.xpath("//*[@id=\"Login1_txtUserName\"]"));
    	UserInput.clear();
    	lp.setUserName(user); // same value from loginDDT, we have to pass
    	lp.setPassword(pwd);
    	lp.clickSignin();
    	lp.clickRole(role); //role parameter is passed from config.configure
    	lp.clickDone();
    	lp.logout();
	}
	
    //DataProvider Method
    @DataProvider(name="LoginData")
    String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/MuxamCareAutoMation/testData/LoginData.xlsx";
		
//the following will go to XLUtils.java file and invoke getRowCount method to count
//rows and return rowCount into rownum int variable
		int rownum=XLUtils.getRowCount(path, "LoginData_001");
	   int colcount=XLUtils.getCellCount(path, "LoginData_001",1);
	
	   String logindata[][]=new String[rownum][colcount];
	   
	   for(int i=1;i<=rownum;i++)
	   {
		 for(int j=0;j<colcount;j++)
		 {
	logindata[i-1][j]=XLUtils.getCellData(path, "LoginData_001", i, j);	 
		 }
	   }
	     return logindata; //return the value 0f logindata[][]
	}	
}

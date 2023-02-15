package com.MuxamCareAutoMation.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.MuxamCareAutoMation.pageobjects.CreatePatientObjects;
import com.MuxamCareAutoMation.pageobjects.LoginPageObjects;

public class TC_CreatePatientTest_003 extends BaseClass

{
	
@Test
public void AddNewPatient() throws InterruptedException

{
	System.out.println("---- ADDING NEW PATIENT ----");
	
	//first we have to login to application, we are using LoginPageObjects class
	LoginPageObjects lp=new LoginPageObjects(driver);
	
	lp.setUserName(username); //username from BaseClass
	System.out.println("User Name Entered!");
	lp.setPassword(password);
	System.out.println("Password Entered!");
	lp.clickSignin();
	lp.clickRole(role);
	System.out.println(role   +   " Role Entered!");
	lp.clickDone();
	
	Thread.sleep(3000);
	
//Now after Login, we will use createPatientObjects class

	CreatePatientObjects cp=new CreatePatientObjects(driver);
	
	cp.clikPrctMngmnt();
	cp.clickMngPtn();
	cp.clickMngPtn1();
	cp.CrtPtnLink();
	cp.Firstname("Randy");
	System.out.println("First Name Entered!");
	cp.Lastname("Khan");
	System.out.println("Last Name! Entered");
	String Ssnmbr=randomString();    // call randomString() method,9 digit number will be stored in Ssnmbr
	cp.Ssn(Ssnmbr);
	System.out.println("SSN "+ Ssnmbr+ " Entered!" );
	WebElement dob=driver.findElement(By.name("ctl00$ContentPlaceHolder1$RWinPatientCreate$C$ManagePatientCreateV31$txtDOB"));
	dob.click();
	dob.sendKeys("12231987");
	System.out.println("DOB Entered!");
	WebElement gndr=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_RWinPatientCreate_C_ManagePatientCreateV31_ddlGender\"]"));
	Select selGndr=new Select(gndr);
	selGndr.selectByValue("1");
	System.out.println("Gender Entered!");
	
	//cp.gender("M");
	cp.CellNmbr("1111111111");
	System.out.println("Cell Number Entered!");
	cp.Address("123 Dothan Street");
	cp.CityName("New Burns Wick");
	cp.stateName("New York");
	cp.ZipNmbr("10111");
	cp.Samepatient();
	cp.Create();
	System.out.println("Patient Created succeffuly!");
	//For Alert
	//Alert confirm=driver.switchTo().alert();
	//System.out.println(confirm.getText());
	
	//confirm.accept();
	//Thread.sleep(2000);
}

//The below method will create randon 9 digit numeric numbers and return. 
public String randomString()
{
	String generateSSN=RandomStringUtils.randomNumeric(9);
	return generateSSN;
}
}



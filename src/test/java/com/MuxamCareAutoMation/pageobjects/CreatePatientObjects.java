package com.MuxamCareAutoMation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreatePatientObjects {

	
	WebDriver ldriver; //create a driver object, ldriver=local drive
	
	public CreatePatientObjects( WebDriver rdriver)  //class name and constructor name must be same
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}

  @FindBy(how= How.XPATH, using="//*[@id=\"form1\"]/div[3]/div[2]/table/tbody/tr/td/ul/li[2]/a")
  @CacheLookup
  WebElement PrctMgmt;
  
  @FindBy(how= How.XPATH, using="//*[@id=\"form1\"]/div[3]/div[2]/table/tbody/tr/td/ul/li[2]/ul/li[4]/a")
  @CacheLookup
  WebElement MngPtn;
  
  @FindBy(how= How.XPATH, using="//*[@id=\"UserNav_PatMang_dlUserNavigation_hyLnkNavigation_0\"]")
  @CacheLookup
  WebElement MngPtn1;
  
  @FindBy(how= How.XPATH, using="//*[@id=\"ContentPlaceHolder1_lnkPatCreate\"]")
  @CacheLookup
  WebElement lnkCrtPatn;
  
  @FindBy(how= How.XPATH, using="//*[@id=\"ctl00_ContentPlaceHolder1_RWinPatientCreate_C_ManagePatientCreateV31_txtFirstName\"]")
  @CacheLookup
  WebElement fname;
  
  @FindBy(how= How.XPATH, using="//*[@id=\"ctl00_ContentPlaceHolder1_RWinPatientCreate_C_ManagePatientCreateV31_txtLastName\"]")
  @CacheLookup
  WebElement lname;

  @FindBy(how= How.XPATH, using="//*[@id=\"ctl00_ContentPlaceHolder1_RWinPatientCreate_C_ManagePatientCreateV31_txtSSN\"]")
  @CacheLookup
  WebElement ssn;
  
  @FindBy(how= How.XPATH, using="//*[@id=\"ctl00_ContentPlaceHolder1_RWinPatientCreate_C_ManagePatientCreateV31_txtDOB\"]")
  @CacheLookup
  WebElement dob;
  
  @FindBy(how= How.XPATH, using="//*[@id=\"ctl00_ContentPlaceHolder1_RWinPatientCreate_C_ManagePatientCreateV31_ddlGender\"]")
  @CacheLookup
  WebElement gndr;
  
  @FindBy(how= How.XPATH, using="//*[@id=\"ctl00_ContentPlaceHolder1_RWinPatientCreate_C_ManagePatientCreateV31_txtCell\"]")
  @CacheLookup
  WebElement cell;
  
  @FindBy(how= How.XPATH, using="//*[@id=\"ctl00_ContentPlaceHolder1_RWinPatientCreate_C_ManagePatientCreateV31_txtAddress1\"]")
  @CacheLookup
  WebElement addr;
  
  @FindBy(how= How.XPATH, using="//*[@id=\"ctl00_ContentPlaceHolder1_RWinPatientCreate_C_ManagePatientCreateV31_txtCity\"] ")
  @CacheLookup
  WebElement city;
  
  @FindBy(how= How.XPATH, using="//*[@id=\"ctl00_ContentPlaceHolder1_RWinPatientCreate_C_ManagePatientCreateV31_ddlState\"]")
  @CacheLookup
  WebElement state;
  
  @FindBy(how= How.XPATH, using="//*[@id=\"ctl00_ContentPlaceHolder1_RWinPatientCreate_C_ManagePatientCreateV31_txtZIP\"]")
  @CacheLookup
  WebElement zip;
  
  @FindBy(how= How.XPATH, using="//*[@id=\"ctl00_ContentPlaceHolder1_RWinPatientCreate_C_ManagePatientCreateV31_pnlCreateUpdPatient\"]/table[2]/tbody/tr[1]/td[4]/a")
  @CacheLookup
  WebElement samePtn;
  
  
  @FindBy(how= How.XPATH, using="//*[@id=\"ctl00_ContentPlaceHolder1_RWinPatientCreate_C_ManagePatientCreateV31_btnSave\"]")
  @CacheLookup
  WebElement create;
  
  //Action methods for each page objects
  
  public void clikPrctMngmnt()
  
  {
	  PrctMgmt.click();
  }  
	  public void clickMngPtn()
	  {
		  
		  MngPtn.click();
	  }
	  
  public void clickMngPtn1()
  {
	  MngPtn1.click();
  }
  
  public void CrtPtnLink()
  {
	  lnkCrtPatn.click();
  }
  
  public void Firstname(String Fstname)
  {
	  fname.click();
	  fname.sendKeys(Fstname);  
  }
  
  public void Lastname(String Lstname)
  {
	  lname.click();
	  lname.sendKeys(Lstname);
  }
  
  public void Ssn(String ssnumber)
  {
  ssn.click();
  ssn.sendKeys(ssnumber);
  
  }
  
  public void DateOfBirth(String mm, String dd, String yyyy)
  {
	  dob.click();
	  dob.sendKeys(mm);  //DOB has patern like 01/30/2021, so we have to pass month,day and year seperately.
	  dob.sendKeys(dd);
	  dob.sendKeys(yyyy);
  }
  
  public void gender(String gender)
  {
	  gndr.click();
	  gndr.sendKeys(gender);
  }
  
  public void CellNmbr(String cellNumber)
  {
  cell.click();
  cell.sendKeys(cellNumber);
  
  }
  
  public void Address(String addr1)
  {
	  addr.click();
	  addr.sendKeys(addr1);
  }
  
  public void CityName(String ctyname)
  {
	 city.click();
	 city.sendKeys(ctyname);
  }
  
  public void stateName(String statenm)
  {
	  state.click();
	  state.sendKeys(statenm);
  }
  
  public void ZipNmbr(String zipnumber)
  {
	  zip.click();
	  zip.sendKeys(zipnumber);
  }
  
  public void Samepatient()
  {
	  samePtn.click();
  }
  
  public void Create()
  {
	  create.click();
  }
}

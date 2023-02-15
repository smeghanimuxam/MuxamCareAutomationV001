package com.MuxamCareAutoMation.utilities;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 

{
	
	Properties pro;  // first thing we have to create an object for properties class
	
	public ReadConfig()    //Constructor to initialize 
	
	{ // src is referring the config.properties file
		File src = new File("./Configuration/config.properties");
		
		try {
			
			FileInputStream fis=new FileInputStream(src); //opening src file in input mode. 
			 
			pro = new Properties();  //initiating pro object 
			pro.load(fis);  // load the complete file
		}  catch (Exception e)  //if the file is not available the exception will be catched.
		
		{
			System.out.println("Exception is " + e.getMessage());
		}
	}
// Now Add method for each and every variable values to read and get value
	//method to get Base url and return the value
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");  //In properties file variable names are case-sensitive. Write exact name of variables as in properties file.
		return url;
	}
	
	//method to get username and return the value
	
	public String getUserName ()
	{
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
		
	}
	
	public String getRole()
	{
		String role=pro.getProperty("role");
		return role;
		
	}
	
	public String getChromePath()
	
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
     public String getIEPath()
	
	{
		String iepath=pro.getProperty("iepath");
		return iepath;
	}

     public String getFirefoxPath()
 	
 	{
 		String firefoxpath=pro.getProperty("firefoxpath");
 		return firefoxpath;
 	}   // If in future you ADD another variable in properties file, just add another method here in ReadConfig file.
}


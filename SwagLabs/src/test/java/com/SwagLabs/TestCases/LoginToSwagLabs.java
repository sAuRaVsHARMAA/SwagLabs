package com.SwagLabs.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.SwagLabs.Utility.BrowserFactory;
import com.SwagLabs.pages.BaseClass;
import com.SwagLabs.pages.LoginPage;

public class LoginToSwagLabs extends BaseClass {
	
	@Test
	public void loginApp()
	{
		LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
		login_page.loginToSwagLabs(excel.getStringData(0,0,"Sheet1"),excel.getStringData(0,0,"Sheet1"));

	}
	
	
	
	

}

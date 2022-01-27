package com.SwagLabs.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.SwagLabs.pages.BaseClass;
import com.SwagLabs.pages.LoginPage;

public class LoginToSwagLabs extends BaseClass {
	
	@Test
	public void loginApp()
	{
		logger=report.createTest("Login to SwagLabs");
		LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Application Started");
		login_page.loginToSwagLabs(excel.getStringData(0,0,"Sheet1"),excel.getStringData(0,1,"Sheet1"));
		logger.pass("Login Success");

	}
	
	
	
	

}

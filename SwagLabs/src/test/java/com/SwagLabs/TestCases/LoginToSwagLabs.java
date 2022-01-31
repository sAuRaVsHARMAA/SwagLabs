package com.SwagLabs.TestCases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.SwagLabs.Utility.ExcelDataProvider;
import com.SwagLabs.pages.BaseClass;
import com.SwagLabs.pages.LoginPage;

public class LoginToSwagLabs extends BaseClass {
	
	@Test(priority = 1)
	public void loginApp()
	{
		logger=report.createTest("Login to SwagLabs");
		LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Application Started");
		login_page.loginToSwagLabs(excel.getStringData(0,0,"Sheet1"),excel.getStringData(0,1,"Sheet1"));
		logger.pass("Login Success");
		Assert.assertTrue(driver.findElement(By.xpath(".//div[@class='app_logo']")).isDisplayed());
	}
	
	@Test(priority =2)
	public void validateSidebar()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		logger=report.createTest("Validate SideBar");
		driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
		List<WebElement> sidebar=driver.findElements(By.xpath(".//a[@class='bm-item menu-item']"));
		ArrayList<String> sidebar_name = new ArrayList<String>();
		for(WebElement sidebar_web:sidebar)
		{
			sidebar_name.add(sidebar_web.getAttribute("innerHTML"));
		}
		
		ExcelDataProvider excel=new ExcelDataProvider();
		int count=0;
		for(int i=0;i<=sidebar_name.size()-1;i++)
		{
			if(sidebar_name.get(i).equals(excel.getStringData(i, 0, "Sheet2")))
			{
				count++;
			}	
			else 
				logger.fail("Text does not match on the Row Number: "+ (count+1));
		}
		Assert.assertEquals(count, 4);
		logger.pass("Sidebar Elements are Available");
	}
	
	@Test(priority = 3)
	public void socialNetworkingLogo()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		logger=report.createTest("Social Networking Logo");
		SoftAssert assertion=new SoftAssert();
		try 
		{
		if(driver.findElement(By.xpath(".//li[@class='social_twitter']/a[@target='_blank']")).isDisplayed())
		{
			logger.pass("Twitter Logo is Available");
			assertion.assertTrue(true);
		}
		else 
		{
			logger.fail("Twitter Logo is not Available");
			assertion.assertTrue(false);
		}
		}catch(Exception e)
		{logger.fail("Element NOt found "+e.getMessage());}
		
		try
		{
		if(driver.findElement(By.xpath(".//li[@class='social_facebook']/a[@target='_blank']")).isDisplayed())
		{
			logger.pass("Facebook Logo is Available");
			assertion.assertTrue(true);
		}
		else 
		{
			logger.fail("Facebook Logo is not Available");
			assertion.assertTrue(false);
		}
		}catch(Exception e)
		{logger.fail("Element Not found "+e.getMessage());}
		
		try {
		if(driver.findElement(By.xpath(".//li[@class='social_linkedin']/a[@target='_blank']")).isDisplayed())
		{
			logger.pass("Linkedin Logo is Available");
			assertion.assertTrue(true);
		}
		else 
		{
			logger.fail("Linkedin Logo is not Available");
			assertion.assertTrue(false);
		}
		}catch(Exception e)
		{
			logger.fail("Element Not found " +e.getMessage());
		}
		assertion.assertAll();	
	}

}

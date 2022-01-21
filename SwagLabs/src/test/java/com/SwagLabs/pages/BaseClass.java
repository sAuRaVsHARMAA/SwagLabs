package com.SwagLabs.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.SwagLabs.Utility.BrowserFactory;
import com.SwagLabs.Utility.ConfigDataProvider;
import com.SwagLabs.Utility.ExcelDataProvider;
import com.SwagLabs.Utility.Helper;

import freemarker.template.utility.CaptureOutput;

public class BaseClass {
	
	protected WebDriver driver;
	protected ExcelDataProvider excel;
	protected ConfigDataProvider configuration;
	
	
	@BeforeSuite
	public void setUpSuite()
	{
		excel=new ExcelDataProvider();
		configuration=new ConfigDataProvider();
	}
	@BeforeClass
	public void setup()
	{
		driver=BrowserFactory.launchBrowser(driver, configuration.getDataFromConfig("browser"), configuration.getDataFromConfig("appUrl"));
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.captureScreenshot(driver);
		}
	}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	

}

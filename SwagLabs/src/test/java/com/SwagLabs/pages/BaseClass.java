package com.SwagLabs.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.SwagLabs.Utility.BrowserFactory;
import com.SwagLabs.Utility.ConfigDataProvider;
import com.SwagLabs.Utility.ExcelDataProvider;

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
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	

}

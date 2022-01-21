package com.SwagLabs.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	
	
	public static WebDriver launchBrowser(WebDriver driver,String browser, String appURL)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Drivers/firefox.exe");
			driver=new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "./Drivers/ie.exe");
			driver=new InternetExplorerDriver();
		}
		
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	

}

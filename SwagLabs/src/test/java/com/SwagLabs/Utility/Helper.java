package com.SwagLabs.Utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	
	//screenshot, alerts, frame, windows, javascript executor
	
	public static String captureScreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/"+getCurrentDate()+".png";
		try {
			FileHandler.copy(src, new File(screenshotPath));
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot");
			}
		
		return screenshotPath;
		
		
	}
	
	public static String getCurrentDate()
	{
		DateFormat dateformatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date currentDate=new Date();
		return dateformatter.format(currentDate);
	}

}

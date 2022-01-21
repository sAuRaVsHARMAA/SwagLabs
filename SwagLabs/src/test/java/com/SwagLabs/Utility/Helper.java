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
	
	public static void captureScreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File("./Screenshot/"+getCurrentDate()+".png"));
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot");
			}
		
		
	}
	
	public static String getCurrentDate()
	{
		DateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date currentDate=new Date();
		return dateformatter.format(currentDate);
	}

}

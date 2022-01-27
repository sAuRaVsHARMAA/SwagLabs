package com.SwagLabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.ID, using="user-name") WebElement username;
	@FindBy(how=How.ID,using="password") WebElement password;
	@FindBy(how=How.ID,using="login-button") WebElement login_button;
	
	public void loginToSwagLabs(String uname, String pass)
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		
		username.sendKeys(uname);
		password.sendKeys(pass);
		login_button.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {	}
	
	}
	
	


}

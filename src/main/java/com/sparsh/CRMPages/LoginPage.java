package com.sparsh.CRMPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sparsh.qa.base.TestBase;

public class LoginPage extends TestBase{
  
	//Pagefactory or Object Repository
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(xpath="//*[@name='password']")
	WebElement password;
	
    @FindBy(xpath="//input[@type='submit']")
	//@FindBy(xpath="/html/body/div[2]/div/div[3]/form/div/div/input")
	WebElement login;
	
	@FindBy(xpath="//*[@class='btn']")
	WebElement signup;
	
	@FindBy(xpath="//*[@class='img-responsive']")
	WebElement Logo;
	
	//Initializing the page objects
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	public boolean validateCRMImage(){
		return Logo.isDisplayed();
	}
	public HomePage login(String un,String psd){
		username.sendKeys(un);
		password.sendKeys(psd);
		login.click();
		return new HomePage();
	}
}

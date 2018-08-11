package com.sparsh.CRMPages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sparsh.qa.base.TestBase;

public class MessagePage extends TestBase{

	//Pagefactory
	
	@FindBy(xpath="input[@value='New Message']")
	WebElement newmessagebtn;
	
	@FindBy(xpath="//input[@id='subject']")
	WebElement subject;
	
	@FindBy(xpath="//*[@id='msg']")
	WebElement Msage;
	
	@FindBy(xpath="//input[@value='Post']")
	WebElement post;
	
	public MessagePage(){
		PageFactory.initElements(driver,this);
		
	}
	
	//Actions
	
	   public void verifymessageTest(){
		   
		       driver.switchTo().frame("mainpanel");
		        newmessagebtn.isDisplayed();
	            newmessagebtn.click();
	            driver.switchTo().frame("mainpanel");
	       }
         }
	
	



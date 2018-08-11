package com.sparsh.CRMPages;
import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sparsh.qa.base.*;
public class HomePage extends TestBase{
	
	    //MessagePage messagepage;	
	    //Object Repository
		//Test cases should be independent to each other
		//before each test cases--launch the browser
		//@test execute testcases
		//after each test case close the browser
		@FindBy(xpath="https://www.freecrm.com/system/index.cfm?action=calendar&sub=default")
		WebElement calenderlink;
		
		@FindBy(xpath= "//td[contains(text(),'User: ashok p')]")
		WebElement usernamelable;
		
		@FindBy(xpath= "//a[contains(text(),'Contacts')]")
		WebElement contactslink;
		
		@FindBy(xpath= "//a[contains(text(),'Deals')]")
		WebElement dealslink;
		
		@FindBy(xpath= "//a[contains(text(),'Tasks')]")
		WebElement tasklink;
		
		@FindBy(xpath= "//a[contains(text(),'Text/SMS')]")
		WebElement text;
		
		@FindBy(xpath= "//a[contains(text(),'Companies')]")
		WebElement companies;
		
		@FindBy(xpath= "//a[@title='Messages']")
		WebElement messages;
		
		@FindBy(xpath="//a[@href='https://www.freecrm.com/system/index.cfm?action=campaign']")
		WebElement campaigns;
		
		@FindBy(xpath="//a[contains(text(),'New Contact')]")
		WebElement newcontact;
		
		//@FindBy(xpath="//a[@href='https://www.freecrm.com/system/index.cfm?action=contact&sub=cmbform']")
		//WebElement combinedform;
		
		@FindBy(xpath="//*[@id='navmenu']/ul/li[4]/ul/li[2]/a")
		WebElement combinedform;
		
		@FindBy(css="#navmenu > ul > li:nth-child(12) > ul > li:nth-child(1) > a")
		WebElement EmailCompaign;
		
		@FindBy(tagName="a")
		List<WebElement> links;
		
		@FindBy(tagName="select")
		List<WebElement> dropdown;
		
		
		
		//Initializing the objects
		public HomePage(){
			PageFactory.initElements(driver, this);
		       }
		
		public String verifyhompageTitle(){
			
			 return driver.getTitle();
			 }
		
		public boolean verifyusername(){
			 return usernamelable.isDisplayed();
		     }
		
		public ContactsPage clickoncontactlink(){
			 contactslink.click();
			 return new ContactsPage();
		     }  
		 
		public DealsPage clickondealslink(){
			 dealslink.click();
			 return new DealsPage();
		     }
		 
		public TaskPage clickontaskPage(){
			 tasklink.click();
			 return new TaskPage();
		 }
		 
		public MessagePage clickonmessagebtn(){
			 messages.click();
			 return new MessagePage();
			}
		 public CampaignsPage clickonCampaigns(){
			 campaigns.click();
			 return new CampaignsPage();
		     }
		 public void clickonEmailCompaign(){
			 Actions action=new Actions(driver);
			 action.moveToElement(campaigns).build().perform();
			 EmailCompaign.click();
		 }
		 
		 public void clickonnewcontactslink(){
			 Actions action=new Actions(driver);
			 action.moveToElement(contactslink).build().perform();
			  newcontact.click();
		    }
		 
		 public void clickoncombinedform(){
			 Actions actiontwo=new Actions(driver);
			 actiontwo.moveToElement(contactslink).build().perform();
			 //actiontwo.moveToElement(newcontact).build().perform();
			//actiontwo.moveToElement(combinedform).click();
			 //driver.findElement(By.name("Combined Form")).click();
			 WebDriverWait wait=new WebDriverWait(driver,5);
			combinedform= wait.until(ExpectedConditions.elementToBeClickable(combinedform));
			combinedform.click(); 
		 }
		
		 public void countlinks(){
			List<WebElement> alllinks=links;
			System.out.println("the count of all the available links are "+ alllinks.size());
			for(WebElement element:alllinks){
				System.out.println("the link is "+element);
			}
		 }
			
		public void countdropdowns(){
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,250)");
			System.out.println("Window Scrolled successfully");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<WebElement> totaldropdown=dropdown;
			System.out.println("the total number of dropdowns are "+ dropdown.size());
			for(WebElement dropcount :totaldropdown){
				System.out.println("the total number of dropdowns count is "+dropcount);
			}
			
		
		}
			
			
}
		 
		 
		
	


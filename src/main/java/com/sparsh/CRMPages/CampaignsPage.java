package com.sparsh.CRMPages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sparsh.qa.base.*;

public class CampaignsPage extends TestBase {

	@FindBy(css="body > table:nth-child(5) > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr > td > div > div.linkStyle > a")
	WebElement upgradeaccount;
	
	@FindBy(name="credit_card_name")
	WebElement name_on_card; 
	
	@FindBy(xpath="//select[@name='credit_card_type']")
	WebElement creaditcardtype;
	
    @FindBy(xpath="//input[@id='credit_card_number']")
	WebElement creaditcardno;
    
    @FindBy(xpath="#billingForm > p > table > tbody > tr:nth-child(2) > td > input")
    WebElement upcaccount;
    @FindBy(xpath="#billingForm > p > table > tbody > tr:nth-child(2) > td > input")
    WebElement upcaccountr;
	
	public CampaignsPage(){
		
		PageFactory.initElements(driver,this);
	  }
	public void upgradeaccount(){
		
		String MainWindow=driver.getWindowHandle();
		upgradeaccount.click();
		for(String chaildhandle:driver.getWindowHandles()){
			driver.switchTo().window(chaildhandle);
		}
			name_on_card.clear();
			name_on_card.sendKeys("ashok");
			Select cardtype=new Select(creaditcardtype);
			cardtype.selectByVisibleText("Mastercard");
			creaditcardno.sendKeys("878979879794");
			upcaccount.click();
		driver.close();
		driver.switchTo().window(MainWindow);
		
		
		
		
		
	}
	
	
	
}

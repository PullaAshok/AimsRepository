package com.sparsh.CRMPages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sparsh.CRMPages.*;
import com.sparsh.qa.base.TestBase;

public class DealsPage extends TestBase {
	
	//Pagefactory 
	
	@FindBy(xpath= "//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//a[@title='New Deal']")
	WebElement newDealPage;
	
	@FindBy(xpath="/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/fieldset/legend")
	WebElement deal;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement dealpagetitle;
	
    @FindBy(css="#prospectForm > table > tbody > tr:nth-child(2) > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > input.button")
	 WebElement companylookup;
    
    @FindBy(xpath="//input[@id='search']")
    WebElement searchtext;
    
    @FindBy(xpath="//input[@type='submit']")
    WebElement search;
    
    @FindBy(css="body > table > tbody > tr:nth-child(3) > td > table > tbody > tr:nth-child(3) > td > a")
    WebElement volksoft;
    
    @FindBy(xpath="//input[@name='amount']")
    WebElement amount;
    
    @FindBy(xpath="//a[contains(text(),'Chukka')]")
    WebElement vinay;
    
    @FindBy(name="probability")
    WebElement probability;
    
    @FindBy(name="commission")
    WebElement commission;
    
    @FindBy(name="identifier")
    WebElement identifier;
    
    @FindBy(xpath="//a[@href='https://www.freecrm.com/system/index.cfm?action=product&sub=load&edit=1']")
    WebElement productsadd;
    
    //adding product details elements
    
    @FindBy(id="name")
    WebElement productname;
    
    @FindBy(id="cost")
    WebElement productcost;
    
    @FindBy(xpath="//input[@id='retail_value']")
    WebElement productretailvalue;
    
    @FindBy(xpath="//input[@id='wholesale']")
    WebElement wolesalevalue; 
    
    @FindBy(xpath="//input[@id='sku']")
    WebElement sKU; 
    
    @FindBy(xpath="//input[@name='inventory_amount']")
    WebElement inventoryamount;
    
    @FindBy(xpath="//select[@name='product_id']")
    WebElement productdropdown;
    
    @FindBy(xpath="//select[@name='type'][@size='1']")
    WebElement typedrpdown;
    
    @FindBy(xpath="//select[@name='source'][@size='1']")
    WebElement sourcedrpdown;
    
    @FindBy(xpath="//input[@type='radio']")
    WebElement statusradiobtn;
    
    @FindBy(xpath="//input[@type='radio'][@value='N']")
    WebElement openStatusRadiobtn;
    
    @FindBy(xpath="//input[@type='radio'][@value='Y']")
    WebElement closedStatusRadiobtn;
    
    @FindBy(css="#f_trigger_c_close_date")
    WebElement pridictadclosedate;
    
    @FindBy(css="#f_trigger_c_actual_close_date")
    WebElement actualclosedate;
    
    @FindBy(css="#prospectForm > table > tbody > tr:nth-child(1) > td > input:nth-child(1)")
    WebElement dealsSave;
    
    @FindBy(css="#prospectForm > table > tbody > tr:nth-child(2) > td:nth-child(1) > table > tbody > tr:nth-child(4) > td:nth-child(2) > input.button")
    WebElement primarycontact;
    
	@FindBy(xpath="//input[@name='search']")
	WebElement newdealsearch;
	
	public DealsPage(){
		PageFactory.initElements(driver, this);
	}
	
	      public void FillnewdealPage(String Dealspagetitle,String Amount,
	    String Probability,String Commission,String Productdropdown,String Sourcedropdown){
	    	  
	    	  dealpagetitle.sendKeys(Keys.F5); 
	    	  
		Actions action=new Actions(driver);
		action.moveToElement(dealslink).build().perform();
		//newDealPage.click();
		WebDriverWait wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(newDealPage));
		newDealPage.click();
		
		dealpagetitle.sendKeys(Dealspagetitle);
		/*String Mainwindow=driver.getWindowHandle();
		companylookup.click();   // window handles.
        
		for(String Chaildwindow:driver.getWindowHandles()){
			driver.switchTo().window(Chaildwindow);
		}
		searchtext.sendKeys("volksoft");
		search.click(); 
		wait.until(ExpectedConditions.visibilityOf(volksoft));
		volksoft.click();
		Set<String> s1=driver.getWindowHandles();
		  
		  Iterator <String> itr=s1.iterator();
		  while(itr.hasNext()){
			  String Chaildwindow=itr.next();
			  if(!Mainwindow.equals(Chaildwindow)){
				  driver.switchTo().window(Chaildwindow);
			     
				  searchtext.sendKeys("volksoft");
					search.click(); 
					wait.until(ExpectedConditions.visibilityOf(volksoft));
					volksoft.click();
					}
		         } */
		     // driver.close();
		   //driver.switchTo().window(Mainwindow);   
		//driver.switchTo().defaultContent();
		  
		//amount.sendKeys(Keys.ENTER);    
			amount.click();
			amount.clear();
		amount.sendKeys(Amount);
		probability.sendKeys(Probability);
		
		commission.sendKeys(Commission);
		
		Select productdrpdown=new Select(productdropdown);
		productdrpdown.selectByVisibleText(Productdropdown);
		
		Select sourcedrpdown1=new Select(sourcedrpdown);
		sourcedrpdown1.selectByIndex(Integer.parseInt(Sourcedropdown));
		
		
		       if(openStatusRadiobtn.isSelected()){
			
			       System.out.println("the first radio button is selected");
			            }
		                else{
		    	     openStatusRadiobtn.click();
		               }
		       
		       pridictadclosedate.sendKeys("09252013");
		       System.out.println(pridictadclosedate.getLocation());
		       
		       dealsSave.submit();
		       
		       String DealschailspageTitle=driver.getTitle();
		       System.out.println("DealschailspageTitle "+ DealschailspageTitle);
		         
		        }
	
	  
	
	
	
	
	
		
	}
	
	

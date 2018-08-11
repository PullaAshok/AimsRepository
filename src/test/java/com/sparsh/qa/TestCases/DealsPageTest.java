package com.sparsh.qa.TestCases;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sparsh.CRMPages.DealsPage;
import com.sparsh.CRMPages.HomePage;
import com.sparsh.CRMPages.LoginPage;
import com.sparsh.qa.TestUtil.TestUtil;
import com.sparsh.qa.base.*;

public class DealsPageTest extends TestBase{
	
	LoginPage loginpage;
	DealsPage dealspage;
	 TestUtil testutil;
	public DealsPageTest(){
		
		super();
	}
	
	@BeforeMethod
	public void setup(){
		 initialization();
		 loginpage=new LoginPage();
		 loginpage.login(Property.getProperty("username"),Property.getProperty("password"));
		 testutil=new TestUtil();
		 testutil.switchtoframe();
		 dealspage=new DealsPage();
		   }
	
	@Test
	public void newDealsPageTest(){
		     try {
		         driver.get(driver.getCurrentUrl());
		          Thread.sleep(1000);
		         driver.navigate().to(driver.getCurrentUrl());
		
		         } catch (InterruptedException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
		        }
		
		          dealspage.FillnewdealPage("Newdealsashok","65","80","60","sdfsd","0");
	         }
	
	
	
 
  
}

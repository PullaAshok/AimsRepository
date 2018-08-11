package com.sparsh.qa.TestCases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.sparsh.CRMPages.ContactsPage;
import com.sparsh.CRMPages.HomePage;
import com.sparsh.CRMPages.LoginPage;
import com.sparsh.CRMPages.MessagePage;
import com.sparsh.qa.base.TestBase;
import com.sparsh.qa.TestUtil.*;
import com.sparsh.CRMPages.*;

public class HomePageTest extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactspage;
	TestUtil testutil;
	DealsPage dealspage;
	MessagePage messagepage;

	 public HomePageTest(){
		super();
	  }
	 //dsds
	
	@BeforeMethod
	  public void setup(){
		 initialization();
		 testutil=new TestUtil();
		 loginpage=new LoginPage();
		homepage=loginpage.login(Property.getProperty("username"),Property.getProperty("password"));
		testutil.switchtoframe();
	    }
	
	@Test(priority=1)
	public void countlink(){
		homepage.countlinks();
		homepage.countdropdowns();
		
	}
	
	@Test(priority=5)
	  public void verifyhomepagetitleTest(){
		String homepagetitle=homepage.verifyhompageTitle();
		Assert.assertEquals(homepagetitle,"CRMPRO","Home page title is not equal");
	    }
	@Test(priority=2)
	  public void verifyusernameTest(){
		testutil.switchtoframe();
		Assert.assertTrue(homepage.verifyusername());
	}
	
	@Test(priority=3)
	  public void verifycontactslinkTest(){
		testutil.switchtoframe();
		contactspage=homepage.clickoncontactlink();
		driver.navigate().refresh();
	    }  
	    
	@Test(priority=4)
	  public void verifydealsclinkTest(){
		testutil.switchtoframe();
		dealspage=homepage.clickondealslink();
		
		driver.navigate().refresh();
	}
	@Test(priority=1)
	public void verifymessagebtnclickTest(){
		driver.navigate().refresh();
		testutil.switchtoframe();
		messagepage=homepage.clickonmessagebtn();
	}
	@AfterMethod
	
	  public void teardown(){
		driver.close();
	    }

}

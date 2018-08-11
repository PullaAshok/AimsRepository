package com.sparsh.qa.TestCases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.sparsh.CRMPages.HomePage;
import com.sparsh.CRMPages.LoginPage;
import com.sparsh.qa.base.TestBase;
import com.sparsh.qa.TestUtil.*;
public class LoginPageTest extends TestBase{
   LoginPage loginpage;
   HomePage homepage;
   TestUtil testutil;
   SoftAssert sassert;
	LoginPageTest (){
		super ();
	     }
    @BeforeMethod
    public void setup(){
	initialization();
	sassert=new SoftAssert();
	testutil=new TestUtil();
	loginpage=new LoginPage();
	      }
	@Test(priority=1)
	public void loginpagetitleTest(){
		try{
		String title=loginpage.validateLoginPageTitle();
		sassert.assertEquals(title,"ee CRM software in the cloud powers sales and customer service");
		System.out.println(title);
		sassert.assertAll();
		}catch(Exception e){
			
			System.out.println("the screenshot has been taken");
		}
	}
	@Test(priority=2)
	public void imagetest(){
		boolean image=loginpage.validateCRMImage();
		Assert.assertTrue(image);
	}
	@Test(priority=3)
	public void loginpageTest(){
		homepage=loginpage.login(Property.getProperty("username"),Property.getProperty("password"));
		  }
	@AfterMethod
	public void logout(){
		driver.quit();
		System.out.println("after test executed");
	}
}

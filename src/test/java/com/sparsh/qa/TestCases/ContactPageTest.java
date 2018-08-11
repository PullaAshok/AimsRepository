package com.sparsh.qa.TestCases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sparsh.qa.base.*;
import com.sparsh.CRMPages.*;
import com.sparsh.qa.TestUtil.*;  
public class ContactPageTest extends TestBase {
	        LoginPage loginpage;
	        HomePage homepage;
	        ContactsPage contactspage;
	        TestUtil testutil;
	        String sheetname="Contacts";
	        SoftAssert sassert;
	        
	    public ContactPageTest(){
		       super();
	          }
	    @BeforeMethod
	    public void setup(){
		      initialization();
		      testutil=new TestUtil();
		      sassert=new SoftAssert();
		      loginpage=new LoginPage();
		      homepage=loginpage.login(Property.getProperty("username"),Property.getProperty("password"));
		      testutil.switchtoframe();
		      contactspage=new ContactsPage(); 
	          }
        
	     @Test(priority=4)
	     public void verifycontactlableTest(){
	    	 try{
	    	   homepage.clickoncontactlink();
	    	   boolean lablenamecontacts=contactspage.verifycontactslable();
	    	   sassert.assertTrue(lablenamecontacts,"lable name wrong");
	    	   System.out.println("lable name contacts displayed successfully"); 
	    	   sassert.assertAll();
	          }catch(Exception e){
	        	  TestUtil.takeScreenshotTest();
	        	  System.out.println("screenshot taken successfully");
	          }
	     }
	     
	     @Test(priority=2)
	     public void createnewcontactTests(){
	    	 try{
	    	   homepage.clickonnewcontactslink(); 
	    	   //TestUtil.fluenwait();
               contactspage.validatecreatecontact("Mr.", "Mallesh", "ramya");
               //contactspage.validatecreatecontact(Titlet, firstName, LastName);
	           }catch(Exception e){
	    	   TestUtil.takeScreenshotTest();
	    	   System.out.println("the screenshot taken successfully");
	       }
	     }
	     @Test(priority=3)
	     public void verifyLableTextTest(){
	    	 try{
	    	 homepage.clickoncontactlink();
	    	 String lableText=contactspage.verifylableText();
	    	 sassert.assertEquals("Contacts",lableText,"Expected contact name is doen't equals");
	    	 sassert.assertAll();
	     }catch(Exception e){
       	  TestUtil.takeScreenshotTest();
       	  System.out.println("screenshot taken successfully text");
         }
	   }  
	     @Test(priority=6)
	     public void verifyframelistTest(){
	    	 try{
	    	 homepage.clickoncontactlink();
	    	 int framesize=contactspage.getframes();
	    	 System.out.println("the number of frames size is "+ framesize);
	    	 sassert.assertEquals(framesize, 3, "actual frameset size is not equal to expected");
	    	 System.out.println("assret executed after faild the testcase");
	    	 //Thread.sleep(3000);
	    	 sassert.assertAll();
	    	 
	    	 }catch(Exception e){
	    		 System.out.println("Screenshot has been taken");
	    		 TestUtil.takeScreenshotTest();
	    		 e.printStackTrace();
	    	 }
	    	 
	    }
	     
	     @DataProvider(name="getdataa")
	     public Object[][] getdatab() throws Exception{
	    	   Object[][] data=TestUtil.getTextdata(sheetname);
	    	   return data;   
	       }
	     
	     @DataProvider(name="getdataa")
	     public Object[][] getdata(){  //getdata() name should be equal to dataProvider name.
	    	 Object[][] data=new Object [3][3];
	    	
	    	 data[0][0]="Mr.";
	    	 data[0][1]="pulla";
	    	 data[0][2]="Ashok";
	    	 
	    	 data[1][0]="Mr.";
	    	 data[1][1]="Hema";
	    	 data[1][2]="pulla";
	    	 
	    	 data[2][0]="Mr.";
	    	 data[2][1]="Rekha";
	    	 data[2][2]="pulla";
	    	 
	    	 
	    	 return data; 
	    	 
	     }
	     @Test(priority=1,dataProvider="getdata")
	         public void createnewcontactTestss(String Titlet,String firstName,String LastName){
	    	 homepage.clickonnewcontactslink(); 
             contactspage.validatecreatecontact(Titlet,firstName,LastName);
             System.out.println("the data provider");
	         } 
	    
	     @Test(priority=2)
	     
	     /*public void validatecombinedformTest(String Company, String Industry, String Revenue, String Employee,String Catogory, String Status, String Priority,
	    		 String Source,String Identifier, String Phonenumber, String Email,String  Notes, String Title, String Firstname, String Middlename,
	    		 String Lastname, String Nickname, String Position,
	    		String Department, String Supervisor, String Asistance, String Category, String Homephone) */
	     
	     public void validatecombinedformTest() throws Exception{
	    	 //homepage.clickonnewcontactslink();
	    	 homepage.clickoncombinedform();
	    	 try{
	    	 contactspage.fillCombinedContactForm("volksoft", "Software", "1000", "Aswini",
	    			 "Client", "Hot", "Low", "Ad", "asasdda", "8445666454", "ashok144143@gmail.com", 
	    			 "this is ashok", "Dr.", "Chukka", "kumar", "vinay", "chintu", "engineer", 
	    			 "software","Friend", "9000114026","contactAshok","Shipping Address","Balajinagar","hyd"); 
	            }catch(Exception e){
	            	TestUtil.takeScreenshotTest();
	            	System.out.println("the screenshot has taken");
	            }
	       }
	     
	 	 @AfterMethod()
	 	 public void teardown(){
	 		   driver.close();
	 	  }
	 	  
	 }
	       
	      
	       
	       
	       
	       
	       
	         
	  

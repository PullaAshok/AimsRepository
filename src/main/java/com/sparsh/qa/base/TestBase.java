package com.sparsh.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.sparsh.qa.TestUtil.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
public class TestBase {
		 public static WebDriver driver;
		 public static Properties Property;
		 public static  EventFiringWebDriver e_webdriver;
		 public static WebEventListener Eventlistener;	//WebDriverEventListener Eventlistenert; class implements WebDriverEventListener interface we can use this also.
		 public TestBase(){
			     try{
				     
			    	 Property=new Properties();
			    	 FileInputStream ip=new FileInputStream("D:/workspacee/SparshTestProject/src/main/java/com/sparsh/qa/configuration/configuration.properties");
			    	 
			    	 //( Username : Admin | Password : admin123 )
			    	 //Property=new Properties();
				     // FileInputStream ip=new FileInputStream("E:/workspace/web-automation/src/main/java/com/sparsh/qa/Configuration/Configurator.properties");
				     try {
					 Property.load(ip);
				    } catch (IOException e) {
					 // TODO Auto-generated catch block
					 e.printStackTrace();
				   }
			      }
			        catch(FileNotFoundException e){
				   e.printStackTrace();
			     }
		   }
			  public static void initialization(){
				 try{
					 String browserName=Property.getProperty("browser");
				    if(browserName.equals("chrome")){
				    	
				    	System.setProperty("webdriver.chrome.driver","D:\\Chomedrivera\\chromedriver_win32\\chromedriver.exe");
				    	driver=new ChromeDriver();
				      }
				    else if(browserName.equals("firefox")){
	                    System.setProperty("webdriver.gecko.driver","D:\\Chomedrivera\\geckodriver.exe");
				    	
				    	driver=new FirefoxDriver();
				        }
				    else if(browserName.equals("opera")){
				    	System.setProperty("webdriver.opera.driver","D:\\Chomedrivera\\operadriver_win32\\operadriver.exe");
				       driver=new OperaDriver();
				              }
				    
				     e_webdriver=new EventFiringWebDriver(driver);  //Initializing the event driver
				    
				     Eventlistener=new WebEventListener();  //Import from Testutil package  create object of our event linstener class 
				    
				      e_webdriver.register(Eventlistener);  //To register my all eventfiring classes
				     
				      driver=e_webdriver;
				    
				    
				    driver.manage().window().maximize(); 
				    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUTS,TimeUnit.SECONDS);
				    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
				    driver.navigate().to(Property.getProperty("url"));
				     
				  }
				  catch(Exception e){
					  System.out.println("error in the browser");
				         }
			    }
	}



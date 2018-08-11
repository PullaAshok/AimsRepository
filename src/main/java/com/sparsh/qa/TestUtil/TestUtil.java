package com.sparsh.qa.TestUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.maven.shared.utils.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.sparsh.qa.base.*;
        public class TestUtil extends TestBase {
	    private static final Class NosuchElementException =null;
		public static long PAGE_LOAD_TIMEOUTS=30;
	    public static long IMPLICIT_WAIT=20;
	    public static String TESTDATA_SHEET_PATH="E:\\TESTDATA\\TESTDATA.xlsx";
	    public void switchtoframe(){
		driver.switchTo().frame("mainpanel");
	                }
	    public static Object[][] getTextdata(String sheetname) throws Exception {
	    	 FileInputStream file=null;
	    
				file=new FileInputStream(TESTDATA_SHEET_PATH);
			
				XSSFWorkbook book=new XSSFWorkbook(file);
			
	    	    XSSFSheet sheet=book.getSheet(sheetname);
	    	 
	    	    Object [][]data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	    	 
	    	    for(int i=0; i<=sheet.getLastRowNum(); i++) {
	    		 
	    		  for(int k=0; k<=sheet.getRow(0).getLastCellNum(); k++) {
	    			 
	    			 data[i][k]=sheet.getRow(i+1).getCell(k).toString();
	    			   }  
	                 }
	    	   return data;
	    	   
	    	   
	        }
	    
	    public static void takeScreenshotTest(){
	    	
	    	TakesScreenshot screenshot=(TakesScreenshot)driver;
	    	File source=screenshot.getScreenshotAs(OutputType.FILE);
	    	
	    	//./Failedsrnshots/screen.png     SimpleDateFormat("yyyyMMddhhmmss'.png'").format(new Date());
	    	String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.png'").format(new Date());
	    	
	    	File destn=new File("./Failedsrnshots/screen" + filename);
	    	
	    	try {
				FileUtils.copyFile(source, destn);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
           }
	    
	    public static void fluenwait(){
	    	Wait wait=new FluentWait<WebDriver>(driver)
	    	.pollingEvery(5, TimeUnit.SECONDS)
	    	.withTimeout(30,TimeUnit.SECONDS)
	    	.ignoring(NoSuchElementException.class);
	    }
	    
	    
      }
        
        
	    	
	    	

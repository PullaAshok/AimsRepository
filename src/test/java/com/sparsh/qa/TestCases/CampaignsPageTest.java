package com.sparsh.qa.TestCases;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import com.sparsh.qa.base.*;
import com.sparsh.CRMPages.*;
import com.sparsh.qa.TestUtil.*;

public class CampaignsPageTest extends TestBase {
	    HomePage homepage;
	    TestUtil testutil;
	    CampaignsPage campaignpage;
		public CampaignsPageTest(){
			super();
		   }
		@BeforeMethod
		public void setup(){
			//
			initialization();
			LoginPage login=new LoginPage();
			homepage=login.login(Property.getProperty("username"),Property.getProperty("password"));
			testutil=new TestUtil();
		    campaignpage=new CampaignsPage();
			testutil.switchtoframe();
		    }
		@Test
		public void validateaccount(){
			homepage.clickonEmailCompaign();
			campaignpage.upgradeaccount();
		}
		
		
}

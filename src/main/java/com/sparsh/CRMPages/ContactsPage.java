package com.sparsh.CRMPages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.sparsh.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath= "//td[contains(text(),'Contacts')]")
	//@CacheLookup
	WebElement contacts;
	
	@FindBy(xpath= "//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath= "//input[@value='Load From Company']")
	WebElement loadcompany;
	
	@FindBy(xpath= "//input[@id='company_name']")
	WebElement companyname;
		
	@FindBy(xpath= "//a[contains(text(),'New Contact')]")
	WebElement newcontact;
	
	@FindBy(xpath= "//select[@name='title']")
	WebElement title;
	
	@FindBy(xpath= "//input[contains(@name,'first_name')]")
	WebElement firstname;
	
	@FindBy(xpath="//input[@name='middle_initial']")
	WebElement middilename;
	//input[@name='tags']
	
	@FindBy(name="priority")
	WebElement priority;
	
	@FindBy(name="company_status")
	WebElement contactstatus;
	
	@FindBy(xpath="//input[@name='tags']")
	WebElement tags;
	
	@FindBy(xpath="//input[@name='contact_phone']")
	WebElement contactphone;
	
	@FindBy(xpath= "//input[@name='company_phone']")
	WebElement companphone;
	
	@FindBy(xpath= "//input[contains(@id,'surname')]")
	WebElement lastname;
	
	@FindBy(xpath= "//select[contains(@name,'suffix')]")
	WebElement suffix;
	
	@FindBy(xpath= "//input[@name='contact_nickname']")
	WebElement nickname;
	
	@FindBy(xpath= "//select[@name='category']")
	WebElement categoryname;
	
	@FindBy(xpath="//iinput[@name='mobile']")
	WebElement mobile;
	
	@FindBy(xpath="//textarea[@name='service']")
	WebElement notessource;
	
	@FindBy(xpath= "//input[@name='contact_email']")
	WebElement contactemail;
	
	@FindBy(xpath= "//input[@name='im_id']")
	WebElement messangerid;
	
	@FindBy(xpath="//img[@title='Date selector']")
	WebElement dateselector;
	
	@FindBy(id="textarea")
	WebElement notes;
	
	@FindBy(xpath="//*[@id='combinedForm']/fieldset/table/tbody/tr[3]/td[1]/table/tbody/tr[8]/td[2]/select")
	WebElement sourcecontact;
	//Select a Date From DatePicker Using Selenium
	
	@FindBy(xpath="//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]")
	WebElement newcontctSave;
	
	@FindBy(xpath= "//*[@id='combinedForm']/fieldset/table/tbody/tr[1]/td/input")
	WebElement save;
	
	@FindBy(xpath="//input[@type='submit'][@class='button'][@value=' = SUBMIT = ']")
	WebElement cominedsave;
                                            	
	
	//Combined form page elements

	@FindBy(xpath="//input[@name='industry']")
	WebElement industry;

	@FindBy(xpath="//input[@name='annual_revenue']")
	WebElement annaualrevenue;
	
	@FindBy(xpath="//input[@name='num_of_employees']")
	WebElement employees;
	
	@FindBy(xpath="//input[@name='department']")
	WebElement department;
	
	@FindBy(xpath="//select[@name='contact_category']")
	WebElement catagory;
	
	@FindBy(xpath="//input[@name='company_position']")
	WebElement position;
	
	@FindBy(xpath="//select[@name='company_status']")
	WebElement status;
	
	@FindBy(xpath="//input[@name='company_identifier']")
	WebElement identifier;
	
	@FindBy(xpath="//input[@name='home_phone']")
	WebElement homephone;
	
	@FindBy(xpath="//input[@name='vat_number']")
	WebElement VATTAX;
	
	@FindBy(xpath="//input[@name='company_phone']")
	WebElement companyphone;
	@FindBy(id="company_email")
	WebElement email;
	
	@FindBy(xpath="//input[@type='radio']")
	WebElement receivemails;
	
	@FindBy(name="address_title")
	WebElement addresstitle;
	
	@FindBy(xpath="//textarea[@name='address']")
	WebElement defaultaddress;
	
	@FindBy(xpath="//input[@name='contact_lookup_ass']")
	WebElement asistance;
	
	@FindBy(xpath="//*[@id='combinedForm']/fieldset/table/tbody/tr[4]/td/fieldset/table/tbody/tr/td/table/tbody/tr[2]/td[2]/select")
	WebElement type;
	
	@FindBy(xpath="//input[@name='contact_lookup_sup']")
	WebElement supervisor;
	
	@FindBy(name="address")
	WebElement city;
	
	@FindBy(xpath="//a[contains(text(),'Combined Form')]")
	WebElement combinedform;
	
	
	//@FindBy(xpath="//input[@id='company_email']")
	//WebElement Email;
	
	   public ContactsPage(){
		    PageFactory.initElements(driver, this);
	        }
	
	   public void validatecreatecontact(String Title, String Ftname,String Lname){
		
		       Select slt=new Select(title);
		       slt.selectByVisibleText(Title);
		
		       firstname.sendKeys(Ftname);
		       lastname.sendKeys(Lname);
		       //mobile.sendKeys(mobileno);
		       newcontctSave.click();
		     }
	
        public boolean verifycontactslable(){
		        return contacts.isDisplayed();
		     }
	
	    public String verifylableText(){
	    	   String contactstext= contacts.getText();
	    	   return contactstext;
	         }
	
		public boolean verifynewcontactspage(){
			   return loadcompany.isDisplayed();
		     }
		
		public int getframes(){
			   List <WebElement> framesetno=driver.findElements(By.tagName("iframe"));
			   int size=framesetno.size();
			   return size;
		      }
		public boolean clickoncombinedform(){
			combinedform.click();
			return combinedform.isDisplayed();
		     }
    public void fillCombinedContactForm(String Company, String Industry,String Revenue,String Employee,
				String Catogory,String ContactStatus,String Priority,String Source,String Identifier,String Phonenumber,
				String Email,String Notes,String Title,String Firstname,String Middlename,String Lastname,
				String Nickname,String Position,String Department,
				String Category,String Homephone,String AddressTiltle,String Type,String Defaultaddress,String City){
    	
    	  companyname.sendKeys(Company);
    	  industry.sendKeys(Industry);
    	  annaualrevenue.sendKeys(Revenue);
    	  employees.sendKeys(Employee);
    	  Select slt=new Select(categoryname);
    	  slt.selectByVisibleText(Catogory);
    	  
    	  Select sltconctact=new Select(contactstatus);
    	  sltconctact.selectByVisibleText(ContactStatus);
    	  
    	  Select sltpriority=new Select(priority);
    	  sltpriority.selectByVisibleText(Priority);
    	  
    	  Select sltsource=new Select(sourcecontact);
    	  sltsource.selectByVisibleText(Source);
    	  
    	  identifier.sendKeys(Identifier);
    	  companphone.sendKeys(Phonenumber);
    	  email.sendKeys(Email);
    	  notessource.sendKeys(Notes);
    	  Select slttitle=new Select(title);
    	  slttitle.selectByVisibleText(Title);
    	  
    	  title.sendKeys(Title);
    	  firstname.sendKeys(Firstname);
    	  middilename.sendKeys(Middlename);
    	  lastname.sendKeys(Lastname);
    	  nickname.sendKeys(Nickname);
    	  position.sendKeys(Position);
    	  //department.sendKeys(Department);
    	 // supervisor.sendKeys(Supervisor);
    	  //asistance.sendKeys(Asistance);
    	  Select sltcatry=new Select(catagory);
    	  sltcatry.selectByVisibleText(Category);
    	  homephone.sendKeys(Homephone);
    	  
    	  addresstitle.sendKeys(AddressTiltle);
    	  Select sltcatype=new Select(type);
    	  sltcatype.selectByVisibleText(Type);
    	  defaultaddress.sendKeys(Defaultaddress);
    	  city.sendKeys(City);
    	save.click();
    	  
    	  
    	  
    	  
   
			
			
		     }
		
		   }
	
	/* public boolean clickonnewcontacts() {
		
		Actions action=new Actions(driver);
		action.moveToElement(contacts).build().perform();
	
		R.keyPress(KeyEvent.VK_DOWN);
		R.keyRelease(KeyEvent.VK_DOWN);
		
		R.keyPress(KeyEvent.VK_ENTER);
		R.keyRelease(KeyEvent.VK_ENTER);   
		
		   return loadcompany.isDisplayed(); 
	}*/ 



	


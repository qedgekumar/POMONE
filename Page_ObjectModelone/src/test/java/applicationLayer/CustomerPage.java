package applicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerPage {
	WebDriver driver;
	public CustomerPage(WebDriver driver)
	{
		this.driver=driver;
	}
	//define repository
	@FindBy(xpath="(//a[@href='a_customerslist.php'])[2]")
	WebElement objCustomer;
	@FindBy(xpath="(//span[@data-caption='Add'])[1]")
	WebElement objAddicon;
	@FindBy(xpath="//input[@id='x_Customer_Number']")
	WebElement objCustomernum;
	@FindBy(xpath="//input[@id='x_Customer_Name']")
	WebElement objCustomerName;
	@FindBy(xpath="//textarea[@id='x_Address']")
	WebElement objAddress;
	@FindBy(xpath="//input[@id='x_City']")
	WebElement objCity;
	@FindBy(xpath="//input[@id='x_Country']")
	WebElement objCountry;
	@FindBy(xpath="//input[@id='x_Contact_Person']")
	WebElement objContactperson;
	@FindBy(xpath="//input[@id='x_Phone_Number']")
	WebElement objPhoneNumber;
	@FindBy(xpath="//input[@id='x__Email']")
	WebElement objEmail;
	@FindBy(xpath="//input[@id='x_Mobile_Number']")
	WebElement objMobileNum;
	@FindBy(xpath="//input[@id='x_Notes']")
	WebElement objNotes;
	@FindBy(xpath="//button[@id='btnAction']")
	WebElement objAddbutton;
	@FindBy(xpath="//button[normalize-space()='OK!']")
	WebElement objConfirmOk;
	@FindBy(xpath="(//button[starts-with(text(),'OK')])[6]")
	WebElement objAlertOk;
	@FindBy(xpath="//span[@data-caption='Search']")
	WebElement objSearchpanel;
	@FindBy(xpath="//input[@id='psearch']")
	WebElement objSearchtextbox;
	@FindBy(xpath="//button[@id='btnsubmit']")
	WebElement objSearchbutton;
	@FindBy(xpath="//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")
	WebElement webtable;
	//method for add customer
	public boolean add_customer(String Customername,String Address,String City,String Country,String Contactname,String Phonenumber,String Email,String Mobilenumber,String Notes) throws Throwable
	{
		this.objCustomer.click();
		this.objAddicon.click();
		String Exp_num=this.objCustomernum.getAttribute("value");
		this.objCustomerName.sendKeys(Customername);
		this.objAddress.sendKeys(Address);
		this.objCity.sendKeys(City);
		this.objCountry.sendKeys(Country);
		this.objContactperson.sendKeys(Contactname);
		this.objPhoneNumber.sendKeys(Phonenumber);
		this.objEmail.sendKeys(Email);
		this.objMobileNum.sendKeys(Mobilenumber);
		this.objNotes.sendKeys(Notes);
		this.objAddbutton.click();
		Thread.sleep(2000);
		this.objConfirmOk.click();
		Thread.sleep(2000);
		this.objAlertOk.click();
		if(!this.objSearchtextbox.isDisplayed())
			this.objSearchpanel.click();
		this.objSearchtextbox.clear();
		this.objSearchtextbox.sendKeys(Exp_num);
		this.objSearchbutton.click();
		Thread.sleep(2000);
		String Act_num=this.webtable.getText();
		if(Act_num.equals(Exp_num))
		{
			Reporter.log("Customer Added success"+Exp_num+"  "+Act_num,true);
			return true;
			
		}
		else {
			Reporter.log("Customer Added Fail"+Exp_num+"   "+Act_num,true);
			return false;
			
		}
		
		
		
	}
	

}

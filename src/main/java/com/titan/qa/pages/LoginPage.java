package com.titan.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.titan.qa.base.TestBase;
import com.titan.qa.util.TestUtil;

public class LoginPage extends TestBase{

	TestUtil testutil = new TestUtil();
	
	
	
	@FindBy(xpath = "//input[@name='username']")
	@CacheLookup
	WebElement username;
	
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//button[contains(.,'SIGN IN & CONTINUESIGN IN AND CONTINUE')]")
	WebElement signinbtn;
	
	
	@FindBy(xpath = "//select[@id='selectGender']")
	WebElement sel_Person_Title;
	
	
	@FindBy(xpath = "//input[@id='firstName']")
	WebElement edt_First_name;
	

	@FindBy(xpath = "//input[@id='lastName']")
	WebElement edt_Last_Name;
	
	@FindBy(xpath = "//select[@id='date']")
	WebElement sel_DOB_Date;
	
	@FindBy(xpath = "//select[@id='month']")
	WebElement sel_DOD_Month;
	
	@FindBy(xpath = "//select[@id='year']")
	WebElement sel_DOB_Year;
	
	
	@FindBy(xpath = "//input[@id='phoneNumber']")
	WebElement edt_Phone_no;
	
	@FindBy(xpath = "//input[@id='emailAddress']")
	WebElement edt_Email_ID;
	
	@FindBy(xpath = "//input[@id='setPassword']")
	WebElement edt_Password;
	
	@FindBy(xpath = "//label[@for='iAgree']")
	WebElement chk_IAgree;

	@FindBy(xpath = "//button[@type='submit'][contains(.,'CREATE ACCOUNT')]")
	WebElement btn_CreateAccount;
	
	
	public LoginPage(){
	
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateLoginPageTitle(){
	
		return driver.getTitle();
	}
	
	
	public HomePage login(String un, String pwd) throws Throwable{
		
		
	   
		username.sendKeys(un);
		password.sendKeys(pwd);
		TestUtil.scrollIntoView(username, driver);
	    TestUtil.clickElementByJS(signinbtn, driver);	
	    TestUtil.Thread_Sleep();
		    
		
		return new HomePage();
	}
	
	
	
	public HomePage NewUserReg(String tle, String ftName, String ltName, String dat , String mon, String yr, String psd,String emi,String phon) throws Throwable{
		
		
		
		Select select = new Select(driver.findElement(By.xpath("//select[@id='selectGender']")));
		select.selectByVisibleText(tle);
		
		
		
		edt_First_name.sendKeys(ftName);
		edt_Last_Name.sendKeys(ltName);
		
		//TestUtil.clickElementByJS(sel_DOB_Date, driver);
		
		TestUtil.scrollIntoView(edt_Phone_no, driver);
		TestUtil.Thread_Sleep();
		TestUtil.drawBorder(sel_DOB_Date, driver);
		TestUtil.Thread_Sleep();
		
		
		
		Select select1 = new Select(sel_DOB_Date);
		select1.selectByVisibleText(dat);
		
		//TestUtil.clickElementByJS(sel_DOD_Month, driver);
		
		TestUtil.drawBorder(sel_DOD_Month, driver);
		Select select2 = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		select2.selectByVisibleText(mon);
		
		//TestUtil.clickElementByJS(sel_DOB_Year, driver);
		
		TestUtil.drawBorder(sel_DOB_Year, driver);
		Select select3 = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		select3.selectByVisibleText(yr);
		
		
		TestUtil.scrollIntoView(sel_DOB_Year, driver);
		
		
		edt_Phone_no.sendKeys(TestUtil.phone);
		
		
		edt_Email_ID.sendKeys(TestUtil.email);
	
		
		//TestUtil.writingdataintoexcel();
		
		edt_Password.sendKeys(psd);
		
		TestUtil.clickElementByJS(chk_IAgree, driver);
		//chk_IAgree.click();
		
		TestUtil.clickElementByJS(btn_CreateAccount, driver);
		
		TestUtil.Thread_Sleep();
		//btn_CreateAccount.click();
		
		
		return new HomePage();
		
		
	}
	
	
	
	
	
	
}

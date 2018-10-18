package com.titan.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.titan.qa.base.TestBase;
import com.titan.qa.util.TestUtil;

public class Checkout extends TestBase{

	
	@FindBy(xpath = "(//h3[contains(.,'DEFAULT')])[1]")
	WebElement lbl_Default_Address;
	
	
	@FindBy(xpath = "//button[contains(.,'USE SELECTED ADDRESS')]")
	WebElement Btn_Select_Address;
	
	
	@FindBy(xpath = "//button[contains(.,'CONTINUE TO PAYMENT')]")
	WebElement btn_Continue_to_Payment;

	
	@FindBy(xpath = "//h3[@class='payment-option'][contains(.,'Cash On Delivery')]")
	WebElement lnk_COD;
	
	@FindBy(xpath = "//button[contains(.,'Confirm Order')]")
	WebElement btn_Confirm_Order;
	
	
	
	
	public Checkout() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public String VerifyCheckoutPageTitle() {
		
		return driver.getTitle();
		
		
	}
	
		
	
	
	public void GoToCODOption() throws Throwable {
		
		
		
		
		
		TestUtil.drawBorder(lbl_Default_Address, driver);
		lbl_Default_Address.isDisplayed();
		TestUtil.drawBorder(Btn_Select_Address, driver);
		TestUtil.Thread_Sleep();
		Btn_Select_Address.click();
		TestUtil.Thread_Sleep();
		
         
        TestUtil.scrolldownslowly();
        TestUtil.scrollIntoView(btn_Continue_to_Payment, driver);
        TestUtil.drawBorder(btn_Continue_to_Payment, driver);
        TestUtil.Thread_Sleep();
        TestUtil.clickElementByJS(btn_Continue_to_Payment, driver);
        TestUtil.Thread_Sleep();
		
		
		TestUtil.scrollIntoView(lnk_COD, driver);
		TestUtil.drawBorder(lnk_COD, driver);
		TestUtil.Thread_Sleep();
		TestUtil.clickElementByJS(lnk_COD, driver);
		TestUtil.Thread_Sleep();
		TestUtil.scrollIntoView(btn_Confirm_Order, driver);
		TestUtil.drawBorder(btn_Confirm_Order, driver);
		TestUtil.Thread_Sleep();
		btn_Confirm_Order.isDisplayed();
		TestUtil.Thread_Sleep();
		
		
		
		
	}
	
	
	
	
	
}

package com.titan.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.titan.qa.base.TestBase;
import com.titan.qa.util.TestUtil;

public class Cart extends TestBase{

	
	@FindBy(xpath = "(//button[contains(.,'PROCEED TO CHECKOUT')])[1]")
	WebElement btn_Proceed_to_chkt;
	
	


     public Cart() {
    	 
    	 PageFactory.initElements(driver, this);
     }
	
	
     public String verifyCartPageTitle(){
 		return driver.getTitle();
 	}
     
     
     public Checkout ClickonProceedtochkt() {
    	 
       
       TestUtil.scrollIntoView(btn_Proceed_to_chkt, driver);
       TestUtil.drawBorder(btn_Proceed_to_chkt, driver);
       TestUtil.clickElementByJS(btn_Proceed_to_chkt, driver);
    	 
    	 
		return new Checkout();
    	 
    	 
    	 
    	 
     }
     
     
     
	
}


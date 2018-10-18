package com.titan.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.titan.qa.base.TestBase;
import com.titan.qa.util.TestUtil;

public class HomePage extends TestBase{

	
	
	@FindBy(xpath = "//a[@id='loginPath']")
	WebElement loginlnk;
	
	
	@FindBy(xpath = "//a[@class='closeSearch collapsed']")
	WebElement lnk_searchicon;
	
	
	@FindBy(xpath = "//input[@id='searchTextBox']")
    WebElement edt_searchtextbox;
	
	
	@FindBy(xpath = "//button[@class='no-btn-search']")
	WebElement btn_search;
	
	
	
	@FindBy(xpath = "//a[contains(.,'WATCHES & SMART')]")
	WebElement lnk_WatchesandSmart;
	
	@FindBy(xpath = "//a[contains(.,'GUYS WATCHES')]")
	WebElement lnk_GUYS_WATCHES;
	
	
	@FindBy(xpath = "//a[contains(.,'CART (')]")
	WebElement lnk_Cart;
	
	
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public  void clickonloginlink() {
		
		//TestUtil.drawBorder(loginlnk, driver);
	    TestUtil.clickElementByJS(loginlnk, driver);
	
		
		
	}
	

	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	
	public PLP GotowatchesPLP() throws Throwable {
		
		
		Actions act = new Actions(driver);
		
		
		act.moveToElement(lnk_WatchesandSmart).build().perform();
		act.moveToElement(lnk_GUYS_WATCHES).build().perform();
		
		TestUtil.clickElementByJS(lnk_GUYS_WATCHES, driver);
		
		
		
		
		return new PLP();
		
		
		
		
		
		
	}
	
	
	
	public void GotoCartPage() {
		
          TestUtil.clickElementByJS(lnk_Cart, driver);
		
		
	}
	
	
	
	
}

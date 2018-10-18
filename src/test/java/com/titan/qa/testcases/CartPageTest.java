package com.titan.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.titan.qa.base.TestBase;
import com.titan.qa.pages.Cart;
import com.titan.qa.pages.HomePage;
import com.titan.qa.pages.LoginPage;
import com.titan.qa.pages.PLP;
import com.titan.qa.util.TestUtil;

public class CartPageTest extends TestBase{

	
	

	LoginPage loginpage;
	HomePage homepage;
	PLP plp;
	Cart cart;
	
	
	
	public CartPageTest(){
		super();
	}
	
	
	
	
	@BeforeMethod
	public void setUp(){
		
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		plp = new PLP();
		cart = new Cart();
		
	}
	
	
	@Test(priority=1)
	public void CartpageTitleTest() throws Throwable {
		
		TestUtil.Thread_Sleep();
		homepage.GotowatchesPLP();
        TestUtil.Thread_Sleep();
		TestUtil.scrolldownslowly();
		TestUtil.scrollupslowly();
		plp.ClickQuickViewofAvailableProductinPLP();
		TestUtil.Thread_Sleep();
		homepage.GotoCartPage();
		String title = cart.verifyCartPageTitle();
		Assert.assertEquals(title, "Shopping Bag - Fastrack");
		
	}
	
	
	@Test(priority=2)
	public void AddaproducttocartTest() throws Throwable{
		
		
		homepage.clickonloginlink();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
		TestUtil.Thread_Sleep();
		homepage.GotowatchesPLP();
		TestUtil.Thread_Sleep();
		
		TestUtil.scrolldownslowly();
		TestUtil.scrollupslowly();
		
		plp.ClickQuickViewofAvailableProductinPLP();
		TestUtil.Thread_Sleep();
		homepage.GotoCartPage();
		TestUtil.Thread_Sleep();
		cart.ClickonProceedtochkt();
		
		
		
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}

	
	
	
	
	
	

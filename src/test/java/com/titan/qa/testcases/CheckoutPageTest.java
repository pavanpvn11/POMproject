package com.titan.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.titan.qa.base.TestBase;
import com.titan.qa.pages.Cart;
import com.titan.qa.pages.Checkout;
import com.titan.qa.pages.HomePage;
import com.titan.qa.pages.LoginPage;
import com.titan.qa.pages.PLP;
import com.titan.qa.util.TestUtil;

public class CheckoutPageTest extends TestBase{



	LoginPage loginpage;
	HomePage homepage;
	PLP plp;
	Cart cart;
	Checkout checkout;
	
	
	public CheckoutPageTest(){
		super();
	}
	
	
	
	
	@BeforeMethod
	public void setUp(){
		
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		plp = new PLP();
		cart = new Cart();
		checkout = new Checkout();
		
	}
	
	
	@Test(priority=1)
	public void CheckouttpageTitleTest() throws Throwable {
		
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
		TestUtil.Thread_Sleep();
		String title = checkout.VerifyCheckoutPageTitle();
		Assert.assertEquals(title, "Checkout");
		
	}
	
	
	@Test(priority=2)
	public void CheckoutPageCODTest(String Title, String FirstName, String LastName, String Date , String Month, String Year, String Password, String email,String phoneno) throws Throwable{
		
		
		homepage.clickonloginlink();
	     
        TestUtil.writingdataintoexcel(1, 7, TestUtil.email = TestUtil.GenerateRandomEmailid());
	     
	     TestUtil.writingdataintoexcel(1, 8, TestUtil.phone = TestUtil.GenerateRandomPhoneno());
	     		     
	     loginpage.NewUserReg(Title, FirstName, LastName, Date, Month, Year, Password,email,phoneno);
	     
	     TestUtil.Thread_Sleep();
	     
	     String title = homepage.verifyHomePageTitle();
		 Assert.assertEquals(title, "Shop Fashion Accessories For Men, Women & Kids - Fastrack");
		 
		//homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
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
		TestUtil.Thread_Sleep();
		checkout.GoToCODOption();
		
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}

	
	
	
	
	
	

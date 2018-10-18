package com.titan.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.titan.qa.base.TestBase;
import com.titan.qa.pages.HomePage;
import com.titan.qa.pages.LoginPage;
import com.titan.qa.pages.PLP;

public class HomePageTest extends TestBase{

	
	LoginPage loginpage;
	HomePage homepage;
	PLP plp;
	
	
	public HomePageTest(){
		super();
	}
	
	
	
	
	@BeforeMethod
	public void setUp(){
		
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		plp = new PLP();
		
	}
	
	
	@Test(priority=1)
	public void homepageTitleTest(){
		
	
		String title = homepage.verifyHomePageTitle();
		Assert.assertEquals(title, "Shop Fashion Accessories For Men, Women & Kids - Fastrack");
		
	}
	
	
	@Test(priority=2)
	public void searchforwatchesTest() throws Throwable{
		
		
		homepage.clickonloginlink();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
		
	
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}

	
	

	
	
	
	
	
	


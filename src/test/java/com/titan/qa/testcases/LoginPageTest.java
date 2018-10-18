package com.titan.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.titan.qa.base.TestBase;
import com.titan.qa.pages.HomePage;
import com.titan.qa.pages.LoginPage;
import com.titan.qa.util.TestUtil;


public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
  
	
	String sheetName = "Registration";
	
	
	public LoginPageTest(){
		super();
	}
	
	
	
	
	@BeforeMethod
	public void setUp(){
		
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		
		
		homepage.clickonloginlink();
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "My Account - Login or Signup - Fastrac");
	}
	
	
	@Test(priority=2)
	public void loginTest() throws Throwable{
		
		
		homepage.clickonloginlink();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password");
		TestUtil.Thread_Sleep();
	        String title = homepage.verifyHomePageTitle();
		Assert.assertEquals(title, "Shop Fashion Accessories For Men, Women & Kids - Fastrack");
		
		
	}
	
	
	@DataProvider
	public Object[][] getTitanTestData() throws Throwable{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	
	
	@Test(priority=3, dataProvider="getTitanTestData")
	public void UserRegistration(String Title, String FirstName, String LastName, String Date , String Month, String Year, String Password, String email,String phoneno) throws Throwable{
			
		
		     homepage.clickonloginlink();
		     
             TestUtil.writingdataintoexcel(1, 7, TestUtil.email = TestUtil.GenerateRandomEmailid());
		     
		     TestUtil.writingdataintoexcel(1, 8, TestUtil.phone = TestUtil.GenerateRandomPhoneno());
		     		     
		     loginpage.NewUserReg(Title, FirstName, LastName, Date, Month, Year, Password,email,phoneno);
		     
		     TestUtil.Thread_Sleep();
		     
		     String title = homepage.verifyHomePageTitle();
			 Assert.assertEquals(title, "Shop Fashion Accessories For Men, Women & Kids - Fastrack");
		     

			
		}
		

			
		
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}

	
	

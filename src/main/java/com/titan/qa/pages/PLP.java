package com.titan.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.titan.qa.base.TestBase;
import com.titan.qa.util.TestUtil;

public class PLP extends TestBase{

	
	
	    public String verifySLPTitle(){
			return driver.getTitle();
		}   
	        
	        
	        
	        public Cart ClickQuickViewofAvailableProductinPLP() throws InterruptedException {
	        	
	        	
	        	
	        	
	        	try{

                    JavascriptExecutor js = (JavascriptExecutor) driver;

                    List<WebElement> lnk_quickView = driver.findElements(By.xpath("//*[@class='btn-link']"));

                    WebElement btn_addToCart;

                    WebElement btn_close;

                    for(WebElement ele : lnk_quickView)

                    {

                           js.executeScript("arguments[0].click()", ele);

                           try

                           {

                                  Thread.sleep(5000);

                               btn_addToCart = driver.findElement(By.xpath("//button[contains(.,'Add to cart')]"));
                               
                               TestUtil.scrollIntoView(btn_addToCart, driver);

                               js.executeScript("arguments[0].click()", btn_addToCart);

                               Thread.sleep(5000);

                               break;

                           }

                           catch(Exception e)

                           {

                                  btn_close = driver.findElement(By.xpath("//a[@class='close']"));

                                  js.executeScript("arguments[0].click()", btn_close);

                           }

                          

                    }

                   

                   

             }

             catch(Exception e) {

                    System.out.println(e);

                    }
				return new Cart();

      }
	        	
	        	
}	        	
	        	
	        	
	        	
	        	
	        	
/*
                try{

                     //  System.out.println("Inside Try 1");

                       int i=1;

                       Actions act = new Actions(driver);

                       while(i<=24)

                       {

                    	
                    	   
                              String oldProductString = "((//*[@class='product-wrapper'])[ProductNum]//*[@class='oos-text ng-scope'])[1]";
                              

                              String oldImgString = "((//*[@class='product-wrapper'])[ImageNum]//*[@class='nav-link ng-binding'])[1]";

                              String quickViewString = "(//*[@class='col-xs-12 no-padding hidden-xs view-after-hover ng-scope']//*[@class='btn-link quick-view-link'])[QuickViewNum]";

                              String dup = Integer.toString(i);

                              String newProductString = oldProductString.replace("ProductNum", dup);

                              String newImgString = oldImgString.replace("ImageNum", dup);

                              String newQuickViewString = quickViewString.replace("QuickViewNum", dup);

                             

                              try

                              {

                                    // System.out.println("Inside Try 2");

                                  WebElement product = driver.findElement(By.xpath(newProductString));

                                  if(product.isDisplayed())

                                  {

                                     i=i+1;

                                  }

                              }

                              catch(Exception e)

                              {

                                   //  System.out.println("Inside catch 1");

                                     WebElement image = driver.findElement(By.xpath(newImgString));

                                     WebElement quickView = driver.findElement(By.xpath(newQuickViewString));

                              act.moveToElement(image).build().perform();

                              JavascriptExecutor js = (JavascriptExecutor) driver;
                              
                              TestUtil.scrollIntoView(image, driver);
                              
                              TestUtil.scrollIntoView(quickView, driver);

                              js.executeScript("arguments[0].click();", quickView);

                              Thread.sleep(3000);

                             

                              String closeString = "//*[@id='quick-view-content']//*[@class='close']";

                                  WebElement close = driver.findElement(By.xpath(closeString));

                              try

                              {

                                     //System.out.println("Inside Try 3");

                                  String addToCartString = "//*[@class='call-to-action btn btn-default ng-binding ng-scope']";

                                         WebElement addToCart = driver.findElement(By.xpath(addToCartString));

                                         if(addToCart.isDisplayed())

                                         {
                                               
                                                js.executeScript("arguments[0].click();", addToCart);

                                            // Report.updateTestLog(Action, "Product which is available is clicked sucessfully", Status.PASS);

                                          break;

                                         }

                              }

                              catch(Exception e1)

                              {

                                     //System.out.println("Inside catch 2");

                                     js.executeScript("arguments[0].click();", close);

                                     i=i+1;

                              }

                              }

                       }

                       Thread.sleep(3000);

                }

                catch(Exception e) {

                     //  System.out.println("Inside catch 3");

                       System.out.println(e);

                       }
				return new Cart();

         }
	        
	        
	        
	        
	  
	        
	        
         
}*/
	

package com.titan.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.titan.qa.base.TestBase;

public class TestUtil extends TestBase{


	public static long PAGE_LOAD_TIMEOUT = 20;
	
	public static long IMPLICIT_WAIT = 20;
	
   public static String email,phone;


	
	
	
	public static void Thread_Sleep() throws Throwable {
		
		Thread.sleep(3000);
		
	}

	
	

	
    public static String GenerateRandomEmailid() throws Throwable {
    	
    	Random ran = new Random();
    	
    	String emid = ("titanauto" + ran.nextInt(100000) +"@yopmail.com");
    	
    System.out.println(emid);
        	
		return emid;
    }
    
    
		  public static String GenerateRandomPhoneno() throws Throwable {
		    	
		    	Random ran = new Random();
		    	
		    	String phn = ("5" + ran.nextInt(1000000000) );	
		    	
		    System.out.println(phn);
		    	
				return phn;	
	  	
    	
    }
	
    public static void drawBorder(WebElement element, WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].style.border='3px solid red'", element);
    }
    
    
    public static void clickElementByJS(WebElement element, WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].click();", element);
    	
    }
    
    
    public static void scrollIntoView(WebElement element, WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    
    
    public static void scrolldown(WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	 js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
   
    }
    
    
    public static void scrollup(WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("window.scrollBy(0,-1000)");
    }
    
    public static void scrolldownslowly() throws Throwable {
    
    JavascriptExecutor js =((JavascriptExecutor)driver);
    for(int sl=0;;sl++)
      {
          if(sl>=5)
          {
              break;
          }
          js.executeScript("window.scrollBy(0,2000)","");
          Thread.sleep(1000);
      }
    }

    public static void scrollupslowly() throws Throwable {
        
        JavascriptExecutor js =((JavascriptExecutor)driver);
        for(int sl=0;;sl++)
          {
              if(sl>=5)
              {
                  break;
              }
              js.executeScript("window.scrollBy(0,-2000)","");
              Thread.sleep(1000);
          }
    
    
    

    }
    
       
     
 
   	public static void takeScreenshotAtEndOfTest() throws IOException {
   		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
   		String currentDir = System.getProperty("user.dir");
   		
   		FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/" + "_Fail_" +System.currentTimeMillis() + ".png"));
   		
   		}
	
   	
   	
    public static String TESTDATA_SHEET_PATH = "C://Fifa 18//Eclipse//Photon Eclipse workspace//TitanAutomation//src//main//java//com//titan//qa//testdata//Titan Automation Data.xlsx";

    

   static Workbook book;

   static Sheet sheet;

   static JavascriptExecutor js;

   

    public static Object[][] getTestData(String sheetName) throws Throwable {

           FileInputStream file = null;

           try {

                 file = new FileInputStream(TESTDATA_SHEET_PATH);

           } catch (FileNotFoundException e) {

                 e.printStackTrace();

           }

           try {

                 book = WorkbookFactory.create(file);

           } catch (IOException e) {

                 e.printStackTrace();

           }

                 

           sheet = book.getSheet(sheetName);
           
                
           //Reading from excel file
            
           Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

           // System.out.println(sheet.getLastRowNum() + "--------" +

           // sheet.getRow(0).getLastCellNum());
              
           
           for (int i = 0; i < sheet.getLastRowNum(); i++) {

                 for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                	 
                	   
                     data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                     
                        // System.out.println(data[i][k]);

                 }

           }
          
           return data;
       
    }



    
  public static void writingdataintoexcel(int rowno, int colno, String value) throws Throwable {
    	  
    
           // Cell cell = null;
            
	        FileInputStream file = new FileInputStream(TESTDATA_SHEET_PATH);
        	
            
            Row row = sheet.getRow(rowno);
            
           Cell cell = row.createCell(colno);
           
           cell.setCellValue(value);
            
           
         

            FileOutputStream outFile =new FileOutputStream(TESTDATA_SHEET_PATH);
            book.write(outFile);
            outFile.close();
            file.close();
              
		
  }




}
    
    
    
    
    
 
    
    
    
    
    
   
    
    

    
    
    
    

   

   

   

   


   	
	
	
	

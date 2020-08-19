package com.stackroute.automation.testng.aug12;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Aug12POI {
  
	  private File datasheets;
	  private FileInputStream fis;
	  private XSSFWorkbook xssf;
	  private Sheet sheets;
	  private Row rowdata;
	  private Cell col1,col2,col3;
	  private WebDriver driver;
	  private String chromepath;
	  private String Fileloc;

	@Test
	public void DataTest01() throws InterruptedException, IOException, AWTException {
			
		   chromepath = System.getProperty("user.dir") + "/lib/chromedriver.exe";
		   System.setProperty("webdriver.chrome.driver", chromepath);
		  
		   driver = new ChromeDriver();
		   driver.get("https://opensource-demo.orangehrmlive.com/");
		   Fileloc = System.getProperty("user.dir")+ "/testdata/newuserdata.xlsx";

		   datasheets = new File(Fileloc);
		   fis = new FileInputStream(datasheets);
		   
		   xssf = new XSSFWorkbook(fis);
		   sheets = xssf.getSheetAt(0);
		   
		   int rowcount = sheets.getLastRowNum();
		   
		    for(int rowno =1; rowno <=rowcount; rowno++) {
		    rowdata = sheets.getRow(rowno);
		    col1 = rowdata.getCell(0);
		    col2 = rowdata.getCell(1);
		   
		    String username = col1.getStringCellValue();
		    String password = col2.getStringCellValue();
		    
		    System.out.println(username +"   " +password);
		    
		    driver.findElement(By.id("txtUsername")).sendKeys(username);
		    driver.findElement(By.id("txtPassword")).sendKeys(password);
		    driver.findElement(By.id("btnLogin")).click();
		    

		    if(driver.getPageSource().contains("Invalid credentials")) {
		        col3 =rowdata.createCell(2);
		        col3.setCellValue("Fail");
		    }else {
		      try {
		        col3 =rowdata.createCell(2);
		        col3.setCellValue("Pass");
		        Thread.sleep(5000);
		        driver.findElement(By.linkText("Welcome Admin")).click();
		        Thread.sleep(5000);
		        driver.findElement(By.linkText("Logout")).click();
		      }catch(Exception e) {
		        System.out.println("testtttt");
		      }
		    }   
		    
		    }
		    FileOutputStream fos=new FileOutputStream(Fileloc);
		    xssf.write(fos);
		    fos.close();
		  
		    System.out.println("Excel File Written.");
		    driver.close();
		    
		   }
		  
			
		   
}

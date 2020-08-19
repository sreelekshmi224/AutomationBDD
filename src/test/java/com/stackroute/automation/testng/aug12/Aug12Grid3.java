package com.stackroute.automation.testng.aug12;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Aug12Grid3 {
  
	// static ChromeDriver driver;
	static WebDriver driver;
	static String chromepath;

	@Test
	public void fileUploadTest01() throws InterruptedException, IOException, AWTException {
		chromepath = System.getProperty("user.dir") + "/lib/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromepath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
			
		driver.get("https://opensource-demo.orangehrmlive.com");
		

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('txtUsername').value='Admin'");
		js.executeScript("document.getElementById('txtPassword').value='admin123'");
   	    js.executeScript("arguments[0].click();",driver.findElement(By.id("btnLogin")));
		js.executeScript("arguments[0].click();",driver.findElement(By.linkText("Welcome Admin")));
		
		js.executeScript("setTimeout(function(){}, 3000)");
		
		js.executeScript("arguments[0].click();",driver.findElement(By.linkText("Logout")));
		
			
				
		/*JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("alert('hello world');");  //Generate Alert Pop Window
		
		String sText =  js.executeScript("return document.getElementById(\"logInPanelHeading\").innerText;").toString(); //Innertext of webpage
		System.out.println(sText);
		
		sText =  js.executeScript("return document.title;").toString(); //Title of webpage
		System.out.println(sText);
		*/
		
		
	}
	
  
  
}

package com.stackroute.automation.testng;

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

public class Aug11TestNG01 {
  
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

		driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("admin123");
		driver.findElement(By.cssSelector("#btnLogin")).click();
		driver.findElement(By.cssSelector("#menu_pim_viewPimModule")).click();
		driver.findElement(By.cssSelector("#btnAdd")).click();
		Thread.sleep(10000);
		//driver.findElement(By.id("photofile")).click();
		
		System.out.println("test");
		String filename = "C:\\Users\\Admin\\Pictures\\AjiMathday.jpg";
		StringSelection stringSelection = new StringSelection(filename);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		
	}
	
	@AfterMethod
	public void postTest(ITestResult itr) throws IOException {
		
		if(!itr.isSuccess()) {
			String failedimage = System.getProperty("user.dir")+"/screenshots/"+itr.getMethod().getMethodName()+System.currentTimeMillis()+".png";
			File failedscr = new File(failedimage);
			File newImage = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(newImage, failedscr);
			
		}else {
			System.out.println("Test Execution Successful and hence screenshot not captured");
			Reporter.log("Test Execution Successful and hence screenshot not captured");
		}
		
		
	}

	
  
  
}

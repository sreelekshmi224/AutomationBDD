package com.stackroute.automation.testng;

import static org.junit.Assert.assertTrue;

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

public class Aug11TestNG2 {
  
	// static ChromeDriver driver;
	static WebDriver driver;
	static String chromepath;

	@Test
	public void paytmTest01() throws InterruptedException, IOException {
		chromepath = System.getProperty("user.dir") + "/lib/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromepath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
			
			driver.get("https://paytm.com");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("_3ac-")));
		driver.findElement(By.className("_3ac-")).click();

		/*
		driver.switchTo().frame(0);

		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@id=\"main-container\"]/div/div/div/div/div[1]/div/div/div[3]/div[2]/a[1]/span")));
		driver.findElement(
				By.xpath("//*[@id=\"main-container\"]/div/div/div/div/div[1]/div/div/div[3]/div[2]/a[1]/span")).click();

		assertTrue(false);
		*/
		assertTrue(true);
		
		driver.close();

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

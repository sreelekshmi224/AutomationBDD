package com.stackroute.automation;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Aug10demos{
	
	//static ChromeDriver driver;
	static WebDriver driver;
	static String chromepath;
	
	@BeforeClass
	public static void init() {
		chromepath = System.getProperty("user.dir")+"/lib/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromepath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public static void close() {
		driver.quit();
	}
	
	
	@Test
	public void alertTest() throws InterruptedException, IOException {
		driver.navigate().to("https://javascript.info/alert-prompt-confirm");
		//driver.findElement(By.xpath("//a[@title='run']")).click();
		//Alert alert = driver.switchTo().alert();
		//Thread.sleep(3000);
		//alert.accept();
		//Thread.sleep(3000);
	
		driver.findElement(By.xpath("//div[7]/div/div/div/a[@title='run']")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.dismiss();
		Thread.sleep(3000);
		
		
	}

	
	
	
	
	
}

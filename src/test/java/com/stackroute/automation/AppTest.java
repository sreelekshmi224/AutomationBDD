package com.stackroute.automation;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest{
	
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
		//driver.close();
		driver.quit();
		
		
	}
	
	
	@Test
	public void google01Test() throws InterruptedException, IOException {
		driver.navigate().to("https://www.google.com/");
		driver.findElement(By.linkText("Images")).click();
		//Thread.sleep(3000);
		driver.findElement(By.className("gLFyf")).sendKeys("Selenium");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"sbtc\"]/button/div/span")).click();
		//Thread.sleep(3000);
		
		File searchscreen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String imagepath = System.getProperty("user.dir")+"/screenshots/image.png";
		FileUtils.copyFile(searchscreen, new File(imagepath));
		
		WebElement testingimage = driver.findElement(By.xpath("//*[@id=\"i6\"]/div[1]/span/span/div[2]/a/img"));
		
		File searchscreen1 = testingimage.getScreenshotAs(OutputType.FILE);
		String imagepath1 = System.getProperty("user.dir")+"/screenshots/image1.png";
		FileUtils.copyFile(searchscreen1, new File(imagepath1));
		
		
		/*
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		*/
		
		
	}

	
	
	
	
	
}

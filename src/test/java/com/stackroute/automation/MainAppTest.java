package com.stackroute.automation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainAppTest{
	
	//static ChromeDriver driver;
	static WebDriver driver;
	static String chromepath;
	
	@BeforeClass
	public static void init() {
		chromepath = System.getProperty("user.dir")+"/lib/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromepath);
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		
		driver.manage().window().fullscreen();
		
	}
	
	@AfterClass
	public static void close() {
		driver.close();
		
	}
	
	
	@Test
	public void mvn01Test() {
		driver.get("https://mvnrepository.com/");
		assertEquals("Home page not displayed ===> ","Maven Repository: Search/Browse/Explore",driver.getTitle());
	}
	
	@Test
	public void mvn02Test() {
		WebElement searchField = driver.findElement(By.id("query"));
		searchField.sendKeys("selenium server");
		WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"search\"]/form/input[2]"));
		searchButton.click();
		assertTrue("Search Result displayed incorrectly =>",driver.getPageSource().contains("Found"));
		
	}
	
	
	
	@Test
	public void mvn03Test() {
		WebElement selserverlink = driver.findElement(By.xpath("//a[text()=\"selenium-server\"][1]"));
		selserverlink.click();
		String expected = "https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-server";
		String actuals = driver.getCurrentUrl();
		assertEquals("Correct Page for Dependency not displayed",expected, actuals);
		
	}
	
	
	
	
}

package com.stackroute.automation;


import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Aug10demos2{
	
	//static ChromeDriver driver;
	static WebDriver driver;
	static String chromepath;
	
	@BeforeClass
	public static void init() {
		chromepath = System.getProperty("user.dir")+"/lib/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromepath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@AfterClass
	public static void close() {
		driver.quit();
	}
	
	@Test
	@Ignore
	public void webElementTest01() throws InterruptedException, IOException {
		driver.get("https://opensource-demo.orangehrmlive.com");
		
		
		
		List<WebElement> inputs = driver.findElements(By.tagName("input"));
		
		for(WebElement input : inputs) {
			System.out.println("Type : "+ input.getAttribute("type"));
		}
				
	}

	@Test
	public void webElementTest02() throws InterruptedException, IOException {
		driver.get("https://opensource-demo.orangehrmlive.com");

		WebElement uname = driver.findElement(By.id("txtUsername"));
		WebElement pwd = driver.findElement(By.id("txtPassword"));
		WebElement login = driver.findElement(By.id("btnLogin"));
		
		
		uname.sendKeys("iniyal");
		uname.clear();
		uname.sendKeys("Admin");
		if(pwd.getAttribute("autocomplete").equals("off")) {
			pwd.sendKeys("admin123");
		}
		
		login.submit();
		
		
		
		WebElement welcomemsg = driver.findElement(By.partialLinkText("Welcome"));
		
		assertTrue(welcomemsg.getText().equals("Welcome Admin"));
		
		assertTrue(welcomemsg.isDisplayed());
		welcomemsg.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Logout")));
		
		WebElement logout = driver.findElement(By.linkText("Logout"));
		System.out.println("Logout link is displayed : "+ logout.isDisplayed());
		
		logout.click();
		
		
	
		
	}

	

	@Test
	@Ignore
	public void webElementTest03() throws InterruptedException, IOException {
		driver.get("https://www.ebay.com");

		WebElement searchfield = driver.findElement(By.id("gh-ac"));
		WebElement categories = driver.findElement(By.id("gh-cat"));
		WebElement searchbutton = driver.findElement(By.id("gh-btn"));
		Select categorieslist = new Select(categories);

		
		List<WebElement> opt = categories.findElements(By.tagName("option"));
		System.out.println(opt.get(0).getText());
		System.out.println(opt.get(1).getText());
		
		
		List<WebElement> options = categorieslist.getOptions();
		
		for(WebElement cat: options) {
			//System.out.println(cat.getText());
		}
		
		searchfield.sendKeys("we the living");
		
		//categorieslist.selectByIndex(4);
		categorieslist.selectByVisibleText("Books");
		//categorieslist.selectByValue("267");
		
		searchbutton.click();
		
		
		
		
		
		
	}
		
	
}



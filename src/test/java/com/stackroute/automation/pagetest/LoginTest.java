package com.stackroute.automation.pagetest;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stackroute.automation.pageobjects.HomePage;
import com.stackroute.automation.pageobjects.LoginPage;

public class LoginTest {
 
	static WebDriver driver;
	static String chromepath;
	String expected="";
	String actuals="";
	LoginPage lpage=null;
	

			
	@BeforeClass
	public void init() {
		chromepath = System.getProperty("user.dir") + "/lib/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromepath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com");
	}
	
	
	@Test
	public void invalidloginTest(){

		lpage = new LoginPage(driver);
	    lpage = PageFactory.initElements(driver, LoginPage.class);
		lpage.invalidLogin("Admin", "admin");

		expected = "Invalid credentials";
		assertEquals(expected,lpage.invalidCredentials());
		
		
		
	}

	@Test
	public void validloginTest(){

		lpage = new LoginPage(driver);
		lpage = PageFactory.initElements(driver, LoginPage.class);
		
		HomePage hmpage = lpage.validLogin("Admin", "admin123");
		hmpage = PageFactory.initElements(driver, HomePage.class);
	    
		expected="Welcome Admin";
		actuals = hmpage.welcomeMessage();
		assertEquals(expected,actuals);
		
	}
	
	
}

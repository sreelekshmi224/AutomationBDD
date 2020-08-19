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

public class HomePageTest {
 
	static WebDriver driver;
	static String chromepath;
	String expected="";
	String actuals="";
	HomePage hmpage=null;
	

			
	
	@Test
	public void logoutTest(){
		hmpage = new HomePage(driver);
	    hmpage = PageFactory.initElements(driver, HomePage.class);
		hmpage.clickLogout();
		LoginPage lpage = new LoginPage(driver);
		expected = "OrangeHRM";
		assertEquals(expected,lpage.getTitle());
	}
	
}

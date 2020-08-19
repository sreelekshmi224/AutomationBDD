package com.stackroute.automation.testng.aug12;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Aug12Grid1 {
  
	// static ChromeDriver driver;
	static WebDriver driver;
	static String chromepath;

	@Test
	public void fileUploadTest01() throws InterruptedException, IOException, AWTException {
	   chromepath = System.getProperty("user.dir") + "/lib/chromedriver.exe";
	   System.setProperty("webdriver.chrome.driver", chromepath);
	  
	   DesiredCapabilities browser = DesiredCapabilities.chrome();
	   browser.setBrowserName("chrome");
	  // browser.setPlatform(Platform.WIN10);
	   //browser.setVersion("84.0.4147.105");
	   
	   
	   driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),browser);
	   driver.get("http://google.com");
	   driver.manage().window().maximize();
	   Thread.sleep(15000);
	   driver.quit();		
		
	}
	
  
  
}

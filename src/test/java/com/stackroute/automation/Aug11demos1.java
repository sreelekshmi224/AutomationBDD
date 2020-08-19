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
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Aug11demos1 {

	// static ChromeDriver driver;
	static WebDriver driver;
	static String chromepath;

	@BeforeClass
	public static void init() {
		chromepath = System.getProperty("user.dir") + "/lib/chromedriver.exe";
		// ChromeOptions chromeoptions = new ChromeOptions();
		// chromeoptions.addArguments("--headless");
		// chromeoptions.addArguments("disable-infobars");
		// chromeoptions.addArguments("--window-size=600,600");

		System.setProperty("webdriver.chrome.driver", chromepath);
		// driver = new ChromeDriver(chromeoptions);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@AfterClass
	public static void close() {
		driver.quit();
	}

	@Test
	@Ignore
	public void paytmTest01() throws InterruptedException, IOException {
		driver.get("https://paytm.com");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("_3ac-")));
		driver.findElement(By.className("_3ac-")).click();

		driver.switchTo().frame(0);

		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@id=\"main-container\"]/div/div/div/div/div[1]/div/div/div[3]/div[2]/a[1]/span")));
		driver.findElement(
				By.xpath("//*[@id=\"main-container\"]/div/div/div/div/div[1]/div/div/div[3]/div[2]/a[1]/span")).click();

		Thread.sleep(5000);

	}

	@Test
	@Ignore
	public void windowTest02() throws InterruptedException, IOException {
		driver.get("https://opensource-demo.orangehrmlive.com");

		driver.findElement(By.partialLinkText("Orange")).click();
		Thread.sleep(4000);

		System.out.println(driver.getWindowHandle());

		int count = 0;
		for (String handle : driver.getWindowHandles()) {
			count++;
			if (count > 1) {
				driver.switchTo().window(handle);
				driver.findElement(By.linkText("Services")).click();

			}
		}
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.linkText("Download")).isDisplayed());
		Thread.sleep(3000);

	}

	@Test
	@Ignore
	public void windowTest03() throws InterruptedException, IOException {
		driver.get("https://opensource-demo.orangehrmlive.com");

		WebElement uname = driver.findElement(By.id("txtUsername"));

		Actions newaction = new Actions(driver);
		Thread.sleep(5000);
		newaction.moveToElement(uname).sendKeys("apple").keyDown(Keys.SHIFT).sendKeys("orange").keyUp(Keys.SHIFT)
				.doubleClick().build().perform();

		Thread.sleep(5000);

	}

	@Test
	public void windowTest04() throws InterruptedException, IOException {

		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement draggableobj = driver.findElement(By.id("draggable"));
		WebElement droppableobj = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(draggableobj, droppableobj).perform();
		Thread.sleep(5000);
		action.clickAndHold(draggableobj);
		action.moveByOffset(20,20);
		action.release(draggableobj);
		action.perform();
	}

}

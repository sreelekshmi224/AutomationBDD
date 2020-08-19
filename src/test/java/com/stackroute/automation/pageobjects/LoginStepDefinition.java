package com.stackroute.automation.pageobjects;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

// Step - Definition - This should have the implementation of the Scenarios mentioned in
// the Feature file
public class LoginStepDefinition {
	
	static WebDriver driver;
	static String chromepath;
	String expected="";
	String actuals="";
	
	
	@Given("the user in login page")
	public void the_user_in_login_page() {
	//	chromepath = System.getProperty("user.dir") + "/lib/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", "D:\\seleniumproject\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com");
	}

	@When("an invalid username is entered")
	public void an_invalid_username_is_entered() {
		driver.findElement(By.id("txtUsername")).sendKeys("apple");
	}

	@When("the password is entered")
	public void the_password_is_entered() {
		driver.findElement(By.id("txtPassword")).sendKeys("apple");
	}

	@When("the login button is clicked")
	public void the_login_button_is_clicked() {
		driver.findElement(By.id("btnLogin")).click();
	}

	@Then("Invalid credentials message should be displayed")
	public void invalid_credentials_message_should_be_displayed() {
	   WebElement errormsg = driver.findElement(By.id("spanMessage"));
	   assertEquals(errormsg.getText(),"Invalid credentials");
	}

	@Given("the user already in login page")
	public void the_user_already_in_login_page() {
		driver.findElement(By.id("txtUsername")).clear();
	}

	
	@When("n valid username is entered")
	public void n_valid_username_is_entered() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");	}

	@When("the password is left blank")
	public void the_password_is_left_blank() {
		driver.findElement(By.id("txtUsername")).sendKeys("");
	}

	@Then("Missing credentials message should be displayed")
	public void Missing_credentials_message_should_be_displayed() {
		   WebElement errormsg = driver.findElement(By.id("spanMessage"));
		   assertEquals(errormsg.getText(),"Password cannot be empty");
		   closebrowser();
	}

	public void closebrowser() {
		driver.quit();
	}
}

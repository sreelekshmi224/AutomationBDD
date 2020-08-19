package com.stackroute.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.stackroute.automation.pageobjects.LoginPage;

public class HomePage {

	static WebDriver driver;
	
	private WebElement welcome;
	
	@FindBy(linkText="Logout")
	private WebElement logout;
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
    public String welcomeMessage() {
    	return driver.findElement(By.id("welcome")).getText();
    }
    
    public void clickwelcome() {
    	welcome.click();
    }
    
    public LoginPage clickLogout() {
    	logout.click();
    	LoginPage lpage = new LoginPage(driver);
    	return lpage;
    }
    
}

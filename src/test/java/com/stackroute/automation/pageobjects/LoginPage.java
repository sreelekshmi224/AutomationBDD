package com.stackroute.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LoginPage{

//	@FindBy(id="txtUsername")
	private WebElement txtUsername;
	//@FindBy(id="txtPassword")
	private WebElement txtPassword;
//	@FindBy(id="btnLogin")
	private WebElement btnLogin;

	static WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}


	public void enterusername(String text) {
        txtUsername.sendKeys(text);
    }

    public void enterpassword(String text) {
        txtPassword.sendKeys(text);
    }

    public void clickLogin() {
        btnLogin.click();
    }
    
    public String invalidCredentials() {
    	return driver.findElement(By.id("spanMessage")).getText();
    }

    public String getTitle() {
    	return driver.getTitle();
    }

    public void invalidLogin(String username,String password) {
    	enterusername(username);
    	enterpassword(password);
    	clickLogin();
    }
    
    
    public HomePage validLogin(String username,String password) {
    	enterusername(username);
    	enterpassword(password);
    	clickLogin();
    	HomePage hmpage = new HomePage(driver);
    	return hmpage;
    }

    
}


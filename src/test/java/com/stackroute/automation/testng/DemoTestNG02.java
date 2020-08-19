package com.stackroute.automation.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DemoTestNG02 {
	
  @Test
  public void demo01Test() {
	  System.out.println("Inside Demo-01 test");
	  assertTrue(false);
  }
  

  @Test
  public void demo02Test() {
	  System.out.println("Inside Demo-02 test");
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Inside Before Method");
  }

  
  @AfterMethod
  public void afterMethod() {
	  System.out.println("Inside After method");
  }

  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Inside Before Class");
  }

  
  @AfterClass
  public void afterClass() {
	  System.out.println("Inside After class");
  }

  
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Inside BeforeTest");
  }

  
  @AfterTest
  public void afterTest() {
	  System.out.println("Inside Aftertest");
  }
  

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Inside BeforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Inside AfterSuite");
  }

}

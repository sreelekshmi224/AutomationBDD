package com.stackroute.automation.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DemoTestNG3 {
	
  @Test(groups= {"odd"})
  public void demo01Test() {
	  Reporter.log("Beginning of demo01Test");
	  System.out.println("Inside Demo-01 test");
	  assertTrue(false);
	  Reporter.log("End of test");
  }
  

  @Test(groups= {"even"},dependsOnGroups= {"odd"})
  public void demo02Test() {
	  Reporter.log("Beginning of demo02Test");
	  System.out.println("Inside Demo-02 test");
	  Reporter.log("End of test");
  }


  @Test(groups= {"odd"},dependsOnMethods= {"demo01Test"})
  public void demo03Test() {
	  Reporter.log("Beginning of demo03Test");
	  System.out.println("Inside Demo-03 test");
	  Reporter.log("End of test");
	  assertTrue(true);
  }
  
  

  @Test(groups= {"even"},dependsOnGroups= {"odd"})
  public void demo04Test() {
	  Reporter.log("Beginning of demo04Test");
	  System.out.println("Inside Demo-04 test");
	  Reporter.log("End of test");
  }
  
  
  
}

package com.stackroute.automation.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DemoTestNG5 {
	
  @Test(groups= {"odd"})
  @Parameters(value="username")
  public void demo01Test(String uname) {
	  System.out.println(uname);
	  Reporter.log("Beginning of demo01Test");
	  System.out.println("Inside Demo-01 test");
	  assertTrue(false);
	  Reporter.log("End of test");
  }
  

  @Test(groups= {"even"})
  public void demo02Test() {
	  Reporter.log("Beginning of demo02Test");
	  System.out.println("Inside Demo-02 test");
	  Reporter.log("End of test");
  }


  @Test(groups= {"odd"})
  public void demo03Test() {
	  Reporter.log("Beginning of demo03Test");
	  System.out.println("Inside Demo-03 test");
	  Reporter.log("End of test");
	  assertTrue(true);
  }
  
  

  @Test(groups= {"even"})
  public void demo04Test() {
	  Reporter.log("Beginning of demo04Test");
	  System.out.println("Inside Demo-04 test");
	  Reporter.log("End of test");
  }
  

  @DataProvider(name = "test1")
  public Object[][] createData1() {
   return new Object[][] {
     { "Kurinchi", new Integer(24) },
     { "Iniyal", new Integer(21)},
   };
  }
   
  //This test method declares that its data should be supplied by the Data Provider named "test1"
  @Test(dataProvider = "test1")
  public void verifyData1(String n1, Integer n2) {
   System.out.println(n1 + " " + n2);
  } 
  
  
  
}

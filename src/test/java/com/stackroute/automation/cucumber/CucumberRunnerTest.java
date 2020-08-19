package com.stackroute.automation.cucumber;


import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"/automation/src/test/java/com/stackroute/automation/cucumber/loginsteps.feature"},
		glue= {"/automation/src/test/java/com/stackroute/automation/pageobjects/LoginStepDefinition.java"},
		plugin= {"pretty","json: reports/login.json"}
		)
public class CucumberRunnerTest {
  
}

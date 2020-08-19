Feature: Login Functionalities

  Scenario: Login with invalid values 
    Given the user in login page
    When an invalid username is entered
    And the password is entered
    And the login button is clicked
    Then Invalid credentials message should be displayed
    
  Scenario: Login with missing details
    Given the user already in login page
    When n valid username is entered
    And the password is left blank
    And the login button is clicked
    Then Missing credentials message should be displayed
    
    

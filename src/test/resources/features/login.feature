Feature: Sign-In

  Background: 
  	Given User is in Sign-Page.
  	
    Scenario: Verify Sign-in link on Sign-In Page	
    When User clicks on Sign-in link on Sign-In Page.
    Then User Sign-In page should be dispalyed.

  Scenario: Verify register link in the top right of the Sign-In Page.
    When User clicks on "register" link in Sign-In Page.
    Then User should be redirected to register Page.

  Scenario: Verify register! link below username and password field of Sign-In Page.
    When User clicks on "register!" link in Sign-In Page.
    Then User should be redirected to register Page.


  @SiginExcelDataDriven
  Scenario: Verify Login with valid and invalid credentials from Excel.
    When User enters username,password and clicks on Login.
    Then Expected message in excel should be displayed.
    
  Scenario: verify Username and password fields visibility
    Then Username field should be visible and password field should be visible.
    
  Scenario: verify Login button is enabled when page loads
    Then the Login button should be enabled
    
  Scenario: verify Password field should be masked
    Then the password field should be masked
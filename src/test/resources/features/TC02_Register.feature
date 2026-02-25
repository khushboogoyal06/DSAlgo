@Register
Feature: To verify and validate  User  Register page
  
  Background:
   Given User is on "Home" page
   When the user click on "Get Started" button
 

 Scenario: Verify title of the page
   Then I verify the title of the page is "Numpy Ninja"
   
   
 Scenario: Verify presence of Register button
 Then the "Register" button should be visible and enabled

  Scenario: Verify presence of Login link/button
  When the user click on "register" button
  Then the "Login" link should be visible
  
  Scenario: Verify Error messages are displayed when all fields are empty during registration
  When The user clicks the "Register" button with all fields empty
  Then The error "Please fill out this field." shows under the Username box


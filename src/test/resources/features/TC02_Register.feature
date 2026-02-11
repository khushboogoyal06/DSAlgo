
@Register
Feature: To verify and validate  User  Register page

  Scenario: To verify Register page with Empty fields
    Given The user opens Register Page
    When User click Register with all empty field
    Then User verify the message at username on Register Page as "Please fill out this field."

  Scenario: To verify Register page with username only
    Given The user opens Register Page
    When User click Register with username as "Huntrix" only
    Then User verify the message at password on Register Page as "Please fill out this field."

  Scenario: To verify Register Page with username and password
    Given The user opens Register Page
    When User click Register with username as "Huntrix" and password as "Welcome@123" only
    Then User verify the message at confirmpassword on Register Page as "Please fill out this field."


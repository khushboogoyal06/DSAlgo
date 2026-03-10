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
    When the user click on "register" button
    When The user clicks the "Register" button with all fields empty
    Then The error "Please fill out this field." shows under the Username box

  Scenario Outline: Verify error messages are displayed for different sets of data
    When the user enters "<username>" in the Username field
    And the user enters "<password>" in the Password field
    And the user enters "<confirmPassword>" in the Confirm Password field
    And the user clicks on the "Register" button
    Then the appropriate message "<message>" should be displayed

    Examples:
      | username    | password       | confirmPassword | message                                                 |
      | sdet224     | huntrix2026    | huntrix2023     | password_mismatch: The two password fields didn’t match |
      | huntrix2023 |                | huntrix2023     | Please fill out this field                              |
      | sdet224     | huntrix2023    |                 | Please fill out this field                              |
      | sdet224     |                | huntrix2023     | Please fill out this field                              |
      | asxcvb      | greenHorn@2024 | greenHorn@2024  | New Account Created. You are logged in as asdfgh        |

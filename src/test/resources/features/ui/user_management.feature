@UI
Feature: User actions on the application

  @User_Register
  Scenario: Successful user registration
    Given user is on registration page
    When user is registered filling out the registration form with the following details
      | First Name | Last Name | Address | City | State | Zip Code | SSN  | Username  | Password     | Confirm      |
      | perf       | user      | town    | town | CA    | 2222     | 2222 | perf-user | perf-user123 | perf-user123 |
    Then webElement with message "Your account was created successfully. You are now logged in." is displayed

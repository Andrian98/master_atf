@UI
Feature: User registration and login functionality

  @Regression
  Scenario: Successful user registration
    Given user is on registration page
    When user populates form with the following details
      | First Name | Last Name | Address | City | State | Zip Code | SSN  | Username   | Password     | Confirm      |
      | perf       | user      | town    | town | CA    | 2222     | 2222 | perf-user1 | perf-user123 | perf-user123 |
    Then message "Your account was created successfully. You are now logged in." is displayed

  @Regression
  Scenario: User successfully logged in
    Given user is on main page
    When user enters valid credentials
    Then user is logged in
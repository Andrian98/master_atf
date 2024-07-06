Feature: User actions on the application

  @User_Register
  Scenario: Successful user registration
    Given user is on registration page
    When user fills out the registration form with the following details
      | First Name | Last Name | Address | City | State | Zip Code | SSN  | Username  | Password     | Confirm      |
      | perf       | user      | town    | town | CA    | 2222     | 2222 | perf-user | perf-user123 | perf-user123 |
    And user clicks register button
    Then user is successfully registered

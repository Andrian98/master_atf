Feature: User actions on the application
  @User_Register
  Scenario: User registration
    Given user is on registry page
    When user details are sent for registration
      | First Name | Last Name | Address | City | State | Zip Code | SSN  | Username  | Password     | Confirm      |
      | perf       | user      | town    | town | CA    | 2222     | 2222 | perf-user | perf-user123 | perf-user123 |
    And user click register button
    Then user is successfully registered


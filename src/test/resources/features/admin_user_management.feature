Feature: Admin actions on the applications

  Scenario: Admin create new user
    Given admin user logs in with the following credentials
      | username | password    |
      | admin    | AdminPass1! |
    When admin navigates to PIM Add employee page
    And admin insert employee details
    Then new employee is created

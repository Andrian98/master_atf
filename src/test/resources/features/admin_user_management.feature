Feature: Admin actions on the applications

  Scenario: Admin logs in
    Given admin is on home page
    When admin enter credentials
    And admin clicks login button
    Then admin is redirected to the dashboard

    Scenario: Admin create new user
      Given admin is logged in
      When admin clicks PIM button from side meniu
      And PIM board is diplayed
      And admin clicks ADD button
      And addEmployee page is displayed
      And admin insert employee full name
      And admin insert employee ID
      Then admin clicks Save button
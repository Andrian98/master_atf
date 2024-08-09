@UIII
Feature: User perform activities with accounts

  Background:
    Given user is on main page
    When user enters valid credentials
    And user is on open new account page
    When user selects account type and existing account
    And user clicks on open new account button
    Then new account is created

  Scenario: User validates all accounts
    Given user is on account overview page
    Then new accounts id are validated

    Scenario: User deletes new account
      Given user is on account overview page
      When user selects the new account
      And user delete the new account
      Then new account are successfully deleted


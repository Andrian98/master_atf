@UI2
Feature: User perform activities with accounts

  Background:
    Given user is logged in with valid credentials

  Scenario: User validates all accounts
    When user navigated to account overview page
    Then new accounts id are validated

    Scenario: User deletes new account
      And user is on account overview page
      When user selects the new account
      And user delete the new account
      Then new account are successfully deleted

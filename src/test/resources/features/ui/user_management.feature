@UI
Feature: User apply for loan and transfer funds
#TODO only GIVEN here with multiple actions, no WHEN
  Background:
    Given user is on main page
    When user enters valid credentials
#TODO AND instead of the GIVEN in the scenario
  Scenario: Successfully apply for a loan
    Given user is on request loan page
    When user applies for a loan with the following details
      | Loan Amount  | 10 |
      | Down Payment | 10 |
    Then new account number is provided

  Scenario: Transfer funds from one account to another
    Given user is on transfer funds page
    And user selected From account and To account
    When user enters valid amount to transfer
    Then transfer successfully completed

  Scenario: Open new account
    Given user is on open new account page
    When user selects account type and existing account
    And user clicks on open new account button
    Then new account is created

  #TODO to delete old evidence after a period of time
  #TODO annotation for negative/regression
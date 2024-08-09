@UI
Feature: User apply for loan and transfer funds

  Background:
    Given user is logged in with valid credentials

  @Regression
  Scenario: Successfully apply for a loan
    And user is on request loan page
    When user applies for a loan with the following details
      | Loan Amount  | 10 |
      | Down Payment | 10 |
    Then new account number is provided

  @Regression
  Scenario: Transfer funds from one account to another
    And user is on transfer funds page
    And user selected From account and To account
    When user enters valid amount to transfer
    Then transfer successfully completed

  @Regression
  Scenario: Open new account
    And user is on open new account page
    When user selects account type and existing account
    And user clicks on open new account button
    Then new account is created




  #TODO to delete old evidence after a period of time
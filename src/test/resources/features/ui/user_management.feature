@UI
Feature: User apply for loan and transfer funds
  Background:
        #TODO Given user is logged in

  Scenario: Successfully apply for a loan
    Given user is on request loan page
    When user applies for a loan with the following details
      | Loan Amount  | 10 |
      | Down Payment | 10 |
    Then new account number is provided

#TODO Make each scenario to be independent
  Scenario: Transfer funds from one account to another
    Given user is on transfer funds page
    And user selected From account and To account
    When user enters valid amount to transfer
    Then transfer successfully completed

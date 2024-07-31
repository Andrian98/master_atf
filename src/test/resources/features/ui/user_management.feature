@UI
Feature: User actions in the application

  @Loan_Apply
  Scenario: Successfully apply for a loan
    Given user is on request loan page
    When user applies for a loan with the following details
      | Loan Amount  | 100 |
      | Down Payment | 30  |
    Then new account number is provided

  @Failed_Transfer_Funds
  @Negative_Scenario
  Scenario: Transfer funds from one account to another
    Given user is on transfer funds page
    And user selected From account and To account
    When user enters invalid amount to transfer
    Then transfer fails with an error message corresponding to the invalid amount

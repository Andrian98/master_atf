Feature: Admin actions on the applications

  Scenario: Admin logs in
    Given I am an authorized user
    When I send a POST request to the login endpoint
      | username | password |
      | admin    | AdminPass1! |
    Then the response status code is 302

#    Scenario: Admin create new user
#      Given admin is logged in
#      When admin clicks PIM button from side meniu
#      And PIM board is diplayed
#      And admin clicks ADD button
#      And addEmployee page is displayed
#      And admin insert employee full name
#      And admin insert employee ID
#      Then admin clicks Save button
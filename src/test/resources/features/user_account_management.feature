Feature: User actions on the application

  Scenario: User logs in
    Given user is on Home page
    When user enters their credentials
    And user clicks Login button
    Then user is redirected to the dashboard

  Scenario: User creates a post
    Given user is logged in
    When user clicks Buzz meniu
    And user clicks on text input bar
    And user insert the text "My ATF is working"
    And user clicks Post button
    Then post is displayed on Buzz Newsfeed

  Scenario: User deletes a post
    Given user is on Buzz board
    When user clicks on three dots button
    And user clicks on Delete Post option
    And user clicks Yes,Delete button
    Then post is successfully deleted

  Scenario: User changes a password
    Given user is logged in
    When user clicks userdropdown meniu
    And user clicks Change Password button
    And update password page is displayed
    And user clicks on Current Password insert bar
    And user insert current password
    And user clicks on Password insert bar
    And user insert new password
    And user clicks on Confirm Password insert bar
    And user insert new password again
    And user clicks on Save button
    Then password is updated

  Scenario: User reverts to the old password
    Given user is logged in
    When user clicks userdropdown meniu
    And user clicks Change Password button
    And update password page is displayed
    And user clicks on Current Password insert bar
    And user insert current new password
    And user clicks on Password insert bar
    And user insert old password
    And user clicks on Confirm Password insert bar
    And user insert old password again
    And user clicks on Save button
    Then old password is restored

  Scenario: User logs out
    Given user is logged in
    When user clicks userdropdown meniu
    And user clicks Logout button
    Then user logged out

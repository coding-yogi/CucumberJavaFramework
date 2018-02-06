Feature: login
  This feature file contains all scenarios for login

  Background:
    Given a user is on login page

  Scenario: profile page should be displayed for successful login
    When he enters valid username and password
    | username                  | password  |
    | testuser01@mailinator.com | Password1 |
    And he clicks on signin
    Then he should see the profile page

  Scenario: error should be displayed after entering invalid credentials
    When he enters invalid username and password
      | username                  | password  |
      | testuser01@mailinator.com | Password2 |
    And he clicks on signin
    Then he should see an error "Email address / username and password do not match."

  Scenario: error should be displayed for blank username
    When he enters blank username and password
      | username  | password  |
      |           | Password1 |
    And he clicks on signin
    Then he should see an error "Please enter an email address or username."

  Scenario: error should be displayed for blank password
    When he enters valid username and blank password
      | username                  | password  |
      | testuser01@mailinator.com |           |
    And he clicks on signin
    Then he should see an error "Please enter your password."
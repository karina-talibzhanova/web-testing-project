Feature: login validation

  Background: Starting from login page
    Given I am on the login page

  Scenario: As a user, I want to be able to log in when I input a valid username and valid password
    When I input a valid username
    And I input a valid password
    And I click login
    Then I am taken to the inventory page

  Scenario: As a user, I want to attempt to log in when I input a invalid username and valid password
    When I input a valid username
    And I input a invalid password
    And I click login
    Then I am given an error message

  Scenario: As a user, I want to attempt to log in when I input a valid username and invalid password
    When I input a invalid username
    And I input a valid password
    And I click login
    Then I am given an error message

  Scenario: As a user, I want to attempt to log in when I input a invalid username and invalid password
    When I input a invalid username
    And I input a invalid password
    And I click login
    Then I am given an error message

  Scenario: As a user, I want to attempt to log in when I input an empty username and an empty password
    When I leave username input blank
    And I leave password input blank
    And I click login
    Then I am given an error message saying Username is required

  Scenario: As a user, I want to attempt to log in when I input a valid username and an empty password
    When I input a valid username
    And I leave password input blank
    And I click login
    Then I am given an error message saying Password is required

  Scenario: As a user, I want to attempt to log in when I input an empty username and a valid password
    When I leave username input blank
    And I input a valid password
    And I click login
    Then I am given an error message saying Username is required

#  Scenario: As a user, I want to log out of my log in session
#    Given I am logged in
#    When I click logout
#    Then I will be directed to the logout page

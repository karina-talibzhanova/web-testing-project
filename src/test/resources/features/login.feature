Feature: login validation

  Background: Starting from login page
    Given I am on the login page

  Scenario: As a user, I want to be able to log in when I input a valid username and valid password
    When I input a valid username
    And I input a valid password
    And I click login
    Then I am taken to the inventory page

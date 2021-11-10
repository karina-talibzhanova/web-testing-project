Feature: As a user, I want to view products
  Background: User is logged in
    Given I am logged in

  Scenario: Order products by name, ascending
    When I click on Name (A-Z)
    Then the products are listed in ascending order by name

  Scenario: Order products by name, descending
    When I click on Name (Z-A)
    Then the products are listed in descending order by name

  Scenario: Order products by price, ascending
    When I click on Price (low to high)
    Then the products are listed in ascending order by price

  Scenario: Order products by price, descending
    When I click on Price (high to low)
    Then the products are listed in descending order by price

  Scenario: Description exists for all products
    When I view the inventory page
    Then all products have a non-empty description

  Scenario: Correct image exists for all products
    When I view the inventory page
    Then all products have the correct image displayed
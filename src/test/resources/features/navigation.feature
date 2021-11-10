Feature:
  Background: I have logged in
    Given I am logged in

  Scenario: As a tester, I want to click on the "Reset state" link so that I can reset the state of the website for testing purposes
    When I click Reset App State
    Then The app state will reset to default

  Scenario: As a user, I want to click on the "About" link so that I can navigate to the company's page
    When I click the dropdown menu icon
    And I click About
    Then the company's page will load

  Scenario: As a user, I want to click on the side bar and see links to other pages so that I can easily navigate elsewhere
    When I click the dropdown menu icon
    Then I will see links to All Items, About, Logout and Reset App State

  Scenario: As a user, I want to click on the social media links and navigate to the correct social media page so that I can interact with the company further
    When I am at the bottom of the page
    And I click on the Twitter icon
    Then the companies Twitter page should load

    When I am at the bottom of the page
    And I click on the Facebook icon
    Then the companies Facebook page should load

    When I am at the bottom of the page
    And I click on the Linkedin icon
    Then the companies Linkedin page should load
Feature: Ability to buy products
  Background:
    Given I am logged in

  Scenario: As a user, when I add items to the cart, I can see how many items are in the cart badge
    When I click Add to Cart to for an item on the inventory page
    Then the cart badge shows the total items in the cart

#  Scenario: As a user, when I add items to thHe cart, I can see how many items are in the cart badge
#    When I click Add to Cart to for an item on the inventory page
#    Then the item is added to cart

  Scenario: As a user, I want to be able to add an item to cart from the product page
    And I am on a product page
    When I click Add to Cart for an item on the product page
    Then the item is added to cart

  Scenario: As a user, I want to be able to remove an item from cart
    And I have an item in cart
    And I am on the cart page
    When I click Remove
    Then the item is removed from the cart

  Scenario: As a user, I want to view products in the checkout overview
    And I have an item in cart
    And I am on the cart page
    When I checkout
    And I add information details
    Then the correct items will be shown in the checkout overview

  Scenario: As a user, I want to view product total in the checkout overview
    And I am on the cart page
    When I checkout
    And I add information details
    Then the correct total is shown in the checkout overview

  Scenario: As a user, when I add information detail in checkout, I continue to the checkout overview
    And I am on the cart page
    When I checkout
    And I add information details
    Then I am taken to the overview checkout page

    Scenario Outline: As a user, if I don't fill in all of the checkout details, I cannot continue to the checkout overview
      And I am on the cart page
      When I checkout
      And I don't add all information <details>
      Then I do not go to the overview checkout page
      And I see an appropriate error response
      Examples:
      | details |
      | " ,Last,Zip" |
      | "First, ,Zip"|
      | "First,Last, " |
      | " , , "         |

  Scenario: As a user, when I add items to the cart, I can see how many items are in the cart badge
    When I click Add to Cart to for an item on the inventory page
    Then the cart badge shows the total items in the cart

  Scenario: As a user, when I remove items from the cart, I can see how many items are in the cart badge
    When I click Remove for an item on the inventory page
    Then the cart badge shows the total items in the cart

  Scenario: As a user, I can click All Items anywhere on the site to go to inventory page
    And I click the sidebar
    When I click All Items
    Then I am taken to the inventory page

  Scenario: As a user, when I am on the product page, I can return to the inventory page
    And I am on a product page
    When I click Back to Products
    Then I am taken to the inventory page

  Scenario: As a user, when I on the checkout overview, I can Cancel checkout and return to the inventory page
    And I am on the cart page
    And I checkout
    And I add information details
    And I am on the checkout overview page
    When I click Cancel
    Then I am taken to the inventory page

  Scenario: As a user, when I on the cart page, I can click Continue Shopping and return to the inventory page
    And I am on the cart page
    When I click Continue Shopping
    Then I am taken to the inventory page

  Scenario Outline: As a user, when I click the item title, I am taken to the specific product page
    When I click the "<title>" of an item
    Then I am taken to the product page with "<title>"
    Examples:
      |  title |
    |      Sauce Labs Backpack  |
    |        Sauce Labs Bike Light          |
    |      Sauce Labs Bolt T-Shirt              |
    |      Sauce Labs Fleece Jacket          |
    |      Sauce Labs Onesie               |
    |     Test.allTheThings() T-Shirt (Red)      |

  Scenario: As a user, when I click the item image, I am taken to the specific product page
    When I click the image of an item
    Then I am taken to the product page

  Scenario: As a user, when I click on the cart badge, I am taken to the cart page
    When I click the cart badge
    Then I am taken to the cart page

Feature: Product Search Test
  As user I want to login into Software testing board website

  @smoke
  Scenario: user should add product successfully to shopping cart
    Given I am on home page
    When I navigate to men pants section
    And I mouse hover on product "Cronus Yoga Pant"
    And I select product size as "32"
    And I select product colour as "Black"
    And I click on add to cart button
    Then I should see the message "You added Cronus Yoga Pant to your shopping cart."
    When I click on shopping cart link
    Then I verify the text "Shopping Cart" in the shopping cart page
    And I verify the product name "Cronus Yoga Pant" in the shopping cart page
    And I verify the product size "32" and colour "Black" in the shopping cart page


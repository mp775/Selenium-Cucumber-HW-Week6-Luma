Feature: Product Search Test
  As user I want to login into Software testing board website

  @regression
  Scenario: user Should Add Product Success Fully To Shopping Cart
    Given I am on home page
    And I mouse hover on gear menu tab and navigate to bag section
    When I click on product name "Overnight Duffle"
    And I change the product quantity to "3"
    And I click on add to cart button
    Then I should see the message "You added Overnight Duffle to your shopping cart."
    When I click on shopping cart link
    Then I verify the product name "Overnight Duffle" in shopping cart page
    And  I verify the product quantity is "3"
    And  I verify the product price is "$135.00"
    When I change the product quantity to "5" in shopping cart page
    And I click on update shopping cart
    Then I verify the product price is updated to "$225.00"
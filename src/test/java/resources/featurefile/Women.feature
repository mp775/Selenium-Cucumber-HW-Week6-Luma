Feature: Product Search Test
  As user I want to login into Software testing board website

  @sanity
  Scenario:verify The Sort By Product Name Filter
    Given I am on home page
    When I navigate to women jacket section
    And I sort jacket by product name
    Then I verify that the product is displayed in alphabetical order

  @sanity
  Scenario: verify The Sort By Price Filter
    Given I am on home page
    When I navigate to women jacket section
    And I sort jacket by price
    Then I verify that the product is displayed by price in low to high order
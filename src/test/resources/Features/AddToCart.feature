Feature: Add to cart functionality

  Background:
    Given user navigates to product category page
@addToCart

  Scenario Outline: Add to cart by providing all fields
    When user clicks on Add To Cart button(Product category page)
    And selects a delivery date from delivery date field
    And enters quantity in quantity field <Quantity>


    And clicks on Add to cart button(Product display page)
    Then success message indicating product added should be displayed
  Examples:
    |Quantity|
  |        1|


  Scenario: Add to cart by providing all fields
    When user clicks on Add To Cart button(Product category page)
    And selects a delivery date from delivery date field
    And enters quantity in quantity field <Quantity>
    |Quantity|1|
    And clicks on Add to cart button(Product display page)
    Then success message indicating product added should be displayed


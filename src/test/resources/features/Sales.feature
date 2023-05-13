@Sales
Feature: Sales feature
  <description>

Scenario: Add Product to Cart
  Given User already on website sauce demo
  When User input "standard_user" as userName and input "secret_sauce" as password
  Then User already on sales page
  When User sort product list by "Price (low to high)"
  And User add 2 product to cart
  And User click icon cart

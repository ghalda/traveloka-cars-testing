@PlaceOrder
Feature: Place Order
  User want to order product in sauce demo

  Scenario Outline: Order Product
    Given User already on website sauce demo
    When User input "standard_user" as userName and input "secret_sauce" as password
    Then User already on sales page
    When  User sort product list by "Price (low to high)"
    And User add "<productName1>" and "<productName2>" to cart
    And User click icon cart
    Then User already on cart page
    When User remove product "<productName2>"
    And User click checkout button
    Then User already on Checkout Information Page
    When User input "Ghalda" as a firstName, input "Putri" as lastName and input "30129" as postCode
    And User click Continue Button
    Then User already on Checkout Overview
    When User click on Finish Button
    Then User already on Success Page
  Examples:
    | productName1      | productName2                      |
    | Sauce Labs Onesie | Test.allTheThings() T-Shirt (Red) |
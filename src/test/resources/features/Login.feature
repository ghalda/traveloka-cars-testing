@Login
  Feature: Login
    As a user I want to login website sauce demo

  Scenario: Normal Login
    Given User already on website sauce demo
    When User input "standard_user" as userName and input "secret_sauce" as password
    Then User already on sales page

  Scenario Outline: Invalid Login
    Given User already on website sauce demo
    When User input "<userName>" as userName and input "<userPassword>" as password
    Then User see error "<errorText>"
  Examples:
    | userName     | userPassword | errorText                                                                 |
    | standar_user |              | Epic sadface: Password is required                                        |
    |              | secret_sauce | Epic sadface: Username is required                                        |
    | ghalda       | 123          | Epic sadface: Username and password do not match any user in this service |
# Web Automation Testing - Traveloka - Cars Product

  - Automation Script using Gherkins Languages:
  
        Feature: Place Order Cars Product
          User want to order cars product in traveloka
          
          Scenario Outline: Order Cars Product
            Given User already on website traveloka
            When User click menu "Car Rental"
            And User select tab "Without Driver"
            And User select "Jakarta" as Pick-up Location
            And User select Today as Date Pick-up and 09 AM as Time Pick-up
            And User select Five days later as Date Drop-off and 11 AM as Time Drop-off
            And User click button Search Car
            Then User already on List Car Page
            When  User click car product
            Then User already on Rental Provider Page
            When User click rental provider
            Then User already on Car Product Detail
            When User click on radio button "Rental Office" as Pick-up Location
            And User click on radio button "Other Location" as Drop-off Location
            And User input additional notes
            And User click Continue Book Button
            Then User already on Rental Detail Page
            When User input "<fullName>" as Full Name in Contact Details
            And User input "<phoneNumber>" as Mobile Number in Contact Details
            And User input "<emailUser>" as Email in Contact Details
            And User select "Ms." as Title in Driver Details
            And User input "<fullName>" as Full Name in Driver Details
            And User input "<phoneNumber>" as Mobile Number in Driver Details
            And User click continue Rental Details Page
            And User input "<specialReq>" as Special Request
            And User checked all Rental Requirements
            And User click button continue to payment
            Then User already on Payment Page
            When User select Payment method Bank Transfer
            And User click button BNI Transfer as Destination Account
            And User click button Pay with Bank Transfer
            Then User already on Transfer Payment Instructions Page
          Examples:
            | fullName            | phoneNumber | emailUser              | specialReq  |
            | Ghalda Putri Balqis | 89653436534 | Gputribalqis@gmail.com | near in KFC |
#Author: maheshmuralikamath@gmail.com

@automated
Feature: This feature is to search and navigate to SecurePay using Google and enter details in Contact us form
  @automated
  Scenario Outline: Implement an automated test for SecurePay
    Given User has opened "https://www.google.com/" in browser
    And User searches "SecurePay" in Google
    And User navigates to "www.securepay.com.au" Link
    And Verify User is able to navigate to SecurePay "Contact us" Page
    Then Contact SecurePay form is updated

    Examples: 


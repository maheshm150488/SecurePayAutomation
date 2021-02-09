#Author: your.email@your.domain.com

@tag
Feature: This feature is to search and navigate to SecurePay using Google and enter details in Contact us form
  @tag2
  Scenario Outline: Implement an automated test for SecurePay
    Given User has opened "https://www.google.com/" in browser
    And User searches "SecurePay" in Google
    And User navigates to "www.securepay.com.au" Link
    And Verify User is able to navigate to SecurePay "Contact us" Page
    Then Contact SecurePay form is updated

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |

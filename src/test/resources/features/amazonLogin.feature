"@amazon
Feature: Amazon login functionality
  Scenario: user should be able to login

    Given user navigates to the Amazon webpage
    When user click on the sign in button
    And user provide correct username "fjonzokova@gmail.com" and password "Donogul@1957"
    Then verify user logged in successfully "Hello, Feruza"

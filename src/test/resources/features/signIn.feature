@smoke
Feature:User should be able to create account
  Scenario:User can create account
    Given user go to Amazon homepage
    And Click Sign in button
    And user send wrong credentials "WrongCredential"
    Then user should be able to see error message

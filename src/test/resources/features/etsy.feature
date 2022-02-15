@smoke
Feature: Etsy functionality
  Scenario: User should able to scroll down on Etsy webpage
  and able to click different window tabs and open them

    Given user navigates to Etsy.com webpage
    When user scrolls down element on the down of the webpage
    And user clicks each elements to open new window
    Then user should able to switch windows and get title of each elements




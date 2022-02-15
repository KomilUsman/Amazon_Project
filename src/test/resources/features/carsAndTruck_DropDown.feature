@carsAndTruck
Feature: testing find car and truck functionality
  Scenario:user should able to fill the form and find the cars

Given user on the cars and truck page
And on the filter section we need to fill the information
And click Find Vehicle button
Then verify page Title contains BMW


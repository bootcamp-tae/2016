@flightSearch
Feature: CheapTickets Flight Search

  Scenario: Perform a Flight Only search
    Given I am at CheapTickets home page
    And I click on Flights tab
    When I perform a flight search from "LAS" to "LAX" for 7 days from today and returning 7 days afterwards
    Then I should see a the departure flight results page


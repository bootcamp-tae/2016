@flightSearch
Feature: CheapTickets Flight Search

//Background

  Scenario: Perform a Flight Only search
    Given I am on the CheapTickets Home Page
    And I click on the Flights Tab
    When I perform a Flight Search with the argument "LAS" in origin and the argument "LAX" in destination for 7 days from today and returning 7 days afterwards
    Then I should see a results page with a button to continue






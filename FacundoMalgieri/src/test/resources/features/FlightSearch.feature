Feature: This is a test for doing a flight search on CheapTickets
  Scenario: FlightSearch
    Given Im on CheapTickets Home Page
    And   I click on Flights Tab
    When  I make a search from "LAS" to "LAX" Departure 7 days and Returning 7 days from today
    Then  I see the results page
    And   I select the 4 departure flight
    Then  I select the 3 returning flight
    And   I see the review page
    Then  I click the continue booking button
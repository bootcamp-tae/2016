@flightSearch
Feature: CheapTickets Flight Search

  Scenario: Perform a Flight Only search
  //Scenario 1. In case of repeated steps, the sentence BACKGROUND is used!

    Given I am on the CheapTickets Home Page
    And I click on the Flights Tab
    When I perform a Flight Search with the argument "LAS" in origin and the argument "LAX" in destination for 7 days from today and returning 7 days afterwards
    Then I should see a results page with a button to continue
    And I select the 4th result in departure flight and the 3th result in returning flight
    Them I should see the final page to finish my search






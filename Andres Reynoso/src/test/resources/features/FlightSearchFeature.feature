Feature:
  Scenario:
    Given I am on cheaptickets homepage
    And  I click on the flight tab
    When I complete the search form with origin "LAS" and destination "LAX" departing in 7 days till 7 days after
    Then I should select the departure flight
    Then I should select the return flight
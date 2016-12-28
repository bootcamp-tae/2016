Feature:
  Scenario:
    Given I am on cheaptickets homepage
    And  I clickOnFlightTab
    When I do the searchForm from "origin" to "deastination", since "departing" day from the date, till "returning" days after the departure
    Then I select the departure flignt
    Then I select the flight back
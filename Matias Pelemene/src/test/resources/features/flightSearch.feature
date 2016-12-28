Feature: Busqueda de vuelos en cheaptickets.com

  Scenario: User is able to perform a flight search
    Given I am at cheapticket's home page
    And I click on flight icon
    When I perform a search filling the fields with "origin", "destiny", "departure date", "arrive date"
    Then I should be at result departure flight page
    #And  I click on the 3rd flight option
    #Then I navigate to return flight page
    #And I click on the 1st flight option

Feature: Fligth search test

  Scenario: User is able to perform a flight search
    Given Im in homepage cheaptickeckts
    And I click on fligth tab
    When I complete the fields "origins","destiny","departure date" and "arrive day" and search fligths
    Then I have result fligths page




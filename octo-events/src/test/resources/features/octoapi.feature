Feature: API that allows the management of Event

  Scenario Outline: Application makes call to GET /issues/id/events
    Given application has acess to the issues API
    When application calls GET issues <id> events
    Then application receives status code <status>
    Examples:
      | id  | status |
      | 1   | 200    |
      | 999 | 404    |


  Scenario Outline: Application makes call to POST /events
    Given application has acess to the events API
    When application calls POST events with mandatory fields <idIssue> , <action>
    Then application receives message containing the id of the newly created event with <status>
    Examples:
      |idIssue |action      | status |
      | 2      |  "open"    |   200  |
      | 3      | "close"    |   200  |





Feature: Test my application smoke

  Scenario Outline: Verify user is able to login with valid credentials
    Given Open browser and start "<Application>"
    When I give valid "<User Name>" and "<Password>"
    Then User should be able to log in

    Examples: 
      | User Name           | Password | Application                      |
      | user@phptravels.com | demouser | https://www.phptravels.net/login |

  #------------------------------------------------------------------------------------------------
  Scenario Outline: Verify user is able to search hotels
    Given User is on search hotels page
    When I enter "<City name>", "<Check in date>", "<Check out date>" and hit on Search button
    Then Hotel Search result should be displayed

    Examples: 
      | City name | Check in date | Check out date |
      | Kolkata   | 20/09/2018    | 25/09/2018     |

  #------------------------------------------------------------------------------------------------
  Scenario Outline: Verify user is able to search flights for One Way trip in Economy class
    Given User is on search flights page
    When I enter "<City or Airport From>", "<City or Airport To>", "<Depart date>" and hit on Search button to search flights
    Then Flight Search result should be displayed

    Examples: 
      | City or Airport From | City or Airport To | Depart date |
      | New York             | Sydney             | 2018-09-20  |

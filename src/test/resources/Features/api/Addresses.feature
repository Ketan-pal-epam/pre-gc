Feature: Getting addresses

    Background:
        Given I have access to the API endpoint "addresses"

    Scenario: Get all addresses
      When I get all addresses
      Then I should get a list of addresses

    Scenario Outline: Get N no. of addresses
      When I get <no> no. of addresses
      Then I should get <no> no. of addresses
      Examples:
        | no   |
        | 1    |
        | 2    |
        | 3    |
        | 4    |
        | 5    |
        | null |

  Scenario Outline: Get address by country code
      Given I add parameter "_country_code" to the request <countryCode>
      When I get address by country code <countryCode>
      Then I should get address with country code <countryCode>
      Examples:
        | countryCode |
        | US          |
        | UK          |
        | IN          |
        | AU          |
        | CA          |
        | null        |




Feature: submit ajax form

      Background:
     Given I click link "Ajax Form Submit"

    Scenario Outline: Submit ajax form with name and message
     When I submit the form with name <name> and message <message>
     Then I should see the message <expectedMessage>
        Examples:
          | name | message           | expectedMessage             |
          | John | Hello             | Ajax Request is Processing! |
          | null | Hello             | Ajax Request is Processing! |
          | John | null              | Ajax Request is Processing! |
          | null | null              | Ajax Request is Processing! |
          | John |                   | Ajax Request is Processing! |
          | null |                   | Ajax Request is Processing! |
          |      | Hello             |                             |
          |      | null              |                             |
          | john | Hello!@#$%^&*()_+ | Ajax Request is Processing! |
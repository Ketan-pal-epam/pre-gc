Feature: Get Books

    Background:
        Given I have access to the API endpoint "books"

    Scenario: Get all books
        When I get all books
        Then I should get a list of books

    Scenario Outline: Get N no. of books
        When I get <no> no. of books
        Then I should get <no> no. of books
        Examples:
            | no   |
            | 1    |
            | 2    |
            | 3    |
            | 4    |
            | 5    |
            | null |

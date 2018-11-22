Feature: facebook @ work
    Background:
        Given I start browser

    Scenario Outline:
        When I access facebook login page
        And I input email - "<email>" with password - "<pw>"
        And I click login button
        Then login facebook success
        Examples:
            | email              | pw         |
            | email              | password |

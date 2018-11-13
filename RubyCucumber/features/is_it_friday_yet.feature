Feature: Is it Friday yet?
    Everybody wants to know when it's Friday

    # Scenario: Sunday isn't Friday
    #     Given today is Sunday
    #     When I ask whether it's Friday yet
    #     Then I should be told "Nope"

    # Scenario: Friday is Friday
    #     Given today is Friday
    #     When I ask whether it's Friday yet
    #     Then I should be told "TGIF"

    # Scenario Outline: Today is or is not Friday
    #     Given today is "<day>"
    #     When I ask whether it's Friday yet
    #     Then I should be told "<answer>"

    #     Examples:
    #         | day            | answer |
    #         | Friday         | TGIF   |
    #         | Sunday         | Nope   |
    #         | anything else! | TGIF   |

    # Scenario: Finding some cheese
    #     Given I am on the Google search page
    #     When I search for "Cheese!"
    #     Then the page title should start with "cheese"

    Scenario: Introduce yourself1!
        Given I'm 40 (year) old!

    Scenario Outline: Introduce yourself!
        Given I'm <age> (year) old!
        Examples: 
        |age|
        |22|
        |23|
        |24|
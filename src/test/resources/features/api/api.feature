@api @full_regression
Feature: OpenLibrary Author API

  Scenario Outline: Validate author details for OL1A
    Given I call OpenLibrary author API for "OL1A"
    Then the response status should be <expected_response_code>
    And the response should have personal_name "<personal_name>"
    And the response should contain alternate_name "<alternate_name>"

    Examples:
      | expected_response_code | personal_name | alternate_name             |
      | 200                    | Sachi Rautroy | Yugashrashta Sachi Routray |

#    test comment - 3
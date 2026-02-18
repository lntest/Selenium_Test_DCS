@ui @full_regression
Feature: Motor vehicle registration duty calculator tests

  Scenario Outline: Verify the passenger vehicle stamp duty
    Given I am on the motor vehicle stamp duty page
    When I click on the check online button and go to vehicle registration duty calculator page
    And I select the passenger vehicle as Yes
    And I enter the purchase price as <purchase_price>
    And I click on submit
    Then I should see the calculated duty payable value succesfully

    Examples:
      | purchase_price |
      | 10000          |
      | 2500           |

  Scenario Outline: Verify the non passenger vehicle stamp duty
    Given I am on the motor vehicle stamp duty page
    When I click on the check online button and go to vehicle registration duty calculator page
    And I select the passenger vehicle as No
    And I enter the purchase price as <purchase_price>
    And I click on submit
    Then I should see the calculated duty payable value succesfully

    Examples:
      | purchase_price |
      | 5000           |

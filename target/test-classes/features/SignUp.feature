Feature: User Sign Up

  Scenario: Successful sign up
    Given I am on the Zoho signup page
    When I clear the browser cache
    And I enter user details from excel
    And I click the Sign Up button
    Then I should be signed up successfully

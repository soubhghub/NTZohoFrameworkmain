Feature: User Login

  Scenario: Successful login
    Given I am on the Zoho login page
    When I clear the browser cache
    And I enter login details from excel
    And I click the Login button
    Then I should be logged in successfully

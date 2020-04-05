Feature: Login feature of the application
 
 
  Scenario: Valid login to the application 
    Given I am at the login page
    And I enter the username as "biswajitsundara" 
    And I enter the password as "automation"
    When I click on the login button
    Then I it opens my account page

  Scenario: Invalid login to the application 
    Given I am at the login page
    And I enter the username as "abcd@gmail.com" 
    And I enter the password as "automation"
    When I click on the login button
    Then It shows error on the page
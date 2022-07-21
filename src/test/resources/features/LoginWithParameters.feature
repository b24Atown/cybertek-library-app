Feature: login with parameters
  @librarianParam
  Scenario: librarian login
    Given User is on the login page
    When User enters "librarian55@library" username
    And User enters "J9ZM6KFz" password
    And User clicks sign in button
    And there should be 7355 users
    Then User should be on the dashboard page

  @studentParam
  Scenario: student login
    Given User is on the login page
    When User enters "student22@library" username
    And User enters "us2rddSF" password
    And User clicks sign in button
    Then User should be on the books page

    Scenario: librarian login one step
      Given User is on the login page
      When User enters "librarian55@library" username and "J9ZM6KFz" password
      Then User should be on the dashboard page
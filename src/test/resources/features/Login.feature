Feature: Login
  @librarian
  Scenario: login for librarian
    Given User is on the login page
    When User logs in as a librarian
    Then User should be on the dashboard page

    @student
  Scenario: login for student
    Given User is on the login page
    When User logs in as a student
    Then User should be on the books page

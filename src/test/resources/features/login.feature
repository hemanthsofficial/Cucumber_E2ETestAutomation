Feature: Customer login

  As a registered Parabank user
  I want to log in with valid credentials
  So that I can view my account overview

  @sanity
  Scenario: Login with valid credentials
    Given the Parabank login page is displayed
    When the user enters "hemanths@gmail.com" in the username field
    And the user enters "Hemu@2021" in the password field
    And the user clicks the login button
    Then the Accounts Overview page should be displayed

  @regression
  Scenario Outline: Login with multiple valid user credentials
    Given the Parabank login page is displayed
    When the user enters "<username>" in the username field
    And the user enters "<password>" in the password field
    And the user clicks the login button
    Then the Accounts Overview page should be displayed

    Examples:
    | username           | password     |
    | khamzatc@gmail.com | Khamzat@2021 |
    | islamm@gmail.com   | Islam@2021   |
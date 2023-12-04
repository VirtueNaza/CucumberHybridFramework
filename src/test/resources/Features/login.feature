Feature:Login functionality

  Background:
    Given user navigates to login page
@login
  Scenario: Login with valid credentials
    When user enters valid email address "nazanwa007@gmal.com" into email address field
    And enters valid password "12345" into password field
    And clicks on login button
    Then user should successfully log in and be navigated to account page
@login
    Scenario: Login with invalid credentials
      When user enters invalid email address "nazababy" into email address field
      And enters invalid password "]]]]]" into password field
      And clicks on login button
      Then user should get proper warning message indicating no match for email address or password
@login
      Scenario: Login without providing any credentials
        When user does not provide any details
        And  clicks on login button
        Then user should get proper warning message indicating no match for email address or password
@login
        Scenario: Login with valid email and invalid password
          When user enters valid email address "nazanwa007@gmal.com" into email address field
          And enters invalid password "]]]]]" into password field
          And clicks on login button
          Then user should get proper warning message indicating no match for email address or password
@login
          Scenario:  Login with invalid email address and valid password
            When user enters invalid email address "nazababy" into email address field
            And enters valid password "12345" into password field
            And clicks on login button
            Then user should get proper warning message indicating no match for email address or password







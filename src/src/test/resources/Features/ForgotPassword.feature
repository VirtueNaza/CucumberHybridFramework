Feature: Forgot password functionality

  Background:
  Given user navigates to forgot password page

@forgotPassword @smoke @regression
   Scenario Outline: Reset Password with registered email
      When user enters registered email into E-mail Address field <registered E-mail>
      And clicks on continue button(Forgot Password page)
      Then success message indicating link sent to Email Address should be displayed
  Examples:  |registered E-mail|
             |nazanwa006@gmail.com|

@forgotPassword @smoke @regression
  Scenario Outline: Reset password with unregistered E-mail Address
    When user enters unregistered email into E-mail Address field <unregistered E-mail>
    And clicks on continue button(Forgot Password page)
    Then a warning message indicating E-mail not found should be displayed.
  Examples:
    |unregistered E-mail|
    |nazanwa000001111@gmail.com|

@forgotPassword @regression
      Scenario: Reset password without Providing E-mail Address
        When user does not provide any details in E-mail Address field
        And clicks on continue button(Forgot Password page)
        Then a warning message indicating E-mail not found should be displayed.

@forgotPassword @regression
        Scenario Outline: Reset password with invalid E-mail Address
          When user enters invalid email into E-mail Address field<invalid Email>
          And clicks on continue button(Forgot Password page)
          Then a warning message indicating E-mail not found should be displayed.
  Examples:
    |invalid Email|
    |[[>:,"{}?<)(*&^%$#2|
    |nazanwa            |
Feature: Register functionality

  Background:
    Given user navigates to register account page

    Scenario: Register by providing only mandatory fields
      When user enters the following details:
      |FirstName| Uchenna|
      |LastName |Igweobu|
      #I'm not passing values for email here because I need the email to be dynamic so I created a dynamic method in MyUtils.z
      |Telephone |980765434             |
      |Password  |12345                 |
      And selects privacy policy
      And clicks on continue button
      Then account should be created and user navigated to account success page

      Scenario: Register by providing all fields
        When user enters the following details:
          |FirstName| Uchenna|
          |LastName |Igweobu|
          |Telephone |980765434             |
          |Password  |12345                 |
        And selects yes in Newsletter field
        And selects privacy policy
        And clicks on continue button
        Then account should be created and user navigated to account success page

        Scenario: Register without providing any details
          When user does not provide any details into any field
          And clicks on continue button
          Then user should get proper warning messages for all mandatory fields

          Scenario: Login with duplicate email address
            When user enters the following details with duplicate email:
              |FirstName| Uchenna|
              |LastName |Igweobu|
              |E-mail     |nazanwa006@gmail.com|
              |Telephone |980765434             |
              |Password  |12345                 |
            And selects yes in Newsletter field
            And selects privacy policy
            And clicks on continue button
            Then proper error message should be displayed indicating duplicate email address

            Scenario: Register without accepting privacy policy
              When user enters the following details:
                |FirstName| Uchenna|
                |LastName |Igweobu|
                |Telephone |980765434             |
                |Password  |12345                 |
              And selects yes in Newsletter field
              And clicks on continue button
              Then proper warning message indicating select privacy policy should be displayed



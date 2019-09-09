Feature: CasparPatientRegistration

  Scenario: Perform user login with valid credentials
    Given User is on login page
    When User perform login with "IXE0865" and "78350619"
    Then User login successfully

  Scenario: Add patient record with mandatory details

    Given User click on Add patient button
    When User enter first name as "John"
    And User enter last name as "Doe"
    And User select DOB as "1" - "January" - "1992"
    And User select Country as "Pakistan"
    And User click on save button
    Then Patient info start appearing


  Scenario: Perform login with patient credentials
    Given User copied patient info
    When User perform logout
    And User perform login with patient credentials
    Then User landed on T&C and release of medical page


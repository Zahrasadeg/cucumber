Feature: Search the employee
Background:
  When user enters valid email and valid password
  And click on login button
  When user clicks on PIM option
  @smoke4
  Scenario:Search Employee by Id
   # Given open the browser and launch HRMS application
   # When user enters valid email and valid password
    #And click on login button
    #When user clicks on PIM option
    When user enters valid employee id
    And Clicks on search button
    And user see employee information is displayed
  #  And close the browser

    @smoke5
    Scenario: :Search Employee by job title
     # Given open the browser and launch HRMS application
     # When user enters valid email and valid password
      #And click on login button
      #When user clicks on PIM option
      When user select Job Title
      And Clicks on search button
      And user see employee information is displayed
     # And close the browser
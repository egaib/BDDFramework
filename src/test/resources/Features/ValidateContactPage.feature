Feature: Validate Contact Page

  @TestID=10001 @Author=EG @Regression
  Scenario: The Contact page displays the required information
    Given The user is on the homepage
    And The user navigates to the Contact page
    Then The required information is displayed on the Contact page

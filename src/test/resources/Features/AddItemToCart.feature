Feature: Add Items To Cart

  @TestID=10000 @Author=EG @Regression
  Scenario: The user is able to add a Anchor Bracelet to the Cart
    Given The user is on the homepage
    And The user adds an Item to the cart
    When The user navigates to the cart
    Then The item is displayed in the cart


#appAddItem
#appCheckout
#implement page factory testng
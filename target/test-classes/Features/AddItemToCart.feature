Feature: AddItemToCart

  @TestID=10000 @Author=EG @Regression
  Scenario: The user is able to add an Item to the Cart
    Given The browser is open and website is loaded
		And The user adds an Item to the cart
    When The user navigates to the cart
    Then The item is displayed in the cart


#Move whats in Test folder (contactPageTests, HomePageTests) into StepDefs

#Replace beforemethod stuff with Given Browser is Open

#appAddItem
#appCheckout

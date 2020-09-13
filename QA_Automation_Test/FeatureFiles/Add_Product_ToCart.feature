Feature: Add Product To Cart And Complete Checkout Process
Background: Common Steps for All Scenario
Given User Launch Browser And Open Url  'http://automationpractice.com/index.php'
When User Verify Page With  Title  "My Store"
Then User Click On Sign In  Button
And User verify Login Page Title  "Login - My Store"
And User Enter Email  As "gnsanap22992@gmail.com" And Password As "test123"
Then User Click on Sign in  Button
And User Verify page with Title "My account - My Store"
And User click on Women Link
Then User select product by clicking on Quick View
And User enter quantity of Product

@sanity
Scenario: User Add Product to Cart
When User click on Add to Cart Button

@sanity
Scenario: User Complete CheckOut Process And Verify Cost Of Product
When User click on Add to Cart Button
And When user click on Proceed to CheckOut Button
Then User verify Total cost Of Product "$35.02"
And User completes Payments Process
When User Verify Order Confirmation Message "Your order on My Store is complete."
Then User close browser



Feature: Create New Account 
@sanity
Scenario: User Create New Account under Sign In
Given User Launch Browser And Open Url 'http://automationpractice.com/index.php'
When User Verify Page With Title "My Store"
Then User Click On SignIn Button
When User Enter Email Address "gnsan@gmail.com"
And User click On Create Account Button
Then User Verify Page With Title1 "Login - My Store"
When User Enter All  Details
And User Click on Register Button
Then User Verify That The New Acoount is Created Successfully "Welcome to your account. Here you can manage all of your personal information and orders."
And User Close The Browser
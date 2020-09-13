Feature: Login Feature
@smoke1
Scenario: Verify User Login with valid and Invalid  Credentials
Given User launch browser and open Url 'http://automationpractice.com/index.php'
When User Verify Page  Title "My Store"
Then User Click On Sign In Button
And User verify Login Page Title "Login - My Store"
And User Enter Email As "gnsanap22992@gmail.com" And Password As "test123"
Then User Click on Signin Button
And User verify page with Title "My account - My Store"
When User Click on Sign Out Button and verify SignOut "Login - My Store"
Then User close browser
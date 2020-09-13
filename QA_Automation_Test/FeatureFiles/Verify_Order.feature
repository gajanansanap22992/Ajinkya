Feature: Order  Verification Feature
@sanity
Scenario: Verify  The Amount Of Order Under Order History
Given User  launch browser and open  Url 'http://automationpractice.com/index.php'
When User  Verify   Page  Title "My Store"
Then User  Click On  Sign In Button
And User  Verify Login Page Title "Login - My Store"
And User  Enter Email As "gnsanap22992@gmail.com" And Password As "test123"
Then User  Click on  Signin Button
And User  verify page  with Title "My account - My Store"
When User click on Order History and Details link
And User verify Order History and Details Page With Title "Order history - My Store"
Then User verify Amount Of Order in Order History

When User  Click on  Sign Out Button and verify SignOut "Login - My Store"
Then User  close  browser
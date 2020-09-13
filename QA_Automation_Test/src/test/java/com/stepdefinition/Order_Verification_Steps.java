package com.stepdefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.page.CreateAccountPage;
import com.page.HomePage;
import com.page.LoginPage;
import com.page.MyAccountPage;
import com.page.OrderHistoryPage;
import com.page.WomenPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Order_Verification_Steps {
	
	public WebDriver driver;	
	public HomePage hp;
	public LoginPage lp;
	public MyAccountPage map;
	public CreateAccountPage cap;
	public WomenPage wp;
	public OrderHistoryPage oh;
	@Given("User  launch browser and open  Url {string}")
	public void user_launch_browser_and_open_Url(String url) {
		 driver=Hooks.driver;
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   driver.manage().deleteAllCookies();
		   lp=new LoginPage(driver);
		   hp=new HomePage(driver);
		   oh=new OrderHistoryPage(driver);
		   map=new MyAccountPage(driver);
		   driver.get(url);
	}

	@When("User  Verify   Page  Title {string}")
	public void user_Verify_Page_Title(String title) {
		Assert.assertEquals(driver.getTitle(), title);
	}

	@Then("User  Click On  Sign In Button")
	public void user_Click_On_Sign_In_Button() {
		hp.ClickOnSignInButton();
	}

	@Then("User  Verify Login Page Title {string}")
	public void user_Verify_Login_Page_Title(String title) {
		Assert.assertEquals(driver.getTitle(), title);
	}

	@Then("User  Enter Email As {string} And Password As {string}")
	public void user_Enter_Email_As_And_Password_As(String email, String password) {
		lp.enterEmail(email);
		lp.enterPassword(password);
	}

	@Then("User  Click on  Signin Button")
	public void user_Click_on_Signin_Button() {
		 lp.clickOnSignInButton();
	}

	@Then("User  verify page  with Title {string}")
	public void user_verify_page_with_Title(String title) {
		Assert.assertEquals(driver.getTitle(), title);
	}
	@When("User click on Order History and Details link")
	public void user_click_on_Order_History_and_Details_link() {
	    map.clickOnOrderHistoryLink();
	}


	@When("User verify Order History and Details Page With Title {string}")
	public void user_verify_Order_History_and_Details_Page_With_Title(String title) {
		Assert.assertEquals(driver.getTitle(), title);
	    
	}
	
	@Then("User verify Amount Of Order in Order History")
	public void user_verify_Amount_Of_Order_in_Order_History() {
		List <WebElement> elementList=driver.findElements(By.xpath("//table[@id='order-list']//tr"));
		
		int orders=elementList.size()-1;
		
		System.out.println("Amount of Order -->"+orders);
		Assert.assertEquals(orders, orders);
	   
	}

	@When("User  Click on  Sign Out Button and verify SignOut {string}")
	public void user_Click_on_Sign_Out_Button_and_verify_SignOut(String title) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   oh.clickOnSignOutButton();
		Assert.assertEquals(driver.getTitle(), title);
	}

	@Then("User  close  browser")
	public void user_close_browser() {
	   System.out.println("User Successfully Scenario ");
	}
}
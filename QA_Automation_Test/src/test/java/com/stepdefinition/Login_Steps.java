package com.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.page.CreateAccountPage;
import com.page.HomePage;
import com.page.LoginPage;
import com.page.MyAccountPage;
import com.testbase.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_Steps 
{
	public WebDriver driver;	
	public HomePage hp;
	//public Hooks hook;
	public LoginPage lp;
	public MyAccountPage map;
	public CreateAccountPage cap;
	public String email;
	public Logger log;
	@Given("User launch browser and open Url {string}")
	public void user_launch_browser_and_open_Url(String url) {
		//hook=new Hooks();
	   driver=Hooks.driver;
	   log=Hooks.loger;
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   driver.manage().deleteAllCookies();
	   lp=new LoginPage(driver);
	   hp=new HomePage(driver);
	   map=new MyAccountPage(driver);
	   driver.get(url);
	   log.info("User launch browser and open Url");
	}

	@When("User Verify Page  Title {string}")
	public void user_Verify_Page_Title(String title) {
		log.info("User Verify Page  Title "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), title);
	}

	@Then("User Click On Sign In Button")
	public void user_Click_On_Sign_In_Button() {
	   hp.ClickOnSignInButton();
	}
	@Then("User verify Login Page Title {string}")
	public void user_verify_Login_Page_Title(String title) {
	   Assert.assertEquals(driver.getTitle(),title);
	}
	@Then("User Enter Email As {string} And Password As {string}")
	public void user_Enter_Email_As_And_Password_As(String email, String password) {
		lp.enterEmail(email);
		lp.enterPassword(password);
	   
	}

	@Then("User Click on Signin Button")
	public void user_Click_on_Signin_Button() {
	   lp.clickOnSignInButton();
	}
	@Then("User verify page with Title {string}")
	public void user_verify_page_with_Title(String title) {
		Assert.assertEquals(driver.getTitle(), title);		
	   
	}
	@When("User Click on Sign Out Button and verify SignOut {string}")
	public void user_Click_on_Sign_Out_Button_and_verify_SignOut(String title) throws InterruptedException {
		Thread.sleep(3000);
	   map.clickOnSignOut();
	   Assert.assertEquals(driver.getTitle(), title);
	}

	@Then("User close browser")
	public void user_close_browser() {
	   System.out.println("Login Test Successfull");
	}



}

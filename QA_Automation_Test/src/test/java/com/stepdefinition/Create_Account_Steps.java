package com.stepdefinition;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.page.CreateAccountPage;
import com.page.HomePage;
import com.testbase.TestBase;
import com.utility.Utility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Create_Account_Steps 
{
	public WebDriver driver;
	public Hooks hook;
	public HomePage hp;
	public CreateAccountPage cap;
	public String email;
	
	@Given("User Launch Browser And Open Url {string}")
	public void user_launch_browser_and_open_url(String url) throws IOException
	{
		
		//System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver.exe");
	   driver=Hooks.driver;
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   driver.manage().deleteAllCookies();
	   hp=new HomePage(driver);
	   cap=new CreateAccountPage(driver);
	   
	   driver.get(url);
	}

	@When("User Verify Page With Title {string}")
	public void user_verify_page_with_title(String title) {
		Assert.assertEquals(driver.getTitle(), title);
	    
	}

	@Then("User Click On SignIn Button")
	public void user_click_on_sign_in_button() {
		hp.ClickOnSignInButton();
	    
	}

	@When("User Enter Email Address {string}")
	public void user_enter_email_address(String em) {
		this.email=Utility.getEmail();
		hp.enterEmail(email);
	  
	}

	@When("User click On Create Account Button")
	public void user_click_on_create_account_button() {
		hp.ClickOnCreateAccount();
	    
	}

	@Then("User Verify Page With Title1 {string}")
	public void user_verify_page_with_title1(String title) {
		Assert.assertEquals(driver.getTitle(), title);
	    
	}

	@When("User Enter All  Details")
	public void user_enter_all_details() throws InterruptedException {
		
		Thread.sleep(2000);
		cap.checkTitle("male");
		cap.enterFirstName("gajanan");
		cap.enterLastName("sanap");
		cap.enterEmail(this.email);
		cap.enterPassword("test123");
		cap.selectDateOfBirth("22-9-1992");
		cap.clickOnCheckNewsletter();
		cap.enterAddressFirstName("gajanan");
		cap.enterAddressLaststName("sanap");
		cap.enterCompanyName("Aew Infotech");
		cap.enterAdreess1("plotno.26 cosmos garden");
		cap.enterAdreess2("near unionbank Baner");
		cap.enterCity("Anchorage");
		cap.selectState("Alaska");
		cap.enterPostalCode("99503");
		cap.selectCountry("United States");
		cap.enterAdditionalInformation("QA automation");
		cap.enterHomePhone("07221223158");
		cap.enterMobilePhone("9090226868");
		cap.enterAddressAlias("amravati maharashtra");
		
	  
	}

	@When("User Click on Register Button")
	public void user_click_on_register_button() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cap.clickOnRegisterButton();
	   
	}

	@Then("User Verify That The New Acoount is Created Successfully {string}")
	public void user_Verify_That_The_New_Acoount_is_Created_Successfully(String message) {
	    Assert.assertTrue(driver.getPageSource().contains(message));
	}
	@Then("User Close The Browser")
	public void user_Close_The_Browser() {
	    
	}


}

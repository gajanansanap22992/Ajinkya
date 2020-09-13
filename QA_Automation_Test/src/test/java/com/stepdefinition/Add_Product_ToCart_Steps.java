package com.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.page.CreateAccountPage;
import com.page.HomePage;
import com.page.LoginPage;
import com.page.MyAccountPage;
import com.page.WomenPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Add_Product_ToCart_Steps {
	
	
	public WebDriver driver;	
	public HomePage hp;
	public LoginPage lp;
	public MyAccountPage map;
	public CreateAccountPage cap;
	public WomenPage wp;
	
	@Given("User Launch Browser And Open Url  {string}")
	public void user_Launch_Browser_And_Open_Url(String url) {
		 driver=Hooks.driver;
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   driver.manage().deleteAllCookies();
		   lp=new LoginPage(driver);
		   hp=new HomePage(driver);
		   wp=new WomenPage(driver);
		   map=new MyAccountPage(driver);
		   driver.get(url);
	    
	}

	

	@When("User Verify Page With  Title  {string}")
	public void user_Verify_Page_With_Title(String title) {
		Assert.assertEquals(driver.getTitle(), title);
	   
	}

	
	@Then("User Click On Sign In  Button")
	public void user_Click_On_Sign_In_Button() {
		 hp.ClickOnSignInButton();
	}

	@Then("User verify Login Page Title  {string}")
	public void user_verify_Login_Page_Title(String title) {
		Assert.assertEquals(driver.getTitle(), title);
	  
	}

	

	@Then("User Enter Email  As {string} And Password As {string}")
	public void user_Enter_Email_As_And_Password_As(String email, String password) {
		lp.enterEmail(email);
		lp.enterPassword(password);
	}

	

	@Then("User Click on Sign in  Button")
	public void user_Click_on_Sign_in_Button() {
		 lp.clickOnSignInButton();
	   
	}
	@Then("User Verify page with Title {string}")
	public void user_Verify_page_with_Title(String title) {
	   Assert.assertEquals(driver.getTitle(), title);
	}
	@Then("User click on Women Link")
	public void user_click_on_Women_Link() {
	   map.clickOnWomenLink();
	}
	@Then("User select product by clicking on Quick View")
	public void user_select_product_by_clicking_on_Quick_View() throws InterruptedException {
	  wp.clickOnQuickView();
	  
	 
	 
	}
	@Then("User enter quantity of Product")
	public void user_enter_quantity_of_Product() {
		driver.switchTo().frame(0);
		  driver.findElement(By.xpath("//input[@id='quantity_wanted']")).clear();
		  try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  driver.findElement(By.xpath("//input[@id='quantity_wanted']")).sendKeys("2");
	}

	

	@When("User click on Add to Cart Button")
	public void user_click_on_Add_to_Cart_Button() throws InterruptedException {
		 driver.findElement(By.xpath("//button//span[contains(text(),'Add to cart')]")).click();
		  Thread.sleep(3000);
	}

	

	@When("When user click on Proceed to CheckOut Button")
	public void when_user_click_on_Proceed_to_CheckOut_Button() {
		 driver.findElement(By.xpath("//div[@class='button-container']//span[contains(text(),'Proceed to checkout')]")).click();
	    
	}

	@Then("User verify Total cost Of Product {string}")
	public void user_verify_Total_cost_Of_Product(String expectedCost) {
	   String actualCost=driver.findElement(By.xpath("//span[@id='total_price']")).getText();
	   Assert.assertEquals(actualCost, expectedCost);
	}


	@Then("User completes Payments Process")
	public void user_completes_Payments_Process() throws InterruptedException {
	   driver.findElement(By.xpath("//a[@title='Proceed to checkout' and @class='button btn btn-default standard-checkout button-medium']//span")).click();
	   try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   driver.findElement(By.xpath("//button[@name='processAddress']")).click();
	   try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   driver.findElement(By.xpath("//input[@id='cgv']")).click();
	   try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   driver.findElement(By.xpath("//button[@name='processCarrier']")).click();
	   Thread.sleep(1500);
	   
	   driver.findElement(By.xpath("//a[@class='bankwire']")).click();
	   Thread.sleep(1500);
	   driver.findElement(By.xpath("//button//span[contains(text(),'I confirm my order')]")).click();
	}


	@When("User Verify Order Confirmation Message {string}")
	public void user_Verify_Order_Confirmation_Message(String message) {
		Assert.assertTrue(driver.getPageSource().contains(message));
	   
	}


}

package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement txtRegisterEmail;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement txtRegisterPassword;

	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement buttonSignIn;
	public void enterEmail(String email)
	{
		txtRegisterEmail.sendKeys(email);
		
	}
	public void enterPassword(String password)
	{
		
		txtRegisterPassword.sendKeys(password);
	}
	public void clickOnSignInButton()
	{
		buttonSignIn.click();
	}


}

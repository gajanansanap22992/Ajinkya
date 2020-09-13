package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
public WebDriver driver;

public HomePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//a[contains(text(),'Sign in')]")
WebElement SignInButton;

@FindBy(xpath = "//input[@id='email_create']")
WebElement txtEmail;

@FindBy(xpath="//button[@id='SubmitCreate']")
WebElement createAccountButton;


public void ClickOnCreateAccount()
{
	createAccountButton.click();
}
public void enterEmail(String email)
{
	txtEmail.sendKeys(email);
}
public void ClickOnSignInButton()
{
	SignInButton.click();
}
}

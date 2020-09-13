package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage 
{
	public WebDriver driver;
	public MyAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//a[@class='logout']")
	WebElement buttonSignOut;
	
	@FindBy(xpath = "//a[contains(text(),'Women') and @title='Women']")
	WebElement linkWomen;
	
	@FindBy(xpath = "//a[@title='Orders']//span[contains(text(),'Order history and details')]")
	WebElement linkOrderAndHistory ;
	
	
	
	
	public void clickOnSignOut()
	{
		buttonSignOut.click();
	}
	public void clickOnWomenLink()
	{
		linkWomen.click();
	}
	public void clickOnOrderHistoryLink()
	{
		linkOrderAndHistory.click();
	}
}

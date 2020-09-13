package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenPage {
	public WebDriver driver;
	public WomenPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@class='product-image-container']//a//img[@title='Faded Short Sleeve T-shirts']")
	WebElement product1;
	
	public void clickOnQuickView()
	{
		 Actions action=new Actions(this.driver);
		   action.moveToElement(product1).click().build().perform();
	}
	

}

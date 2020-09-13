package com.page;

import org.objectweb.asm.util.CheckMethodAdapter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class CreateAccountPage {
	
	public WebDriver driver;

	public CreateAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@id='id_gender2']")
	WebElement genderFemale ;
	
	@FindBy(xpath = "//input[@id='id_gender1']")
	WebElement genderMale ;
	
	@FindBy(xpath = "//input[@id='customer_firstname']")
	WebElement txtFirstName ;
	
	@FindBy(xpath = "//input[@id='customer_lastname']")
	WebElement txtLastName ;
	
	@FindBy(xpath = "//input[@id='passwd']")
	WebElement txtPassword ;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement txtEmail ;
	
	@FindBy(xpath = "//select[@id='days']")
	WebElement selectDay ;
	
	@FindBy(xpath = "//select[@id='months']")
	WebElement selectMonth ;
	
	@FindBy(xpath = "//select[@id='years']")
	WebElement selectYear ;

	@FindBy(xpath = "//input[@id='newsletter']")
	WebElement checkNewsLetter ;

	@FindBy(xpath = "//input[@id='optin']")
	WebElement checkOffers ;

	@FindBy(xpath = "//input[@id='firstname']")
	WebElement txtAddFirstName ;

	@FindBy(xpath = "//input[@id='lastname']")
	WebElement txtAddLastName ;

	@FindBy(xpath = "//input[@id='company']")
	WebElement txtCompany ;

	@FindBy(xpath = "//input[@id='address1']")
	WebElement txtAddressLine1 ;

	@FindBy(xpath = "//input[@id='address2']")
	WebElement txtAddressLine2 ;

	@FindBy(xpath = "//input[@id='city']")
	WebElement txtCity ;

	@FindBy(xpath = "//select[@id='id_state']")
	WebElement selectState ;

	@FindBy(xpath = "//select[@id='id_country']")
	WebElement selectCountry ;

	@FindBy(xpath = "//input[@id='postcode']")
	WebElement txtPostalCode ;

	@FindBy(xpath = "//textarea[@id='other']")
	WebElement txtAddInfo ;

	@FindBy(xpath = "//input[@id='phone']")
	WebElement txtPhone ;

	
	@FindBy(xpath = "//input[@id='phone_mobile']")
	WebElement txtMobilePhone ;

	
	@FindBy(xpath = "//input[@id='alias']")
	WebElement txtAddressAlias ;
	
	@FindBy(xpath = "//button[@id='submitAccount']")
	WebElement registerButton;
	

	public void checkTitle(String gender)
	{
		if(gender.equals("male"))
		{
			genderMale.click();
		}
		else if(gender.equals("female"))
		{
			genderFemale.click();
		}
	}
	
	public void enterFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}

	public void enterLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}

	public void enterEmail(String email)
	{
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void enterPassword(String pass)
	{
		txtPassword.sendKeys(pass);
	}

	public void selectDateOfBirth(String dob)
	{
		String[] str=new String[3];
	    str=dob.split("-",3);
		String day=str[0];
		String month=str[1];
		String year=str[2];
		Utility.selectByValue(selectDay, day);
		Utility.selectByValue(selectMonth, month);
		Utility.selectByValue(selectYear, year);
		
	}

	public void clickOnCheckNewsletter()
	{
		checkNewsLetter.click();
	}

	public void clickOnCheckOffer()
	{
		checkOffers.click();
	}

	public void enterAddressFirstName(String fname)
	{
		txtAddFirstName.clear();
	txtAddFirstName.sendKeys(fname);	
	}
	public void enterAddressLaststName(String lname)
	{
		txtAddLastName.clear();
		txtAddLastName.sendKeys(lname);
		
	}

	public void enterCompanyName(String company)
	{
		txtCompany.sendKeys(company);
	}

	public void enterAdreess1(String address)
	{
		txtAddressLine1.sendKeys(address);
	}
	public void enterAdreess2(String address)
	{
		txtAddressLine2.sendKeys(address);
	}

	
	public void enterCity(String city)
	{
		txtCity.sendKeys(city);
	}
	public void selectState(String state)
	{
		Utility.selectByText(selectState, state);
	}
	public void selectCountry(String country)
	{
		Utility.selectByText(selectCountry, country);
	}
	public void enterAdditionalInformation(String info)
	{
		txtAddInfo.sendKeys(info);
	}
	public void enterHomePhone(String hphone)
	{
		txtPhone.sendKeys(hphone);
	}
	public void enterMobilePhone(String mphone)
	{
		txtMobilePhone.sendKeys(mphone);
	}
	public void enterPostalCode(String postalcode)
	{
		txtPostalCode.sendKeys(postalcode);
	}
	public void enterAddressAlias(String aalias)
	{
		txtAddressAlias.clear();
		txtAddressAlias.sendKeys(aalias);
	}
	public void clickOnRegisterButton()
	{
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		registerButton.click();
	}
	

}

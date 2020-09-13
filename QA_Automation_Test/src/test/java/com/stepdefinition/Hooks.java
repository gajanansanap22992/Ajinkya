package com.stepdefinition;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.testbase.TestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends TestBase
{
	public static WebDriver driver;
	public static Logger loger;
	
	@Before
	public void setUp( ) throws IOException
	{
		driver=getDriver();
		loger=getLogg();
		
		
	}
	@After
	public void tearDown(Scenario scenario) throws InterruptedException
	{
		
		if(scenario.isFailed())
		{
			final byte[] screens=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			//scenario.embed(screens,"image/png");
		}
		else if(!scenario.isFailed())
		{
			final byte[] screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			//scenario.embed(screen,"image/png");
		}
		Thread.sleep(2000);
		//driver.quit();
	}

}

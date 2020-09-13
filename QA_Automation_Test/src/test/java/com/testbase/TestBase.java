package com.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestBase {
	
	public static WebDriver driver;
	public static Logger logger;
	
	
	public static Logger getLogg()
	{
		 logger=Logger.getLogger("logg");
		PropertyConfigurator.configure("C:\\Users\\gnsan\\git\\Automation_Test\\QA_Automation_Test\\Log4j.properties");
		return logger;
		
	}
	
	public static WebDriver getDriver() throws IOException
	{
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\utility\\Config.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		
		String browser=prop.getProperty("browser");
		if(browser.equals("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromepath"));
			driver=new ChromeDriver();
			
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("ffpath"));
			driver =new FirefoxDriver();
		}
		
		return driver;
		
	}

}


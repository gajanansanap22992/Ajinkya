package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility {
	
	public static void selectByValue(WebElement element,String value)
	{
		
		Select select=new Select(element);
		select.selectByValue(value);
	}
	public static void selectByText(WebElement element,String text)
	{
	
		Select select=new Select(element);
		select.selectByVisibleText(text);;
	}

	public static String getEmail()
	{
		
			String s=RandomStringUtils.randomAlphabetic(8)	;
		return s+"@gmail.com";
		
	}
	
	public static Object[][] getData() throws IOException
	{
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//TestData//data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		int lrow=sheet.getLastRowNum();
		int lcol=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[lrow][lcol];
		for(int i=1;i<=lrow;i++)
		{
			
			XSSFRow currentRow=sheet.getRow(i);
			data[i-1][0]=currentRow.getCell(0).getStringCellValue().toString();
			String s=  currentRow.getCell(1).getStringCellValue().toString();
			data[i-1][1]=s.replace('s', ' ');
			String a=currentRow.getCell(2).getStringCellValue().toString();
			data[i-1][2]=a.replace('s', ' ');
			
		}
		return data;
		
		
	}	

}

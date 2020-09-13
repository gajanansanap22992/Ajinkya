package com.testrunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {".//FeatureFiles/Create_Account.feature",".//FeatureFiles/Login.feature",
				".//FeatureFiles/Add_Product_ToCart.feature",".//FeatureFiles/Verify_Order.feature"},
		glue = "com.stepdefinition",
		dryRun = false,
		monochrome = true,
		//tags = {" @smoke1 "},
		plugin = {"pretty","json:target/cucumber.json"}
		
		
		
		
		)

public class TestRunner extends AbstractTestNGCucumberTests{
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}

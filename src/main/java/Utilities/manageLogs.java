package Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import TestAllActions.BaseClass;


public class manageLogs {
	
    static { System.setProperty("log4j.configurationFile","log4j.xml"); }
    public Logger logger = LogManager.getLogger(BaseClass.class.getName());

	@BeforeSuite
	public void setup(ITestContext context) {
		 logger.info("Start : "+context.getSuite().getXmlSuite().getName());	
	}

	@BeforeMethod
	public void beforeMethodListener(ITestResult result) throws Exception {
		logger.info("Start test : "+result.getMethod().getMethodName());
	}
	
	@AfterMethod
	public void afterMethodListener(ITestResult result) throws Exception {
		if(result.getStatus() == ITestResult.SUCCESS) {
			logger.info("success test - " + result.getMethod().getMethodName());
		}else if (result.getStatus() == ITestResult.FAILURE) {
			logger.error("failed test - " + result.getMethod().getMethodName());
		}else if(result.getStatus() == ITestResult.SKIP) {
			logger.warn("skipped test - " + result.getMethod().getMethodName());
		}
	}
	
	@AfterSuite
	public void tearDown(ITestContext context) {
		logger.info("End : "+context.getSuite().getXmlSuite().getName());	
	}


}

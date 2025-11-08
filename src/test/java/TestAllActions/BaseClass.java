package TestAllActions;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.google.gson.JsonObject;

import Utilities.pageObjects;
import io.restassured.response.Response;

public class BaseClass extends pageObjects{
	
	static { System.setProperty("log4j.configurationFile","log4j.xml"); }
    public Logger logger = LogManager.getLogger(BaseClass.class.getName());
    

	//--------------------------------
    // Summary:
	// 		Initialization of BaseURL from config.properies file.
	//--------------------------------
	public String initURL() throws Exception {
		return objReadingPropertyFile.getProperty("baseURL");
	}
	
	//--------------------------------
    // Summary:
	// 		Map returning the values of Query Parameters.
	//--------------------------------
	public Map<String, String> keyTokenQueryParams() {
		return objTestUtils.queryParameters();
	}
	
	//--------------------------------
    // Summary:
	// 		Map returning the values of Query Parameters.
	//--------------------------------
	public Map<String, String> createBoardQueryParams() {
		return objTestUtils.createBoardQueryParams();
	}
	
	//--------------------------------
    // Summary:
	// 		Map returning the updated values of Query Parameters.
	//--------------------------------
	public Map<String, String> updateBoardQueryParams() {
		return objTestUtils.updateBoardQueryParams();
	}
	
	
	//--------------------------------
    // Summary:
	// 		Map returning the values of Query Parameters.
	//--------------------------------
	public Map<String, String> updateCardQueryParams() {
		return objTestUtils.updateCardQueryParams();
	}
	
	//--------------------------------
    // Summary:
	// 		Map returning the values of Query Parameters.
	//--------------------------------
	public Map<String, String> createCardQueryParams() {
		return objTestUtils.createCardQueryParams();
	}
	
	//--------------------------------
    // Summary:
	// 		Validate assertions Actual vs Expected.
	// Params:
	//		JsonObject, value.
	//--------------------------------
	public void validateAssertions(Object object , String value) {
		Assert.assertEquals(object, value);	
	}

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

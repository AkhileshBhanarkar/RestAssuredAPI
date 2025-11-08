package TestAllActions;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TestAllActions.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class checkPing extends BaseClass{
	
	//--------------------------------
    // Summary:
	// 		Checking the ping request 
	//		before executing all other requests.
	//--------------------------------
	
	public checkPing() throws Exception {
		RestAssured.baseURI=initURL();
		Response response = given().get(objReadingPropertyFile.getProperty("ping_request"));
		
		Assert.assertEquals(response.statusCode(), 200);
		
		logger.info("**** Server is running ****");
	}

}

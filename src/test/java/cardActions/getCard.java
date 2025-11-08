package cardActions;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import TestAllActions.BaseClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class getCard extends BaseClass{
	
	//--------------------------------
    // Summary:
	// 		Fetching a newly created card for previously
	//		created List.
	// Params:
	//		statusCode.
	//--------------------------------
	public getCard(int statusCode) throws Exception {
		 RestAssured.baseURI = initURL();
	     String response = given()
	     					.queryParams(keyTokenQueryParams())
	     				.when()
	     					.get(objTestUtils.initCardURLEndpoint("CardEndPoint")+cardId)
	     				.then()
	     					.log().all().statusCode(statusCode).extract().response().asString();
	     
	     JsonPath json = new JsonPath(response);
			validateAssertions(json.get("id"),cardId);
			validateAssertions(json.get("desc"),objReadingPropertyFile.getProperty("txt_desc_create_crad"));
			Assert.assertTrue(cardId.matches(objReadingPropertyFile.getProperty("regex")));
			logger.info(cardId + " matches the regex code");
			
			logger.info("------------------------------------------------");
			logger.info("Newly created card id matches with the saved card id in global variable");
			logger.info("------------------------------------------------");
			

		}

}

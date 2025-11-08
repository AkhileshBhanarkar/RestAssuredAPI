package ListActions;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import TestAllActions.BaseClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class getList extends BaseClass {
	
	//--------------------------------
    // Summary:
	// 		Fetching a newly created List in a Board.
	//--------------------------------
	public getList(int statusCode) throws Exception {
	 RestAssured.baseURI = initURL();
     String response = given()
     					.queryParams(keyTokenQueryParams())
     				.when()
     					.get(objTestUtils.initListURLEndpoint("ListEndPoint")+listId)
     				.then()
     					.log().all().statusCode(statusCode).extract().response().asString();
     
     JsonPath json = new JsonPath(response);
		validateAssertions(json.get("id"),listId);
		Assert.assertTrue(listId.matches(objReadingPropertyFile.getProperty("regex")));
		logger.info(organizationId + " matches the regex code");
		
		logger.info("------------------------------------------------");
		logger.info("Extracted list ID matches with the saved list ID in global variable");
		logger.info("------------------------------------------------");
		

	}
}

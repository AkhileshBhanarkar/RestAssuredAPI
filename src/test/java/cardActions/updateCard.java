package cardActions;

import static io.restassured.RestAssured.given;

import org.testng.asserts.SoftAssert;

import TestAllActions.BaseClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class updateCard extends BaseClass {

	//--------------------------------
    // Summary:
	// 		Updating a Created card for previously
	//		created List.
	// Params:
	//		statusCode, name.
	//--------------------------------
	public updateCard(int statusCode,String name) throws Exception {
		RestAssured.baseURI=initURL();
		String res= given()
						.log().all().queryParam("name", name).queryParams(keyTokenQueryParams()).queryParams(updateCardQueryParams())
					.when()
						.put(objTestUtils.initCardURLEndpoint("CardEndPoint")+cardId)
					.then().log().all().statusCode(statusCode).extract().response().asPrettyString();
		
		JsonPath json = new JsonPath(res);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(json.get("name"), name);
		softAssert.assertEquals(json.get("idList"),listId);
		softAssert.assertTrue(json.get("idList").toString().matches(objReadingPropertyFile.getProperty("regex")));
		softAssert.assertEquals(json.get("idBoard"),BoardId);
		softAssert.assertTrue(json.get("idBoard").toString().matches(objReadingPropertyFile.getProperty("regex")));
		
		softAssert.assertAll();
		
		logger.info("------------------------------------------------");
		logger.info("Updates the name of card successfully.");
		logger.info("------------------------------------------------");
		
		
	}
}

package ListActions;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import TestAllActions.BaseClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class updateList extends BaseClass{
	
	//--------------------------------
    // Summary:
	// 		Updating a Created List for a Board.
	// Params:
	//		statusCode, name.
	//--------------------------------
	public updateList(int statusCode,String name) throws Exception {
		RestAssured.baseURI=initURL();
		String res= given()
						.log().all().queryParam("name", name).queryParams("closed", "true").queryParams(keyTokenQueryParams())
					.when()
						.put(objTestUtils.initListURLEndpoint("ListEndPoint")+listId)
					.then().log().all().statusCode(statusCode).extract().response().asPrettyString();
		
		JsonPath json = new JsonPath(res);
		Assert.assertEquals(json.get("name"), name);
		
		logger.info("------------------------------------------------");
		logger.info("Updates the name of List successfully.");
		logger.info("------------------------------------------------");
		
		
	}

}

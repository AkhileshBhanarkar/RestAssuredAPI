package BoardActions;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import TestAllActions.BaseClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class deleteBoard extends BaseClass{
	
	//--------------------------------
    // Summary:
	// 		Deleting a newly created Board.
	// Params:
	//		statusCode.
	//--------------------------------
	public deleteBoard(int statusCode) throws Exception {
		
		RestAssured.baseURI=initURL();
		String res= given()
						.log().all().queryParams(keyTokenQueryParams())
					.when()
						.delete(objTestUtils.initBoardURLEndpoint("BoardEndPoint")+BoardId)
					.then()
						.log().all().statusCode(statusCode).extract().response().asPrettyString();
		
		JsonPath json = new JsonPath(res);
		Assert.assertEquals(json.get("_value"), null);
		
		logger.info("------------------------------------------------");
		logger.info("Deleted Board response gives null values");
		logger.info("------------------------------------------------");
	}
}

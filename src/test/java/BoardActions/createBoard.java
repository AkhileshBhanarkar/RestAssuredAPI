package BoardActions;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import TestAllActions.BaseClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class createBoard extends BaseClass{
	
	//--------------------------------
    // Summary:
	// 		Creating a Board in API.
	// Params:
	//		statusCode, name.
	//--------------------------------
	public createBoard(int statusCode , String name) throws Exception {
		RestAssured.baseURI=initURL();
		String res= given()
						.log().all().queryParam("name", name).queryParams(createBoardQueryParams()).queryParams(keyTokenQueryParams())
						.header("Content-Type",objReadingPropertyFile.getProperty("contentType_header"))
					.when()
						.post(objTestUtils.initBoardURLEndpoint("BoardEndPoint"))
					.then()
						.log().all().statusCode(statusCode).extract().response().asPrettyString();
		
		JsonPath json = new JsonPath(res);
		BoardId=json.get("id");
		extractedURL = json.get("shortUrl");
		Assert.assertEquals(json.get("name"), name);
		
		
		logger.info("------------------------------------------------");
		logger.info("Extracted name matches with given input name");
		logger.info("------------------------------------------------");
	}


}

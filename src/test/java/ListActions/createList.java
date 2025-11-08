package ListActions;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import TestAllActions.BaseClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class createList extends BaseClass{
	
	//--------------------------------
    // Summary:
	// 		Creating a new List in previously
	//		created Board.
	// Params:
	//		statusCode, name.
	//--------------------------------
	public createList(int statusCode ,String name) throws Exception {
	       
        RestAssured.baseURI = initURL();
        String response = given()
        					.queryParam("name", name).queryParams(keyTokenQueryParams()).queryParam("idBoard", BoardId)
        					.header("Content-Type", objReadingPropertyFile.getProperty("contentType_header"))
        				.when()
        					.post(objTestUtils.initListURLEndpoint("ListEndPoint"))
        				.then()
        					.log().all().statusCode(statusCode).extract().response().asPrettyString();

        JsonPath json = new JsonPath(response);
        listId = json.getString("id");
        validateAssertions(json.getString("idBoard"),BoardId);
        Assert.assertTrue(listId.matches(objReadingPropertyFile.getProperty("regex")));
     
    	
		logger.info("------------------------------------------------");
		logger.info("Extracted board is matches with given input board id");
		logger.info("------------------------------------------------");
	}
 }



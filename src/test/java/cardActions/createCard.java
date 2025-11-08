package cardActions;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import TestAllActions.BaseClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class createCard extends BaseClass {
	
	//--------------------------------
    // Summary:
	// 		Creating a new card for previously
	//		created List.
	// Params:
	//		statusCode.
	//--------------------------------
	public  createCard(int statusCode) throws Exception {
	       
        RestAssured.baseURI = initURL();
        String response = given()
        					.queryParams(keyTokenQueryParams()).queryParam("idList", listId).queryParams(createCardQueryParams())
        					.header("Content-Type", objReadingPropertyFile.getProperty("contentType_header"))
        				.when()
        					.post(objTestUtils.initCardURLEndpoint("CardEndPoint"))
        				.then()
        					.log().all().statusCode(statusCode).extract().response().asString();

        JsonPath json = new JsonPath(response);
        cardId = json.getString("id");
        validateAssertions(json.getString("id"),cardId);
        Assert.assertTrue(listId.matches(objReadingPropertyFile.getProperty("regex")));
        
        
		logger.info("------------------------------------------------");
		logger.info("Card Id is in valid regex format");
		logger.info("Created a new Card successfully in Board");
		logger.info("------------------------------------------------");
	}

}

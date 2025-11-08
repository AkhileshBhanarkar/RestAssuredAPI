package BoardActions;

import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import TestAllActions.BaseClass;

public class getBoard extends BaseClass{
	
	//--------------------------------
    // Summary:
	// 		Fetching a newly created Board.
	// Params:
	//		statusCode.
	//--------------------------------
	public  getBoard(int statusCode) throws Exception {
		RestAssured.baseURI=initURL();

		String res= given()
						.queryParams(keyTokenQueryParams()).header("Accept",objReadingPropertyFile.getProperty("accept_header"))
					.when()
						.get(objTestUtils.initBoardURLEndpoint("BoardEndPoint")+BoardId)
					.then()
						.log().all().statusCode(statusCode).extract().response().asPrettyString();
		
		JsonPath json = new JsonPath(res);
		SoftAssert softAssert = new SoftAssert();
		organizationId=json.get("idOrganization");
		softAssert.assertEquals(json.get("id"),BoardId);
		softAssert.assertEquals(json.get("shortUrl"), extractedURL);
		softAssert.assertEquals(json.get("desc"),objReadingPropertyFile.getProperty("txt_desc_create_board"));
		softAssert.assertEquals(json.get("prefs.permissionLevel"),objReadingPropertyFile.getProperty("txt_permission_level_create_board"));
		softAssert.assertEquals(json.get("prefs.voting"),objReadingPropertyFile.getProperty("txt_voting_create_board"));
		softAssert.assertEquals(json.get("prefs.comments"),objReadingPropertyFile.getProperty("txt_comments_create_board"));
		softAssert.assertEquals(json.get("prefs.invitations"),objReadingPropertyFile.getProperty("txt_invitation_create_board"));
		softAssert.assertEquals(json.get("prefs.background"),objReadingPropertyFile.getProperty("txt_background_create_board"));
		softAssert.assertEquals(json.get("prefs.cardAging"),objReadingPropertyFile.getProperty("txt_cardAging_create_board"));
		softAssert.assertTrue(organizationId.matches(objReadingPropertyFile.getProperty("regex")));
		
		softAssert.assertAll();
		
		logger.info(organizationId + " matches the regex code");
		
		logger.info("------------------------------------------------");
		logger.info("Extracted ID matches with the saved ID in global variable");
		logger.info("All the values matches with the values while creating board.");
		logger.info("------------------------------------------------");
		
		
	}
	

 
	
}

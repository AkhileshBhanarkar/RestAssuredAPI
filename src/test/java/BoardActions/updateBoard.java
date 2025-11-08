package BoardActions;

import static io.restassured.RestAssured.given;
import org.testng.asserts.SoftAssert;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestAllActions.BaseClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class updateBoard extends BaseClass{
	
	//--------------------------------
    // Summary:
	// 		Updating a Board.
	// Params:
	//		statusCode, name.
	// 
	//--------------------------------
	public updateBoard(int statusCode,String name) throws Exception {
		RestAssured.baseURI=initURL();
		String res= given()
						.log().all().queryParam("name", name).queryParams(keyTokenQueryParams())//.queryParam("prefs/permissionLevel", "public")
						.queryParams(updateBoardQueryParams()).header("Content-Type","application/json")
					.when()
						.put(objTestUtils.initBoardURLEndpoint("BoardEndPoint")+BoardId)
					.then().log().all().statusCode(statusCode).extract().response().asPrettyString();
		
		JsonPath json = new JsonPath(res);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(json.get("idOrganization"), organizationId);
		softAssert.assertEquals(json.get("shortUrl"), extractedURL);
		softAssert.assertEquals(json.get("name"), name);
		softAssert.assertEquals(json.get("desc"),objReadingPropertyFile.getProperty("txt_desc_update_board"));
		softAssert.assertEquals(json.get("prefs.permissionLevel"),objReadingPropertyFile.getProperty("txt_permission_level_update_board"));
		softAssert.assertEquals(json.get("prefs.voting"),objReadingPropertyFile.getProperty("txt_voting_update_board"));
		softAssert.assertEquals(json.get("prefs.comments"),objReadingPropertyFile.getProperty("txt_comments_update_board"));
		softAssert.assertEquals(json.get("prefs.invitations"),objReadingPropertyFile.getProperty("txt_invitation_update_board"));
		softAssert.assertEquals(json.get("prefs.background"),objReadingPropertyFile.getProperty("txt_background_update_board"));
		softAssert.assertEquals(json.get("prefs.cardAging"),objReadingPropertyFile.getProperty("txt_cardAging_update_board"));
		
		softAssert.assertAll();
		
		logger.info("------------------------------------------------");
		logger.info("Extracted OrganizationID matches with the saved OrganizationID in global variable");
		logger.info("All the values matches with the values after updating board.");
		logger.info("------------------------------------------------");
		
		
	}

}

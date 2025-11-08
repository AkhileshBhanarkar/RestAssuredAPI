package cardActions;

import static io.restassured.RestAssured.given;
import TestAllActions.BaseClass;
import io.restassured.RestAssured;

public class deleteCard extends BaseClass {

	//--------------------------------
    // Summary:
	// 		Deleting a newly created card for previously
	//		created List.
	// Params:
	//		statusCode.
	//--------------------------------
	public deleteCard(int statusCode) throws Exception {
		
		RestAssured.baseURI=initURL();
		String res= given()
						.log().all().queryParams(keyTokenQueryParams())
				.when()
						.delete(objTestUtils.initCardURLEndpoint("CardEndPoint")+cardId)
				.then()
						.log().all().statusCode(statusCode).extract().response().asPrettyString();
		
		
		logger.info("------------------------------------------------");
		logger.info("Deleted a newly created card");
		logger.info("------------------------------------------------");
	}
}

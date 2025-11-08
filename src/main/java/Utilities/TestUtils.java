package Utilities;

import java.util.HashMap;
import java.util.Map;

public class TestUtils {
	
	ReadingPropertyFile readingPropertyFile;
	
	public TestUtils(ReadingPropertyFile readingPropertyFile) {
		this.readingPropertyFile=readingPropertyFile;
	}
	
	//--------------------------------
    // Summary:
	// 		Returns the Board URL endpoint.
	// Params:
	//		Key.
	//--------------------------------
	public String initBoardURLEndpoint(String key) throws Exception {
		return readingPropertyFile.getProperty(key);
	}
	
	//--------------------------------
    // Summary:
	// 		Returns the List URL endpoint.
	// Params:
	//		Key.
	//--------------------------------
	public String initListURLEndpoint(String key) throws Exception {
		return readingPropertyFile.getProperty(key);
	}
	
	//--------------------------------
    // Summary:
	// 		Returns the Card URL endpoint.
	// Params:
	//		Key.
	//--------------------------------
	public String initCardURLEndpoint(String key) throws Exception {
		return readingPropertyFile.getProperty(key);
	}
	
	//--------------------------------
    // Summary:
	// 		Returning stored values for Query Parameters
	// Value:
	//		Key, Token.
	//--------------------------------
	public Map<String, String> queryParameters() {
		
		HashMap <String , String> queryParams = new HashMap<String, String>();
		try {
			queryParams.put("key", readingPropertyFile.getProperty("key"));
			queryParams.put("token", readingPropertyFile.getProperty("token"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return queryParams;
	}
	
	//--------------------------------
    // Summary:
	// 		Returning stored values for
	//		Query Parameters while creating board.
	//--------------------------------
	public Map<String, String> createBoardQueryParams() {
		
		HashMap <String , String> createBoardParams = new HashMap<String, String>();
		try {
			createBoardParams.put("desc", readingPropertyFile.getProperty("txt_desc_create_board"));
			createBoardParams.put("prefs_permissionLevel",readingPropertyFile.getProperty("txt_permission_level_create_board"));
			createBoardParams.put("prefs_voting", readingPropertyFile.getProperty("txt_voting_create_board"));
			createBoardParams.put("prefs_comments", readingPropertyFile.getProperty("txt_comments_create_board"));
			createBoardParams.put("prefs_invitations", readingPropertyFile.getProperty("txt_invitation_create_board"));
			createBoardParams.put("prefs_background", readingPropertyFile.getProperty("txt_background_create_board"));
			createBoardParams.put("prefs_cardAging", readingPropertyFile.getProperty("txt_cardAging_create_board"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return createBoardParams;
	}
	
	//--------------------------------
    // Summary:
	// 		Returning stored values for
	//		Query Parameters while updating board.
	//--------------------------------
	public Map<String, String> updateBoardQueryParams() {
		
		HashMap <String , String> updateBoardParams = new HashMap<String, String>();
		try {
			updateBoardParams.put("desc", readingPropertyFile.getProperty("txt_desc_update_board"));
			updateBoardParams.put("prefs/permissionLevel",readingPropertyFile.getProperty("txt_permission_level_update_board"));
			updateBoardParams.put("prefs/voting", readingPropertyFile.getProperty("txt_voting_update_board"));
			updateBoardParams.put("prefs/comments", readingPropertyFile.getProperty("txt_comments_update_board"));
			updateBoardParams.put("prefs/invitations", readingPropertyFile.getProperty("txt_invitation_update_board"));
			updateBoardParams.put("prefs/background", readingPropertyFile.getProperty("txt_background_update_board"));
			updateBoardParams.put("prefs/cardAging", readingPropertyFile.getProperty("txt_cardAging_update_board"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return updateBoardParams;
	}
	
	//--------------------------------
    // Summary:
	// 		Returning stored values for
	//		Query Parameters while updating card.
	//--------------------------------
	public Map<String, String> updateCardQueryParams() {
		
		HashMap <String , String> updateCardParams = new HashMap<String, String>();
		try {
			updateCardParams.put("desc",readingPropertyFile.getProperty("txt_desc_update_crad"));
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return updateCardParams;
	}
	
	//--------------------------------
    // Summary:
	// 		Returning stored values for
	//		Query Parameters while creating card.
	//--------------------------------
	public Map<String, String> createCardQueryParams() {
		
		HashMap <String , String> createCardParams = new HashMap<String, String>();
		try {
			createCardParams.put("desc",readingPropertyFile.getProperty("txt_desc_create_crad"));
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return createCardParams;
	}
	
}

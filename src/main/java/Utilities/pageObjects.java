package Utilities;

public class pageObjects {
	
	//--------------------------------
	// GLOBAL VARIABLES
	//--------------------------------
	public static String BoardId;
	public static String response;
	public String URLEndpoint;
	public static String organizationId;
	public static String extractedURL;
	public static String listId;
	public static String cardId;

	
	//--------------------------------
	//INSTANCE OF CLASS
	//--------------------------------
	public ReadingPropertyFile objReadingPropertyFile;
	public TestUtils objTestUtils;
	public manageLogs objManageLogs;
	
	public pageObjects() {
		objReadingPropertyFile = new ReadingPropertyFile();
		objTestUtils = new TestUtils(objReadingPropertyFile);
		objManageLogs = new manageLogs();

	}
	 
	
	

}

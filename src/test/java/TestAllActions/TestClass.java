package TestAllActions;

import org.testng.annotations.Test;

import BoardActions.deleteBoard;
import BoardActions.getBoard;
import BoardActions.createBoard;
import BoardActions.updateBoard;
import ListActions.createList;
import ListActions.getList;
import ListActions.updateList;
import Utilities.manageLogs;
import cardActions.createCard;
import cardActions.deleteCard;
import cardActions.getCard;
import cardActions.updateCard;

//--------------------------------
// Summary:
// 		By Clicking on Run All, 
//		all the API request will 
//		execute on 1 click.
//--------------------------------

public class TestClass extends manageLogs{

	public checkPing ping;
	
	public getBoard objGetBoard;
	public createBoard objCreateBoard;
	public updateBoard objUpdateBoard;
	public deleteBoard objDeleteBoard;
	
	public createList objCreateList;
	public getList objGetList;
	public updateList objUpdateList;
	
	public createCard objCreateCard;
	public getCard objGetCard;
	public updateCard objUpdateCard;
	public deleteCard objDeleteCard;
	
	//--------------------------------
    // Summary:
	// 		Checking the ping request 
	//		before executing all other requests.
	//--------------------------------
	@Test(priority=0)
	public void pingCheck() throws Exception {
		ping = new checkPing();
	}
	
	//--------------------------------
    // Summary:
	// 		Execution of "POST" http request 
	//		for Creating a Board.
	//--------------------------------
	@Test(priority=1)
	public void createBoard() throws Exception {
		objCreateBoard = new createBoard(200,"NewBoard");

		logger.info("**** Board created successfully ****");		
	}
	
	//--------------------------------
    // Summary:
	// 		Execution of "GET" http request 
	//		for fetching all the details of Board.
	//--------------------------------
	@Test(priority=2)
	public void getBoard() throws Exception {
		objGetBoard = new getBoard(200);
		
		logger.info("**** Board Fetched successfully ****");
	}
	
	//--------------------------------
    // Summary:
	//		Execution of "POST" http request 
	//		to create a List for previously
	//		created Board.
	//--------------------------------
	@Test(dependsOnMethods = "getBoard")
	public void createList() throws Exception {
		 objCreateList = new createList(200, "NewList");
		 
		 logger.info("**** List for a Board is created successfully ****");
	}
	
	//--------------------------------
    // Summary:
	//		Execution of "GET" http request 
	//		to fetch a List from previously
	//		created Board.
	//--------------------------------
	@Test(dependsOnMethods = "createList")
	public void getList() throws Exception {
		objGetList = new getList(200);
		
		 logger.info("**** List for Board is fetched successfully ****");
	}
	
	//--------------------------------
    // Summary:
	//		Execution of "PUT" http request 
	//		to Update a List.
	//--------------------------------
	@Test(dependsOnMethods = "getList")
	public void updateList() throws Exception {
		 objUpdateList = new updateList(200,"updatedList");
		
		 logger.info("**** List for Board is updated successfully ****");
	}
	
	//--------------------------------
    // Summary:
	//		Execution of "POST" http request 
	//		to create a new Card for previously
	//		created List.
	//--------------------------------
	@Test(dependsOnMethods = "updateList")
	public void createCard() throws Exception {
		 objCreateCard = new createCard(200);
		
		 logger.info("**** Card for New List is created successfully ****");
	}
	
	//--------------------------------
    // Summary:
	//		Execution of "GET" http request 
	//		for fetching all details of newly 
	//		created card for previously created List.
	//--------------------------------
	@Test(dependsOnMethods = "createCard")
	public void getCard() throws Exception {
		 objGetCard = new getCard(200);
		
		 logger.info("**** Card for New List is fetched successfully ****");
	}
	
	//--------------------------------
    // Summary:
	//		Execution of "PUT" http request 
	//		to update a Card for previously
	//		created List.
	//--------------------------------
	@Test(dependsOnMethods = "getCard")
	public void updateCard() throws Exception {
		 objUpdateCard = new updateCard(200,"UpdateACard");
		
		 logger.info("**** Card for New List is updated successfully ****");
	}
	
	
	//--------------------------------
    // Summary:
	//		Execution of "DELETE" http request 
	//		for deleting a new Card for previously
	//		created List.
	//--------------------------------
	@Test(dependsOnMethods = "updateCard")
	public void deleteCard() throws Exception {
		 objDeleteCard = new deleteCard(200);
		
		 logger.info("**** Card for New List is deleted successfully ****");
	}
	
	

	//--------------------------------
    // Summary:
	// 		Execution of "PUT" http request 
	//		as updating particular details of Board.
	//--------------------------------
	@Test(priority=3)
	public void updateBoard() throws Exception {
		objUpdateBoard = new updateBoard(200,"UpdateBoard");
		
		logger.info("**** Board updated successfully ****");
	}
	
	//--------------------------------
    // Summary:
	// 		Execution of "DELETE" http request 
	//		for deleting a newly created Board.
	//--------------------------------
	@Test(priority=4)
	public void deleteBoard() throws Exception {
		objDeleteBoard = new deleteBoard(200);

		logger.info("**** Board deleted successfully ****");
	}

}

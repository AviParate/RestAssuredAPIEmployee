package com.employeeapi.testcases;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.employeeapi.base.TestBase;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
public class TC05_Delete_Employee_Record extends TestBase{

     
	@BeforeClass
	void deleteEmployee() throws InterruptedException
	{
	  logger.info("********Started TC05_Delete_Employee_Record*********"+"\n");
	  response = httpRequest.request(Method.GET,"/employees");
	  
	//First get the JsonPath object instance from the Response interface
	  JsonPath jsonPathEvaluator = response.jsonPath();
	  
	  //JSONObject requestParams = new JSONObject();
	  //httpRequest.body(requestParams.toJSONString());
	  
	//Capture id
	String empID1 = jsonPathEvaluator.get("[0].id");
	response = httpRequest.request(Method.DELETE,"/delete/"+empID1); //Pass ID to delete record
	
	Thread.sleep(5000);
	
	}



	@Test
	void responsebodycheck()
	{       
		logger.info("******** Checking Response Body*********");
		String responsebody = response.getBody().asString();	
		logger.info("Response Body==>"+ "\n"+responsebody+"\n");
		Assert.assertEquals(responsebody.contains("Successfully! Record has been deleted"), true);
	}
	
	@Test
	void statuscodecheck()
	{		        
	    logger.info("******** Checking Status Code*********");
				int statusCode = response.getStatusCode();
				logger.info("Status Code is==>"+statusCode+"\n");
				  
	}
	     	 
	

	@AfterClass
	void tearDown()
	{
		logger.info("********Finished TC05_Delete_Employee_Record*********");
	}
	
}

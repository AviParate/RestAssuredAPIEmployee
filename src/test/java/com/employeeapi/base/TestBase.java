package com.employeeapi.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID="5"; //Hard coded - Input for Get details of Single Employee & update employee
	
	public static Logger logger;
	public String baseURI;
	
	
		
	@BeforeClass
	public void setup(){
		
			logger=Logger.getLogger("EmployeesRestAPI");//added Logger
			PropertyConfigurator.configure("Log4j.properties"); //added logger
			logger.setLevel(Level.DEBUG);	
			RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
			httpRequest = RestAssured.given(); //.contentType(ContentType.JSON);
	}
	
	
	//Response Validations
	public static void checkresponsebody()
	{
	        logger.info("******** Checking Response Body*********");
			String responsebody = response.getBody().asString();
			//JSONObject jsonObject = new JSONObject(responsebody);
			logger.info("Response Body==>"+ "\n"+responsebody+"\n");
			Assert.assertTrue(responsebody!=null);
			
	}



	public static void checkstatuscode()
	{
	        logger.info("******** Checking Status Code*********");
			int statusCode = response.getStatusCode();
			logger.info("Status Code is==>"+statusCode+"\n");
			Assert.assertEquals(statusCode, 200);
			
	}
	
	
	public static void checkstatusline()
	{
	        logger.info("******** Checking Status Line*********");
			String statusline = response.getStatusLine();
			logger.info("Status Line is==>"+statusline+"\n");
			Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}
	
	public static void checkContentType()
	{
		logger.info("***********Checking Content Type**********");
		
		String contentType = response.header("Content-Type");
		logger.info("Content type is ==>" +contentType+"\n");
		Assert.assertEquals(contentType, "application/json");
	}
	
}

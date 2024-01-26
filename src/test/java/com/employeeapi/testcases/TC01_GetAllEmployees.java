package com.employeeapi.testcases;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.employeeapi.base.TestBase;
import io.restassured.http.Method;
public class TC01_GetAllEmployees extends TestBase{

     
	@BeforeClass
	void getAllEmployess() throws InterruptedException
	{
	  logger.info("********Started TC01_GetAllEmployees*********"+"\n");
	  response = httpRequest.request(Method.GET,"/employees");
	  Thread.sleep(5000);
	
	}



	@Test
	void responsebodycheck()
	{       
			TestBase.checkresponsebody();		    
	}
	
	@Test
	void statuscodecheck()
	{		        
			TestBase.checkstatuscode();		    
	}
	  
	@Test
	void statuslinecheck()
	{	        			
		    TestBase.checkstatusline();		    
	}
	  
	@Test
	void contenttypecheck()
	{
		    TestBase.checkContentType();
	}
	    	 
	

	@AfterClass
	void tearDown()
	{
		logger.info("********Finished TC01_GetAllEmployees*********");
	}
	
}

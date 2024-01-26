package com.employeeapi.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.employeeapi.base.TestBase;
import com.employeeapi.utilities.RestUtils;

import io.restassured.http.Method;
public class TC03_PostNewEmployee extends TestBase{

	
	String empName = RestUtils.empName();
	String empSalary = RestUtils.empSalary();
	String empAge = RestUtils.empAge();
     
	@BeforeClass
	void postNewEmployee() throws InterruptedException
	{
	  logger.info("********Started TC03_PostNewEmployee*********"+"\n");
	  
	  JSONObject requestParams = new JSONObject();
	  requestParams.put("employee_name",empName);
	  requestParams.put("employee_salary",empSalary);
	  requestParams.put("employee_age", empAge);
	  
	  httpRequest.body(requestParams.toJSONString());
	  response = httpRequest.request(Method.POST,"/create");
	  
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
	    
/*	@Test
	void checkresponsebodypost()
	{
	       	String responsebody = response.getBody().asString();
			Assert.assertEquals(responsebody.contains(empSalary), true);
			Assert.assertEquals(responsebody.contains(empName), true);
			Assert.assertEquals(responsebody.contains(empAge), true);
						
	}*/

	@AfterClass
	void tearDown()
	{
		logger.info("********Finished TC03_PostNewEmployee*********");
	}
	
}

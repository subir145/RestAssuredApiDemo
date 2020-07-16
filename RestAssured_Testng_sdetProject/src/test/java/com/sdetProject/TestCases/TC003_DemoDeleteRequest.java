package com.sdetProject.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sdetProject.Generics.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC003_DemoDeleteRequest extends TestBase {
	
	@BeforeClass
	public void GetAllEmployees() throws InterruptedException
	{
		logger.info("------started TC001 Get All Employees-------");
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="/api/users?page=2";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET);
		//First get the JsonPath object instance from the Response Interface
		JsonPath JsonPathEvaluator=response.jsonPath();
		
		//Capture Id
		String empID=JsonPathEvaluator.get("[0].id");
		response=httpRequest.request(Method.DELETE);
		
		Thread.sleep(3000);
	}
	
	@Test
	public void CheckResponseBody()
	{
		logger.info("-----Checking Response Body--------");
		String responseBody=response.getBody().asString();
		logger.info("The response Body is :"+ responseBody);
		Assert.assertTrue(responseBody!=null);
	}
	
	@Test
	public void CheckStatusCode()
	{
		logger.info("------Checking status code------------");
		int Statuscode = response.getStatusCode();
		logger.info("The status code is :" + Statuscode );
		Assert.assertEquals(Statuscode, 204);
		
	}
	
//	@Test
//	public void CheckResponseTime()
//	{
//		logger.info("--------Checking Response Time-----------");
//		long ResponseTime=response.getTime();  //Getting Status Line
//		logger.info("Response time is :" + ResponseTime);
//		
//		if(ResponseTime>2000)
//			logger.info("Response Time is greater then 2000");
//		
//		Assert.assertTrue(ResponseTime<2000);
//	}
//	
//	@Test
//	public void CheckStatusLine()
//	{
//		logger.info("-------Checking Status Line-----");
//		String statusLine=response.getStatusLine();
//		logger.info("Status Line is :"+ statusLine);
//		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
//	}
//	
//	@Test
//	public void CheckContentType()
//	{
//		logger.info("---------checking Content Type-------");
//		String ContentType=response.header("Content-Type");
//		logger.info("Content type is :" + ContentType);
//		Assert.assertEquals(ContentType, "text/html; charset=UTF-8");
//	}
//	
//	@Test
//	public void CheckServerType()
//	{
//		logger.info("---------checking Server Type-------");
//		String ServerType=response.header("Server");
//		logger.info("Content type is :" + ServerType);
//		Assert.assertEquals(ServerType, "nginx/1.14.1");
//	}
//	
//	@Test
//	public void CheckContentEncoding()
//	{
//		logger.info("---------checking Content Encoding------");
//		String contentEncoding=response.header("Content-Encoding");
//		logger.info("Content type is :" + contentEncoding);
//		Assert.assertEquals(contentEncoding, "gzip");
//	}
//	
//	@Test
//	public void CheckContentLength()
//	{
//		logger.info("---------checking Content Length------");
//		String contentLength=response.header("Content-Length");
//		logger.info("Content type is :" + contentLength);
//		if(Integer.parseInt(contentLength)<100)
//			logger.warn("content length is less than 100");
//		
//	  Assert.assertTrue(Integer.parseInt(contentLength)>100);
//				
//			
//	}
	
	@AfterClass
	public void tearDown()
	{
		logger.info("----------Finished TC001_GetAllEmployees--------");
	}
	
	
	

}

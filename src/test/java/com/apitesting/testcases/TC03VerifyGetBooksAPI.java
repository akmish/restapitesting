package com.apitesting.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.apitesting.base.TestBase;

import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class TC03VerifyGetBooksAPI extends TestBase {
	
	@BeforeClass
	public void getBooksAPI() throws InterruptedException {
		//logger.info("++++++++++++++++ Test getBooksAPI Execution started ++++++++++++++++++");
		baseURI = "https://demoqa.com/BookStore/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/Books");
		Thread.sleep(3000);
	}
	
	@Test
	public void checkResponseBody() {
		logger.info("++++++++++++++++ Test response body ++++++++++++++++++");
		String ResponseBody = response.getBody().asString();
		logger.info("Response Body --> " + ResponseBody);
		Assert.assertTrue(ResponseBody != null);
	}
	
	@Test
	public void checkStatusCode() {
		logger.info("++++++++++++++++ Test Status Code ++++++++++++++++++");
		int StatusCode = response.getStatusCode();
		logger.info("Status Code --> " + StatusCode);
		Assert.assertEquals(StatusCode, 200);
	}
	
	@AfterClass
	public void TearDown() {
		logger.info("++++++++++++++++ Test getBooksAPI Execution finished ++++++++++++++++++");
	}

}

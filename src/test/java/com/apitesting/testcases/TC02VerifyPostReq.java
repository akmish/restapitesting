package com.apitesting.testcases;

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


public class TC02VerifyPostReq {
	
	static String Token;
	
	@Test
	public void verifyPostGenerateTokenAPI() {
		
		baseURI = "https://demoqa.com/Account/v1";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject reqParam = new JSONObject();
		
		reqParam.put("userName", "TOOLSQA-Test");
		reqParam.put("password", "Test@123");
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(reqParam.toJSONString());
		
		Response response = httpRequest.request(Method.POST, "/GenerateToken");
		
		String responseBody = response.body().asString();

		System.out.println(responseBody);

		Token = response.jsonPath().get("token");
		String status = response.jsonPath().get("status");
		Assert.assertEquals(status, "Success");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

	}

}

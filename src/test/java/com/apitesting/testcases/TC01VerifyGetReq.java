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

public class TC01VerifyGetReq {

	@Test
	public void verifyGetAllBooksAPI() {

		baseURI = "https://demoqa.com/BookStore/v1";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "/Books");

		String responseBody = response.body().asString();

		System.out.println(responseBody);

		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);	

	}
}

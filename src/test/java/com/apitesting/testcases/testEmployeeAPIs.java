package com.apitesting.testcases;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class testEmployeeAPIs extends DataProviderForAPITest{
	
	@Test(dataProvider = "SampleGetData")
	public void verifyGetRequestWithParams(int userID) {
		
		baseURI = "http://localhost:3000";
		
		given().
			param("Band", "7").
			get("/Employee/"+userID).
		then().
			body("id", equalTo(userID)).
			log().body(true);
	}
	
	// @Test(dataProvider = "SamplePostData")
	public void verifyPostRequestWithParams(String Fname, String Lname, String DoJ, int DepartmentID, int Band) {
		
		JSONObject req = new JSONObject();
		req.put("Fname", Fname);
		req.put("Lname", Lname);
		req.put("DoJ", DoJ);
		req.put("DepartmentID", DepartmentID);
		req.put("Band", Band);
		
		baseURI = "http://localhost:3000";
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
		when().
			post("/Employee").
		then().
			statusCode(201).
			log().body();
	}
	
	// @Test
	public void verifyPutRequestWithParams() {
		
		JSONObject req = new JSONObject();
		req.put("Fname", "Kevin");
		req.put("Lname", "Hart");
		req.put("DoJ", "18/12/2016");
		req.put("DepartmentID", 16);
		req.put("Band", 4);
		
		baseURI = "http://localhost:3000";
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
		when().
			put("Employee/7259").
		then().
			statusCode(200).
			log().body();
	}
	
	// @Test
	public void verifyPatchRequestWithParams() {
		
		JSONObject req = new JSONObject();
		req.put("Fname", "Kevin");
		req.put("Lname", "Hart");
		req.put("DoJ", "18/12/2016");
		req.put("DepartmentID", 16);
		req.put("Band", 5);
		
		baseURI = "http://localhost:3000";
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
		when().
			patch("Employee/7259").
		then().
			statusCode(200).
			log().body();
	}
	
	// @Test(dataProvider = "SampleDeleteData")
	public void verifyDeleteRequestWithParams(int userID) {
		
		baseURI = "http://localhost:3000";
		
		when().
			delete("/Employee/"+userID).
		then().
			statusCode(200).
			log().all();
	}
}

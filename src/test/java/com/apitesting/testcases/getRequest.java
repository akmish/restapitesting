package com.apitesting.testcases;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class getRequest {
	
	@Test
	void test_01() {
		Response res = get("https://reqres.in/api/users?page=2");
		
		System.out.println(res.asString());
		System.out.println(res.getBody().asString());
		System.out.println(res.getStatusCode());
		System.out.println(res.getSessionId());
		System.out.println(res.getContentType());
		
		int statusCode = res.getStatusCode();
		AssertJUnit.assertEquals(statusCode, 200);
	}
	
	@Test
	void test_02() {
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data.id[0]", equalTo(7));
	}

}

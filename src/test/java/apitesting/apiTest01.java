package apitesting;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class apiTest01 {

	@Test
	void testPost() {

		//		Map<String, Object> map = new HashMap<String, Object>();
		//		map.put("name", "Akshat");
		//		map.put("job","Software");
		//
		//		JSONObject req = new JSONObject(map);

		JSONObject req = new JSONObject();
		req.put("name", "Akshat");
		req.put("job","Software");

		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
		when().
			post("https://reqres.in/api/users").
		then().
			statusCode(201).
			log().all();
	}

	@Test
	void testPut() {

		//		Map<String, Object> map = new HashMap<String, Object>();
		//		map.put("name", "Akshat");
		//		map.put("job","Software");
		//
		//		JSONObject req = new JSONObject(map);

		JSONObject req = new JSONObject();
		req.put("name", "Akki");
		req.put("job","Software Engineer");

		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
		when().
			put("https://reqres.in/api/users/7").
		then().
			statusCode(200).
			log().body();
	}

	@Test
	void testPatch() {

		//		Map<String, Object> map = new HashMap<String, Object>();
		//		map.put("name", "Akshat");
		//		map.put("job","Software");
		//
		//		JSONObject req = new JSONObject(map);

		JSONObject req = new JSONObject();
		req.put("name", "Akku");
		req.put("job","Software Engineer");
		req.put("id", "7");

		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
		when().
			patch("https://reqres.in/api/users/7").
		then().
			statusCode(200).
			log().cookies();
	}
	
	@Test
	void testDelete() {

		JSONObject req = new JSONObject();
		req.put("name", "Akku");
		req.put("job","Software Engineer");
		req.put("id", "7");

		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			delete("https://reqres.in/api/users/2").
		then().
			statusCode(204).
			log().ifError();
	}

	@Test 
	void testVerifyPatch() { 
		given().
			get("https://reqres.in/api/users?page=2").
		then().
			statusCode(200).
			body("data.id[0]", equalTo(7)).
			log().ifValidationFails();
	}
}
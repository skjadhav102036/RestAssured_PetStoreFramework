package api.endpoints;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.*;
import io.restassured.response.*;

import api.endpoints.Routes;
import api.payload.User;

//This class will have implementation of the CRUD methods

public class UserEndPoints {

	public static Response CreateUser(User payload) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Routes.post_url);
		return response;
	}

	public static Response ReadUser(String userName) {

		Response response = given()
				.pathParam("username", userName)
				.when().get(Routes.get_url);
		return response;
	}
	
	
	public static Response updateUser(String userName,User payload) {

		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
				.when()
				.put(Routes.update_url);
		return response;
	}
	
	public static Response deleteUser (String userName) {
		 
		Response response=given()
				.pathParam("username", userName)
				.when()
				.delete(Routes.delete_url);
		return response;
	}
	
	

}

package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User UserPayload;

	@BeforeClass
	public void setupdata() {
		faker = new Faker();
		UserPayload = new User();
		UserPayload.setId(faker.idNumber().hashCode());
		UserPayload.setUsername(faker.name().firstName());
		UserPayload.setLastName(faker.name().lastName());
		UserPayload.setEmail(faker.internet().emailAddress());
		UserPayload.setPassword(faker.internet().password());
		UserPayload.setPhone(faker.phoneNumber().cellPhone());
	}

	@Test(priority = 1, testName = "createUser")
	public void testPostUser() {
		Response response = UserEndPoints.CreateUser(this.UserPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("create user done");

	}

	@Test(priority = 2, testName = "get user")
	public void testGetUserbyName() {
		Response response = UserEndPoints.ReadUser(this.UserPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("get user done");
	}

	@Test(priority = 3, testName = "update user")
	public void testUpdateUserbyName() {
		// update data using payload
		UserPayload.setUsername(faker.name().firstName());
		UserPayload.setLastName(faker.name().lastName());
		UserPayload.setEmail(faker.internet().emailAddress());

		Response response = UserEndPoints.updateUser(this.UserPayload.getUsername(), this.UserPayload);
		response.then().log().all();
		response.then().log().body().statusCode(200);// chai assertion
		Assert.assertEquals(response.getStatusCode(), 200); // test ng assertion
		System.out.println("update user done");

	}

	@Test(priority = 4, testName = "delete user ")
	public void deleteUserByName() {
		Response response = UserEndPoints.deleteUser(this.UserPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().log().all();
		System.out.println("delete user ok ");

	}

}

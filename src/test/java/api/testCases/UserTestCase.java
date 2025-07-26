package api.testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endPoints.UserEndPoints;
import api.payLoad.User;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import junit.framework.Assert;

public class UserTestCase {

	Faker faker;
	User userPayload;

	@BeforeTest
	public void generateTestData() {
		faker = new Faker();
		userPayload = new User();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		userPayload.setUsername(faker.number().digit());
	}

	@Test(priority = 1)
	public void postTestCase() {
		Response response = UserEndPoints.createUser(userPayload);
		System.out.println("Create user");
		response.then().log().all();
		int resCode = response.getStatusCode();
		Assert.assertEquals(resCode, 200);
		System.out.println("===============");

	}

	@Test(priority = 2)
	public void getUserTestCase() {
		Response response = UserEndPoints.getUser(this.userPayload.getUsername());
		System.out.println("Get user");
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("===============");
	}

	@Test(priority = 3)
	public void updateUserTestCase() {
		userPayload.setFirstName(faker.name().firstName());
		Response response = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		System.out.println("update user");
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

		System.out.println("updated users list");
		

		System.out.println("===============");
	}

	@Test(priority = 4)
	public void deleteUserTestCase() {
		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
		System.out.println("delete user");
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("===============");
	}
}

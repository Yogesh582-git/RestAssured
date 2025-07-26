package api.testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endPoints.UserEndPoints;
import api.payLoad.User;
import api.utilities.dataProvider1;
import io.restassured.response.Response;
import junit.framework.Assert;

public class UserTestDD {
	User userPayload;

	@Test(priority = 1, dataProvider = "data_book1", dataProviderClass = dataProvider1.class)
	public void createUser(String id, String username, String firstName, String lastName, String email, String password,
			String phone, String userStatus) {
		userPayload = new User();

		userPayload.setId((int) Double.parseDouble(id));
		userPayload.setUsername(username);
		userPayload.setFirstName(firstName);
		userPayload.setLastName(lastName);
		userPayload.setEmail(email);
		userPayload.setPassword(password);
		userPayload.setPhone(phone);
		userPayload.setUsername(userStatus);
		Response response = UserEndPoints.createUser(userPayload);
		System.out.println("Create user");
		response.then().log().all();
		int resCode = response.getStatusCode();
		Assert.assertEquals(resCode, 200);
		System.out.println("===============");

	}
	
	@Test(priority = 2,dataProvider = "data_book1_user", dataProviderClass = dataProvider1.class)
	public void getUserTestCase(String username) {
		Response response = UserEndPoints.getUser(username);
		System.out.println("Get user");
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("===============");
	}

}

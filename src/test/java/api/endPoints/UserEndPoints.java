package api.endPoints;

import api.payLoad.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndPoints {
	
	public static Response createUser(User payload) {
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routers.post_url);
		return response;
	}
	
	public static Response getUser(String username) {
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("username", username)
		.when()
		.get(Routers.get_url);
		return response;
	}
	
	public static Response updateUser(String username,User payload) {
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("username", username)
		.body(payload)
		.when()
		.put(Routers.put_url);
		return response;
	}
	
	public static Response deleteUser(String username) {
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("username", username)
		.when()
		.delete(Routers.del_url);
		return response;
	}


	
}

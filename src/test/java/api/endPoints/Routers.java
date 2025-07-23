package api.endPoints;

public interface Routers {
//	post  : https://petstore.swagger.io/v2/user
//	get	  : https://petstore.swagger.io/v2/user/username
//  put   : https://petstore.swagger.io/v2/user/username
//  delete: https://petstore.swagger.io/v2/user/username

	String base_url = "https://petstore.swagger.io/v2";
	String post_url = base_url + "/user";
	String get_url = base_url + "/user/{username}";
	String put_url = base_url + "/user/{username}";
	String del_url = base_url + "/user/{username}";

}

package api.endPoints;

public class  Routers {
//	post  : https://petstore.swagger.io/v2/user
//	get	  : https://petstore.swagger.io/v2/user/username
//  put   : https://petstore.swagger.io/v2/user/username
//  delete: https://petstore.swagger.io/v2/user/username

	private static String base_url = "https://petstore.swagger.io/v2";
	private static String post_url = base_url + "/user";
	private static String get_url = base_url + "/user/{username}";
	private static String put_url = base_url + "/user/{username}";
	private static String del_url = base_url + "/user/{username}";

}

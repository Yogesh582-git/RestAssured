package api.endPoints;

public class Routers {
//	post  : https://petstore.swagger.io/v2/user
//	get	  : https://petstore.swagger.io/v2/user/username
//  put   : https://petstore.swagger.io/v2/user/username
//  delete: https://petstore.swagger.io/v2/user/username
	
	
	public static String base_url="https://petstore.swagger.io/v2";
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String put_url=base_url+"/user/{username}";
	public static String del_url=base_url+"/user/{username}";
		

}

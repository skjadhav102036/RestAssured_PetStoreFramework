package api.endpoints;

//here we only only maintain urls

//https://petstore.swagger.io/    --- from this we are automating user module

public class Routes {

	public static String base_url = "https://petstore.swagger.io/v2";
	
	// user module
	public static String post_url = base_url + "/user";
	public static String get_url = base_url +"/user/{username}";
	public static String update_url=base_url +"/user/{username}";
	public static String delete_url = base_url + "/user/{username}";
	
	
	// Store module 
	
		//here you will create store module url's
	
	//Pet module 
		// here you will create pet module URL's
	
	

}

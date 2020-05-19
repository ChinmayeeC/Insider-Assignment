import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_MoviePosterURL {

	
	
	@Test
	void MoviePosterURL()
	{
		//Specify Base URI
		
		RestAssured.baseURI = "https://apiproxy.paytm.com/v2/movies";
	
		//Request Object
		RequestSpecification request=RestAssured.given();
		
		//Response Object
		Response response=request.request(Method.GET,"/upcoming");
		
		//Print Response
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" +responseBody);
		
		Assert.assertNotEquals(responseBody.contains(".jpg"), false);
		
		
}
}
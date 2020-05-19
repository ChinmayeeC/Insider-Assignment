import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class TC002_MovieReleaseDate {
	
	

	@Test
	void MovieReleaseDate()
	{
		//Specify Base URI
		
		RestAssured.baseURI = "https://apiproxy.paytm.com";
	
		//Request Object
		RequestSpecification request=RestAssured.given();
		
		//Response Object
		Response response=request.request(Method.GET,"/v2/movies/upcoming");
		
		//Print Response
		String responseBody = response.getBody().asString();
		
	
		JsonPath jsonpath=response.jsonPath() ; 
	
		
		System.out.println(jsonpath.get("releaseDate"));
		Assert.assertEquals(responseBody.contains("releaseDate"), true);
        
		
		
	}	

}

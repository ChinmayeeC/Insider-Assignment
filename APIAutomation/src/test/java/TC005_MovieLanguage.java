	import org.testng.Assert;
	import org.testng.annotations.Test;

	import io.restassured.RestAssured;
	import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;

	public class TC005_MovieLanguage {
		

		@Test
		void CheckStatusCode()
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
			
			JsonPath jsonpath=response.jsonPath() ; 
			
			
			System.out.println(jsonpath.get("language"));
			Assert.assertEquals(responseBody.contains("language"), true);
			
					
			
			
		}
		
		
		
		
	}




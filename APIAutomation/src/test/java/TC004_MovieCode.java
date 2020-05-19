import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TC004_MovieCode {

	@Test
	void MovieCode()
	{
	
	given()
	
	.when()
	    .get("https://apiproxy.paytm.com/v2/movies/upcoming")
	    
	.then()
	    .statusCode(200)
	    .body("movie_name", equalTo("Radhe"))
	    .body("contentId", equalTo("135344"));
	}

}

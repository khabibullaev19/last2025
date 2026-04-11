package techproedapi.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import techproedapi.mains.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertTrue;

public class GetRequest07 extends TestBase{
    /*
       When
           I send a GET Request to REST API URL
           https://jsonplaceholder.typicode.com/todos/123
       Then
           HTTP Status Code should be 200
           And "Server" in Headers should be "cloudflare"
           And response content type is "application/JSON"
           And "userId" should be 7,
           And "title" should be "esse et quis iste est earum aut impedit"
           And "completed" should be false
     */

    /*
        After the Base URL if you type something together with "/" like "/123" it is called
        "path parameter". Path param makes the source small.
     */

    @Test
    public void get01(){
        spec01.pathParam("id",123);

        Response response = given().
                            spec(spec01).
                            when().
                               get("/{id}");

        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("userId", equalTo(7),
                        "title",equalTo("esse et quis iste est earum aut impedit"),
                        "completed",equalTo(false));

        assertTrue(response.getHeader("Server").equals("cloudflare"));
    }
}

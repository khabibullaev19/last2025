package techproedapi.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GetRequest02 {

    /*
        When I send a GET Request to https://restful-booker.herokuapp.com/booking,
        and I accept "application/json"  ==> Means API is accepting data just in Json Format
        then status code should be 200
        and content type should be "application/json" ==> Response must be in Json Format
     */

    @Test
    public void getMethod02(){
        Response response = given().
                               accept(ContentType.JSON).
                            when().
                               get("https://restful-booker.herokuapp.com/booking");
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);
    }

    /*
        When I send a GET Request to "https://restful-booker.herokuapp.com/booking/5"
        Then status code should be 200
        And content type should be "application/json"
     */
    @Test
    public void testCase01(){
        Response response = given().when().get("https://restful-booker.herokuapp.com/booking/5");
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
    }

    @Test
    public void testCase02(){
        Response response = given().
                            when().
                                   get("https://restful-booker.herokuapp.com/booking/1001");
        response.prettyPrint();
        response.then().assertThat().statusCode(404);
        assertTrue(response.asString().contains("Not Found"));
        assertFalse(response.asString().contains("Suleyman"));
    }

}

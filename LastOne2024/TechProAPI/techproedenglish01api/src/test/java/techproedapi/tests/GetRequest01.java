package techproedapi.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {
    @Test
    public void getMethod01(){
        Response response = given().
                            when().
                                get("https://restful-booker.herokuapp.com/booking");
        //To see response body on the console use prettyPrint() method
        response.prettyPrint();

        //To see status code on the console use getStatusCode() or statusCode()
        System.out.println(response.getStatusCode());

        //To assert status code
        //Assert the format of response body, it should be in Json format
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);//"application/json" is also possible
    }

    @Test
    public void getMethod2(){
        Response response = given().
                            when().
                               get("https://restful-booker.herokuapp.com/booking/3");
        System.out.println(response.statusCode());
        response.prettyPrint();
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json");
    }
}

package techproedapi.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest05 {
    /*
        When I send a GET Request to REST API URL
        https://restful-booker.herokuapp.com/booking/1
        And Accept type is "application/JSON"
        Then
        HTTP Status Code should be 200
        And Response format should be "application/JSON"
        And first name should be "Susan"
        And lastname should be "Brown"
        And check-in date should be "2015-02-16"
        And checkout date should be "2017-06-20"
     */
    @Test
    public void get01(){
        Response response = given().
                               //accept(ContentType.JSON).
                            when().
                               get("https://restful-booker.herokuapp.com/booking/1");

        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", equalTo("Eric")).
                body("lastname", equalTo("Ericsson")).
                body("totalprice", equalTo(799)).
                body("depositpaid", equalTo(false)).
                body("bookingdates.checkin", equalTo("2021-03-06")).
                body("bookingdates.checkout", equalTo("2021-11-17"));
    }

    @Test
    public void get02(){
        Response response = given().
                //accept(ContentType.JSON).
                        when().
                get("https://restful-booker.herokuapp.com/booking/1");

        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", equalTo("Eric"),
                        "lastname", equalTo("Ericsson"),
                        "totalprice", equalTo(799),
                        "depositpaid", equalTo(false),
                        "bookingdates.checkin", equalTo("2021-03-06"),
                        "bookingdates.checkout", equalTo("2021-11-17"));

    }

}

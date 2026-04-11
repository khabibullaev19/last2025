package techproedapi.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import techproedapi.mains.TestBase;

import static io.restassured.RestAssured.given;

public class GetReq01 extends TestBase {

    /*
       When
            I send GET Request to REST API URL
            https://restful-booker.herokuapp.com/booking/5
       Then
           HTTP Status Code should be 200
           And response content type is "application/JSON"
           And response body should be like;
           {
            "firstname": "Sally",
            "lastname": "Ericsson",
            "totalprice": 111,
            "depositpaid": false,
            "bookingdates": {"checkin": "2017-05-23",
                             "checkout": "2019-07-02"}
             }
     */

    /*
       JSONPATH: JsonPath is used to navigate in Json data
     */

    @Test
    public void getMethod() {
        spec08.pathParam("bookingid",5);

        Response response = given().
                //accept(ContentType.JSON).
                            spec(spec08).
                            when().
                            get("/{bookingid}");

        response.prettyPrint();
        //System.out.println(response.getStatusCode());
    }

}

package techproedapi.tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproedapi.mains.TestBase;

import static io.restassured.RestAssured.*;

public class GetRequest10 extends TestBase {
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
    public void get01(){
        spec02.pathParam("bookingid",5);
        Response response = given().
                               spec(spec02).
                            when().
                               get("/{bookingid}");
        response.prettyPrint();

        JsonPath json = response.jsonPath();
        SoftAssert sf = new SoftAssert();

        // Print the firstname on the console
        System.out.println(json.getString("firstname"));
        sf.assertEquals(json.getString("firstname"),"Sally");

        // Print the last name on the console
        System.out.println(json.getString("lastname"));
        sf.assertEquals(json.getString("lastname"),"Wilson");

        // Print the totalprice on the console
        System.out.println(json.getInt("totalprice"));
        sf.assertEquals(json.getInt("totalprice"),602);

        // Print the depositpaid on the console
        System.out.println(json.getBoolean("depositpaid"));
        sf.assertEquals(json.getBoolean("depositpaid"),true);

        // Print the checkin on the console
        System.out.println(json.getString("bookingdates.checkin"));
        sf.assertEquals(json.getString("bookingdates.checkin"),"2020-03-09");

        // Print the checkout on the console
        System.out.println(json.getString("bookingdates.checkout"));
        sf.assertEquals(json.getString("bookingdates.checkout"),"2021-03-18");

        sf.assertAll();
    }
}

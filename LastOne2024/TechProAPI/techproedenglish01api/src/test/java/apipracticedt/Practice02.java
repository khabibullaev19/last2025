package apipracticedt;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproedapi.mains.TestBase;
import techproedapi.utilities.JsonUtil;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Practice02 extends TestBase {
    /*
       When
           I send GET Request to REST API URL
           https://restful-booker.herokuapp.com/booking/1
       Then
           HTTP Status Code should be 200
           And Response format should be "application/JSON"
           And first name should be "Sally"
           And lastname should be "Smith"
           And totalprice should be 705
           And checkin date should be "2015-02-16"
           And checkout date should be "2017-06-20"

           NOTE: For Base URL use spec02
           NOTE: For actual data use JsonPath
           NOTE: For expected data use Map
           NOTE: Use Hard Assertion and Soft Assertion
     */
    @Test
    public void getPractice(){
        spec02.pathParam("id",1);

        JSONObject expectedData = new JSONObject();
        expectedData.put("statuscode",200);
        expectedData.put("firstname","Sally");
        expectedData.put("lastname","Wilson");
        expectedData.put("totalprice",884);
        expectedData.put("checkin","2016-02-17");
        expectedData.put("checkout","2021-07-25");
        System.out.println(expectedData);

        Response response = given().
                               spec(spec02).
                            when().
                               get("/{id}");
        response.prettyPrint();

        // Assertion by using body()
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", equalTo(expectedData.getString("firstname")),
                        "lastname",equalTo(expectedData.getString("lastname")),
                        "totalprice",equalTo(expectedData.getInt("totalprice")),
                        "bookingdates.checkin",equalTo(expectedData.getString("checkin")),
                        "bookingdates.checkout",equalTo(expectedData.getString("checkout")));

        // Assertion by using assertEquals(), assertTrue(), assertFalse()

        // To Get actual data from response body, you can use JsonPath
        JsonPath json = response.jsonPath();

        assertEquals(expectedData.getInt("statuscode"),response.getStatusCode());
        assertEquals(expectedData.getString("firstname"),json.getString("firstname"));
        assertEquals(expectedData.getString("lastname"),json.getString("lastname"));
        assertEquals(expectedData.getInt("totalprice"),json.getInt("totalprice"));
        assertEquals(expectedData.getString("checkin"),json.getString("bookingdates.checkin"));
        assertEquals(expectedData.getString("checkout"),json.getString("bookingdates.checkout"));


        // Use De-Serialization with GSON
        //Map<String, Object> booking = response.as(HashMap.class);

        // Use De-Serialization with ObjectMapper
        Map<String, Object> booking = JsonUtil.convertJsonToJava(response.asString(), HashMap.class);
        assertEquals(expectedData.getInt("statuscode"),response.getStatusCode());
        assertEquals(expectedData.getString("firstname"),booking.get("firstname"));
        assertEquals(expectedData.getString("lastname"),booking.get("lastname"));
        assertEquals(expectedData.getInt("totalprice"),booking.get("totalprice"));
        assertTrue(booking.get("bookingdates").toString().contains(expectedData.getString("checkin")));
        assertTrue(booking.get("bookingdates").toString().contains(expectedData.getString("checkout")));

        // asString() is used to convert Response objects to String
        // toString() is used to convert Object objects to String

                 // Soft Assertion

        SoftAssert softAssert = new SoftAssert();

        // To Get actual data from response body, you can use JsonPath
        softAssert.assertEquals(json.getString("firstname"),expectedData.getString("firstname"));
        softAssert.assertEquals(json.getString("lastname"),expectedData.getString("lastname"));
        softAssert.assertEquals(json.getInt("totalprice"),expectedData.getInt("totalprice"));
        softAssert.assertEquals(json.getString("bookingdates.checkin"),expectedData.getString("checkin"));
        softAssert.assertEquals(json.getString("bookingdates.checkout"),expectedData.getString("checkout"));

        // Use De-Serialization with ObjectMapper
        softAssert.assertEquals(booking.get("firstname"),expectedData.getString("firstname"));
        softAssert.assertEquals(booking.get("lastname"),expectedData.getString("lastname"));
        softAssert.assertEquals(booking.get("totalprice"),expectedData.getInt("totalprice"));
        softAssert.assertTrue(booking.get("bookingdates").toString().contains(expectedData.getString("checkin")));
        softAssert.assertTrue(booking.get("bookingdates").toString().contains(expectedData.getString("checkout")));

        softAssert.assertAll();

    }
}

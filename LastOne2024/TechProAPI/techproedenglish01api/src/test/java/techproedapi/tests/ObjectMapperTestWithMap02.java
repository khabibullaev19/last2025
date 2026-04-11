package techproedapi.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproedapi.mains.TestBase;
import techproedapi.utilities.JsonUtil;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ObjectMapperTestWithMap02 extends TestBase {
    /*
       When
           I send GET Request to REST API URL
           https://restful-booker.herokuapp.com/booking/5
       Then
           HTTP Status Code should be 200
           And Response Content Type is "application/json"
           And Response Body should be like:
           {
            "firstname":"Sally"
            "lastname":"Ericsson"
            "totalprice": 111,
            "depositpaid": false,
            "bookingdates":
                    {
                     "checkin": "2017-05-23"
                     "checkout": "2019-07-02"
                     }
            }
     */
    @Test
    public void jsonFromApiToJava(){
        // 1. Set the URL
        spec02.pathParam("id",5);

        // 2. Put the expected values into Java Object(Map)
        Map<String,Object> expectedMap = new HashMap<>();
        expectedMap.put("firstname","Susan");
        expectedMap.put("lastname","Jackson");
        expectedMap.put("totalprice",525);
        expectedMap.put("depositpaid",false);
        expectedMap.put("checkin","2015-09-01");
        expectedMap.put("checkout","2020-06-13");

        // 3. Get the actual data as a Map
        Response response = given().
                               spec(spec02).
                            when().
                               get("/{id}");
        response.prettyPrint();

        Map<String,Object> actualMap = JsonUtil.convertJsonToJava(response.asString(),HashMap.class);
        System.out.println(actualMap);

        // 4. Start Assertion (Hard Assertion)
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);
        assertEquals(expectedMap.get("firstname"),actualMap.get("firstname"));
        assertEquals(expectedMap.get("lastname"),actualMap.get("lastname"));
        assertEquals(expectedMap.get("totalprice"),actualMap.get("totalprice"));
        assertEquals(expectedMap.get("depositpaid"),actualMap.get("depositpaid"));
        assertTrue(actualMap.get("bookingdates").toString().contains(expectedMap.get("checkin").toString()));
        assertTrue(actualMap.get("bookingdates").toString().contains(expectedMap.get("checkout").toString()));

        // 5. Start Assertion (Soft Assertion)
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualMap.get("firstname"),expectedMap.get("firstname"));
        softAssert.assertEquals(actualMap.get("lastname"),expectedMap.get("lastname"));
        softAssert.assertEquals(actualMap.get("totalprice"),expectedMap.get("totalprice"));
        softAssert.assertEquals(actualMap.get("depositpaid"),expectedMap.get("depositpaid"));
        softAssert.assertTrue(actualMap.get("bookingdates").toString().contains(expectedMap.get("checkin").toString()));
        softAssert.assertTrue(actualMap.get("bookingdates").toString().contains(expectedMap.get("checkout").toString()));

        softAssert.assertAll();
    }
    /*
       1). Object Mapper Class is used for Serialization(Java to Json) and De-Serialization(Json to Java)
       2). ObjectMapper does the same with GSON.
       3). I created a class in "utilities" package, its name is JsonUtil then I created two methods in the class.
           First one is for Serialization
           Second one is for De-Serialization
                  In the first method, to convert Java Object to Json I used writeValueAsString() method.
                  In the second method, to convert Json Data to Java Object I used readValue() method.
           I made the methods static, so I am able to access them just by using class name which is JsonUtil.
           I made the second method "generic" because I want my method to return different Java Objects.
     */
}

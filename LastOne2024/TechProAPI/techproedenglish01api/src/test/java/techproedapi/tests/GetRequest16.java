package techproedapi.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproedapi.mains.TestBase;

import javax.naming.ldap.HasControls;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class GetRequest16 extends TestBase {
    /*
       When
           I send GET request to https://restful-booker.herokuapp.com/booking/3
       Then
           Status Code is 200
           And Content Type is "application/json"
           And Status line is "HTTP/1.1 200 OK"
           And First name is Jim
           And Total price is 623
           And Deposit paid is true
           And Checkin date is 2020-03-18

        Use De-Serialization to convert Json response body to a Map
        Then by using the map and soft-assertion make assertions.
     */
    @Test
    public void get01(){
        spec02.pathParam("bookingid",3);

        Response response = given().
                               spec(spec02).
                            when().
                               get("/{bookingid}");
        response.prettyPrint();

        HashMap<String,Object> hMap = response.as(HashMap.class);
        System.out.println(hMap);

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");

//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(hMap.get("firstname"),"Jim");
//        softAssert.assertEquals(hMap.get("totalprice"),717);
//        softAssert.assertEquals(hMap.get("depositpaid"),true);
//        softAssert.assertTrue(hMap.get("bookingdates").toString().contains("checkin=2018-07-12"));
//        softAssert.assertAll();
    }
}

package techproedapi.tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import techproedapi.mains.BookingDatesDt;
import techproedapi.mains.BookingDt;
import techproedapi.mains.TestBase;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Pojo01 extends TestBase {
    /*
       POJO stands for Plain Old Java Object
       POJO is a class created by using Json Data
       Json Data ==> Pojo Class ==> Object ==> Use the Object in Automation

       When you create a Pojo Class, it should have:
       1). private variables
       2). getter() and setter() methods for all variables
       3). Construction with all parameters
       4). Construction without parameters
       5). toString()
     */

    /*
       When
           I send POST Request to https://restful-booker.herokuapp.com/booking ==> spec02
           with the request body
                {
                  "firstname": "Ali",
                  "lastname": "Can",
                  "totalprice": 111,
                  "depositpaid": true,
                  "bookingdates": {
                        "checkin": "2020-09-16"
                        "checkout": "2020-09-18"
                  },
                  "additionalneeds": "Wifi"
                }
        Then
           Status Code is 200
           Content Type is "application/json"
           Assert all response body details

           Note: Create Request Body by using POJO
     */

    @Test
    public void post01(){

        //To create request body we will use POJO Classes

        // Expected data is stored inside the POJO Classes
        BookingDatesDt bookingDatesDt = new BookingDatesDt("2020-09-16","2020-09-18");
        BookingDt bookingDt = new BookingDt("Ali","Can",111,true,bookingDatesDt,"Wifi");

        Response response = given().
                            contentType(ContentType.JSON).
                            spec(spec02).
                            body(bookingDt).
                            when().
                            post();
        response.prettyPrint();

        // Actual Data is stored inside the Json path object
        JsonPath actualData = response.jsonPath();

        // Hard Assertion
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);

        System.out.println(bookingDt.getFirstname());

        assertEquals(bookingDt.getFirstname(),actualData.getString("booking.firstname"));
        assertEquals(bookingDt.getLastname(),actualData.getString("booking.lastname"));
        assertEquals(bookingDt.getTotalprice().toString(),actualData.getString("booking.totalprice"));
        assertEquals(bookingDt.getDepositpaid(),actualData.getBoolean("booking.depositpaid"));
        assertEquals(bookingDatesDt.getCheckin(),actualData.getString("booking.bookingdates.checkin"));
        assertEquals(bookingDatesDt.getCheckout(),actualData.getString("booking.bookingdates.checkout"));
        assertEquals(bookingDt.getAdditionalneeds(),actualData.getString("booking.additionalneeds"));
    }
}

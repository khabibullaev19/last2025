package techproedapi.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproedapi.mains.TestBase;
import techproedapi.mains.TestPojo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Pojo02 extends TestBase {
    /*
       1) Add path parameter which is "/create" to the base url
       2) By using POJO, create a Request Body which has the following data
             {
              "name": "Test Data",
              "salary": "8888",
              "age": "33"
              }
       3) When
              I send POST Request to http://dummy.restapiexample.com/api/v1/create
          Then
              Status Code is 200
              Content Type is "application/json"
              "status" key has value "success"
              "message" key has value "Successfully! Record has been added."
       4) Make assertions by using Hard Assertion and Soft Assertion
     */

    @Test
    public void post01(){

        TestPojo expectedData = new TestPojo("Test Data","8888","33");
        expectedData.setStatus("success");
        expectedData.setMessage("Successfully! Record has been added.");

        spec04.pathParam("createParam","create");

        Response response = given().
                            spec(spec04).
                            body(expectedData).
                            when().
                            post("/{createParam}");
        response.prettyPrint();

        Map<String,String> actualData = response.as(HashMap.class);

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);

        assertEquals(actualData.get("status"),expectedData.getStatus());
        assertEquals(actualData.get("message"),expectedData.getMessage());

        SoftAssert softAssert = new SoftAssert();
        assertEquals(actualData.get("status"),expectedData.getStatus());
        assertEquals(actualData.get("message"),expectedData.getMessage());
        softAssert.assertAll();
    }

}
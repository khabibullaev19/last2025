package apipracticedt;

import io.restassured.response.Response;
import org.codehaus.groovy.transform.tailrec.TernaryToIfStatementConverter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproedapi.mains.TestBase;
import techproedapi.utilities.JsonUtil;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

public class Practice01 extends TestBase {
    /*
       When
           I send a GET Request to REST API URL
           https://restful-booker.herokuapp.com/booking/1001
       Then
           HTTP Status Code should be 404
           And Response Body contains "Not Found"
           And Response Body does not contain "JavaApi"
           And header "Server" should be "Cowboy"
           And header "Content-Type" should be "text/plain; charset=utf-8"
           And header "Via" should be "1.1 vegur"

           Note: For Base URL Use spec02
           Note: Use Map for expected values
           Note: Use Hard Assertion and Soft Assertion
     */

    @Test
    public void getPractice(){
        //1. Set the URL
        spec02.pathParam("id",1001);

        //2.Set the expected data
        Map<String,String> expectedData = new HashMap<>();
        expectedData.put("trueText","Not Found");
        expectedData.put("wrongText","JavaApi");
        expectedData.put("Server","Cowboy");
        expectedData.put("Content-Type","text/plain; charset=utf-8");
        expectedData.put("Via","1.1 vegur");

        // 3. Set Actual data
        Response response = given().
                               spec(spec02).
                            when().
                               get("/{id}");
        response.prettyPrint();

//        Map<String,String> actualData = JsonUtil.convertJsonToJava(response.toString(),HashMap.class);
//        System.out.println(actualData);

        // 4. Start Assertion (Hard Assertion)
        response.
                then().
                assertThat().
                statusCode(404).
                headers("Server",expectedData.get("Server"),
                        "Content-Type",expectedData.get("Content-Type"),
                        "Via",expectedData.get("Via"));
        assertTrue(response.asString().contains(expectedData.get("trueText")));
        assertFalse(response.asString().contains(expectedData.get("wrongText")));

        // 5. Soft Assertion
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.getHeader("Server"),expectedData.get("Server"));
        softAssert.assertEquals(response.getHeader("Content-Type"),expectedData.get("Content-Type"));
        softAssert.assertEquals(response.getHeader("Via"),expectedData.get("Via"));

        softAssert.assertTrue(response.asString().contains(expectedData.get("trueText")));
        softAssert.assertFalse(response.asString().contains(expectedData.get("wrongText")));

        softAssert.assertAll();
    }
}

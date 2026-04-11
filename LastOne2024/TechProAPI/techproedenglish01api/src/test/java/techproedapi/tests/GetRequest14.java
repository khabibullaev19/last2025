package techproedapi.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproedapi.mains.TestBase;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class GetRequest14 extends TestBase {
    /*
        GSON is a converter.
        GSON is used to convert Json Data Format to Java Objects. ==> De-Serialization(We will use that)
        GSON is used to convert Java Objects to Json Data Format. ==> Serialization
     */
    @Test
    public void get01(){
        Response response = given().
                               spec(spec01).
                            when().
                               get("/2");
        response.prettyPrint();
        //Let's convert Json Data to a HashMap
        HashMap<String,Object> hMap = response.as(HashMap.class);
        System.out.println(hMap);

        // Print all keys from json data on the console
        System.out.println(hMap.keySet());

        // Print all values from json data on the console
        System.out.println(hMap.values());

        // Hard Assertions

        // Assert that "completed" is false
        assertEquals(false,hMap.get("completed"));

        // Assert that "title" is "quis ut nam facilis et officia qui"
        assertEquals("quis ut nam facilis et officia qui",hMap.get("title"));

        // Assert that "userId" is 1
        assertEquals(1,hMap.get("userId"));

        // Soft Assertions
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(hMap.get("completed").equals(false));
        softAssert.assertTrue(hMap.get("title").equals("quis ut nam facilis et officia qui"));
        softAssert.assertTrue(hMap.get("userId").equals(1));
        softAssert.assertAll();
    }
}

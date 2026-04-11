package techproedapi.tests;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import techproedapi.mains.TestBase;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.awt.geom.RectangularShape;
import java.util.HashMap;
import java.util.Map;

public class Delete02 extends TestBase {
    /*
       1) Create class and name it as "Delete02"
       2) When
              I send DELETE Request to http://dummy.restapiexample.com/api/v1/delete/719
          Then
              Status Code should be 200
              The value of "status" key in response body should be "success"
              The value of "message" key in response body should be "Successfully! Record has been deleted"

              NOTE 1: Use hard assertion
              NOTE 2: After given() please use contentType(ContentType.JSON)
     */
    @Test
    public void delete01(){
        spec04.pathParams("delete","delete",
                              "id",719);

        Map<String,String> expectedMap = new HashMap<>();
        expectedMap.put("status","success");
        expectedMap.put("message","Successfully! Record has been deleted");

        Response response = given().
                               spec(spec04).
                            when().
                               delete("/{delete}/{id}");
        response.prettyPrint();
        Map<String,String> actualMap = response.as(HashMap.class);

        // 1.Way for hard assertion
        response.
                then().
                assertThat().
                statusCode(200).body("status", equalTo(expectedMap.get("status")),
                        "message",equalTo(expectedMap.get("message")));

        // 2.Way for hard assertion by using assertEquals()
        assertEquals(expectedMap.get("status"),actualMap.get("status"));
        assertEquals(expectedMap.get("message"),actualMap.get("message"));
    }
}

package techproedapi.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import techproedapi.mains.TestBase;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Patch01 extends TestBase {
    /*
       For PATCH Request(Partial Update) you need:
        1). Endpoint ==> Mandatory
        2). Request Body ==> Mandatory
        3). Authorization ==> It depends on the API
        4). Headers ==> It depends on the API
     */

    /*
                      {
                        "userId": 10,
                        "id": 198,
                        "title": "quis eius est sint explicabo",
                        "completed": true
                       }
     */

    @Test
    public void patch01(){
        spec01.pathParams("id",3);

        Map<String,String> reqBody = new HashMap<>();
        reqBody.put("title","Ali");

        // Normally, after running the code I should see Ali as title on the console.
        // But that API does not let us update data. Because of that I just asserted
        // status code and content type.
        Response response = given().
                              spec(spec01).
                            body(reqBody).
                            when().
                              patch("/{id}");
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);
    }
}

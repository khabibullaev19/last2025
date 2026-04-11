package techproedapi.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproedapi.mains.TestBase;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class PutRequest01 extends TestBase{
    /*
        For PUT Request(FULL UPDATE) we need:
        1). Endpoint ==> Mandatory
        2). Request Body ==> Mandatory
        3). Authorization ==> It depends on the API
        4). Headers ==> It depends on the API
     */

    /*
       When
           I send PUT Request to http://dummy.restapiexample.com/api/v1/update/2
       Then
           Status Code is 200
           Content Type is "application/json"
           "status" key has value "success"
           "message" key has value "Successfully! Record has been updated."

       NOTE: Create Request Body in 3 different ways.
     */

    @Test
    public void put01(){
        spec04.pathParams("function", "update",
                           "id",2);

        // Use map to create Request Body
        Map<String,Object> reqBody = new HashMap<>();
        reqBody.put("name","Selim Ceren");
        reqBody.put("salary", "88888");
        reqBody.put("age","100");

        Response response = given().
                               spec(spec04).
                            body(reqBody).
                            when().
                               put("/{function}/{id}");
        response.prettyPrint();

        // Hard Assertion for all steps
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("status", Matchers.equalTo("success"),
                        "message",Matchers.equalTo("Successfully! Record has been updated."));

        // Soft Assertion together with De-Serialization
        HashMap<String,Object> hMap = response.as(HashMap.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(hMap.get("status"),"success");
        softAssert.assertEquals(hMap.get("message"),"Successfully! Record has been updated.");
        softAssert.assertAll();
    }
}

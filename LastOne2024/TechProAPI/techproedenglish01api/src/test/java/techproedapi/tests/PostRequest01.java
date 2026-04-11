package techproedapi.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproedapi.mains.TestBase;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class PostRequest01 extends TestBase {
                    /*
                       For Post Request, you need:
                       1) Endpoint ==> Mandatory
                       2) Request Body ==> Mandatory
                       3) Authorization ==> It depends on the API
                       4) Headers ==> It depends on the API
                     */

    /*
       When
           I send POST Request to http://dummy.restapiexample.com/api/v1/create
       Then
           Status Code is 200
           Content Type is "application/json"
           "status" key has value "success"
           "message" key has value "Successfully! Record has been added."

           NOTE: Create Request Body in 3 different ways
     */
    @Test
    public void post01(){
        spec04.pathParam("create","create");

        //1. Way to create request body ==> Not Recommended
        //String reqBody = "{\"name\":\"Ali\",\"salary\":\"4444\",\"age\":\"33\"}";

        //2.Way to create Request Body by using JSONObject Class
//        JSONObject reqBody = new JSONObject();
//        reqBody.put("name","Ali");
//        reqBody.put("salary","4444");
//        reqBody.put("age","33");

        //3.Way to create Request Body by using Map ==> The best way to use
        Map<String, String> reqBody = new HashMap<>();
        reqBody.put("name","Ali");
        reqBody.put("salary","4444");
        reqBody.put("age","33");

        // For basic authorization after spec() use ==> auth().basic("admin", "password123")
        // For Bearer Token authorization use ==> auth().oauth2("Token will be typed over here")
        Response response = given().
                               spec(spec04).
                            body(reqBody).
                            when().
                               post("/{create}");
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("status", Matchers.equalTo("success"),
                        "message",Matchers.equalTo("Successfully! Record has been added."));


        HashMap<String, Object> hMap = response.as(HashMap.class);
        System.out.println(hMap);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(hMap.get("message"),"Successfully! Record has been added.");
        softAssert.assertEquals(hMap.get("status"),"success");
        softAssert.assertAll();
    }
}

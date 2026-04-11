package techproedapi.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import techproedapi.mains.TestBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetRequest44 extends TestBase {
    @Test
    public void get01(){
        //spec07.pathParam("id","61f9763063f9f044992e9190");

        Response response = given().
                header("ApiKey","SePJO6IeuCjZ8NafBwbgTNqWZIVHABZ").
                //spec(spec07).
                when().
                get("https://staging-admin.govassist.com/ds160/applicant/61f9763063f9f044992e9190");
        response.prettyPrint();

//        HashMap<String,Object> hMap = response.as(HashMap.class);
//        System.out.println(hMap);

//        response.
//                then().
//                assertThat().
//                statusCode(200).
//                contentType(ContentType.JSON);
//                //statusLine("HTTP/1.1 200 OK");
    }
}

package techproedapi.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import techproedapi.mains.TestBase;
import static io.restassured.RestAssured.*;

public class Delete01 extends TestBase {
    /*
       For DELETE Request we need just Endpoint like GET Request, we don't need Request Body
     */
    @Test
    public void delete01(){
        // Get the data before deleting
        Response responseGet = given().spec(spec01).when().get("/129");
        responseGet.prettyPrint();

        // The data after deleting
        Response response = given().spec(spec01).when().delete("/129");
        response.prettyPrint();
    }
}

package techproedapi.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import techproedapi.mains.TestBase;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetRequest09 extends TestBase {
    /*
        Among the data there should be someone whose first name is Jim
        URL: https://restful-booker.herokuapp.com/booking
     */

    /*
       Query param is used to filter the result
       Syntax ==> ?key=value&key=value
       1.Way: You can type query param inside the get() method parenthesis (Not Recommended)
       2.Way: You can use spec2.queryParam("firstname", "Jim"); (Use it for single query param)
       3.Way: You can use spec2.queryParams("firstname","Jim", "totalprice",2); (Use it for multiple query params)
     */

    @Test
    public void get01(){
//        spec02.queryParam("firstname","Jim");
//        spec02.queryParam("totalprice",2);
        spec02.queryParams("firstname","Jim",
                                 "totalprice",2); // To remove repetition use "queryParams()" method

        Response response = given().
                            spec(spec02).
                            when().
                               get();
        response.prettyPrint();

        //Assert that the data whose name is Jim exists among the data
        assertTrue(response.asString().contains("bookingid"));

    }
}

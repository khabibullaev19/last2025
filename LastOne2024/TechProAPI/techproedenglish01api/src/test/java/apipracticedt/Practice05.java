package apipracticedt;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproedapi.mains.PojoPractice03;
import techproedapi.mains.PojoPractice05;
import techproedapi.mains.TestBase;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Practice05 extends TestBase {
    /*
       When
           I send a POST Request to REST API URL
           http://dummy.restapiexample.com/api/v1/create
           {
               "employee_name": "Ali Can",
               "employee_salary": "77000",
               "employee_age": "35",
               "profile_image": ""
            }
       Then
           HTTP Status Code Should be 200
           And Response format should be :"application/json"
           And "status" should be "success"
           And "message" should be "Successfully! Record has been updated."
           And "data.empty" should be false

           NOTE: For Base URL use spec04 and add path param "/create"
           NOTE: For actual data use De-Serialization
           NOTE: For expected data use Pojo Class
           NOTE: Use Hard Assertion(body()) and Soft Assertion
     */

    @Test
    public void postPractice(){
        spec04.pathParam("create","create");

        PojoPractice05 expectedData = new PojoPractice05("Ali Can","77000","35",null);
        expectedData.setStatus("success");
        expectedData.setMessage("Successfully! Record has been added.");

        Response response = given().
                             contentType(ContentType.JSON).
                              spec(spec04).
                                     body(expectedData).
                            when().
                              post("/{create}");
        response.prettyPrint();

        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("status", equalTo(expectedData.getStatus()),
                        "message",equalTo(expectedData.getMessage()),
                        "data.employeeName",equalTo(expectedData.getEmployeeName()),
                        "data.employeeSalary",equalTo(expectedData.getEmployeeSalary()),
                        "data.employeeAge",equalTo(expectedData.getEmployeeAge()),
                        "data.profileImage",equalTo(expectedData.getProfileImage()));

        // Hard Assertion with assertEquals(), assertTrue(), assertFalse()
        // We have two options to convert response body'
        // 1). JsonPath   2). De-Serialization==> a)GSON   b)ObjectMapper
        JsonPath jsonPath = response.jsonPath();

        assertEquals(expectedData.getStatus(),jsonPath.getString("status"));
        assertEquals(expectedData.getMessage(),jsonPath.getString("message"));
        assertEquals(expectedData.getEmployeeName(),jsonPath.getString("data.employeeName"));
        assertEquals(expectedData.getEmployeeSalary(),jsonPath.getString("data.employeeSalary"));
        assertEquals(expectedData.getEmployeeAge(),jsonPath.getString("data.employeeAge"));
        assertEquals(expectedData.getProfileImage(),jsonPath.getString("data.profileImage"));

        SoftAssert softAssert = new SoftAssert();
        assertEquals(jsonPath.getString("status"),expectedData.getStatus());
        assertEquals(jsonPath.getString("message"),expectedData.getMessage());
        assertEquals(jsonPath.getString("data.employeeName"),expectedData.getEmployeeName());
        assertEquals(jsonPath.getString("data.employeeSalary"),expectedData.getEmployeeSalary());
        assertEquals(jsonPath.getString("data.employeeAge"),expectedData.getEmployeeAge());
        assertEquals(jsonPath.getString("data.profileImage"),expectedData.getProfileImage());
        softAssert.assertAll();
    }

}

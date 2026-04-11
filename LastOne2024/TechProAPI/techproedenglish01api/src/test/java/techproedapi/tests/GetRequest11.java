package techproedapi.tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproedapi.mains.TestBase;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest11 extends TestBase {
    /*
       When
           I send a GET Request http://dummy.restapiexample.com/api/v1/employees
       Then
           Status Code is 200
           And the name of 5th employee is "Airi Satou"
           And the salary of 6th employee is "372000"
           And there are "24" employees
           And "Rhona Davidson" is one of the employees
           And "21", "23", "61" are among employee ages
     */

    @Test
    public void get01(){
        //spec03.pathParam()
        Response response = given().
                               spec(spec03).
                            when().
                               get();
        response.prettyPrint();

        response.then().assertThat().statusCode(200).
                body("data.employee_name[4]", equalTo("Airi Satou"),
                        "data.employee_salary[5]",equalTo(372000),
                        "data.id",hasSize(24),
                        "data.employee_name",hasItem("Rhona Davidson"),
                        "data.employee_age",hasItems(21,23,61));

        /*
           What is the difference between Hard Assertion and Soft Assertion?
           In Hard Assertion, if any assertion fails next ones do not execute.
           In Soft Assertion, all assertions are executed everytime then you get report
           for all assertions one by one.
         */

        /*
           There are 3 steps for SoftAssertion
           1) You have to create an object from SoftAssert class
              SoftAssert softAssert = new SoftAssert();
           2) You select assertion methods from SoftAssert Class by using softAssert objet
           3) Do not forget to type assertAll() method at the end.
              If you do not type assertAll() method at the end you will get green everytime, but it is not meaningful
         */

        //Assert the same test case by using Soft Assertion and JsonPath
        JsonPath json = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(json.getString("data.employee_name[4]"),"Airi Satou");
        softAssert.assertEquals(json.getInt("data.employee_salary[5]"),372000);
        softAssert.assertEquals(json.getList("data.id").size(),24);
        softAssert.assertTrue(json.getList("data.employee_name").contains("Rhona Davidson"));

        List<Integer> ageList = new ArrayList<>();
        ageList.add(21);
        ageList.add(23);
        ageList.add(61);
        softAssert.assertTrue(json.getList("data.employee_age").containsAll(ageList));

        softAssert.assertAll();
    }
}

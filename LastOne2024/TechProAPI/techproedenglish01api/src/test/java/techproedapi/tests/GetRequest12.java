package techproedapi.tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproedapi.mains.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.*;

public class GetRequest12 extends TestBase {
    /*
       When
           I send GET Request to http://dummy.restapiexample.com/api/v1/employees
       Then
           Status Code is 200
           1). Print all ids greater than 10 on the console
               Assert that there are 14 ids greater than 10
           2). Print all ages less than 30 on the console
               Assert that maximum age is 23
           3). Print all employee names whose salaries are greater than 350000
               Assert that Charde Marshall is one of the employees whose salary is greater than 350,000
           4). Print all employee salaries whose ids are less than 11
               Assert that maximum salary is 143060
     */

    @Test
    public void get01(){
        Response response = given().
                              spec(spec04).
                            when().
                              get();
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200);

        JsonPath json = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();

        // Print all ids greater than 10 on the console
        List<Integer> idList = json.getList("data.findAll{Integer.valueOf(it.id)>10}.id");
        System.out.println(idList);
        // Assert that there are 14 ids greater than 10
        softAssert.assertEquals(idList.size(),14);

        // Print all ages less than 30 on the console
        List<Integer> ageList = json.getList("data.findAll{Integer.valueOf(it.employee_age)<30}.employee_age");
        System.out.println(ageList);
        // Assert that maximum age is 23
    /*
              I am commenting that part because my list is already an Integer
        List<Integer> ageIntList = new ArrayList<>();
        for (Integer w : ageList){
            ageIntList.add(Integer.valueOf(w));
        }
        System.out.println(ageIntList);
    */
        Collections.sort(ageList);
        System.out.println(ageList);
        softAssert.assertTrue(ageList.get(ageList.size()-1)==23);

        // Print all employee names whose salaries are greater than 350000
        List<String> nameList = json.getList("data.findAll{Integer.valueOf(it.employee_salary)>350000}.employee_name");
        System.out.println(nameList);
        // Assert that Charde Marshall is one of the employees whose salary is greater than 350,000
        softAssert.assertTrue(nameList.contains("Charde Marshall"));

        // Print all employee salaries whose ids are less than 11
        List<Integer> salaryList = json.getList("data.findAll{Integer.valueOf(it.id)<11}.employee_salary");
        System.out.println(salaryList);
        // Assert that maximum salary is 433060
        Collections.sort(salaryList);
        System.out.println(salaryList);
        softAssert.assertTrue(salaryList.get(salaryList.size()-1)==433060);
        softAssert.assertAll();
    }
}
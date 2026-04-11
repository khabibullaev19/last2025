package techproedapi.tests;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class GetRequest13 {
    // How to work with Json Data
    // File Path: C:\Program Files\Sublime Text\Employee.json

    @Test
    public void get01(){
        JsonPath json = new JsonPath(new File("C:\\Program Files\\Sublime Text\\Employee.json"));
        SoftAssert softAssert = new SoftAssert();

        // Get all employee names whose salaries are greater than 150,000
        List<String> nameList = json.getList("data.findAll{Integer.valueOf(it.employee_salary)>150000}.employee_name");
        System.out.println(nameList);

        // Assert that 17 employees are earning greater than 150,000
        softAssert.assertEquals(nameList.size(),17);

        // Assert that maximum salary for all employees is 725000
        List<Integer> salaryList = json.getList("data.employee_salary");
        Collections.sort(salaryList);
        softAssert.assertTrue(salaryList.get(salaryList.size()-1)==725000);

        softAssert.assertAll();
    }
}

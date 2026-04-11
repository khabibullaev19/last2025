package apipracticedt;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproedapi.mains.TestBase;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class Practice06 extends TestBase {
    /*
       1) Create base url in TestBase Class for "http://api.agromonitoring.com"
       2) Set the URL to "http://api.agromonitoring.com/agro/1.0/polygons?appid=2cb6803f295233aa579843d9e45599f2"
          by using pathParams() and queryParams() methods
       3) Request Body is : {
                              "name":"Polygon Sample",
                              "geo_json":{
                                           "type":"Feature",
                                           "properties":{},
                                           "geometry":{
                                                       "type":"Polygon",
                                                       "coordinates":[
                                                             [
                                                                  [-121.1958,37.6683],
                                                                  [-121.1779,37.6687],
                                                                  [-121.1773,37.6792],
                                                                  [-121.1958,37.6792],
                                                                  [-121.1958,37.6683]
                                                              ]
                                                           ]
                                                        ]
                                                     }
                                                  }
                                               }
       4) Create POST Request to "http://api.agromonitoring.com/agro/1.0/polygons?appid=2cb6803f295233aa579843d9e45599f2"
          Print the response body on the console
       5) Assert Status Code (201) and Response Body details by using body() method
       6) Assert Response Body details by using Soft Assert
     */

    @Test
    public void postPractice(){
        spec06.pathParams("agro","agro",
                "id",1.0,
                "polygons","polygons").
                queryParam("appid","2cb6803f295233aa579843d9e45599f2");

        // Request Body creation
        float coordinates[][][] = {{{-121.1958f,37.6683f},{-121.1779f,37.6687f},{-121.1773f,37.6792f},{-121.1958f,37.6792f},{-121.1958f,37.6683f}}};

        Map<String,Object> geometry = new HashMap<>();
        geometry.put("type","Polygon");
        geometry.put("coordinates",coordinates);

        Map<String,String> properties = new HashMap<>();

        Map<String,Object> geo_json = new HashMap<>();
        geo_json.put("type","Feature");
        geo_json.put("properties",properties);
        geo_json.put("geometry",geometry);

        Map<String,Object> requestBody = new HashMap<>();
        requestBody.put("name","Polygon Sample");
        requestBody.put("geo_json",geo_json);

        float center[] = {-121.1867f,37.67385f};
        float area = 190.9484f;

        // Send POST Request
        Response response = given().
                            contentType(ContentType.JSON).
                                spec(spec06).
                                    body(requestBody).
                            when().
                                post("/{agro}/{id}/{polygons}");
        response.prettyPrint();
        response.
                then().
                assertThat().
                statusCode(201).
                contentType(ContentType.JSON).
                body("geo_json.geometry.coordinates[0][0][0]",equalTo(coordinates[0][0][0]),
                        "geo_gson.geometry.coordinates[0][0][1]",equalTo(coordinates[0][0][1]),
                        "geo_json.geometry.coordinates[0][1][0]",equalTo(coordinates[0][1][0]),
                        "geo_json.geometry.coordinates[0][1][1]",equalTo(coordinates[0][1][1]),
                        "geo_json.geometry.coordinates[0][2][0]",equalTo(coordinates[0][2][0]),
                        "geo_json.geometry.coordinates[0][2][1]",equalTo(coordinates[0][2][1]),
                        "geo_json.geometry.coordinates[0][3][0]",equalTo(coordinates[0][3][0]),
                        "geo_json.geometry.coordinates[0][3][1]",equalTo(coordinates[0][3][1]),
                        "geo_json.geometry.coordinates[0][4][0]",equalTo(coordinates[0][4][0]),
                        "geo_json.geometry.coordinates[0][4][1]",equalTo(coordinates[0][4][1]),
                        "geo_json.type",equalTo(geo_json.get("type")),
                        "geo_json.properties",equalTo(properties),
                        "name",equalTo(requestBody.get("name")),
                        "center[0]",equalTo(center[0]),
                        "center[1]",equalTo(center[1]),
                        "area",equalTo(area));

        // Hard assertion with assertEquals() method, assertTrue() and assertFalse()
        // 1). JsonPath    2) De-Serialization ==> a) GSON  b) ObjectMapper
        JsonPath json = response.jsonPath();

        assertEquals(coordinates[0][0][0],json.get("geo_json.geometry.coordinates[0][0][0]"));
        assertEquals(coordinates[0][0][1],json.get("geo_json.geometry.coordinates[0][0][1]"));
        assertEquals(geo_json.get("type"),json.get("geo_json.type"));
        assertEquals(properties,json.get("geo_json.properties"));

        // Soft Assertion
        // 1). JsonPath    2) De-Serialization ==> a) GSON  b) ObjectMapper

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(json.get("geo_json.geometry.coordinates[0][0][0]"),coordinates[0][0][0]);
        softAssert.assertEquals(json.get("geo_json.geometry.coordinates[0][0][1]"),coordinates[0][0][1]);
        softAssert.assertEquals(json.get("geo_json.type"),geo_json.get("type"));
        softAssert.assertEquals(json.get("geo_json.properties"),properties);

        softAssert.assertAll();
    }
}

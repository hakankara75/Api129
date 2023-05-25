package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class Post01 extends JsonPlaceHolderBaseUrl {
      /*
    Given
      1)  https://jsonplaceholder.typicode.com/todos
      2)  {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
           }
   When
    I send POST Request to the Url
   Then
       Status code is 201
   And
       response body is like {
                               "userId": 55,
                               "title": "Tidy your room",
                               "completed": false,
                               "id": 201
                               }
*/

    @Test //string ile post request tavsiye edilmez.
    public void test1(){
        //set the url
        spec.pathParam("first", "todos");

        //set the expected data
        String payLoad =" {\n" +
                "            \"userId\": 7551,\n" +
                "            \"title\": \"Tidy your room\",\n" +
                "            \"completed\": false\n" +
                "           }";
        //yukarida json datasi java objesi haline getirildi.

        //set the request and get the response
        Response response=given(spec).body(payLoad).post("{first}");
        response.prettyPrint();

        //do assertion
        assertEquals(201, response.statusCode());
        JsonPath jsonPath=response.jsonPath();
        assertEquals(7551, jsonPath.getInt("userId"));
        assertEquals("Tidy your room", jsonPath.getString("title"));
        assertFalse(jsonPath.getBoolean("completed"));




    }
    @Test //map ile tavsiye edilir
    public void test2(){
        //set the url
        spec.pathParam("first", "todos");

        //set the expected data //json datayi java objesi olarak yollamaliyiz. gson dependency ile serialization yapildi.
        Map<String, Object> expectedData= new HashMap<>();
        expectedData.put("userId", 75513 );
        expectedData.put("title", "Tidy your room" );
        expectedData.put("completed", false );


        //set the request and get the response
        Response response=given(spec).body(expectedData).post("{first}"); //gson dependency ile serialization yapildi. javadan json'a cevirildi
        response.prettyPrint();

        //do assertion
        Map<String, Object> actualData= response.as(HashMap.class); //yukarida serialization ile javadan gson ile json yaptik datayi. burda tersi de-serialization yaptik
        assertEquals(201, response.statusCode());

        assertEquals(expectedData.get("completed"), actualData.get("completed") );
        assertEquals(expectedData.get("title"), actualData.get("title") );
        assertEquals(expectedData.get("userId"), actualData.get("userId") );





    }
}

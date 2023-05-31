package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import test_data.JsonPlaceHolderTestData;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get13_ObjectMapper_Pojo extends JsonPlaceHolderBaseUrl {

         /*
       Given
           https://jsonplaceholder.typicode.com/todos/198
       When
            I send GET Request to the URL
        Then
            Status code is 200
            And response body is like {
                                       "userId": 10,
                                       "id": 198,
                                       "title": "quis eius est sint explicabo",
                                       "completed": true
                                     }
    */

    @Test
    public void get13(){
        //Set the url
        spec.pathParams("first", "todos", "second", 198);

        //set the expected data
        String body = JsonPlaceHolderTestData.expectedDataString(10, "quis eius est sint explicabo",true);

        JsonPlaceHolderPojo expectedData = ObjectMapperUtils.convertJsonToJava(body, JsonPlaceHolderPojo.class);

        //send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //do assertion
        JsonPlaceHolderPojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(), JsonPlaceHolderPojo.class);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getUserId(), actualData.getUserId());
        assertEquals(expectedData.getTitle(), actualData.getTitle());
        assertEquals(expectedData.getCompleted(), actualData.getCompleted());




    }
}

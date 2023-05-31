package delete_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Delete01 extends JsonPlaceHolderBaseUrl {

     /*
     Given
         https://jsonplaceholder.typicode.com/todos/198
     When
   I send DELETE Request to the Url
Then
   Status code is 200
   And Response body is { }
  */

    @Test
    public void name() {
        //set the url
        spec.pathParams("first", "todos", "second", 198);

        //set the expected data
        Map<String,String>expectedData = new HashMap<>(); //silme oldugu icin data bos olur

        //send the request and get the response
        Response response=given(spec).delete("{first}/{second}");
        response.prettyPrint();

        //do assertion
        Map<String,String> actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);

        //1.yol her iki map de bos oldugu icin karsilastirabiliriz
        assertEquals(expectedData, actualData);

        //2.yol
        assertTrue(actualData.isEmpty());

        assertTrue(actualData.size()==0);

    }
}

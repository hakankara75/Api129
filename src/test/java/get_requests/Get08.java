package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get08 extends JsonPlaceHolderBaseUrl {
     /*
    Given
       https://jsonplaceholder.typicode.com/todos/2
   When
       I send GET Request to the URL
   Then
       Status code is 200
       And "completed" is false
       And "userId" is 1
       And "title" is "quis ut nam facilis et officia qui"
       And header "Via" is "1.1 vegur"
       And header "Server" is "cloudflare"
       {
           "userId": 1,
           "id": 2,
           "title": "quis ut nam facilis et officia qui",
           "completed": false
       }
*/

    @Test
    public void test8() {
        //set the URL
        spec.pathParams("first", "todos", "second", 2);

        //set the expected data
        JsonPlaceHolderTestData obj=new JsonPlaceHolderTestData();
        Map<String, Object> expectedData= obj.expectedDataMap(1, "quis ut nam facilis et officia qui", false );
        expectedData.put("Via", "1.1 vegur"); //degiskenleri metotla olusan map'e ekledik.
        expectedData.put("Server", "cloudflare");


        //send the request and get the response
        Response response= given(spec).get("{first}/{second}");
        response.prettyPrint();

        //do assertions
        Map<String,Object> actualData= response.as(HashMap.class);
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));

        // and header "Via" is "1.1 vegur"
        assertEquals(expectedData.get("Via"), response.getHeader("Via"));//yukarida map'e ekledigimiz veriler ile assertion'u sabit veri ile yaptik.

        //and header "Server" is "cloudflare"
        assertEquals(expectedData.get("Server"), response.getHeader("Server"));


    }
}

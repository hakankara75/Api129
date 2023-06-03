package herokuapp_smoketest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static herokuapp_smoketest.C01_PostRequest.bookingId;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C04_PatchRequest extends HerOkuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    And
        {
            "totalprice": 100
        }
    When
        Send patch request
    Then
        Status code is 200
    And
        Body:
                 {
            "firstname" : "Hakan",
            "lastname" : "Kara",
            "totalprice" : 100,
            "depositpaid" : true,
            "bookingdates" : {
                "checkin" : "2018-01-01",
                "checkout" : "2019-01-01"
            },
            "additionalneeds" : "Ankara Simidi"
        }

     */

    @Test
    public void patch01() {
        //set the url
        spec.pathParams("first", "booking", "second", bookingId);

        //set the expected data
        Map<String, Object> expectedData= new HashMap<>();
        expectedData.put("additionalneeds", "Ankara Simidi" );

        //Send the request and get the response
       Response response= given(spec).body(expectedData).patch("{first}/{second}");
       response.prettyPrint();

       //do assertion
        Map<String,Object> actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),Map.class);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));







    }
}

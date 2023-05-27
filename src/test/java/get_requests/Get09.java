package get_requests;

import base_urls.HerOkuAppBaseUrl;
import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerokuappTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get09 extends HerOkuAppBaseUrl {
     /*
   Given
       https://restful-booker.herokuapp.com/booking/215
   When
       I send GET Request to the url
   Then
       Response body should be like that;
        {
         "firstname": "John",
         "lastname": "Smith",
         "totalprice": 715,
         "depositpaid": true,
         "bookingdates": {
             "checkin": "2018-01-01",
             "checkout": "2019-01-01"
         },
         "additionalneeds": "Breakfast"
         }
*/

    @Test
    public void test9a() {
        //set the url
        spec.pathParams("first", "booking", "second", 715 );

        //set the expected data
        Map<String, String> bookingdatesMap= new HashMap<>();
        bookingdatesMap.put("checkin", "2018-01-01");
        bookingdatesMap.put("checkout", "2019-01-01");
        Map<String, Object> expectedData= new HashMap<>();
        expectedData.put("firstname", "John");
        expectedData.put("lastname", "Smith");
        expectedData.put("totalprice", 111);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates", bookingdatesMap);
        expectedData.put("additionalneeds", "Breakfast");

        //send the request and get the response
        Response response= given(spec).get("{first}/{second}");
        response.prettyPrint();

        //do assertion
        Map<String,Object> actualData= response.as(HashMap.class); //de-serialization
        assertEquals(expectedData.get( "firstname"), actualData.get( "firstname"));
        assertEquals(expectedData.get( "lastname"), actualData.get( "lastname"));
        assertEquals(expectedData.get( "totalprice"), actualData.get( "totalprice"));
        assertEquals(expectedData.get( "depositpaid"), actualData.get( "depositpaid"));


        assertEquals(bookingdatesMap.get("checkin"), ((Map)actualData.get( "bookingdates")).get("checkin"));
        assertEquals(bookingdatesMap.get("checkout"), ((Map)actualData.get( "bookingdates")).get("checkout"));
        assertEquals(expectedData.get( "additionalneeds"), actualData.get( "additionalneeds"));


    }

    //yukaridaki testin dinamik hali
    @Test
    public void test9b() {
        //set the url
        spec.pathParams("first", "booking", "second", 715 );

        //set the expected data
        HerokuappTestData obj= new HerokuappTestData();
        Map<String, String> bookingdatesMap= obj.bookingdatesMapMethod("2018-01-01", "2019-01-01");

        Map<String, Object> expectedData= obj.expectedDataMethod("John", "Smith", 111,  true, bookingdatesMap, "Breakfast");

        //send the request and get the response
        Response response= given(spec).get("{first}/{second}");
        response.prettyPrint();

        //do assertion
        Map<String,Object> actualData= response.as(HashMap.class); //de-serialization
        assertEquals(expectedData.get( "firstname"), actualData.get( "firstname"));
        assertEquals(expectedData.get( "lastname"), actualData.get( "lastname"));
        assertEquals(expectedData.get( "totalprice"), actualData.get( "totalprice"));
        assertEquals(expectedData.get( "depositpaid"), actualData.get( "depositpaid"));


        assertEquals(bookingdatesMap.get("checkin"), ((Map)actualData.get( "bookingdates")).get("checkin"));
        assertEquals(bookingdatesMap.get("checkout"), ((Map)actualData.get( "bookingdates")).get("checkout"));
        assertEquals(expectedData.get( "additionalneeds"), actualData.get( "additionalneeds"));




    }
}

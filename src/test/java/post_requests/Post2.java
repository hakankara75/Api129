package post_requests;

import base_urls.HerOkuAppBaseUrl;
import org.junit.Test;
import test_data.HerokuappTestData;

import java.util.Map;

public class Post2 extends HerOkuAppBaseUrl {
       /*
   Given
       1) https://restful-booker.herokuapp.com/booking
       2) {
            "firstname": "John",
            "lastname": "Doe",
            "totalprice": 11111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2021-09-09",
                "checkout": "2021-09-21"
             }
          }
   When
       I send POST Request to the Url
   Then
       Status code is 200
       And response body should be like {
                                           "bookingid": 5315,
                                           "booking": {
                                               "firstname": "John",
                                               "lastname": "Doe",
                                               "totalprice": 11111,
                                               "depositpaid": true,
                                               "bookingdates": {
                                                   "checkin": "2021-09-09",
                                                   "checkout": "2021-09-21"
                                               }
                                           }
                                        }
*/

    @Test
    public void post2() {
        //set the url
        spec.pathParam("first", "booking");

        //set the expected data
        HerokuappTestData obj= new HerokuappTestData();
        Map<String, String> bookingdatesMap= obj.bookingdatesMapMethod("2021-09-09", "2021-09-21" );
        Map<String, Object> expectedDataMethod=obj.expectedDataMethod("John", "Doe", 11111,  true, bookingdatesMap, "" );

        //send the request and get the response




    }
}

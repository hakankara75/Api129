package herokuapp_smoketest;

import base_urls.HerOkuAppBaseUrl;
import org.junit.Test;

import static herokuapp_smoketest.C01_PostRequest.bookingId;

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



    }
}

package herokuapp_smoketest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import utils.ObjectMapperUtils;

import static herokuapp_smoketest.C01_PostRequest.bookingId;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C03_PutRequest extends HerOkuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    And
                {
            "firstname" : "Hakan",
            "lastname" : "Kara",
            "totalprice" : 200,
            "depositpaid" : true,
            "bookingdates" : {
                "checkin" : "2018-01-01",
                "checkout" : "2019-01-01"
            },
            "additionalneeds" : "Ankara Simidi"
        }
    When
           Send put request

    Then
           Status coe is 200
    And
            Body:
                 {
            "firstname" : "Hakan",
            "lastname" : "Kara",
            "totalprice" : 200,
            "depositpaid" : true,
            "bookingdates" : {
                "checkin" : "2018-01-01",
                "checkout" : "2019-01-01"
            },
            "additionalneeds" : "Ankara Simidi"
        }

     */

    @Test
    public void put01() {
        //set the url
        spec.pathParams("first", "booking","second", bookingId);

        //set the expected data
        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData= new BookingPojo("Hakan", "Kara", 20, true, bookingDatesPojo, "Ankara Simidi");

        //send the request and get the response
        Response response= given(spec).body(expectedData).put("{first}/{second}");
        response.prettyPrint();

        //do assertion
        BookingPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), BookingPojo.class);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getDepositpaid());

        assertEquals(bookingDatesPojo.getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(), actualData.getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(), actualData.getAdditionalneeds());

    }
}

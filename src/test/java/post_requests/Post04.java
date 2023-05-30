package post_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post04 extends HerOkuAppBaseUrl {
    /*
      Given
       1)  https://restful-booker.herokuapp.com/booking
       2)   {
             "firstname": "Ali",
             "lastname": "Can",
             "totalprice": 999,
             "depositpaid": true,
             "bookingdates": {
                 "checkin": "2021-09-21",
                 "checkout": "2021-12-21"
              },
              "additionalneeds": "Breakfast"
          }
     When
    I send POST Request to the URL
   Then
    Status code is 200
And
    Response body is like {
                            "bookingid": 16,
                            "booking" :{
                                     "firstname": "Ali",
                                     "lastname": "Can",
                                     "totalprice": 999,
                                     "depositpaid": true,
                                     "bookingdates": {
                                         "checkin": "2021-09-21",
                                         "checkout": "2021-12-21"
                                     },
                                     "additionalneeds": "Breakfast"
                                  }
                               }
  */

    @Test
    public void name() {
        //set the url
        spec.pathParam("first", "booking");

        //set the expected data
        BookingDatesPojo bookingDatesPojo= new BookingDatesPojo("2021-09-21", "2021-12-21");
        BookingPojo payLoad = new BookingPojo("Ali", "Can",999,true, bookingDatesPojo, "Breakfast" );

        //set the request and get the response
        Response response = given(spec).body(payLoad).post("{first}");
        response.prettyPrint();

        //do assertion
        BookingResponsePojo actualData = response.as(BookingResponsePojo.class);

        assertEquals(200, response.statusCode());
        assertEquals(payLoad.getFirstname(), actualData.getBooking().getFirstname());
        assertEquals(payLoad.getLastname(), actualData.getBooking().getLastname());
        assertEquals(payLoad.getTotalprice(), actualData.getBooking().getTotalprice());
        assertEquals(payLoad.getDepositpaid(), actualData.getBooking().getDepositpaid());
        assertEquals(bookingDatesPojo.getCheckin(), actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(), actualData.getBooking().getBookingdates().getCheckout());
        assertEquals(payLoad.getAdditionalneeds(), actualData.getBooking().getAdditionalneeds());
    }
}

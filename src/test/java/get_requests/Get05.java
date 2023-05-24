package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class Get05 extends HerOkuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends a GET request to the URL
    Then
        Status code is 200
And
   Among the data there should be someone whose firstname is "Sally" and last name is "Brown"
        (Data içerisinde firstname değeri "Sally", lastname değeri "Brown" olan biri olmalı)
 */

    @Test
    public void test5() {
        //set the url
        spec.pathParam("first", "booking")
                .queryParams("firstname", "Sally", "lastname", "Brown");

        //set the expected data

        //send the request and get the response
        Response response=given(spec).get("{first}");
        response.prettyPrint();

        //Do assertion
        response.then()
                .statusCode(200)
                .body("bookingid", hasSize(greaterThan(0)));




    }
}

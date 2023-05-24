package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get06 extends HerOkuAppBaseUrl {
    /*
  Given
      https://restful-booker.herokuapp.com/booking/23
  When
      User send a GET request to the URL
  Then
      HTTP Status Code should be 200
  And
      Response content type is "application/json"
  And
      Response body should be like;
           {
              "firstname": "Josh",
              "lastname": "Allen",
              "totalprice": 111,
              "depositpaid": true,
              "bookingdates": {
                  "checkin": "2018-01-01",
                  "checkout": "2019-01-01"
              },
              "additionalneeds": "midnight snack"
           }
*/

    @Test
    public void test6() {
        //set the url
        spec.pathParams("first", "booking", "second", 18);

        //set the expected data

        //send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //do assertions
        //1.Yol
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Josh"),
                        "lastname", equalTo("Allen"),
                        "totalprice", equalTo(111),
                        "depositpaid", equalTo(true),
                        "bookingdates.checkin", equalTo("2018-01-01"),
                        "bookingdates.checkout", equalTo("2019-01-01"),
                        "additionalneeds", equalTo("midnight snack"));


        //2.yol : Json Path
        JsonPath jsonPath=response.jsonPath(); //jsonPath() methodu ile response'ı JsonPath objesine çevirdik
        String firstname= jsonPath.getString("firstname");
        assertEquals("firstname uyusmadi", "Josh", jsonPath.getString("firstname"));
        assertEquals("Allen", jsonPath.getString("lastname"));
        assertEquals(111, jsonPath.getInt("totalprice"));
        assertTrue(jsonPath.getBoolean("depositpaid"));
        assertEquals("2018-01-01", jsonPath.getString("bookingdates.checkin"));
        assertEquals("2019-01-01", jsonPath.getString("bookingdates.checkout"));
        assertEquals("midnight snack", jsonPath.getString("additionalneeds"));

        //3.yol  TestNG soft assertion
        //soft assertion adimlari
        //1. soft assert objesi olustur
        SoftAssert softAssert=new SoftAssert();

        //2.assert yap
        softAssert.assertEquals(jsonPath.getString("firstname"), "Josh", "firstname uyusmadi");
        softAssert.assertEquals( jsonPath.getString("lastname"), "Allen",  "lastname uyusmadi");
        softAssert.assertEquals(jsonPath.getInt("totalprice"), 111, "totalprice uyusmadi");
        softAssert.assertTrue(jsonPath.getBoolean("depositpaid"),  "depositpaid uyusmadi");
        softAssert.assertEquals(jsonPath.getString("bookingdates.checkin"), "2018-01-01", "checkin uyusmadi");
        softAssert.assertEquals(jsonPath.getString("bookingdates.checkout"), "2019-01-01", "checkout uyusmadi");
        softAssert.assertEquals(jsonPath.getString("additionalneeds"), "midnight snack", "additionalneeds uyusmadi");


        //assertAll() methodunu kullan
        softAssert.assertAll();


    }
}

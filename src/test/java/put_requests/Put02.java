package put_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiPojo;
import pojos.DummyRestApiResponsePojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Put02 extends DummyRestApiBaseUrl {
       /*
   URL: https://dummy.restapiexample.com/api/v1/update/21
  HTTP Request Method: PUT Request
  Request body: {
                   "employee_name": "Ali Can",
                   "employee_salary": 111111,
                   "employee_age": 23,
                   "profile_image": "Perfect image"
                }
  Test Case: Type by using Gherkin Language
  Assert:
           i) Status code is 200
           ii) Response body should be like the following
               {
                   "status": "success",
                   "data": {
                       "employee_name": "Ali Can",
                       "employee_salary": 111111,
                       "employee_age": 23,
                       "profile_image": "Perfect image"
                   },
                   "message": "Successfully! Record has been updated."
               }
*/

    /*
    Given
         URL: https://dummy.restapiexample.com/api/v1/update/21
    And
           Request body: {
                   "employee_name": "Ali Can",
                   "employee_salary": 111111,
                   "employee_age": 23,
                   "profile_image": "Perfect image"
                }
     When
            User sends PUT Request
     Then
            status code sholul be 200
     And
            {
                   "status": "success",
                   "data": {
                       "employee_name": "Ali Can",
                       "employee_salary": 111111,
                       "employee_age": 23,
                       "profile_image": "Perfect image"
                   },
                   "message": "Successfully! Record has been updated."
               }
     */
/*
Given on kosul
When yapilan islemlerdir
Then assertion icin
And tekrarli islerde
*/
    @Test
    public void name() {
        //set the url
        spec.pathParams("first", "update", "second", 21);

        //set the expected data
        DummyRestApiPojo expectedData= new DummyRestApiPojo("Ali Can",111111,23,"Perfect image");

        //sent the request and get the response
        Response response= given(spec).body(expectedData).put("{first}/{second}");
        response.prettyPrint();

        //do assertion
        DummyRestApiResponsePojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(), DummyRestApiResponsePojo.class);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedData.getEmployee_name(), actualData.getData().getEmployee_name());
        assertEquals(expectedData.getEmployee_age(), actualData.getData().getEmployee_age());
        assertEquals(expectedData.getEmployee_salary(), actualData.getData().getEmployee_salary());
        assertEquals(expectedData.getProfile_image(), actualData.getData().getProfile_image());

        // Tüm body assert edilecekse
        assertEquals("Successfully! Record has been updated.", actualData.getMessage());
        assertEquals("success", actualData.getStatus());



    }
}

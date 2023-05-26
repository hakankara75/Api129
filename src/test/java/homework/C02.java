package homework;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.testng.AssertJUnit.*;

public class C02 extends ReqresBaseUrl {
    /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */

    @Test
    public void name() {
//        i) Set the URL --> Endpoint'i kur
        spec.pathParams("first", "api", "second", "users", "third", 23 );

//        ii) Set the expected data --> Beklenen veriyi kur


//        iii) Send the request and get the response --> Request yolla, response al
        Response response =given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();

//        iv) Do Assertion --> Doğrulama yap
        response.then()
                .statusCode(404)
                .contentType(ContentType.JSON)
                .statusLine("HTTP/1.1 404 Not Found");


        assertEquals("cloudflare",response.getHeader("Server"));
        assertFalse( response.asString().contains("id"));
        assertTrue(  response.asString().contains(""));





    }
}

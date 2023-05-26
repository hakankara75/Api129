package homework;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01 extends ReqresBaseUrl {
     /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK

            {
    "userId": 21,
    "title": "Wash the dishes",
    "completed": false,
    "updatedAt": "2023-05-26T07:22:31.007Z"
}
     */

    @Test
    public void name() {

//        i) Set the URL --> Endpoint'i kur
        spec.pathParams("first", "api", "second", "users", "third", 3 );

//        ii) Set the expected data --> Beklenen veriyi kur


//        iii) Send the request and get the response --> Request yolla, response al
        Response response= given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();

//        iv) Do Assertion --> Doğrulama yap
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .statusLine("HTTP/1.1 200 OK");






    }
}

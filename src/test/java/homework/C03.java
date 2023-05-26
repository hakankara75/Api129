package homework;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class C03 extends ReqresBaseUrl {

    @Test
    public void name() {
/*
       Given
           https://reqres.in/api/users/2
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be “application/json”
       And
           “email” is “janet.weaver@reqres.in”,
       And
           “first_name” is "Janet"
       And
           “last_name” is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */

//        i) Set the URL --> Endpoint'i kur
        spec.pathParams("first", "api", "second", "users", "third", 2 );

//        ii) Set the expected data --> Beklenen veriyi kur


//        iii) Send the request and get the response --> Request yolla, response al
        Response response=given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();

//        iv) Do Assertion --> Doğrulama yap
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.email", equalTo("janet.weaver@reqres.in"),
                        "data.first_name" , equalTo("Janet"  )
                        ,"data.last_name", equalTo("Weaver")
                        ,"support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));


    }
}

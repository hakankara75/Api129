package get_requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get03 {
          /*
      Given
          https://jsonplaceholder.typicode.com/todos/23
      When
          User send GET Request to the URL
      Then
          HTTP Status Code should be 200
And
    Response format should be “application/json”
And
    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
And
    “completed” is false
And
    “userId” is 2
   */


    @Test
    public void get3() {
        // 1-       Set the URL
        String url="https://jsonplaceholder.typicode.com/todos/23";

        //  2-      Set the expected data --> Bu kısım post ve put gibi body gerektiren ileriki testlerde yapılacak
        // 3-       Send the request and get the response
        Response response=given().get(url); //Not Found
        response.prettyPrint();

        //Do assertion
       // 1.yol birden fazla body metotu var. hard code. ilk hatada alt satirlar hakkinda sonuc vermez
        response.then()
                .statusCode(200)
                .contentType("application/json")
                .body("userId", equalTo(2))
                .body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"))
                .body("completed", equalTo(false));

        //2.yol tek body icinde coklu assertion yaparak soft code olusturduk. boylece tum durumlar hakkinda sonuc aliriz
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("userId", equalTo(2),
                        "title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed", equalTo(false) );

    }
}

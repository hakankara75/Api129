package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GmiBank_Authentication {

    /**
     *HerOkuApp api için token üreten method
     * @return type string dir.
     */
    public static String generateToken(){
      String bodyMap = "{ \"username\" : \"admin\", \"password\" : \"password123\" }";
        //   Map<String, String> bodyMap= new HashMap<>();  //istersek bu da calisir String yerine
//     bodyMap.put("username", "admin" );
//     bodyMap.put("password", "password123" );

       Response response= given().contentType(ContentType.JSON).body(bodyMap).post("https://gmibank.com/api/authenticate");

       return response.jsonPath().getString("token");

    }

}

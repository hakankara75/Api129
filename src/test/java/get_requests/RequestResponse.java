package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {
    /*
       1) Postman manual test için kullanılır
       2) API otomasyonu için Rest-Assured Library kullanıyoruz
       3) Otomasyon kodlarının yazımı için şu adımların izlenmesi gerekir:
           a) Gereksinimleri anlama
           b) Test Case'i yazma:
               -Test yazmak için 'Gherkin Language' kullanıyoruz.
               x) Given: Ön koşullar --> Enpoint, Body ...
               y) When: Yapılacak işlemler --> Get, Put, Delete ...
               z) Then: Dönütler --> Assertion, Close ...
               t) And:  Art arda kullanılan aynı işlemler için and kullanılır
           c) Otomasyon kolarının yazma:
               i) Set the URL --> Endpoint'i kur
               ii) Set the expected data --> Beklenen veriyi kur
               iii) Send the request and get the response --> Request yolla, response al
               iv) Do Assertion --> Doğrulama yap
        */
    public static void main(String[] args) {
    //Get request nasil yapilir:
        String endpoint ="https://petstore.swagger.io/v2/pet/7001";
       Response response= given().get(endpoint);
       response.prettyPrint(); //prettyPrint() burada response'i sout komutu gibi yazdirir

        //status code nasil yazdirilir
        System.out.println("Status code: "+ response.statusCode()); //Status code: 200
        System.out.println("Get status code: "+ response.getStatusCode()); //Get status code: 200

        //Content type nasil yazdirilir
        System.out.println("Content type code: "+ response.contentType()); //Content type code: application/json

        //statuse line nasil yazdirilir
        System.out.println("Status line: "+ response.statusLine()); //Status line: HTTP/1.1 200 OK

        //header nasil yazdirilir
        System.out.println("Server: "+ response.header("Server")); //Jetty(9.2.9.v20150224)
        System.out.println("Connection: "+ response.header("Connection")); //Connection: keep-alive

        //date time nasil yazdirilir
        System.out.println("Date: "+ response.header("Date")); //23 May 2023 09:14:05 GMT
        System.out.println("Time: "+ response.getTime()); //Time: 1635








    }
}

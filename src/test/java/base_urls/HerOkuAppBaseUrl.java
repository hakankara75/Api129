package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static utils.AuthenticationHerOkuApp.generateToken;

public class HerOkuAppBaseUrl {
    protected RequestSpecification spec;
    @Before  //her @Test methodu oncesi calisir
    public void setup(){
        spec = new RequestSpecBuilder()
                .addHeader("Cookie", "token="+generateToken())
                .setContentType(ContentType.JSON)
                .setBaseUri("https://restful-booker.herokuapp.com").build();

    }

}

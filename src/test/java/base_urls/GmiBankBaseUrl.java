package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static utils.GmiBank_Authentication.generateToken;

public class GmiBankBaseUrl {
    protected RequestSpecification spec;
    @Before  //her @Test methodu oncesi calisir
    public void setup(){
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer "+generateToken())
                .setBaseUri("https://gmibank.com")
                .build();

    }
}

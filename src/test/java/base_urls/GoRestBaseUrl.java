package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GoRestBaseUrl {
    protected RequestSpecification spec;
    @Before  //her @Test methodu oncesi calisir
    public void setup(){
        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri("https://gorest.co.in/public/v1/").build();

    }

}

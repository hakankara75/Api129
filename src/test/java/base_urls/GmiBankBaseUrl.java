package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GmiBankBaseUrl {
    protected RequestSpecification spec;
    @Before  //her @Test methodu oncesi calisir
    public void setup(){
        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJrX3R3YWluIiwiYXV0aCI6IlJPTEVfQURNSU4sUk9MRV9NQU5BR0VSIiwiZXhwIjoxNjg1OTA3NDc0fQ.lbdkxZO4VAviwyv0BirwXEGbi0Z3iNsHRvzWJqrhl6VgwV03p2yEhEkNTZYdD_LjBRbNBdcnAXfenXBa8VQxkg").setContentType(ContentType.JSON).setBaseUri("https://gmibank.com").build();

    }
}

package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {
    protected RequestSpecification spec;

    //setup methodu ile tekrarli yapilacak islemleri topluyoruz. ve test oncesi calisacak sekilde @Before
   // anatasyonu ekliyoruz.

@Before  //her @Test methodu oncesi calisir
    public void setup(){
    spec=new RequestSpecBuilder().setContentType(ContentType.JSON).
            setAccept(ContentType.JSON).setBaseUri("https://jsonplaceholder.typicode.com").build();


}

}

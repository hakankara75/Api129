package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class Get10 extends GoRestBaseUrl {
     /*
   Given
       https://gorest.co.in/public/v1/users
   When
       User send GET Request
   Then
       The value of "pagination limit" is 10
   And
       The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
   And
       The number of users should  be 10
   And
       We have at least one "active" status
   And
       "Gov. Vrinda Panicker", "Sen. Devika Embranthiri" and "Rev. Jay Shukla" are among the users
   And
       The female users are less than or equals to male users
       (Kadın kullanıcı sayısı erkek kullanıcı sayısından küçük yada eşit olamlı)
*/

    @Test
    public void name() {
        //set the url
        spec.pathParam("first", "users");

        //set the expected data
        //gelen actuallData bir list oldugu icin burada kalip olusturmadik

        //send the request and get the response
        Response response= given(spec).get("{first}");
        response.prettyPrint();

        //do assertion
        response.then().statusCode(200)
                .body("meta.pagination.limit" , equalTo(10),
                        "meta.pagination.links.current", equalTo("https://gorest.co.in/public/v1/users?page=1"),
                        "data", hasSize(10),
                        "data.status", hasItem("active"),//status'u list olarak verir. hasItem(contains) ile de active ogesinin  olup olmadigina bakar
                        "data.name", hasItems("Shashikala Butt", "Trilochana Chattopadhyay", "Chidambaram Gill"));


        //kadin ve erkek sayilarini karsilastiralim
        JsonPath jsonPath= response.jsonPath();
        List<String> genderList= jsonPath.getList("data.gender");
        System.out.println("genderList = " + genderList);

        int kadinSayisi= 0;
        for (String gender : genderList){
            if(gender.equalsIgnoreCase("female")){
                kadinSayisi++;
            }
        }

        assertTrue(kadinSayisi <=(genderList.size()-kadinSayisi));

    }
}

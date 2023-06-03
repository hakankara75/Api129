package gmi_bank;

import base_urls.GmiBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.CountryPojo;
import pojos.StatePojo;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PostCountry extends GmiBankBaseUrl {

    /*
    Given
        https://gmibank.com/api/tp-countries
    And
        {
          "name": "Banana",
          "states": [
            {
              "id": 0,
              "name": "Apple"
            },
            {
              "id": 1,
              "name": "Orange"
            },
                {
              "id": 2,
              "name": "Pear"
            }
          ]
        }

      When
        Send post request
      Then
        Status code is 201
      And
        Body:
        {
            "id": 187487,
            "name": "Banana",
            "states": [
                {
                    "id": 0,
                    "name": "Apple",
                    "tpcountry": null
                },
                {
                    "id": 1,
                    "name": "Orange",
                    "tpcountry": null
                },
                {
                    "id": 2,
                    "name": "Pear",
                    "tpcountry": null
                }
            ]
        }

     */

    @Test
    public void post01() {
        //set the url
        spec.pathParams("first", "api","second", "tp-countries");

        //set the expected data
        StatePojo state1= new StatePojo(1,"Apple");
        StatePojo state2= new StatePojo(2, "Orange");
        StatePojo state3= new StatePojo(3, "Pear");

        List<StatePojo> statePojoList= new ArrayList<>();
        statePojoList.add(state1);
        statePojoList.add(state2);
        statePojoList.add(state3);

        CountryPojo expectedData= new CountryPojo("Banana", statePojoList);

        //send the request and get the response
        Response response= given(spec).body(expectedData).post("{first}/{second}");
        response.prettyPrint();






    }
}

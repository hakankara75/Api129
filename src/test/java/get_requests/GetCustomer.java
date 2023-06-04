package get_requests;

import base_urls.GmiBankBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Account;
import pojos.Country;
import pojos.Customer;
import pojos.User;
import utils.ObjectMapperUtils;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class GetCustomer extends GmiBankBaseUrl {
          /*
    Given
        https://www.gmibank.com/api/tp-customers/133986
    When
        User sends Get request
    Then
        Status code should be 200
     And
        Response body should be like:
{
    "id": 133986,
    "firstName": "Danika",
    "lastName": "Huel",
    "middleInitial": "S",
    "email": "danikahuel@gmail.com",
    "mobilePhoneNumber": "155-489-7844",
    "phoneNumber": "155-489-7844",
    "zipCode": "32476",
    "address": "3848 Lang Hill",
    "city": "Free City",
    "ssn": "725-97-6213",
    "createDate": "2022-01-21T05:00:00Z",
    "zelleEnrolled": false,
    "country": {
        "id": 187679,
        "name": "Banana",
        "states": null
    },
    "state": "Apple",
    "user": {
        "id": 134701,
        "login": "raymundo.moen",
        "firstName": "Danika",
        "lastName": "Huel",
        "email": "danikahuel@gmail.com",
        "activated": true,
        "langKey": "en",
        "imageUrl": null,
        "resetDate": null
    },
    "accounts": [
        {
            "id": 128481,
            "description": "Description",
            "balance": 0,
            "accountType": "CHECKING",
            "accountStatusType": "ACTIVE",
            "createDate": "2022-01-04T21:00:00Z",
            "closedDate": "2022-01-04T21:00:00Z",
            "employee": null,
            "accountlogs": null
        },
        {
            "id": 131776,
            "description": "mfy",
            "balance": 536846,
            "accountType": "CREDIT_CARD",
            "accountStatusType": "ACTIVE",
            "createDate": "2022-01-18T21:00:00Z",
            "closedDate": "2022-01-18T21:00:00Z",
            "employee": null,
            "accountlogs": null
        }
    ]
}
     */

    @Test
    public void getCustomer() {
        //set the url
        spec.pathParams("first", "api", "second", "tp-customers", "third", 133986);

        //set the expected data     //serialization
        Country country = new Country("Banana", null);
        User user = new User(134701, "raymundo.moen", "Danika", "Huel", "danikahuel@gmail.com", true, "en", null, null);
        Account account1 = new Account(128481, "Description", 0, "CHECKING", "ACTIVE", "2022-01-04T21:00:00Z", "2022-01-04T21:00:00Z", null, null);
        Account account2 = new Account(131776, "mfy", 536846, "CREDIT_CARD", "ACTIVE", "2022-01-18T21:00:00Z", "2022-01-18T21:00:00Z", null, null);
        ArrayList<Account> accountList=new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);

        Customer expectedData= new Customer(133986, "Danika","Huel","S","danikahuel@gmail.com",
                "155-489-7844","155-489-7844","32476","3848 Lang Hill","Free City","725-97-6213",
                "2022-01-21T05:00:00Z",false, country, "Apple", user, accountList);


        //send the request and  get the response
        Response response= given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();

        //do assert         //de-serialization
        Customer actualData= ObjectMapperUtils.convertJsonToJava(response.asString(), Customer.class);

        assertEquals(200, response.statusCode());

        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getMiddleInitial(), actualData.getMiddleInitial());
        assertEquals(expectedData.getEmail(), actualData.getEmail());
        assertEquals(expectedData.getMobilePhoneNumber(), actualData.getMobilePhoneNumber());
        assertEquals(expectedData.getPhoneNumber(), actualData.getPhoneNumber());
        assertEquals(expectedData.getZipCode(), actualData.getZipCode());
        assertEquals(expectedData.getAddress(), actualData.getAddress());
        assertEquals(expectedData.getCity(), actualData.getCity());
        assertEquals(expectedData.getSsn(), actualData.getSsn());
        assertEquals(expectedData.getCreateDate(), actualData.getCreateDate());
        assertEquals(expectedData.isZelleEnrolled(), actualData.isZelleEnrolled());
        assertEquals(expectedData.getState(), actualData.getState());

        assertEquals(country.getName(), actualData.getCountry().getName());
        assertEquals(country.getStates(), actualData.getCountry().getStates());

        assertEquals(user.getId(), actualData.getUser().getId());
        assertEquals(user.getLogin(), actualData.getUser().getLogin());
        assertEquals(user.getFirstName(), actualData.getUser().getFirstName());
        assertEquals(user.getLastName(), actualData.getUser().getLastName());
        assertEquals(user.getEmail(), actualData.getUser().getEmail());
        assertEquals(user.getLangKey(), actualData.getUser().getLangKey());
        assertEquals(user.getImageUrl(), actualData.getUser().getImageUrl());
        assertEquals(user.getResetDate(), actualData.getUser().getResetDate());

        assertEquals(account1.getId(), actualData.getAccounts().get(0).getId());
        assertEquals(account1.getDescription(), actualData.getAccounts().get(0).getDescription());
        assertEquals(account1.getBalance(), actualData.getAccounts().get(0).getBalance());
        assertEquals(account1.getAccountType(), actualData.getAccounts().get(0).getAccountType());
        assertEquals(account1.getAccountStatusType(), actualData.getAccounts().get(0).getAccountStatusType());
        assertEquals(account1.getCreateDate(), actualData.getAccounts().get(0).getCreateDate());
        assertEquals(account1.getClosedDate(), actualData.getAccounts().get(0).getClosedDate());
        assertEquals(account1.getEmployee(), actualData.getAccounts().get(0).getEmployee());
        assertEquals(account1.getAccountlogs(), actualData.getAccounts().get(0).getAccountlogs());









    }
}

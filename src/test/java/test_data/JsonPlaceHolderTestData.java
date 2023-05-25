package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String, Object> expectedDataMap(int userId, String title, boolean completed) {

      Map<String, Object> expectedData = new HashMap<>(); //serialization java to json
        expectedData.put("userId", userId );
        expectedData.put("title", title);
        expectedData.put("completed", completed);
        System.out.println("expectedData"+ expectedData);
        return expectedData;
}
 }
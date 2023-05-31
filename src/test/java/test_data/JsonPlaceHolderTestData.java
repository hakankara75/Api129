package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String, Object> expectedDataMap(Integer userId, String title, Boolean completed) {

      Map<String, Object> expectedData = new HashMap<>(); //serialization java to json
        if (userId != null){
        expectedData.put("userId", userId );
        }
        if(title != null){
            expectedData.put("title", title);
        }
        if(completed != null){
            expectedData.put("completed", completed);
        }

        return expectedData;

}

    /**JsonPlaceHolder json datasını String'e çeviren method:
     *
     * @param userId
     * @param title
     * @param completed
     * @return type string tir
     */
    public static String expectedDataString (int userId, String title, boolean completed) {


        return "{ \"userId\": "+userId+", \"title\": \""+title+"\", \"completed\": "+completed+" }";
    }


 }
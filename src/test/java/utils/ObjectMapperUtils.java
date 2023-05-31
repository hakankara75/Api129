package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

public class ObjectMapperUtils {

    public static <T> T convertJsonToJava(String json,Class<T> cls){ //Generic method
        //<T> T --> Herhangi bir data tipini temsil eder.
        //readValue() methodu birinci paramtrede aldığı String Json datayı ikinci paramterde belirtilen data tipine çevirir.
        try {
            return new ObjectMapper().readValue(json, cls );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}

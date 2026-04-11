package techproedapi.utilities;

// Object Mapper is a class, it is used to serialization or de-serialization GSON

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
    }

    //1.Method is for "serialization" (Convert Java Object to Json Data)
    public static String convertJavaToJson(Object obj) {
        String jsonResult = "";
        try {
            jsonResult = mapper.writeValueAsString(obj);
        } catch (IOException e) {
            System.out.println("Object could not be converted to Json" + e.getMessage());
        }
        return jsonResult;
    }


    //2.Method is for "de-serialization" (Convert Json to Java Object)
    //Generic Method: You will decide return type when you use the method

    public static <T> T convertJsonToJava(String json,Class<T> cls){
        T javaResult = null;

        try {
            javaResult = mapper.readValue(json,cls);
        } catch (IOException e) {
            System.out.println("Could not covert Json to Java Object" + e.getMessage());
        }

        return javaResult;
    }
}

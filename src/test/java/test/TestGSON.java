package test;

import com.google.gson.Gson;
import test_data.DataObjectBuilder;
import test_data.models.LoginCredData;

public class TestGSON {

    public static void main(String[] args) {

        // Convert from Object to JSON
         LoginCredData loginCredData = new LoginCredData("lien@gmail.com", "12345678");
        Gson gson = new Gson();
        System.out.println(gson.toJson(loginCredData));

        // Convert from JSON to Object
        // String loginCredJSONData = "{\"email\":\"lien@gmail.com\",\"password\":\"12345678\"}";
//        String loginCredJSONData= "[\n" +
//                "  {\n" +
//                "    \"email\": \"abc@abc.abc\",\n" +
//                "    \"password\": \"12345678\"\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"email\": \"abc@sth.xyz\",\n" +
//                "    \"password\": \"123456789\"\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"email\": \"lien@gmail.com\",\n" +
//                "    \"password\": \"1234567890\"\n" +
//                "  }\n" +
//                "]";

        String filePath = "/src/test/java/test_data/authen/LoginCreds.json";

//        LoginCredData[] convertedFromJson = gson.fromJson(loginCredJSONData, LoginCredData[].class);
        LoginCredData[] convertedFromJson = DataObjectBuilder.buildDataObject(filePath, LoginCredData[].class);
        for (LoginCredData credData : convertedFromJson) {
            System.out.println(credData);
        }
    }
}

package test;

import com.google.gson.Gson;
import test_data.models.LoginCredData;

public class TestGSON {

    public static void main(String[] args) {

        // Convert from Object to JSON
        LoginCredData loginCredData = new LoginCredData("lien@gmail.com", "12345678");
        Gson gson = new Gson();
        System.out.println(gson.toJson(loginCredData));

        // Convert from JSON to Object
        String loginCredJSONData = "{\"email\":\"lien@gmail.com\",\"password\":\"12345678\"}";
        LoginCredData convertedFromJson = gson.fromJson(loginCredJSONData, LoginCredData.class);
        System.out.println(convertedFromJson);
    }
}

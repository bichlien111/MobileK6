package test_data;

import com.google.gson.Gson;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataObjectBuilder {

    public static <T> T buildDataObject(String filePath, Class<T> dataType) {

        T returnedData = null;
        Exception e = null;
        String absoluteFilePath = System.getProperty("user.dir").concat(filePath);

        try (Reader reader = Files.newBufferedReader(Paths.get(absoluteFilePath))) {
            Gson gson = new Gson();
            returnedData = gson.fromJson(reader, dataType);

        } catch (Exception exception) {
            e = exception;
        }

        if(returnedData == null) {
            throw new RuntimeException(e.getMessage());
        }

        return  returnedData;
    }
}

package io.github.toberocat.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;

public class JsonUtility {

    private static final ObjectMapper om = new ObjectMapper();

    public static boolean saveObject(File file, Object object) {
        try {
            om.writerWithDefaultPrettyPrinter().writeValue(file, object);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String saveObject(Object object) {
        try {
            return om.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static <T> T readObject(String object, Class<T> clazz) {
        try {
            return om.readValue(object, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static <T> T readObject(InputStream is, Class<T> clazz) {
        try {
            return om.readValue(is, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T readObject(File file, Class<T> clazz) throws IOException {
        return om.readValue(file, clazz);
    }

    public static <T> T readObjectFromURL(URL url, Class<T> clazz) {
        try {
            return om.readValue(url, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

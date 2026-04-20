package io.github.julianachavespalm.saucedemo.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GetUtils {
    public static JSONArray getJsonAsArray(String path, String key) throws IOException {
        String content = Files.readString(Paths.get(path));
        return new JSONObject(content).getJSONArray(key);
    }

    public static String getVariable(String name) {
        String value = System.getenv(name);
        if (value != null && !value.isEmpty()) {
            return value;
        }
        value = System.getProperty(name);
        if (value != null && !value.isEmpty()) {
            return value;
        }
        return null;
    }
}
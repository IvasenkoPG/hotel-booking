package com.ivasenko.hotel.server.hotelbooking.utils;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonParserUtil {
    public static JSONObject parseJsonToObject(String pathToFile) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        File file = new File(ClassLoader.getSystemResource(pathToFile).getFile());
        Object obj = parser.parse(new FileReader(file));
        return (JSONObject) obj;
    }
}

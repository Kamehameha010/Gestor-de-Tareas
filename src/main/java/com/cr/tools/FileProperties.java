package com.cr.tools;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class FileProperties {

    public static void writeFile(FileWriter fileWriter, HashMap<String, String> propities, String comments){
        var prop = new Properties();
        propities.forEach( (key,value) -> prop.setProperty(key, value));
        try {
            prop.store(fileWriter,comments);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties readFile(FileReader filename) {

        var properties = new Properties();
        try {
            properties.load(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}

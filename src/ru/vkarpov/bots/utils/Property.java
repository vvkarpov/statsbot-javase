package ru.vkarpov.bots.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Property {

    public static String getProperties(String key){
        Properties property = new Properties();

        try {
            InputStream in = Property.class.getResourceAsStream("config.properties");
            property.load(in);

        } catch (IOException e) {
            System.err.println("ERROR: File config.properties not find!");
        }

        return property.getProperty(key);
    }

}

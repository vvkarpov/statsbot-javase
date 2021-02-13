package ru.vkarpov.bots.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {

    public static String getProperties(String key){
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/ru/vkarpov/bots/resources/config.properties");
            property.load(fis);

        } catch (IOException e) {
            System.err.println("ERROR: File config.properties not find!");
        }

        return property.getProperty(key);
    }

}

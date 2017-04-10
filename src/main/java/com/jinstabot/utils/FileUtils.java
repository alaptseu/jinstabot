package com.jinstabot.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Alex L.
 */
public class FileUtils {

    public static Properties loadProperties(File file) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(file));
            return properties;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

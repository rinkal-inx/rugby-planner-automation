package com.rugby.planner.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    // This method loads the config.properties file
    public static void loadConfig() {
        try {
            FileInputStream fis = new FileInputStream("src/test/resource/config/config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("❌ Failed to load config.properties file!");
        }
    }

    public static String getProperty(String key) {
        if (properties == null) {
            loadConfig(); // auto-load if not loaded yet
        }
        return properties.getProperty(key);
    }
}

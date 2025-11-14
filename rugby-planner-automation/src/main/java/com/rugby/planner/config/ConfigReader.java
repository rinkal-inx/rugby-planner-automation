package com.rugby.planner.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    public static void loadConfig() {
        try {
            InputStream input = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config/config.properties");

            if (input == null) {
                throw new RuntimeException("❌ config.properties NOT FOUND in classpath!");
            }

            properties.load(input);
            System.out.println("✔ config.properties loaded successfully");

        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to load config: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        if (properties.isEmpty()) {
            loadConfig();
        }
        return properties.getProperty(key);
    }
}
/*package com.rugby.planner.config;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    // This method loads the config.properties file
    public static void loadConfig() {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
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
}*/

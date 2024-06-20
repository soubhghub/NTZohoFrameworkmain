package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();
    private static final String propertyFilePath = "src/test/resources/config.properties";

    static {
        try {
            FileInputStream fis = new FileInputStream(propertyFilePath);
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (key.endsWith(".path")) {
            return Paths.get(value).toAbsolutePath().toString();
        }
        return value;
    }
}

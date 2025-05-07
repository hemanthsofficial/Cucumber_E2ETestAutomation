package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyExtractor {
    public static String extract(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/config/Config.properties");
        properties.load(fileInputStream);
        return properties.getProperty(key);
    }
}
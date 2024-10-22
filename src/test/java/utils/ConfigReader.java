package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties properties = new Properties();
    public static String getProperty(String key) {
        try {
            properties.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (IOException e) {
            System.out.println("Unable to locate Config property file");
        }
        return properties.getProperty(key);
    }

}

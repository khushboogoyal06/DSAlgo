package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    static Properties prop;

    // load properties file
    public static Properties initProperties() {

        prop = new Properties();

        try {
            InputStream input = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config/config.properties");

            if (input != null) {
                prop.load(input);
            } else {
                System.out.println("config.properties file NOT found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return prop;
    }

    // get value from properties file
    public static String getProperty(String key) {

        // if properties not loaded, load them
        if (prop == null) {
            initProperties();
        }

        return prop.getProperty(key);
    }
}

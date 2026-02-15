package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    static Properties prop;

    public static Properties initProperties() {

        prop = new Properties();

        try {

            InputStream input = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config/config.properties");

            if (input == null) {
                System.out.println("config.properties file NOT found");
                return prop;   
            }

            prop.load(input);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return prop;   
    }

    public static String getProperty(String key) {

        if (prop == null) {
            initProperties();
        }

        return prop.getProperty(key);
    }
}

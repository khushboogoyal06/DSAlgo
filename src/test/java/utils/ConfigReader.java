package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	private  Properties prop;

	/**
	 * This is to load the properties from the congig.properties file
	 * @return 
	 * @return
	 */
	 public Properties init_prop() {
		try {
			
				prop = new Properties();
				FileInputStream fis = new FileInputStream("src/test/resources/Config/config.properties");
				prop.load(fis);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return prop;
	 }
}
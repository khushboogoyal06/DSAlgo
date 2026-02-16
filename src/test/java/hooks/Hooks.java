package hooks;

import io.cucumber.java.Before;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import driverfactory.DriverFactory;
import io.cucumber.java.After;
import utils.ConfigReader;

public class Hooks {
	
	private DriverFactory driverfactory;
	private WebDriver driver;
	ConfigReader configReader;
	Properties prop ;
	

    @Before(order=0)
    public void getProperty() {
    	configReader = new ConfigReader();
    	prop = configReader.init_prop();
        
    }
    
    @Before(order=1)
    public void launchBrowser() {
    	configReader = new ConfigReader();
    	String browserName = prop.getProperty("browser");
    	driverfactory = new DriverFactory();
    	driver = driverfactory.initDriver(browserName);
    	
    	String url = prop.getProperty("url");
    	System.out.println("url is " + url);
    	driver.get(url);
        
    }

    @After(order=0)
    public void quitBrowser() {
    	driver.quit();
        
    }
}


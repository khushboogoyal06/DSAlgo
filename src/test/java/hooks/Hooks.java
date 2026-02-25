package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import driverfactory.DriverFactory;
import io.cucumber.java.After;

import driverfactory.DriverFactory;
import pages.QueuePage;
import utils.ConfigReader;

public class Hooks {
	
	private DriverFactory driverfactory;
	private WebDriver driver;
	ConfigReader configReader;
	Properties prop ;
	

    private static final Logger logger = LogManager.getLogger(Hooks.class);
	

    @Before(order=0)
    public void setUp() {

        // load config file
        ConfigReader.initProperties();

        // start browser
        DriverFactory.initDriver();

        // open url
        DriverFactory.getDriver().get(
                ConfigReader.getProperty("url")
        );
    }
@Before(order=1, value="@login")
   public void login() {
	   // LOGIN
       QueuePage queuePage =
               new QueuePage(DriverFactory.getDriver());

       queuePage.clickSignIn();
       queuePage.login(
               ConfigReader.getProperty("username"),
               ConfigReader.getProperty("password")
       );
	   
   }
    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
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
    	 logger.info("Launching browser..." +url);
    	driver.get(url);
        
    }

    @After(order=0)
    public void quitBrowser() {
    	driver.quit();
        
    }
    
    @After(order=1)
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            logger.error("Scenario FAILED: " + scenario.getName());
            // take screenshot here
        } else {
            logger.info("Scenario PASSED: " + scenario.getName());
        }

        logger.info("Closing browser...");
        logger.info("===== Ending Scenario =====");
        // driver.quit();
    }
}
    
    
    
    


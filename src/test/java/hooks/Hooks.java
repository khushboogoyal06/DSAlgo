package hooks;

import io.cucumber.java.Before;
import driverfactory.DriverFactory;
import io.cucumber.java.After;
import utils.ConfigReader;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.initDriver();
        DriverFactory.getDriver().get(
            ConfigReader.getProperty("url")
        );
    }

    @After
    public void tearDown() {
        DriverFactory.getDriver().quit();
    }
}


/*
 * import driverfactory.DriverFactory; import io.cucumber.java.After; import
 * io.cucumber.java.Before; import io.cucumber.java.Scenario;
 * 
 * public class Hooks {
 * 
 * @Before public void launchBrowser() { DriverFactory.initDriver(); }
 * 
 * @After(order = 1) public void quitBrowser(Scenario scenario) {
 * 
 * if (DriverFactory.getDriver() != null) { DriverFactory.getDriver().quit(); }
 * }
 * 
 * }
 */

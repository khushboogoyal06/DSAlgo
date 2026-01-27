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


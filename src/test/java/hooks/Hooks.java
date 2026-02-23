package hooks;

import driverfactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before(order = 0)
	public void setUp() {
		DriverFactory.initDriver();
		DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/");
	}

	@After(order = 0)
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
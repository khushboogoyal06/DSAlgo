package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.QueuePage;
import pages.RegisterPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverfactory.DriverFactory;
import io.cucumber.java.After;
import utils.ConfigReader;

public class Hooks {

	private DriverFactory driverfactory;
	private WebDriver driver;
	ConfigReader configReader;
	Properties prop;

	private static final Logger logger = LogManager.getLogger(Hooks.class);

	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();

	}

//	@Before(order = 1)
//	public void launchBrowser() throws InterruptedException {
//		configReader = new ConfigReader();
//		String browserName = prop.getProperty("browser");
//		driverfactory = new DriverFactory();
//		driver = driverfactory.initDriver(browserName);
//
//		String url = prop.getProperty("url");
//		logger.info("Launching browser..." + url);
//		driver.get(url);
//		Thread.sleep(2000);
//
//	}
	
	
	@Before(order = 1, value = "@register")
	public void register() throws InterruptedException {
		// LOGIN
		configReader = new ConfigReader();
		String browserName = prop.getProperty("browser");
		driverfactory = new DriverFactory();
		driver = driverfactory.initDriver(browserName);
		
		logger.info("driver  browser..." + driver);

		String url = prop.getProperty("url");
		logger.info("Launching browser..." + url);
		driver.get(url);
		Thread.sleep(1000);
		
		

	}

	@Before(order = 1, value = "@login")
	public void login() throws InterruptedException {
		// LOGIN
		configReader = new ConfigReader();
		String browserName = prop.getProperty("browser");
		driverfactory = new DriverFactory();
		driver = driverfactory.initDriver(browserName);
		
		logger.info("driver  browser..." + driver);

		String url = prop.getProperty("url");
		logger.info("Launching browser..." + url);
		driver.get(url);
		Thread.sleep(1000);
		QueuePage queuePage = new QueuePage(DriverFactory.getDriver());
		RegisterPage registerpage = new RegisterPage(DriverFactory.getDriver());
		registerpage.clickonGetstartedButton();
		Thread.sleep(1000);
		queuePage.clickSignIn();
		queuePage.login(prop.getProperty("username"), prop.getProperty("password"));
		

	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();

	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {
			logger.error("Scenario FAILED: " + scenario.getName());
			// take screenshot here

			String ScreenshotName = scenario.getName().replaceAll(" ", "");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", ScreenshotName);

		} else {
			logger.info("Scenario PASSED: " + scenario.getName());
		}

		logger.info("Closing browser...");
		logger.info("===== Ending Scenario =====");
		// driver.quit();
	}
}

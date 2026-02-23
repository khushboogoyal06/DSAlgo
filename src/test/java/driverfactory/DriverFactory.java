package driverfactory;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigReader;

public class DriverFactory {

	private static final Logger logger = LogManager.getLogger(DriverFactory.class);

	private static final ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	private static final ThreadLocal<String> tlBrowser = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return tldriver.get();
	}

	public static void setupBrowser(String browser) {
		tlBrowser.set(browser);
		System.out.println("Browser set to: " + browser);
	}

	public static String getBrowser() {
		return tlBrowser.get();
	}

	public static void initDriver() {
		// If driver already exists for this thread, don’t create again
		if (tldriver.get() != null) {
			return;
		}

		String browserName = tlBrowser.get();
		if (browserName == null || browserName.trim().isEmpty()) {
			browserName = ConfigReader.getProperty("browser");
		}

		logger.info("You selected " + browserName + " to run these tests");

		WebDriver driver;

		if (browserName != null && browserName.trim().equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName != null && browserName.trim().equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName != null && browserName.trim().equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Wrong browser in config: " + browserName);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0)); // keep OFF, use explicit waits
		driver.manage().window().maximize();

		tldriver.set(driver);
	}

	// Call this ONLY from Hooks @After
	public static void quitDriver() {
		WebDriver driver = tldriver.get();
		try {
			if (driver != null) {
				driver.quit();
			}
		} finally {
			tldriver.remove();
			tlBrowser.remove();
		}
	}
}
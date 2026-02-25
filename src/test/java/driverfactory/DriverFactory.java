package driverfactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.messages.types.Duration;
import utils.ConfigReader;

public class DriverFactory {

    // single driver instance
    public static WebDriver driver;

    /**
     * This is used to initialize the thread local driver on the basis of given driver
     * @param browser
     * @return
     */
    public  WebDriver initDriver(String browser) {

        //String browser = ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } 
        else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } 
        else {
            System.out.println("Browser not supported. Launching Chrome by default.");
            driver = new ChromeDriver();
        }

        // basic setup
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        return driver;
    }

    public static synchronized WebDriver getDriver() {
        return mydriver.get();
    }

    // quit driver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

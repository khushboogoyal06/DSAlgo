package driverfactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;

public class DriverFactory {

    private static ThreadLocal<WebDriver> mydriver = new ThreadLocal<>();

    public static WebDriver initDriver() {

        String browser = ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            mydriver.set(new ChromeDriver());
        } 
        else if (browser.equalsIgnoreCase("firefox")) {
            mydriver.set(new FirefoxDriver());
        }

        getDriver().manage().window().maximize();
        //getDriver().deleteAllCookies();

        return getDriver();
    }

    public static WebDriver getDriver() {
        return mydriver.get();
    }
}




/*
 * import java.time.Duration;
 * 
 * import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.edge.EdgeDriver; import
 * org.openqa.selenium.firefox.FirefoxDriver;
 * 
 * import io.cucumber.java.After; import utils.ConfigReader;
 * 
 * public class DriverFactory { private static final ThreadLocal<WebDriver>
 * tldriver = new ThreadLocal<>(); private static ThreadLocal<String> plbrowser
 * = new ThreadLocal<>();
 * 
 * private static WebDriver driver;
 * 
 * public static WebDriver getDriver() { return tldriver.get();
 * 
 * }
 * 
 * public static void setupBrowser(String browser) { plbrowser.set(browser);
 * System.out.println(browser);
 * 
 * }
 * 
 * public static String getBrowser() {
 * 
 * System.out.println("plbroswer is set to" + plbrowser.get()); return
 * plbrowser.get();
 * 
 * }
 * 
 * public static void initDriver() {
 * 
 * String browserName = plbrowser.get(); if (browserName == null) { browserName
 * = ConfigReader.getProperty("browser"); } System.out.println(browserName);
 * System.out.println("You selected " + browserName + " to run these tests");
 * 
 * if (browserName.trim().equalsIgnoreCase("chrome")) { tldriver.set(new
 * ChromeDriver());
 * 
 * } else if (browserName.trim().equalsIgnoreCase("firefox")) { tldriver.set(new
 * FirefoxDriver());
 * 
 * } else if (browserName.trim().equalsIgnoreCase("edge")) { tldriver.set(new
 * EdgeDriver());
 * 
 * } else { System.out.println("You selected wrong browser: " + browserName);
 * return; } driver = tldriver.get();
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 * driver.manage().window().maximize();
 * 
 * }
 * 
 * @After(order = 0) public void close() {
 * 
 * tldriver.remove();
 * 
 * } }
 */
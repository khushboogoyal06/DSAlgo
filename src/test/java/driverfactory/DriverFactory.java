package driverfactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> mydriver = new ThreadLocal<>();

    /**
     * This is used to initialize the thread local driver on the basis of given driver
     * @param browser
     * @return
     */
    public  WebDriver initDriver(String browser) {

        //String browser = ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            mydriver.set(new ChromeDriver());
        } 
        else if (browser.equalsIgnoreCase("firefox")) {
            mydriver.set(new FirefoxDriver());
        }

       
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return mydriver.get();
    }
}
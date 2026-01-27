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



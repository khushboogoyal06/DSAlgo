package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;

import driverfactory.DriverFactory;
import pages.QueuePage;
import utils.ConfigReader;

public class Hooks {

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

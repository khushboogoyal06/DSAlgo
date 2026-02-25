package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import driverfactory.DriverFactory;
import io.cucumber.java.en.*;
import java.time.Duration;

public class GraphSteps {

    private WebDriver driver;
    // FIXED CONSTRUCTOR
    public GraphSteps() {
        driver = DriverFactory.getDriver();
        new WebDriverWait(driver, Duration.ofSeconds(10));
    }

@Given("User is logged into DS Algo portal successfully")
public void the_user_is_logged_into_ds_algo_portal_successfully() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("User clicks on the Get Started button present in graph card")
public void user_clicks_on_the_get_started_button_present_in_graph_card() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Graph page header should be {string}")
public void graph_page_header_should_be(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("User is in Graph Page")
public void user_is_in_graph_page() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("User clicks on Graph topic {string}")
public void user_clicks_on_graph_topic(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
}


package stepdefinitions;

import static org.junit.Assert.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import driverfactory.DriverFactory;
import io.cucumber.java.en.*;
import pages.GraphPage;

import java.time.Duration;

public class GraphSteps {

    private WebDriver driver;
    private GraphPage graphPage;
    private WebDriverWait wait;

    public GraphSteps() {
        driver = DriverFactory.getDriver();
        graphPage = new GraphPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // LOGIN

    @Given("User is logged into DS Algo portal successfully")
    public void user_logged_into_portal_successfully() {
        // handled by login hook
    }

    // GRAPH PAGE HEADER

    @When("User clicks on the Get Started button present in graph card")
    public void user_clicks_graph_get_started_button() {
        graphPage.openGraphPage();
    }

    @Then("Graph page header should be {string}")
    public void verify_graph_page_header(String expectedHeader) {
        assertEquals(expectedHeader, graphPage.getGraphHeaderText());
    }

    // GRAPH PAGE

    @Given("User is in Graph Page")
    public void user_is_in_graph_page() {
        graphPage.openGraphPage();
    }

    // TOPIC NAVIGATION

    @When("User clicks on Graph topic {string}")
    public void user_clicks_graph_topic(String topic) {
        graphPage.clickTopic(topic);
    }

    @Then("User should navigate to Graph title {string}")
    public void verify_graph_topic_navigation(String expectedTitle) {
        assertEquals(expectedTitle, graphPage.getTopicHeaderText(expectedTitle));
    }

    // PRACTICE PAGE

    @Given("User is in Graph {string} page")
    public void user_is_in_graph_topic_page(String topic) {
        graphPage.openGraphPage();
        graphPage.clickTopic(topic);
    }

    @When("User clicks on Graph practice questions")
    public void user_clicks_graph_practice_questions() {
        graphPage.clickPracticeQuestions();
    }

    @Then("User should navigate to Graph practice page")
    public void verify_graph_practice_page_navigation() {
        assertTrue(driver.getCurrentUrl().contains("practice"));
    }

    // TRY HERE

    @When("User clicks on Graph Try here button")
    public void user_clicks_graph_try_here_button() {
        graphPage.clickTryHere();
    }

    @Then("User should navigate to Graph Try Editor page")
    public void verify_graph_try_editor_navigation() {
        assertTrue(driver.getCurrentUrl().contains("tryEditor"));
    }

    @Then("Graph Run Button should be visible")
    public void verify_graph_run_button_visibility() {
        assertTrue(graphPage.isRunButtonDisplayed());
    }

    // VALID CODE EXECUTION

    @Given("User is in Graph Try editor page of corresponding {string}")
    public void user_is_in_graph_try_editor_page(String topic) {
        graphPage.openGraphPage();
        graphPage.clickTopic(topic);
        graphPage.clickTryHere();
    }

    @When("User runs valid Graph code")
    public void user_runs_valid_graph_code() {
        graphPage.enterCode("print(\"Hello Graph\")");
        graphPage.clickRun();
    }

    @Then("Graph output should be displayed")
    public void verify_graph_output() {
        assertFalse(graphPage.getOutput().isEmpty());
    }

    // INVALID CODE EXECUTION

    @When("User runs invalid Graph code")
    public void user_runs_invalid_graph_code() {
        graphPage.enterCode("print(");
        graphPage.clickRun();
    }

    @Then("Graph error alert should be displayed")
    public void verify_graph_error_alert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertNotNull(alert.getText());
        alert.accept();
    }
}
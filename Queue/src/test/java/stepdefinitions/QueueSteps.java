package stepdefinitions;

import static org.junit.Assert.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import driverfactory.DriverFactory;
import io.cucumber.java.en.*;
import pages.QueuePage;

import java.time.Duration;

public class QueueSteps {

    private WebDriver driver;
    private QueuePage queuePage;
    private WebDriverWait wait;

    private void initPages() {
        driver = DriverFactory.getDriver();
        queuePage = new QueuePage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("user successfully signed in to DSAlgo portal")
    public void user_successfully_signed_in() {
        initPages();
    }

    @Given("User is on the Home page")
    public void user_on_home_page() {
        initPages();
    }

    @When("User clicks on the Get Started button present in Queue card")
    public void click_queue_get_started() {
        queuePage.openQueuePage();
    }

    @Then("Queue page header should be {string}")
    public void verify_queue_header(String expected) {
        assertEquals(expected, queuePage.getQueueHeaderText());
    }

    @Given("User is in Queue Page")
    public void user_is_in_queue_page() {
        initPages();
        queuePage.openQueuePage();
    }


    @When("User clicks on Queue topic {string}")
    public void user_clicks_queue_topic(String topic) {
        queuePage.clickTopic(topic);
    }

    @Then("User should navigate to {string}")
    public void user_should_navigate_to(String expectedTitle) {
        assertEquals(
            expectedTitle,
            queuePage.getTopicHeaderText(expectedTitle)
        );
    }

    @Given("User is in {string} page")
    public void user_is_in_topic_page(String topic) {
        initPages();
        queuePage.openQueuePage();
        queuePage.clickTopic(topic);
    }
    
    @When("User clicks on practice questions")
    public void click_practice_questions() {
        queuePage.clickPracticeQuestions();
    }

    @Then("User should navigate to practice page")
    public void verify_practice_page() {
        assertTrue(driver.getCurrentUrl().contains("/practice"));
    }

    @When("User clicks on Try here button")
    public void click_try_here() {
        queuePage.clickTryHere();
    }

    @Then("User should navigate to Try Editor page")
    public void verify_try_editor_page() {
        assertTrue(driver.getCurrentUrl().contains("/tryEditor"));
    }

    @Then("Run Button Appears on the Page")
    public void run_button_visible() {
        assertTrue(queuePage.isRunButtonDisplayed());
    }

    @Given("User is in Try editor page of corresponding {string}")
    public void user_is_in_Try_editor_page_of_corresponding(String topicLink) {
        initPages();
        queuePage.openQueuePage();
        queuePage.clickTopic(topicLink);
        queuePage.clickTryHere();
    }

    @When("User clicks run button after entering valid code")
    public void run_valid_code() {
        queuePage.enterCode("print(\"Hello\")");
        queuePage.clickRun();
    }

    @Then("Expected output should be displayed")
    public void verify_output() {
        assertFalse(queuePage.getOutput().isEmpty());
    }

    @When("User clicks run button after entering invalid code")
    public void run_invalid_code() {
        queuePage.enterCode("print(");
        queuePage.clickRun();
    }

    @Then("Alert should appear with error message")
    public void verify_alert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertNotNull(alert.getText());
        alert.accept();
    }
}

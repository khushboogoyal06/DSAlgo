package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class QueuePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public QueuePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Sign in")
    private WebElement signInLink;

    @FindBy(id = "id_username")
    private WebElement usernameField;

    @FindBy(id = "id_password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    @FindBy(linkText = "Sign out")
    private WebElement signOutLink;

    @FindBy(xpath = "//a[@href='queue' and normalize-space()='Get Started']")
    private WebElement queueGetStarted;

    @FindBy(xpath = "//h4[normalize-space()='Queue']")
    private WebElement queueHeader;

    @FindBy(xpath = "//p[contains(@class,'bg-secondary') and contains(@class,'text-white')]")
    private List<WebElement> topicHeaders;

    @FindBy(xpath = "//a[normalize-space()='Practice Questions']")
    private WebElement practiceQuestions;

    @FindBy(xpath = "//a[@href='/tryEditor']")
    private WebElement tryHere;

    // CodeMirror hidden textarea
    @FindBy(css = ".CodeMirror textarea")
    private WebElement codeMirrorEditor;

    
    @FindBy(xpath = "//button[normalize-space()='Run']")
    private WebElement runButton;

    @FindBy(id = "output")
    private WebElement output;

    //  DYNAMIC LOCATOR 

    private By topicLink(String topicName) {
        return By.xpath(
            "//a[contains(@class,'list-group-item') and normalize-space()='" + topicName + "']"
        );
    }


  
    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
    }

    public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public boolean isUserLoggedIn() {
        return wait.until(ExpectedConditions.visibilityOf(signOutLink)).isDisplayed();
    }

  
    public void openQueuePage() {
        wait.until(ExpectedConditions.elementToBeClickable(queueGetStarted)).click();
    }

    public String getQueueHeaderText() {
        return wait.until(ExpectedConditions.visibilityOf(queueHeader))
                   .getText()
                   .trim();
    }

    public void clickTopic(String topicName) {
        WebElement topic =
                wait.until(ExpectedConditions.elementToBeClickable(topicLink(topicName)));
        topic.click();
    }

    public String getTopicHeaderText(String expectedTitle) {
        for (WebElement header : topicHeaders) {
            if (header.getText().trim().equals(expectedTitle)) {
                return header.getText().trim();
            }
        }
        throw new NoSuchElementException(
            "Topic header not found with title: " + expectedTitle
        );
    }


    public boolean isPracticeQuestionsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(practiceQuestions))
                   .isDisplayed();
    }

    public void clickPracticeQuestions() {
        wait.until(ExpectedConditions.elementToBeClickable(practiceQuestions)).click();
    }

   
    public boolean isTryHereDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(tryHere)).isDisplayed();
    }

    public void clickTryHere() {
        wait.until(ExpectedConditions.elementToBeClickable(tryHere)).click();
    }

    
    public void enterCode(String code) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "document.querySelector('.CodeMirror').CodeMirror.setValue(arguments[0]);",
            code
        );
    }

    public void clickRun() {
        wait.until(ExpectedConditions.elementToBeClickable(runButton)).click();
    }

    public boolean isRunButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(runButton)).isDisplayed();
    }

    public String getOutput() {
        return wait.until(ExpectedConditions.visibilityOf(output))
                   .getText()
                   .trim();
    }
}

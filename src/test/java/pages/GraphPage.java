package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class GraphPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public GraphPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    
    // LOGIN ELEMENTS
    
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

   
    // GRAPH MODULE ELEMENTS
 
    @FindBy(xpath = "//a[@href='graph' and normalize-space()='Get Started']")
    private WebElement graphGetStarted;

    @FindBy(xpath = "//h4[normalize-space()='Graph']")
    private WebElement graphHeader;

    @FindBy(xpath = "//p[contains(@class,'bg-secondary') and contains(@class,'text-white')]")
    private List<WebElement> topicHeaders;

    @FindBy(xpath = "//a[normalize-space()='Practice Questions']")
    private WebElement practiceQuestions;

    @FindBy(xpath = "//a[@href='/tryEditor']")
    private WebElement tryHere;

    // CodeMirror editor
    @FindBy(css = ".CodeMirror textarea")
    private WebElement codeMirrorEditor;

    @FindBy(xpath = "//button[normalize-space()='Run']")
    private WebElement runButton;

    @FindBy(id = "output")
    private WebElement output;

   
    // DYNAMIC TOPIC LOCATOR
   
    private By topicLink(String topicName) {
        return By.xpath(
            "//a[contains(@class,'list-group-item') and normalize-space()='" + topicName + "']"
        );
    }

   
    // LOGIN ACTIONS
  
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

    
    // GRAPH PAGE ACTIONS
  
    public void openGraphPage() {
        wait.until(ExpectedConditions.elementToBeClickable(graphGetStarted)).click();
    }

    public String getGraphHeaderText() {
        return wait.until(ExpectedConditions.visibilityOf(graphHeader))
                   .getText().trim();
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
        throw new NoSuchElementException("Topic header not found: " + expectedTitle);
    }

   
    // PRACTICE QUESTIONS
    

    public boolean isPracticeQuestionsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(practiceQuestions)).isDisplayed();
    }

    public void clickPracticeQuestions() {
        wait.until(ExpectedConditions.elementToBeClickable(practiceQuestions)).click();
    }

  
    // TRY EDITOR
    

    public boolean isTryHereDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(tryHere)).isDisplayed();
    }

    public void clickTryHere() {
        wait.until(ExpectedConditions.elementToBeClickable(tryHere)).click();
    }

    
    // CODE EXECUTION
    
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
                   .getText().trim();
    }
}
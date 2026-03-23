package pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverfactory.DriverFactory;
import utils.ConfigReader;

public class DataStructuresIntro {
	private static final Logger logger = LogManager.getLogger(DataStructuresIntro.class);
	private WebDriver driver;
	@FindBy(xpath = "//a[@class='list-group-item']")
	private WebElement timeComplexityLink;
	@FindBy(xpath = "//a[normalize-space()='Practice Questions']")
	private WebElement practiseQuestionsLink;
	@FindBy(xpath = "//a[normalize-space()='Try here>>>']")
	private WebElement tryHereButton;
	@FindBy(xpath = "//button[normalize-space()='Run']")
	private WebElement runButton;
	@FindBy(xpath = "//pre[@id='output']")
	private WebElement outputMessage;


	public DataStructuresIntro() {
		logger.info("DataStructure introduction constructor....");
		driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}

	public void successfulLoginAndNavigationToDataStructuresIntro() {
		String url = ConfigReader.getProperty("url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@class='btn']")).click();
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		driver.findElement(By.xpath("//input[@id='id_username']")).sendKeys("Test-0707");
		driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("Thankyou1234#");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[@href='data-structures-introduction']")).click();
	}

	public void goToTimeComplexPage() {
		timeComplexityLink.click();
	}

	public String fetchTitle() {
		return driver.getTitle();
	}
	public void goToPracticeQuestionsPage() {
		practiseQuestionsLink.click();
	}
	public void clickOnTryHere() {
		logger.info("clicking on try here button");
		tryHereButton.click();
	}
	public String enterPythonCodeAndClickRun(String valid) {
		logger.info("entering text in editor ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(valid.equalsIgnoreCase("y")) {
			js.executeScript("editor.setValue('print(\"Valid python code\")');");
			logger.info("Entered valid code");
		}else if(valid.equalsIgnoreCase("n")) {
			js.executeScript("editor.setValue('some non python text');");
			logger.info("Entered invalid code");
		}
		logger.info("entered code in editor");
		runButton.click();
		logger.info("clicked on run");
		String result=runCodeAndGetResult(driver);
		logger.info(outputMessage.getText());
		return result;
	}

	public String runCodeAndGetResult(WebDriver driver) {

		String result = "";
		try {
			Alert alert = driver.switchTo().alert();
			result = alert.getText();
			alert.accept();
		} catch (NoAlertPresentException e) {
			result = outputMessage.getText();
		}

		return result;
	}


}

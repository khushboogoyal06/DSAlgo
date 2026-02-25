package pages;

import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
	private WebDriver driver;
	
	  private static final Logger logger = LogManager.getLogger(RegisterPage.class);
	
	//1. By Locator
	
	private By register  = By.xpath("//a[contains(text(),'Register')]");
	private By getStartedBtn = By.xpath("//button[@class='btn']");
	private By loginLink = By.xpath("//a[text()='Login ']");
	private By registerBtn = By.xpath("//input[@value='Register']");
	private By username = By.xpath("//input[@value='Register']");
	//WebElement username = driver.findElement(By.id("username"));
	
	
	//2. Constructor of the page class
	
	public RegisterPage(WebDriver driver) {
		this.driver =driver;
	}
	
  //page action
	
	public String getRegisterPageTitle() {
		return driver.getTitle().trim();
	}
	
	public boolean isRegisterLinkPresent() {
		return	driver.findElement(register).isDisplayed();
	
	}
	public void clickOnRegisterlnk() {
		driver.findElement(register).click();
		
	}
	
	public boolean isLoginLinkPresent() {
		return	driver.findElement(loginLink).isDisplayed();
	
	}
	
	public void clickonGetstartedButton() {
		driver.findElement(getStartedBtn).click();
	}
	
	public void clickonRegisterBtn() {
		driver.findElement(registerBtn).click();
	}
   public void validateErrormessageforUsername() {
	   String validationMessage = driver.findElement(username).getAttribute("validationMessage");
	   System.out.println("validation Message is " + validationMessage);
	   
   }
	
}

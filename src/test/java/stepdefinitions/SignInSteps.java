package stepdefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverfactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInSteps {

	private WebDriver driver;
	private WebDriverWait wait;

	private final By usernameTxt = By.id("id_username");
	private final By passwordTxt = By.id("id_password");
	private final By loginBtn = By.cssSelector("input[type='submit'], input[value='Login']");
	private final By registerLinkExact = By.linkText("Register");
	private final By alertMsg = By.cssSelector(".alert, .alert-danger, .alert-primary, .error, .message");

	private void init() {
		driver = DriverFactory.getDriver();
		if (driver == null) {
			DriverFactory.initDriver();
			driver = DriverFactory.getDriver();
		}
		Assert.assertNotNull("Driver is null", driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	@Given("^User is in Sign-Page\\.?$")
	public void user_is_in_sign_page() {
		init();
		driver.get("https://dsportalapp.herokuapp.com/login");
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTxt));
	}

	@When("^User clicks on Sign-in link on Sign-In Page\\.?$")
	public void user_clicks_on_sign_in_link_on_sign_in_page() {
		init();
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTxt));
	}

	@Then("^User Sign-In page should be dispalyed\\.?$")
	public void user_sign_in_page_should_be_dispalyed() {
		init();
		boolean urlOk = driver.getCurrentUrl().toLowerCase().contains("login");
		boolean fieldVisible = !driver.findElements(usernameTxt).isEmpty();
		Assert.assertTrue("Login page not displayed", urlOk || fieldVisible);
	}

	@When("^User clicks on \"([^\"]*)\" link in Sign-In Page\\.?$")
	public void user_clicks_on_link_in_sign_in_page(String linkTextFromFeature) {
		init();

		String normalized = linkTextFromFeature.replaceAll("[^a-zA-Z]", "").toLowerCase();

		if (normalized.equals("register")) {
			if (!driver.findElements(registerLinkExact).isEmpty()) {
				wait.until(ExpectedConditions.elementToBeClickable(registerLinkExact)).click();
				return;
			}
			By registerAnyCase = By.xpath(
					"//a[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'register')]"
					);
			wait.until(ExpectedConditions.elementToBeClickable(registerAnyCase)).click();
			return;
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkTextFromFeature))).click();
	}

	@Then("^User should be redirected to register Page\\.?$")
	public void user_should_be_redirected_to_register_page() {
		init();
		String url = driver.getCurrentUrl().toLowerCase();
		Assert.assertTrue("Not redirected to register page", url.contains("register"));
	}

	@When("^User enters username,password and clicks on Login\\.?$")
	public void user_enters_username_password_and_clicks_on_login() {
		init();
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTxt)).clear();
		driver.findElement(usernameTxt).sendKeys("testuser");

		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTxt)).clear();
		driver.findElement(passwordTxt).sendKeys("testpass");

		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
	}

	@Then("^Expected message in excel should be displayed\\.?$")
	public void expected_message_in_excel_should_be_displayed() {
		init();
		WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(alertMsg));
		Assert.assertTrue(msg.getText().toLowerCase().contains("invalid"));
	}

	@Then("^Username field should be visible and password field should be visible\\.?$")
	public void username_field_should_be_visible_and_password_field_should_be_visible() {
		init();
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTxt)).isDisplayed());
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTxt)).isDisplayed());
	}

	@Then("^the Login button should be enabled\\.?$")
	public void the_login_button_should_be_enabled() {
		init();
		WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(loginBtn));
		Assert.assertTrue(btn.isEnabled());
	}

	@Then("^the password field should be masked\\.?$")
	public void the_password_field_should_be_masked() {
		init();
		WebElement pwd = wait.until(ExpectedConditions.presenceOfElementLocated(passwordTxt));
		Assert.assertEquals("password", pwd.getAttribute("type"));
	}
}
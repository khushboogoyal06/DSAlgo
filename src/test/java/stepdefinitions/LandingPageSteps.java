package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverfactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LandingPageSteps {

	private WebDriver driver;

	@Given("User launches the browser")
	public void user_launches_the_browser() {
		// Hooks should already create the driver
		driver = DriverFactory.getDriver();

		// If driver is still null, your Hooks is not running or initDriver is not working
		Assert.assertNotNull("Driver is null. Hooks/DriverFactory did not initialize driver.", driver);
	}

	@When("User navigates to {string}")
	public void user_navigates_to(String url) {
		driver = DriverFactory.getDriver();
		Assert.assertNotNull("Driver is null before navigation.", driver);
		driver.get(url);
	}

	@Then("User should see the landing page with the {string} button")
	public void user_should_see_the_landing_page_with_the_button(String buttonText) {
		driver = DriverFactory.getDriver();
		Assert.assertNotNull("Driver is null on validation step.", driver);

		boolean visible = driver.findElements(
				By.xpath("//*[normalize-space()='" + buttonText + "']")
				).size() > 0;
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Assert.assertTrue("Expected button text not found: " + buttonText, visible);
	}
}



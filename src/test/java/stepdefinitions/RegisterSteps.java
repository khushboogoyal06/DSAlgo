package stepdefinitions;

import org.junit.Assert;

import driverfactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegisterPage;

public class RegisterSteps {
	String title;
	
	private RegisterPage registerPage = new RegisterPage(DriverFactory.getDriver());
	


	@Given("User is on {string} page")
	public void user_is_on_page(String expectedpageName) throws InterruptedException {
		//DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com");
		
	   title = registerPage.getRegisterPageTitle();
	   System.out.println("my login page title is " + title);
	   Thread.sleep(1000);
	   
	   
	}

@When("the user click on {string} button")
public void the_user_click_on_button(String buttonName) throws InterruptedException {
	if(buttonName.equals("Get Started")) {
    registerPage.clickonGetstartedButton();
    System.out.println("inside get started");
    Thread.sleep(1000);
	} else if (buttonName.equals("register")){
		registerPage.clickOnRegisterlnk();
		 System.out.println("inside registration");
		    Thread.sleep(1000);
	}
}

@Then("I verify the title of the page is {string}")
public void i_verify_the_title_of_the_page_is(String expectedPageTitle) {
	System.out.println(expectedPageTitle); 
	System.out.println("actual title is " + title);
	Assert.assertTrue(title.contains(expectedPageTitle));
}

@Then("the {string} button should be visible and enabled")
public void the_button_should_be_visible_and_enabled(String expectedButton) {
	Assert.assertTrue(registerPage.isRegisterLinkPresent());
    
}

@Then("the {string} link should be visible")
public void the_link_should_be_visible(String string) {
    Assert.assertTrue(registerPage.isLoginLinkPresent());
}

@Then("the {string} input field should be displayed")
public void the_input_field_should_be_displayed(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("The user clicks the {string} button with all fields empty")
public void the_user_clicks_the_button_with_all_fields_empty(String string) {
	registerPage.clickonGetstartedButton();
   
}

@Then("The error {string} shows under the Username box")
public void the_error_shows_under_the_username_box(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

}

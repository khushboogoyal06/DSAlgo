package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/LandingPage.feature",
		glue = {"stepdefinitions", "hooks"},
		plugin = {
				"pretty",
				"html:target/cucumber-report.html",
				"json:target/cucumber.json"
		},
		monochrome = true
		)
public class MyTestRunner {
}



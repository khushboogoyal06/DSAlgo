package testrunners;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@SuppressWarnings("deprecation")

@RunWith(Cucumber.class)
//features ="classpath:src/test/resources/features",

@CucumberOptions(features = "src/test/resources/features", glue = {"stepdefinitions", "hooks"}, plugin =
{ "pretty", "html:target/cucumber-reports/cucumber.html",
"json:target/cucumber-reports/cucumber.json" }, monochrome = true) // tags =
// "@smoke" // optional

public class MyTestRunner {

}






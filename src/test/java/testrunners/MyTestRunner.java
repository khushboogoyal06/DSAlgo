package testrunners;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@SuppressWarnings("deprecation")

@RunWith(Cucumber.class)
//features ="classpath:src/test/resources/features",

@CucumberOptions(features = "classpath:features/TC02_Register"
, glue = {"stepdefinitions", "hooks"}
,tags = "@login"
, plugin ={ "pretty", "html:target/cucumber-reports/cucumber.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		// "com.aventstack.chaintest.plugins.ChainTestCucumberListener",
"json:target/cucumber-reports/cucumber.json" }, monochrome = true) // tags =
// "@smoke" // optional

public class MyTestRunner {

}






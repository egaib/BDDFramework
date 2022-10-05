package CucumberRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
	glue = {"StepDefs"},
	plugin = {"pretty","html:target/HtmlReports/Cucumber-pretty",
	"json:target/JSONReports/CucumberReport.json"},
	tags="@Regression", stepNotifications=true)
public class CucumberTestRunner {
	
}

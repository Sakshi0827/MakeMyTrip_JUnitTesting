package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 
@CucumberOptions(format = {"pretty", "json:target/Report/Email/Cucumber.json", 
		"junit:target/Report/Email/Cucumber.xml", "html:target/Report/Email",
		}, monochrome= true, features = "src\\test\\resources\\FeatureFile\\EmailLogin.feature",
		glue = "StepDefinition", strict = true, dryRun = false, tags="~@PositiveEmail") 
public class LoginEmailRunner {

}

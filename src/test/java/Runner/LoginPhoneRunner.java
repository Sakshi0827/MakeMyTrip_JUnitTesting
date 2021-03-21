package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 
@CucumberOptions(format = {"pretty", "json:target/Report/Phone/Cucumber.json", 
		"junit:target/Report/Phone/Cucumber.xml", "html:target/Report/Phone",
		}, monochrome= true, features = "src\\test\\resources\\FeatureFile\\MobileLogin.feature",
		glue = "StepDefinition", strict = true, dryRun = false, tags="~@PositivePhone") 
public class LoginPhoneRunner {

}

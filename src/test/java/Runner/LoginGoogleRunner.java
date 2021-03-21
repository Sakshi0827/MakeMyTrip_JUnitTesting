package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class) 
@CucumberOptions(format = {"pretty", "json:target/Destination/MMT/Google/Cucumber.json", 
		"junit:target/Destination/MMT/Google/Cucumber.xml", "html:target/Destination/MMT/Google",
		}, monochrome= true, features = "src\\test\\resources\\FeatureFile\\GoogleLogin.feature",
		glue = "StepDefinition", strict = true, dryRun = false, tags="@PositiveGooglePass") 
public class LoginGoogleRunner {

}



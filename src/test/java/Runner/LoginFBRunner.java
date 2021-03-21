package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 
@CucumberOptions(format = {"pretty", "json:target/Destination/democart/Cucumber.json", 
		"junit:target/Destination/MMT/Cucumber.xml", "html:target/Destination/MMT",
}, monochrome= true, features = "src\\test\\resources\\FeatureFile\\FacebookLogin.feature",
		glue = "StepDefinition", strict = true, dryRun = false)//, tags="@BlankFBid") 
public class LoginFBRunner {

}

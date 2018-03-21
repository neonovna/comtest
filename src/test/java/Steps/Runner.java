package Steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/Features"},
        format = {"pretty", "html:target/cucumber-html-report"},
        tags = {"~@ignore"}
)
public class Runner {
}

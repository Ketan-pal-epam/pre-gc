package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/resources/features/api/Addresses.feature"},
        glue = {"StepDefinitions.api"},
        plugin = {"pretty", "html:target/cucumber-reports/api-add.html"},
        monochrome = true
)
public class ApiAddRunner extends AbstractTestNGCucumberTests {
}

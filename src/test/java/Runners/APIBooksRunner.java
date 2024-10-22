package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/api/Books.feature"},
        glue = {"StepDefinitions.api"},
        plugin = {"pretty", "html:target/cucumber-reports/api-books.html"},
        monochrome = true
)
public class APIBooksRunner extends AbstractTestNGCucumberTests {
}

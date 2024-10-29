package Runners.ui;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/resources/features/ui/IFrameDemo.feature"},
        glue = {"StepDefinitions.ui"},
        plugin = {"pretty", "html:target/cucumber-reports/ajax-form.html"},
        monochrome = true
)
public class AjaxFormRunner extends AbstractTestNGCucumberTests {
}
